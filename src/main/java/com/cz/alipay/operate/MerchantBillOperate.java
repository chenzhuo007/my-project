package com.cz.alipay.operate;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayDataBillAccountlogQueryResponse;
import com.alipay.api.response.AlipayDataBillBalanceQueryResponse;
import com.alipay.api.response.AlipayDataBillBalancehisQueryResponse;
import com.alipay.api.response.AlipayDataBillBuyQueryResponse;
import com.alipay.api.response.AlipayDataBillSellQueryResponse;
import com.cz.alipay.model.BillBalanceHisQueryDTO;
import com.cz.alipay.model.BillQueryDTO;
import com.cz.alipay.model.BillSellQueryDTO;

/**
 * <Description>：商家账单相关操作：https://opendocs.alipay.com/open/01inem
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public interface MerchantBillOperate extends AlipayOperate {

    /**
     * 支付宝商家账户账务明细查询
     *
     * @param dto
     * @return
     * @throws AlipayApiException
     */
    AlipayDataBillAccountlogQueryResponse queryBill(BillQueryDTO dto) throws AlipayApiException;


    /**
     * 支付宝商家账户当前余额查询
     *
     * @return
     * @throws AlipayApiException
     */
    AlipayDataBillBalanceQueryResponse queryBillBalance() throws AlipayApiException;


    /**
     * 支付宝商家账户历史余额查询
     *
     * @param dto
     * @return
     * @throws AlipayApiException
     */
    AlipayDataBillBalancehisQueryResponse queryBillBalanceHis(BillBalanceHisQueryDTO dto) throws AlipayApiException;


    /**
     * 支付宝商家账户卖出交易查询
     *
     * @param dto
     * @return
     * @throws AlipayApiException
     */
    AlipayDataBillSellQueryResponse queryBillSell(BillSellQueryDTO dto) throws AlipayApiException;

    /**
     * 支付宝商家账户买入交易查询
     *
     * @param billSellQueryDTO
     * @return
     * @throws AlipayApiException
     */
    AlipayDataBillBuyQueryResponse queryBillBuy(BillSellQueryDTO billSellQueryDTO) throws AlipayApiException;

}

