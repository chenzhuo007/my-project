package com.cz.alipay.model;

/**
 * <Description>：支付宝商家账户账务明细查询
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */

public class BillQueryDTO extends AlipayBasePage {

    /**
     * 账务流水创建时间的起始范围 例如：	2019-01-01 00:00:00
     */
    private String startTime;

    /**
     * 账务流水创建时间的结束范围。与起始时间间隔不超过31天。查询结果为起始时间至结束时间的左闭右开区间
     */
    private String endTime;

    /**
     * 支付宝订单号，通过支付宝订单号精确查询相关的流水明细，商户订单号与支付宝订单号互斥
     */
    private String alipayOrderNo;

    /**
     * 商户订单号，通过商户订单号精确查询相关的流水明细，商户订单号与支付宝订单号互斥
     */
    private String merchantOrderNo;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAlipayOrderNo() {
        return alipayOrderNo;
    }

    public void setAlipayOrderNo(String alipayOrderNo) {
        this.alipayOrderNo = alipayOrderNo;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    @Override
    public String toString() {
        return "BillQueryDTO{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", alipayOrderNo='" + alipayOrderNo + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                '}';
    }
}
