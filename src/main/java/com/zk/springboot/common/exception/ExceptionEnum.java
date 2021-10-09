package com.zk.springboot.common.exception;

/**
 *  异常枚举
 **/
public enum ExceptionEnum {

    USER_NOT_FOUND("100","用户查询异常"),
    USER_ADD_ERROR("101","用户增加异常"),
    USER_UPDATE_ERROR("102","用户更新异常"),

    ROLE_NOT_FOUND("200","角色查询异常"),
    ROLE_ADD_ERROR("201","角色增加异常"),
    ROLE_UPDATE_ERROR("202","角色更新异常"),

    ERROR("500","服务器错误");


    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String message;

    ExceptionEnum(String code,String message){
        this.code=code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
