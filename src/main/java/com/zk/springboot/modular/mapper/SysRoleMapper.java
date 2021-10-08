package com.zk.springboot.modular.mapper;

import com.zk.springboot.modular.model.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.springboot.modular.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author zk
 * @since 2021-10-08
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> findAll();

    SysRole findById(@Param("id") Integer id);

    List<SysUser> findUsersByRoleId(@Param("id") Integer id);

}
