package com.mao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mao by 18:18 2019/5/20
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login(boolean error, HttpServletRequest request, Model model){
        String msg = "";
        if (error){
            Object exception = request.getSession()
                    .getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            if (exception instanceof Exception)
                msg = ((Exception) exception).getMessage();
        }
        model.addAttribute("msg",msg);
        return "login";
    }

    @GetMapping({"index","/"})
    public String index(){
        return "index";
    }

}