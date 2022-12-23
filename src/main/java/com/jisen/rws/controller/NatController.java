package com.jisen.rws.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jisen.rws.common.R;
import com.jisen.rws.entity.NatEntity;
import com.jisen.rws.mapper.NatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jisen
 * @date 2021/7/27 12:01
 */
@RestController
public class NatController {

    //redis来提供分库分表的全局增长id
    private static final String NAT_ID = "NAT_ID";

    @Autowired
    NatMapper natMapper;

    @Autowired
    RedisTemplate<String, String> redisTemplate;


    @GetMapping("/getLastNat/{idCard}")
    public R getValue(@PathVariable String idCard){

        LambdaQueryWrapper<NatEntity> queryWrapper = Wrappers.<NatEntity>query().lambda().eq(NatEntity::getIdCardCode,idCard)
                .orderByDesc(NatEntity::getSamplingDate)
                .last("limit 1")
                ;

//        QueryWrapper<KeyValueEntity> queryWrapper = Wrappers.<KeyValueEntity>query();
        List<NatEntity> keyValueEntity = natMapper.selectList(queryWrapper);

//        KeyValueEntity keyValueEntity = keyValueMapper.selectById(1627450189180217840L);
        System.out.println(keyValueEntity);
        return R.ok().put("data",keyValueEntity);
    }

    @GetMapping("/getNatPage/{idCard}")
    public R selectPage(@PathVariable String idCard){

        Map<String, Object> map = new HashMap<>();


        LambdaQueryWrapper<NatEntity> queryWrapper = Wrappers.<NatEntity>query().lambda().eq(NatEntity::getIdCardCode,idCard)
                .orderByDesc(NatEntity::getSamplingTime)

                ;



        IPage<NatEntity> page = new Page<>(1, 4);

        IPage<NatEntity> ipage = natMapper.selectPage(page, queryWrapper);

        System.out.println(ipage.getRecords());

        map.put("total", ipage.getTotal());
        map.put("list", ipage.getRecords());
        map.put("currentPage", 1);
        map.put("pageSize", 4);
        return R.ok().put("data",map);
    }



    @PostMapping("/saveNat")
    public R getValue(@RequestBody NatEntity qo){

        Long increment = redisTemplate.opsForValue().increment(NAT_ID);
        qo.setId(increment);

        natMapper.insert(qo);

        Map<String, Object> map = new HashMap<>();
        map.put("id",qo.getId());
        return R.ok(map);
    }



}
