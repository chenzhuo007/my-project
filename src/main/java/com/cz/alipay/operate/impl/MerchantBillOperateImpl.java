package com.cz.alipay.operate.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayDataBillAccountlogQueryRequest;
import com.alipay.api.request.AlipayDataBillBalanceQueryRequest;
import com.alipay.api.request.AlipayDataBillBalancehisQueryRequest;
import com.alipay.api.request.AlipayDataBillBuyQueryRequest;
import com.alipay.api.request.AlipayDataBillSellQueryRequest;
import com.alipay.api.response.AlipayDataBillAccountlogQueryResponse;
import com.alipay.api.response.AlipayDataBillBalanceQueryResponse;
import com.alipay.api.response.AlipayDataBillBalancehisQueryResponse;
import com.alipay.api.response.AlipayDataBillBuyQueryResponse;
import com.alipay.api.response.AlipayDataBillSellQueryResponse;
import com.cz.alipay.model.BillBalanceHisQueryDTO;
import com.cz.alipay.model.BillQueryDTO;
import com.cz.alipay.model.BillSellQueryDTO;
import com.cz.alipay.operate.MerchantBillOperate;

/**
 * <Description>：商家账单相关操作
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public class MerchantBillOperateImpl implements MerchantBillOperate {

    private AlipayClient alipayClient;

    public MerchantBillOperateImpl(AlipayClient alipayClient) {
        this.alipayClient = alipayClient;
    }

    @Override
    public AlipayDataBillAccountlogQueryResponse queryBill(BillQueryDTO dto) throws AlipayApiException {
        AlipayDataBillAccountlogQueryRequest request = new AlipayDataBillAccountlogQueryRequest();
        request.setBizContent(JSON.toJSONString(dto));
        return alipayClient.execute(request);
    }

    @Override
    public AlipayDataBillBalanceQueryResponse queryBillBalance() throws AlipayApiException {
        return alipayClient.execute(new AlipayDataBillBalanceQueryRequest());
    }

    @Override
    public AlipayDataBillBalancehisQueryResponse queryBillBalanceHis(BillBalanceHisQueryDTO dto) throws AlipayApiException {
        AlipayDataBillBalancehisQueryRequest request = new AlipayDataBillBalancehisQueryRequest();
        request.setBizContent(JSON.toJSONString(dto));
        return alipayClient.execute(request);
    }

    @Override
    public AlipayDataBillSellQueryResponse queryBillSell(BillSellQueryDTO dto) throws AlipayApiException {
        AlipayDataBillSellQueryRequest request = new AlipayDataBillSellQueryRequest();
        request.setBizContent(JSON.toJSONString(dto));
        return alipayClient.execute(request);
    }

    @Override
    public AlipayDataBillBuyQueryResponse queryBillBuy(BillSellQueryDTO billSellQueryDTO) throws AlipayApiException {
        AlipayDataBillBuyQueryRequest request = new AlipayDataBillBuyQueryRequest();
        request.setBizContent(JSON.toJSONString(billSellQueryDTO));
        return alipayClient.execute(request);
    }
}

