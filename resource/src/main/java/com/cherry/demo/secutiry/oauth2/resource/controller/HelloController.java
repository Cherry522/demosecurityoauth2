package com.cherry.demo.secutiry.oauth2.resource.controller;

/**
 * @author chenyan
 * @date 4:11 PM
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello.";
    }
}
