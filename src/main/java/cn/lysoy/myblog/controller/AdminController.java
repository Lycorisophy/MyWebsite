package cn.lysoy.myblog.controller;

import cn.lysoy.myblog.common.constant.CodeEnum;
import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.service.ArticleService;
import cn.lysoy.myblog.service.UserService;
import cn.lysoy.myblog.util.EncryptUtil;
import cn.lysoy.myblog.util.JsonUtil;
import cn.lysoy.myblog.util.SessionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author lysoy
 */
@Controller
@Slf4j
@RequestMapping(value = "/admin.html")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    private User getUser(HttpServletRequest request){
        //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
        Cookie[] cookies = request.getCookies();
        String sessionId = null;
        for(Cookie c :cookies ){
            if (c.getName().equals("sessionid")){
                sessionId = c.getValue();
            }
        }
        if (sessionId == null || sessionId.trim().length() == 0) {
            return null;
        }
        User user;
        HttpSession session = request.getSession();
        user = (User) session.getAttribute(sessionId);
        return user;
    }


    @GetMapping(value = "")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        ModelAndView mv = new ModelAndView();
        User user = (User) request.getAttribute("user");
        if (user == null) {
            return mv;
        }
        mv.setViewName("admin");
        mv.addObject("username", user.getUsername());
        mv.addObject("role", user.getRole());
        return mv;
    }

    @PostMapping(value = "")
    public String updataArticle(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String tag = request.getParameter("tag");
        String brief = request.getParameter("brief");
        return "username";
    }
}
