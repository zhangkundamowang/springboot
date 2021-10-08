package com.zk.springboot.modular.mapper;

import com.zk.springboot.modular.model.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author zk
 * @since 2021-10-08
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
