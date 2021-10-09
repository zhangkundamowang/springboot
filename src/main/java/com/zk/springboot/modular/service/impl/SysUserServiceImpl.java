package com.zk.springboot.modular.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.springboot.common.exception.ExceptionEnum;
import com.zk.springboot.common.exception.RunException;
import com.zk.springboot.common.response.Response;
import com.zk.springboot.common.utils.RedisUtil;
import com.zk.springboot.modular.model.SysRole;
import com.zk.springboot.modular.model.SysUser;
import com.zk.springboot.modular.mapper.SysUserMapper;
import com.zk.springboot.modular.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        try{
            SysUser user = userMapper.getUserById(userId);
            if(null!=user){
                return user;
            }else{
                throw new RunException(ExceptionEnum.USER_NOT_FOUND);
            }
        }catch (Exception e){
            log.info("用户查询异常");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  Response findUserByName(String userName) {
        Response response=new Response();
        SysUser user = userMapper.getUserByName(userName);
        return response.success(user);
    }

    @Override
    public SysRole findRoleByUserId(Integer userId) {
        return userMapper.findRoleByUserId(userId);
    }

    @Override
    public void addUser(String userName, String nickName) {
        try{
            SysUser user=new SysUser();
            user.setUserName(userName);
            user.setNickName(nickName);
            int row=userMapper.insert(user);
            if(row==1){
                //redis中新增10秒过期的key  用于测试key过期
                RedisUtil.setTime(userName,userName,10);
                //jedis基本使用
                Map<String, String> map = new HashMap<String, String>();
                map.put("username", userName);
                map.put("nickname", nickName);
                RedisUtil.getJedis().hmset("用户"+userName,map);
            }else{
                throw  new RunException(ExceptionEnum.USER_ADD_ERROR);
            }
        }catch (Exception e){
            log.info("增加用户失败");
            e.printStackTrace();
        }

    }
}
