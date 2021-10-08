package com.zk.springboot.modular.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.springboot.modular.model.SysRole;
import com.zk.springboot.modular.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zk
 * @since 2021-10-08
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("SELECT * FROM t_tenant_user WHERE id < #{map.id}")
    List<SysUser> selectUserPage(@Param("map") Map<String, Object> map, Page<SysUser> page);

    SysUser getUserById(@Param("userId") Integer userId);

    SysUser getUserByName(@Param("name") String name);

    /**
     * 注意@Param("userId") 这是传的参数
     */
    SysRole findRoleByUserId(@Param("userId") Integer userId);
}
