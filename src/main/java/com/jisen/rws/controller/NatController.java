package com.jisen.rws.controller;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jisen.rws.common.R;
import com.jisen.rws.entity.NatEntity;
import com.jisen.rws.entity.qo.NatInsertQo;
import com.jisen.rws.entity.qo.NatResultQo;
import com.jisen.rws.mapper.NatMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jisen
 * @date 2021/7/27 12:01
 */
@RestController
@Slf4j
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

    @PostMapping("/scanInsert")
    public R scanInsert(@RequestBody  NatInsertQo qo){

        ArrayList<String> idCards=new ArrayList<>();

        //构建redis的key：日期加试管编号：
        String key=qo.getSamplingDate()+":"+qo.getTestTubeId();
        log.info("scanInsert,采样试管redis的key："+key);

        String value = redisTemplate.opsForValue().get(key);
        if(value==null){
            idCards.add(qo.getIdCardCode());
        }
        else {
            List<String> strings = JSON.parseArray(value, String.class);
            log.info("scanInsert,之前redis里面的身份证号码集合："+strings);

            if(strings.contains(qo.getIdCardCode())){
                //今日已采样，不做额外处理
                log.info("scanInsert,今日已采样，不做额外处理");
                return R.ok();
            }
            else {
                idCards.addAll(strings);
                idCards.add(qo.getIdCardCode());
                log.info("scanInsert,将此身份证添加到redis里面");

            }
        }

        redisTemplate.opsForValue().set(key,JSON.toJSONString(idCards));


        NatEntity entity=new NatEntity();
        entity.setTestTubeId(qo.getTestTubeId());
        entity.setIdCardCode(qo.getIdCardCode());
        entity.setSamplingDate(qo.getSamplingDate());
        entity.setSamplingTime(new Date());

        Long increment = redisTemplate.opsForValue().increment(NAT_ID);
        entity.setId(increment);

        natMapper.insert(entity);
        Map<String, Object> map = new HashMap<>();
        map.put("id",entity.getId());
        return R.ok(map);
    }



    @PostMapping("/setResult")
    public R setResult(@RequestBody NatResultQo qo){



        //构建redis的key：日期加试管编号：
        String key=qo.getSamplingDate()+":"+qo.getTestTubeId();
        log.info("setResult,采样试管redis的key："+key);

        String value = redisTemplate.opsForValue().get(key);
        if(value==null){
            //没有此数据
            log.info("setResult,没有此试管的采集记录："+key);
            return R.error("没有此试管的采集记录");
        }
        else {
            int count=0;
            Date now=new Date();

            List<String> strings = JSON.parseArray(value, String.class);
            log.info("setResult,之前redis里面的身份证号码集合："+strings);

            for(String idCard:strings){
                //遍历查出数据，修改结果

                LambdaQueryWrapper<NatEntity> queryWrapper = Wrappers.<NatEntity>query().lambda()
                        .eq(NatEntity::getIdCardCode,idCard)
                        .eq(NatEntity::getSamplingDate,qo.getSamplingDate())
                        .orderByDesc(NatEntity::getSamplingDate)
                        .last("limit 1")
                        ;

                NatEntity target = natMapper.selectOne(queryWrapper);

                if(target!=null){
                    log.info("setResult,准备更新数据："+target.getIdCardCode()+","+target.getSamplingDate());

                    target.setResult(qo.getIsPositive()==0?"2":"1");
                    target.setResultTime(now);
                    count++;
                    //不能根据id修改，因为分库分表不是按id来分的，而是按身份证号码和采样日期来分的
                    natMapper.update(target,queryWrapper);
                }
                else {
                    log.info("setResult,未查到该身份证号的数据："+idCard+",日期："+target.getSamplingDate());

                }

            }

            Map<String, Object> map = new HashMap<>();
            map.put("updateCount",count);
            return R.ok(map);

        }


    }




}
