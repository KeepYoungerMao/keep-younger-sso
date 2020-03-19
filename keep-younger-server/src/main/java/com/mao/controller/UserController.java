package com.mao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author mao by 17:07 2019/5/20
 */
@RestController
@RequestMapping("api")
public class UserController {

    @RequestMapping("user")
    public Principal user(Principal principal){
        return principal;
    }

}