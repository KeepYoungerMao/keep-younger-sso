package com.mao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author mao by 14:51 2020/3/20
 */
@RestController
@RequestMapping("api")
public class ApiController {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("ok")
    public String hello(){
        String url = "http://keep-younger-service/api/ok";
        return restTemplate.getForObject(url,String.class);
    }

}