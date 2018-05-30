package com.ping.thread.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mr.Ping on 2018/5/29.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"","/","index"})
    public String index(){
        return "index";
    }
}
