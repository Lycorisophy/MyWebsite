package cn.lysoy.myblog.controller;

import cn.lysoy.myblog.common.constant.CodeEnum;
import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.service.UserService;
import cn.lysoy.myblog.util.EncryptUtil;
import cn.lysoy.myblog.util.JsonUtil;
import cn.lysoy.myblog.util.SessionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author lysoy
 */
@Controller
@Slf4j
@RequestMapping(value = "/manage")
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping(value = {"", "/"})
    public String getAbout() {
        try {
            return "redirect:/manage.html";
        } catch (Exception e) {
            log.error("Fail to page about.html", e);
        }
        return JsonUtil.fail(CodeEnum.SERVER_EXCEPTION).toJSON();
    }

    @PostMapping(value = "")
    public String login(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
        String username = request.getParameter("username");
        if (username == null || username.trim().length() == 0) {
            return JsonUtil.fail(CodeEnum.USERNAME_BLANK).toJSON();
        }
        String password = request.getParameter("password");
        if (password == null || password.trim().length() == 0) {
            return JsonUtil.fail(CodeEnum.COMMENT_BLANK).toJSON();
        }
        User user;
        HttpSession session = request.getSession();

        try {
            user = (User) session.getAttribute(username);
            if(user.getPassword().equals(EncryptUtil.Md5Encrypt(password))){
                try {
                    String sessionid = SessionUtil.generateSessionId(user.getId());
                    session.setAttribute(sessionid, user);
                    session.setMaxInactiveInterval(1800);
                    Cookie cookie = new Cookie("sessionid", sessionid);
                    cookie.setMaxAge(1800);
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }catch (Exception e) {
                    log.error(e.getMessage());
                }
                return "redirect:/admin.html";
            }
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        QueryWrapper<User> queryWrapper;
        List<User> userList = null;
        try {
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", username)
                    .eq("password", EncryptUtil.Md5Encrypt(password))
                    .last("limit 1");
            userList = userService.list(queryWrapper);
        }catch (Exception e) {
            log.error(JsonUtil.fail(CodeEnum.USERNAME_NOT_EXIST).toJSON());
        }
        if (userList.size() == 1) {
            user = userList.get(0);
            try {
                String sessionid = SessionUtil.generateSessionId(user.getId());
                session.setAttribute(sessionid, user);
                session.setMaxInactiveInterval(1800);
                Cookie cookie = new Cookie("sessionid", sessionid);
                cookie.setMaxAge(1800);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
                return "redirect:/admin.html";
            }catch (Exception e) {
                log.error(e.getMessage());
            }
            return "redirect:/manage.html";
        }
        return "redirect:/manage.html";
    }
}
