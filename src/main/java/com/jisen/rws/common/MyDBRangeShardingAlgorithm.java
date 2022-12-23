package com.jisen.rws.common;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import java.util.Collection;

/**
 * 范围分片查询算法
 *
 * @author jisen
 * @date 2021/7/27 15:29
 */
public class MyDBRangeShardingAlgorithm implements RangeShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        return collection;

    }
}