package com.zk.springboot.common.exception;

import lombok.Data;

/**
 * 处理业务异常类
 */
@Data
public class RunException extends  RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;

    /**
     * 错误信息
     */
    protected String errorMsg;

    public RunException() {
    }

    public RunException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getCode());
        this.errorCode=exceptionEnum.getCode();
        this.errorMsg=exceptionEnum.getMessage();
    }


    public RunException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "RunException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
