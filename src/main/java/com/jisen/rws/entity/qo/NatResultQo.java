package com.jisen.rws.entity.qo;

import lombok.Data;

/**
 * @author jisen
 * @date 2021/7/27 11:58
 */
@Data
public class NatResultQo {

    //采样日期
    private String samplingDate;
    //试管id
    private Long testTubeId;
    //核酸采样结果，0阴性 1阳性
    private int isPositive;




}
