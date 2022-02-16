package cn.lysoy.myblog.controller;

import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.service.ArticleService;
import cn.lysoy.myblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author lysoy
 */
@Controller
@Slf4j
@RequestMapping(value = "/add_user.html")
public class AddUserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        ModelAndView mv = new ModelAndView();
        User user = (User) request.getAttribute("user");
        if (user == null) {
            return mv;
        }
        mv.setViewName("add_user");
        return mv;
    }

    @PostMapping(value = "")
    public String addUser(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String tag = request.getParameter("tag");
        String brief = request.getParameter("brief");
        return "username";
    }
}
