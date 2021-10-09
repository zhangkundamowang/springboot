package com.zk.springboot.modular.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.springboot.common.config.aop.LogAnno;
import com.zk.springboot.modular.model.SysRole;
import com.zk.springboot.modular.model.SysUser;
import com.zk.springboot.modular.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * 用户管理
 *
 * @author zk
 * @since 2021-09-06
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理！", tags = "用户管理")
public class SysUserController {

    @Resource
    private SysUserService userService;

    /**
     * 第二种分页方式，使用mapper文件的select注解，优点是可以方便的建立查询语句，可以联合多表查询。
     */
    @RequestMapping(value = "/findUserByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页获取所有用户")
    public Page<SysUser> findUserByPage(
            @ApiParam(name = "pageNo", value = "当前页")
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @ApiParam(name = "pageSize", value = "每一页数据个数")
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        return userService.findUserByPage(pageNo, pageSize);
    }

    @RequestMapping(value = "/findUserById", method = RequestMethod.POST)
    @ApiOperation(value = "通过userId查找用户")
    public SysUser findUserById(
            @ApiParam(name = "userId", value = "用户id")
            @RequestParam(value = "userId", required = true) Integer userId) {
        return userService.findUserById(userId);
    }

    @RequestMapping(value = "/findUserByName", method = RequestMethod.POST)
    @ApiOperation(value = "通过userName查找用户")
    public SysUser findUserByName(
            @ApiParam(name = "userName", value = "用户名")
            @RequestParam(value = "userName", required = true) String userName) {
        return userService.findUserByName(userName);
    }

    @LogAnno(operateType = "添加用户")
    @RequestMapping(value = "/aop", method = RequestMethod.POST)
    @ApiOperation(value = "测试Aop")
    public void add() {
        System.out.println("模拟操作---向数据库中添加用户!!");
    }


    /**
     * 查询该用户对应的角色 一个用户对应一个角色  多个用户对应一个角色 多对一
     */
    @PostMapping(value = "/findRoleByUserId")
    @ApiIgnore
    public SysRole findRoleByUserId(@Param("userId") Integer userId) {
        return userService.findRoleByUserId(userId);
    }

}