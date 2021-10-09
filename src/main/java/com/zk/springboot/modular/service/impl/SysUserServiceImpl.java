package com.zk.springboot.modular.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.springboot.modular.model.SysRole;
import com.zk.springboot.modular.model.SysUser;
import com.zk.springboot.modular.mapper.SysUserMapper;
import com.zk.springboot.modular.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zk
 * @since 2021-10-08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper userMapper;

    @Override
    public Page<SysUser> findUserByPage(Integer pageNo, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 100);
        Page<SysUser> page = new Page<>(pageNo, pageSize);
        page.setRecords(userMapper.selectUserPage(map, page));
        return page;
    }

    @Override
    public SysUser findUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public SysUser findUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public SysRole findRoleByUserId(Integer userId) {
        return userMapper.findRoleByUserId(userId);
    }
}
