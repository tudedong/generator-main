package com.td.generator.exception;

import com.td.generator.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 15:20:45
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error(e.getMessage(),e);
        return Result.errorResult("系统异常");
    }
}
