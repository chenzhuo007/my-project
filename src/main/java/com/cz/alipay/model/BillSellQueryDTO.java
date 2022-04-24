package com.cz.alipay.model;

/**
 * <Description>：支付宝商家账户卖出交易查询
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public class BillSellQueryDTO extends BillQueryDTO {

    /**
     * 门店编号，模糊搜索
     */
    private String storeNo;

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    @Override
    public String toString() {
        return "BillSellQueryDTO{" +
                "storeNo='" + storeNo + '\'' +
                '}';
    }
}
