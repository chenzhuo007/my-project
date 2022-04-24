package com.cz.alipay.model;

import com.cz.alipay.util.FastJsonUtil;

/**
 * <Description>：统一的返回结果
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public class AlipayResult {

    public static void main(String[] args) {
        AlipayBasePage alipayBasePage = new AlipayBasePage();

        alipayBasePage.setPageNo("1");
        alipayBasePage.setPageSize("1");
        System.out.println(FastJsonUtil.toJsonString(alipayBasePage));
    }
}
