package com.jisen.rws.common;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author jisen
 * @date 2021/7/27 16:44
 */
public class MyTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        for (String tableName : availableTargetNames) {
            //日期的最后一位，对5取模
            Integer date=Integer.parseInt(shardingValue.getValue().substring(shardingValue.getValue().length()-1));
            if (tableName.endsWith(date % 5 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

}