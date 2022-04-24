package com.cz.alipay.model;

/**
 * <Description>：支付宝商家账户历史余额查询
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public class BillBalanceHisQueryDTO extends AlipayBasePage {

    /**
     * 查询指定自然日的起初余额和期末余额，biz_date与biz_month传入参数互斥
     */
    private String bizDate;

    /**
     * 查询指定自然月的起初余额和期末余额，biz_date与biz_month传入参数互斥
     */
    private String bizMonth;

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getBizMonth() {
        return bizMonth;
    }

    public void setBizMonth(String bizMonth) {
        this.bizMonth = bizMonth;
    }

    @Override
    public String toString() {
        return "BillBalanceHisQueryDTO{" +
                "bizDate='" + bizDate + '\'' +
                ", bizMonth='" + bizMonth + '\'' +
                '}';
    }
}
