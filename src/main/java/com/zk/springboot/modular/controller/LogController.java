package com.zk.springboot.modular.controller;


import com.zk.springboot.config.aop.LogAnno;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zk
 * @since 2021-10-09
 */
@Api(value = "日志管理",tags = "日志管理")
@RestController
@RequestMapping("/log")
public class LogController {

    @LogAnno(operateType = "AOP加自定义注解记录日志")
    @RequestMapping(value = "/aop", method = RequestMethod.POST)
    @ApiOperation(value = "AOP加自定义注解记录日志")
    public void add() {
        System.out.println("模拟操作---向数据库中添加用户!!");
    }

}
