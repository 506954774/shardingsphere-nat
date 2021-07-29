package com.jisen.rws.common;

import com.jisen.rws.utils.NanoTimeUtils;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/**
 * @author jisen
 * @date 2021/7/28 13:03
 */
public class NanoTimeShardingKeyGenerator implements ShardingKeyGenerator {
    @Override
    public Comparable<?> generateKey() {
        return NanoTimeUtils.getNanoTime();
    }

    @Override
    public String getType() {
        return "NanoTimeShardingKeyGenerator";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
