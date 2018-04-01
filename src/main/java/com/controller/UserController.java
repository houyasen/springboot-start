package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectUserList")
    @Transactional(propagation = Propagation.SUPPORTS)//查询事务
    public String selectUserList(ModelMap map){
        List<User> list = userService.selectUserList();
        map.addAttribute("userList",list);
        return "userList";
    }


    @RequestMapping("/insert")
    @Transactional(propagation = Propagation.REQUIRED)//增删事务
    public String insert(){
        User user = new User();
        user.setName("wangba");
        user.setAge(88);
        user.setBirthday(new Date());
        user.setAddress("运城");
        user.setDesc("少年一堆");
        userService.insert(user);
        return "forward:/user/selectUserList";
    }

}
