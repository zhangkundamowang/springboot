package com.zk.springboot.modular.service.impl;

import com.zk.springboot.modular.model.SysUserRole;
import com.zk.springboot.modular.mapper.SysUserRoleMapper;
import com.zk.springboot.modular.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author zk
 * @since 2021-10-08
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}
