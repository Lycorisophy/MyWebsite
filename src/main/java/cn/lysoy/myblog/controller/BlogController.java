package cn.lysoy.myblog.controller;

import cn.lysoy.myblog.common.constant.CodeEnum;
import cn.lysoy.myblog.entity.Article;
import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.service.ArticleService;
import cn.lysoy.myblog.service.UserService;
import cn.lysoy.myblog.util.JsonUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lysoy
 */
@Controller
@Slf4j
@RequestMapping(path = "/blog.html")
public class BlogController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ModelAndView getBlog(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        Article article = new Article();
        User user = new User();
        try {
            article = articleService.getById(id);
            user = userService.getById(article.getAuthor_id());
        } catch (Exception e) {
            log.error("Fail to page blog.html", e);
        } finally {
            String username = null;
            try {
                username = user.getUsername();
            }catch (Exception e) {
                e.printStackTrace();
            }
            if (username == null || username.trim().length() == 0) {
                modelAndView.addObject("username", "佚名");
            } else {
                modelAndView.addObject("username", username);
            }
            String brief = null;
            try {
                brief = user.getBrief();
            }catch (Exception e) {
                e.printStackTrace();
            }
            if (brief == null || brief.trim().length() == 0) {
                modelAndView.addObject("brief", "没有简介");
            } else {
                modelAndView.addObject("brief", brief);
            }
            String content = null;
            try {
               content = article.getContent();
            }catch (Exception e) {
                e.printStackTrace();
            }
            if (content == null || content.trim().length() == 0) {
                modelAndView.addObject("content", "作者一个字都没写");
            } else {
                modelAndView.addObject("content", content);
            }
            modelAndView.setViewName("blog");
            return modelAndView;
        }
    }
}