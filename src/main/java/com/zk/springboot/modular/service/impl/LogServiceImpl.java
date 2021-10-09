package com.zk.springboot.modular.service.impl;

import com.zk.springboot.modular.model.Log;
import com.zk.springboot.modular.mapper.LogMapper;
import com.zk.springboot.modular.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zk
 * @since 2021-10-09
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
