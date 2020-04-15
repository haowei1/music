package com.hao.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author m760384371
 * @date 2019/10/15
 */
@Controller
public class ShowController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}
