package com.jisen.rws.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author jisen
 * @date 2021/7/27 11:58
 */
@Data
@TableName("tb_keyvalue")
public class KeyValueEntity {
    /**
     * 用户id
     */
    @TableId
    private Long id;
    private String fldKey;
    private String fldValue;
}
