package com.cherry.demo.secutiry.oauth2.resource.controller;

/**
 * @author chenyan
 * @date 4:11 PM
 */

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/network")
public class NetworkController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('network_list')")
    public String list(){
        return "list network json.";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('network_create')")
    public String add(){
        return "add network json.";
    }
}
