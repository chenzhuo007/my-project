package com.cz.util.dic.test;

import com.alibaba.fastjson.JSON;
import com.cz.util.bean.CopyUtils;
import com.cz.util.dic.DicTranslate;

import lombok.Data;

/**
 * <Description>：测试类
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/22
 */
@Data
public class UserInfo {

    @DicTranslate(enumClass = NameEnum.class)
    private String name;

    @DicTranslate(enumClass = AgeEnum.class)
    private String age;

    public UserInfo() {
    }

    public UserInfo(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("1");
        userInfo.setAge("1");
        UserInfo result = CopyUtils.copyObject(userInfo, UserInfo.class, true);
        System.out.println(JSON.toJSONString(result));
    }
}
