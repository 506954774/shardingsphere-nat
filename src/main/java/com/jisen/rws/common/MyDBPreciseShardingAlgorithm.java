package com.jisen.rws.common;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author jisen
 * @date 2021/7/27 15:29
 */
public class MyDBPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith((shardingValue.getValue()/10) % 2 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

}