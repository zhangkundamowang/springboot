package com.zk.springboot.modular.mapper;

import com.zk.springboot.modular.model.Log;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zk
 * @since 2021-10-09
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {

}
