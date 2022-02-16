package cn.lysoy.myblog.controller;

import cn.lysoy.myblog.common.constant.CodeEnum;
import cn.lysoy.myblog.entity.Article;
import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.service.ArticleService;
import cn.lysoy.myblog.service.UserService;
import cn.lysoy.myblog.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author lysoy
 */
@Controller
@Slf4j
@RequestMapping(value = "/del_article.html")
public class DelArticleController {
    private static final Integer LIMIT = 5;
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    @GetMapping("")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        ModelAndView mv = new ModelAndView();
        User user = (User) request.getAttribute("user");
        if (user == null) {
            return mv;
        }
        List<Article> articleList = articleService.list();
        int i = 1;
        for (Article article: articleList) {
            String username = userService.getById(article.getId()).getUsername();
            mv.addObject("articleid"+ i, article.getId());
            mv.addObject("authorname"+ i, username);
            mv.addObject("articletitle" + i, article.getTitle());
            i++;
        }
        for (;i<=LIMIT;i++) {
            mv.addObject("articleid"+ i, null);
            mv.addObject("authorname"+ i, null);
            mv.addObject("articletitle" + i, null);
        }
        mv.setViewName("del_article");
        return mv;
    }

    @GetMapping(value = "/{id}")
    public String delArticle(@PathVariable("id") String id, HttpServletRequest request) throws NoSuchAlgorithmException, IOException {
        User user = (User) request.getAttribute("user");
        if (user == null) {
            return JsonUtil.fail(CodeEnum.SERVER_EXCEPTION).toJSON();
        } else if (user.getRole() < 3) {
            return JsonUtil.fail(CodeEnum.SERVER_EXCEPTION).toJSON();
        }
        if (articleService.removeById(id)) {
            return "redirect:/del_article.html";
        } else {
            return JsonUtil.fail(CodeEnum.SERVER_EXCEPTION).toJSON();
        }
    }
}
