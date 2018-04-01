package com.controller;

import com.pojo.Resource;
import com.pojo.User;
import com.result.AjaxResultVo;
import com.result.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/ceshi")
public class CeShiController {

    @Autowired
    private Resource resource;


    @RequestMapping("/hello")
    public Object sayHello() {
        User u = new User();
        u.setName("张三");
        u.setAge(22);
        u.setAddress("北京朝阳");
        u.setBirthday(new Date());
        u.setDesc("屌丝一枚");
        return u.toString();
    }

    @RequestMapping("/ajax")
    public AjaxResultVo getAjaxResult() {
        AjaxResultVo result = new AjaxResultVo();

        User u = new User();
        u.setName("李四");
        u.setAge(22);
        u.setAddress("北京朝阳");
        u.setBirthday(new Date());
        u.setDesc("屌丝一枚");

        result.setData(u);
        result.setStatus(StatusCode.SUCCESS.getCode());
        return result;
    }

    @RequestMapping("/getResource")
    public AjaxResultVo getResource() {
        AjaxResultVo result = new AjaxResultVo();
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);

        result.setData(bean);
        result.setStatus(StatusCode.SUCCESS.getCode());
        return result;
    }

}
