package com.zk.springboot.modular.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zk
 * @since 2021-10-09
 */
@Api(value = "日志管理",tags = "日志管理")
@RestController
@RequestMapping("/log")
public class LogController {

}
