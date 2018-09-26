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
@RequestMapping("/vm")
public class VmController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('vm_list')")
    public String list(){
        return "list vm json.";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('vm_create')")
    public String add(){
        return "add vm json.";
    }
}
