package com.cz.util.dic.test;

import com.cz.util.dic.BaseEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <Description>：
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/22
 */
@Getter
@RequiredArgsConstructor
public enum AgeEnum implements BaseEnum {

    ten("1", "10"),
    one("2", "1");

    private final String key;

    private final String value;
}
