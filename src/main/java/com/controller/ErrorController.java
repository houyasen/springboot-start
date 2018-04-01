package com.controller;

import com.result.AjaxResultVo;
import com.result.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/er")
    public String erro(){

        int a = 1 / 0;

        return "error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxer(){
        return "ceshiAjaxerror";
    }

    @RequestMapping("/getAjaxerror")
    public AjaxResultVo getAjaxerror(){
        AjaxResultVo result = new AjaxResultVo();
        int a = 1 / 0;
        result.setStatus(StatusCode.SUCCESS.getCode());
        return result;
    }

}
