package me.hibiki.system.exception;

import me.hibiki.system.domain.ResultMapBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 高弘昆
 * @date 2020/6/17 11:24
 */
@ControllerAdvice
public class SystemExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public ResultMapBean systemExceptionAdvice(SystemException systemException){
        ResultMapBean resultMapBean = new ResultMapBean();
        resultMapBean.setMsg(systemException.getMessage());
        return  resultMapBean;
    }
}
