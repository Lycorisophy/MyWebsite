package cn.lysoy.myblog.controller;

import cn.lysoy.myblog.common.constant.CodeEnum;
import cn.lysoy.myblog.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lysoy
 */
@Controller
@Slf4j
@RequestMapping(path ={"/about", "/About"} )
public class AboutController {
    @GetMapping(value = {"", "/"})
    public String getAbout() {
        try {
            return "redirect:/about.html";
        } catch (Exception e) {
            log.error("Fail to page about.html", e);
        }
        return JsonUtil.fail(CodeEnum.SERVER_EXCEPTION).toJSON();
    }
}