package com.jisen.rws.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author jisen
 * @date 2021/7/27 11:58
 */
@Data
@TableName("tb_nat_")
public class NatEntity {

    @TableId(type=IdType.INPUT)
    private Long id;

    private String idCardCode;
    private String samplingDate;

    private Date samplingTime;
    private Date resultTime;
    private String result;


}
