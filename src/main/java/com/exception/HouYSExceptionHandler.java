package com.exception;

import com.result.AjaxResultVo;
import com.result.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice  //此注解说明跑出异常的时候会被这个类捕获
@ResponseBody
public class HouYSExceptionHandler {

    public static final String HOU_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();

        ModelAndView mav = new ModelAndView();
        if(isAjax(request)){
            AjaxResultVo result = new AjaxResultVo();
            result.setStatus(StatusCode.SERVER_ERROR.getCode());
            return result;
        }else{
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURI());
            mav.setViewName(HOU_ERROR_VIEW);
            return mav;
        }
    }

    public static boolean isAjax(HttpServletRequest request){

        String requestType = request.getHeader("X-Requested-With");

        return (requestType != null && "XMLHttpRequest".equals(requestType.toString()));
    }
}
