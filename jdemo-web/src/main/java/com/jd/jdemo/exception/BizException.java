package com.jd.jdemo.exception;

import lombok.Data;

/**
 * 业务异常
 *
 * @author xuhuanjun
 * @date 2018/8/13 20:16
 */
@Data
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -4108291995431449966L;
    /**
     * 异常码
     */
    private Integer code = null;

    /**
     * 无参数自定义业务异常构造方法.
     */
    public BizException() {
    }

    /**
     * @param message 异常消息.
     */
    public BizException(String message) {
        super(message);
    }

    /**
     * @param code    错误码
     * @param message 异常消息.
     */
    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @param cause 根异常.
     */
    public BizException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message 异常消息.
     * @param cause   根异常.
     */
    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param code    异常代码
     * @param message 异常消息.
     * @param cause   根异常.
     */
    public BizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
