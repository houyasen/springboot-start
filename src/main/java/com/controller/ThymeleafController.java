package com.controller;

import com.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thy")
public class ThymeleafController {

    @Autowired
    private Resource resource;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(ModelMap map){
        map.addAttribute("resource",resource);
        return "demo2";
    }
}
