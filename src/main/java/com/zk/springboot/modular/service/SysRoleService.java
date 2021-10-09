package com.zk.springboot.modular.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zk.springboot.modular.model.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.springboot.modular.model.SysUser;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author zk
 * @since 2021-10-08
 */
public interface SysRoleService extends IService<SysRole> {

    IPage<SysRole> findRoleByPage(Integer pageNo, Integer pageSize);

    SysRole findRoleById(Integer roleId);

    List<SysUser> findUsersByRoleId(Integer roleId);
}
