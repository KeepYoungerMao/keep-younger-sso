package com.mao.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author mao by 14:09 2020/3/19
 */
@Controller
public class CommonController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("src")
    public String securedPage(Model model, Principal principal){
        model.addAttribute("user",principal.getName());
        return "src";
    }

}