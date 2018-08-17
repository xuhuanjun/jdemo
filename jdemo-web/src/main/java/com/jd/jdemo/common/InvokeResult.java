package com.jd.jdemo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统调用，统一响应对象。
 *
 * @param <T> 反馈数据
 * @author xuhj
 */
@Data
public class InvokeResult<T> implements Serializable {
    /**
     * 调用是否成功标识
     */
    private boolean success;
    /**
     * 异常码
     */
    private int code;
    /**
     * 反馈消息
     */
    private String msg;
    /**
     * 反馈数据
     */
    private T data;

    /**
     * 调用成功
     *
     * @param data
     * @return
     */
    public static InvokeResult successed(Object data) {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setSuccess(true);
        invokeResult.setData(data);
        return invokeResult;
    }

    /**
     * 调用失败
     *
     * @param msg 错误信息
     * @return
     */
    public static InvokeResult failed(String msg) {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setSuccess(false);
        invokeResult.setMsg(msg);
        return invokeResult;
    }

    /**
     * 调用失败
     *
     * @param code 异常编码
     * @param msg  异常信息
     * @return
     */
    public static InvokeResult failed(int code, String msg) {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setSuccess(false);
        invokeResult.setCode(code);
        invokeResult.setMsg(msg);
        return invokeResult;
    }
}
