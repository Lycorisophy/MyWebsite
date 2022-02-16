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
@RequestMapping(path ={"/", "/Index", "/Index.html", "index"} )
public class IndexController {
    @GetMapping(value = {"", "/"})
    public String getIndex() {
        try {
            return "redirect:/index.html";
        } catch (Exception e) {
            log.error("Fail to page index.html", e);
        }
        return JsonUtil.fail(CodeEnum.SERVER_EXCEPTION).toJSON();
    }
}