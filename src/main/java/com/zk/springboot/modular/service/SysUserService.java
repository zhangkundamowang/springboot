package com.zk.springboot.modular.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.springboot.modular.model.SysRole;
import com.zk.springboot.modular.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zk
 * @since 2021-10-08
 */
public interface SysUserService extends IService<SysUser> {

    Page<SysUser> findUserByPage(Integer pageNo, Integer pageSize);

    SysUser findUserById(Integer userId);

    SysUser findUserByName(String userName);

    SysRole findRoleByUserId(Integer userId);
}
