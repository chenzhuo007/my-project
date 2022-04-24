package com.cz.util.dic;

/**
 * <Description>：基础枚举
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/14
 */
public interface BaseEnum {

    String KEY = "key";

    String VALUE = "value";

    /**
     * 获取key值
     *
     * @return
     */
    String getKey();

    /**
     * 获取value值
     *
     * @return
     */
    String getValue();
}
