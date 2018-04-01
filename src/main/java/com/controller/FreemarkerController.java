package com.controller;


import com.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller     //freemark模板返回如果用RestController返回的是字符串，渲染不回页面
@RequestMapping("/free")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/freemarker")
    public String freemarker(ModelMap map) {
        map.addAttribute("resource",resource);
        return "demo2";
    }
}
