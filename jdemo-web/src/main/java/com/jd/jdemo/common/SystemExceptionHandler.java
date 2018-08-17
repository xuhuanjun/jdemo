package com.jd.jdemo.common;

import com.jd.jdemo.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统统一异常处理，如有必要，可以在此添加自定义异常的捕获。
 */
@ControllerAdvice
@Slf4j
public class SystemExceptionHandler {
    /**
     * 业务异常统一处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Object handleException(BizException e) {
        log.error("******系统异常统一处理***业务异常****{}", e);
        return InvokeResult.failed(e.getCode(), e.getMessage());
    }

    /**
     * 系统异常统一处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public Object handleException(Throwable e) {
        log.error("******系统异常统一处理***系统异常****{}", e);
        return InvokeResult.failed("系统运行异常");
    }
}
