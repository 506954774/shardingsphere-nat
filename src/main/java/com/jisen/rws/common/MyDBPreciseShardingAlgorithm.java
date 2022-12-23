package com.jisen.rws.common;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author jisen
 * @date 2021/7/27 15:29
 */
public class MyDBPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {

        for (String tableName : availableTargetNames) {
            //身份证的第六位数字，对5取模
            Integer num=Integer.parseInt(shardingValue.getValue().substring(5,6));
            if (tableName.endsWith(num % 5 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

}