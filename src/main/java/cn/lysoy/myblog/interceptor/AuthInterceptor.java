package cn.lysoy.myblog.interceptor;

import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LySoY
 * @data 2022-2-15
 * 自定义登陆拦截器
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
            Cookie[] cookies = request.getCookies();
            String sessionId = null;
            for(Cookie c :cookies ){
                if (c.getName().equals("sessionid")){
                    sessionId = c.getValue();
                }
            }
            if (sessionId == null || sessionId.trim().length() == 0) {
                return false;
            }
            User user;
            HttpSession session = request.getSession();
            user = (User) session.getAttribute(sessionId);
            if(user!=null){
                request.setAttribute("user", user);
                return true;
            }
            response.sendRedirect(request.getContextPath()+"manage.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        return false;
        //如果设置为true时，请求将会继续执行后面的操作
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("请求登陆管理页");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        User user = (User) request.getAttribute("user");
        HttpSession session = request.getSession();
        String sessionid = SessionUtil.generateSessionId(user.getId());
        session.setAttribute(sessionid, user);
        session.setMaxInactiveInterval(1800);
        Cookie cookie = new Cookie("sessionid", sessionid);
        cookie.setMaxAge(1800);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }
}
