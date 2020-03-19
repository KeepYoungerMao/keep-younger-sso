package com.mao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mao by 18:18 2019/5/20
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping({"index","/"})
    public String index(){
        return "index";
    }

}