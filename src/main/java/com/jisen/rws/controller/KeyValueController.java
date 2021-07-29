package com.jisen.rws.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jisen.rws.common.R;
import com.jisen.rws.entity.KeyValueEntity;
import com.jisen.rws.mapper.KeyValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jisen
 * @date 2021/7/27 12:01
 */
@RestController
public class KeyValueController {

    @Autowired
    KeyValueMapper keyValueMapper;

    @GetMapping("/getValue/{key}")
    public R getValue(@PathVariable String key){

        QueryWrapper<KeyValueEntity> queryWrapper = Wrappers.<KeyValueEntity>query().gt("id", 1627450015479212021L).eq("fld_key","Coconut");
//        QueryWrapper<KeyValueEntity> queryWrapper = Wrappers.<KeyValueEntity>query();
        List<KeyValueEntity> keyValueEntity = keyValueMapper.selectList(queryWrapper);

//        KeyValueEntity keyValueEntity = keyValueMapper.selectById(1627450189180217840L);
        System.out.println(keyValueEntity);
        return R.ok().put("data",keyValueEntity);
    }

    @GetMapping("/getPage/{key}")
    public R selectPage(@PathVariable String key){

        Map<String, Object> map = new HashMap<>();
        QueryWrapper<KeyValueEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("fld_key",key);
//        queryWrapper.groupBy("id");

        queryWrapper.orderByDesc("id");

        IPage<KeyValueEntity> page = new Page<>(1, 4);

        IPage<KeyValueEntity> ipage = keyValueMapper.selectPage(page, queryWrapper);

        System.out.println(ipage.getRecords());

        map.put("total", ipage.getTotal());
        map.put("list", ipage.getRecords());
        map.put("currentPage", 1);
        map.put("pageSize", 4);
        return R.ok().put("data",map);
    }



    @PostMapping("/setValue")
    public R getValue(@RequestBody JSONObject jsonObject){
        KeyValueEntity keyValueEntity1 = jsonObject.toJavaObject(KeyValueEntity.class);

        int insert = keyValueMapper.insert(keyValueEntity1);
        return R.ok();
    }
}
