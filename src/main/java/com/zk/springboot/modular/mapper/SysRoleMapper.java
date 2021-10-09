package com.zk.springboot.modular.mapper;

import com.zk.springboot.modular.model.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.springboot.modular.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author zk
 * @since 2021-10-08
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> findAll();

    SysRole findRoleById(@Param("roleId") Integer roleId);

    List<SysUser> findUsersByRoleId(@Param("roleId") Integer roleId);

}
