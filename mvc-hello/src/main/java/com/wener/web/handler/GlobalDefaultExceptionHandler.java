package com.wener.web.handler;

import com.wener.web.exception.GlobalException;
import com.wener.web.exception.ParamsNotNullException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {
    /*默认异常信息*/
    private static final String DEFAULT_ERROR_VIEW = "error";
    private static final String DEFAULT_ERROR_MESSAGE = "系统忙，请稍后再试";
    private static final String DEFAULT_404_VIEW = "404";

    @ExceptionHandler(GlobalException.class)
    public ModelAndView handlerError(GlobalException ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(DEFAULT_ERROR_VIEW);
        mv.addObject("msg", ex.getMessage());
        log.error(ex.getMessage());
        return mv;
    }
    @ExceptionHandler(ParamsNotNullException.class)
    public ModelAndView resolveException( ParamsNotNullException ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(DEFAULT_404_VIEW);
        mv.addObject("msg", ex.getMessage());
        log.error(ex.getMessage());
        return mv;
    }

}
