package com.jisen.rws.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jisen.rws.entity.KeyValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jisen
 * @date 2021/7/27 12:00
 */
@Mapper
public interface KeyValueMapper extends BaseMapper<KeyValueEntity> {
    KeyValueEntity selectValue(@Param("key") String key);


    void insertBatch(List<KeyValueEntity> list);
}
