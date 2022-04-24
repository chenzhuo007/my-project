package com.cz.util.dic;

import lombok.Data;

/**
 * <Description>：字典
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/22
 */
@Data
public class Dic implements BaseEnum {

    private String key;

    private String value;
}
