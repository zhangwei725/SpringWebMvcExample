package com.wener.web.handler;

import com.wener.web.exception.GlobalException;
import com.wener.web.exception.ParamsNotNullException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    public static final String DEFAULT_ERROR_VIEW = "error";
    public static final String DEFAULT_404_VIEW = "404";
    /*处理所有的异常信息*/
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        if (ex instanceof GlobalException) {
            mv.setViewName(DEFAULT_ERROR_VIEW);
            mv.addObject("msg", ex.getMessage());
            log.error(ex.getMessage());
        }else if (ex instanceof ParamsNotNullException){
            mv.setViewName(DEFAULT_404_VIEW);
            mv.addObject("msg",ex.getMessage());
        }
        return mv;
    }
}