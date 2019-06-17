package com.wener.web.controller;

import com.wener.web.exception.GlobalException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @RequestMapping("/global")
    @ResponseBody
    public void hello() {
        throw  new GlobalException("全局异常");
    }
}
