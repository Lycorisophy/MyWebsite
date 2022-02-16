package cn.lysoy.myblog.controller;

import cn.hutool.core.date.DateUnit;
import cn.lysoy.myblog.common.constant.CodeEnum;
import cn.lysoy.myblog.entity.Article;
import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.service.ArticleService;
import cn.lysoy.myblog.service.UserService;
import cn.lysoy.myblog.service.impl.ArticleServiceImpl;
import cn.lysoy.myblog.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author lysoy
 */
@Controller
@Slf4j
@RequestMapping(value = "/add_article.html")
public class AddArticleController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    @GetMapping(value = "")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        ModelAndView mv = new ModelAndView();
        User user = (User) request.getAttribute("user");
        if (user == null) {
            return mv;
        }
        mv.setViewName("add_article");
        return mv;
    }

    @PostMapping(value = "")
    public String addUser(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        String title = request.getParameter("title");
        if (title == null || title.trim().length() == 0) {
            return JsonUtil.fail(CodeEnum.COMMENT_BLANK).toJSON();
        }
        String content = request.getParameter("content");
        if (content == null || content.trim().length() == 0) {
            return JsonUtil.fail(CodeEnum.COMMENT_BLANK).toJSON();
        }
        String tag = request.getParameter("tag");
        if (tag == null || tag.trim().length() == 0) {
            return JsonUtil.fail(CodeEnum.COMMENT_BLANK).toJSON();
        }
        String brief = request.getParameter("brief");
        if (brief == null || brief.trim().length() == 0) {
            return JsonUtil.fail(CodeEnum.COMMENT_BLANK).toJSON();
        }
        Article article = new Article();
        article.setTag(tag);
        article.setContent(content);
        article.setBrief(brief);
        article.setTitle(title);
        article.setCreate_time(new Date());
        article.setUpdate_time(new Date());
        User user = (User) request.getAttribute("user");
        try {
            article.setAuthor_id(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (articleService.save(article)) {
            return "redirect:/add_article.html";
        } else {
            return JsonUtil.fail(CodeEnum.SERVER_EXCEPTION).toJSON();
        }
    }
}
