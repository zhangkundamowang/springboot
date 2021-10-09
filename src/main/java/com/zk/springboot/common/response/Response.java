package com.zk.springboot.common.response;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description 自定义响应
 **/
public class Response {

    public String code;
    public String message;
    public Object data;

    public Response() {
    }

    public Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功
     */
    public static Response success() {
        return success(null);
    }

    public static Response success(Object o) {
        Response rb = new Response();
        rb.setCode("200");
        rb.setData(o);
        return rb;
    }

    public static Response success(String message, Object data) {
        Response rb = new Response();
        rb.setCode("200");
        rb.setMessage(message);
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     */
    public static Response error(String code, String message) {
        Response rb = new Response();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

    public static Response error(String message) {
        Response rb = new Response();
        rb.setCode("-100");
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
