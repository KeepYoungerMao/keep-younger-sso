package com.mao.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mao by 14:51 2020/3/20
 */
@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping("ok")
    public String hello(){
        return "test is ok. server is keep younger service one";
    }

}