package com.zk.springboot.modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.springboot.common.exception.ExceptionEnum;
import com.zk.springboot.common.exception.RunException;
import com.zk.springboot.config.mybatisplus.PageFactory;
import com.zk.springboot.modular.model.SysRole;
import com.zk.springboot.modular.mapper.SysRoleMapper;
import com.zk.springboot.modular.model.SysUser;
import com.zk.springboot.modular.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author zk
 * @since 2021-10-08
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {


    @Resource
    private SysRoleMapper mapper;

    @Override
    public IPage<SysRole> findRoleByPage(Integer pageNo,Integer pageSize) {
        LambdaQueryWrapper<SysRole> query = Wrappers.lambdaQuery();
        //if... query.eq(SysRole::getRemark, "备注");
        Page<SysRole> page = PageFactory.page(pageNo,pageSize);
        IPage<SysRole> SysRoleIPage = mapper.selectPage(page, query);
        return SysRoleIPage;
    }

    @Override
    public SysRole findRoleById(Integer roleId) {
        try {
            SysRole role = mapper.findRoleById(roleId);
            if(null!=role){
                return  role;
            }else{
                throw  new RunException(ExceptionEnum.ROLE_NOT_FOUND);
            }
        }catch (Exception e){
            log.info("角色查询异常");
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public List<SysUser> findUsersByRoleId(Integer roleId) {
        return mapper.findUsersByRoleId(roleId);
    }


}
