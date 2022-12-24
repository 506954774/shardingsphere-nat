package com.jisen.rws.entity.qo;

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
public class NatInsertQo {

    //采样日期
    private String samplingDate;
    //试管id
    private Long testTubeId;
    //核酸采样者的身份证号码
    private String idCardCode;




}
