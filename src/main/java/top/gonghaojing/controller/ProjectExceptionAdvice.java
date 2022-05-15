package top.gonghaojing.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.gonghaojing.exception.BusinessException;
import top.gonghaojing.exception.SystemException;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public Result business(BusinessException e){
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public Result system(SystemException e){
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result system(Exception e){
        return new Result(Code.SYSTEM_ERR, null, e.getMessage());
    }
}
