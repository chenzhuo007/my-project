package com.cz.alipay.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * <Description>：json工具类
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public class FastJsonUtil {

    public static <S> String toJsonString(S s) {
        SerializeConfig config = new SerializeConfig();
        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        return JSON.toJSONString(s, config);
    }
}
