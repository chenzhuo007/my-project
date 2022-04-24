package com.cz.alipay.client;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.cz.alipay.operate.MerchantBillOperate;
import com.cz.alipay.operate.impl.MerchantBillOperateImpl;

/**
 * <Description>：
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public class AlipayClientFactory {


    public static AlipayClient getAlipayClient(String serverUrl, String appId, String privateKey) {
        return new DefaultAlipayClient(serverUrl, appId, privateKey);
    }

    public static MerchantBillOperate getMerchantBillOperate(String serverUrl, String appId, String privateKey) {
        return new MerchantBillOperateImpl(getAlipayClient(serverUrl, appId, privateKey));
    }


}
