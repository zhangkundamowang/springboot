package com.zk.springboot.modular.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zk.springboot.modular.model.SysRole;
import com.zk.springboot.modular.model.SysUser;
import com.zk.springboot.modular.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import javax.annotation.Resource;
import java.util.List;

/**
 * 角色管理
 *
 * @author zk
 * @since 2021-09-06
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色管理", tags = "角色管理")
public class SysRoleController {

    @Resource
    private SysRoleService service;

    /**
     * 第一种分页方式，mybatis-plus原生QueryWrapper方式分页，这种方式比较简单，可以不用修改Mapper，适合简单的增删改查。
     */
    @RequestMapping(value = "/findRoleByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页获取所有角色")
    public IPage<SysRole> findRoleByPage(@ApiParam(name = "pageNo", value = "当前页")
                                         @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                         @ApiParam(name = "pageSize", value = "每一页数据个数")
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        return service.findRoleByPage(pageNo, pageSize);
    }

    @RequestMapping(value = "/findRoleById", method = RequestMethod.POST)
    @ApiOperation(value = "通过roleId查询角色")
    public SysRole findRoleById(
            @ApiParam(name = "roleId", value = "角色id")
            @RequestParam(value = "roleId", required = false) int roleId) {
        return service.findRoleById(roleId);
    }

    /**
     * 查询该角色下的所有用户 一个角色对应多个用户 一对多
     */
    @RequestMapping(value = "/findUsersByRoleId", method = RequestMethod.POST)
    @ApiIgnore
    public List<SysUser> findUsersByRoleId(@Param("roleId") Integer roleId) {
        return service.findUsersByRoleId(roleId);
    }

}
