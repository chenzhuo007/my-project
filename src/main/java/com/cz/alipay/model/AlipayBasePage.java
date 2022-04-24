package com.cz.alipay.model;

/**
 * <Description>：
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public class AlipayBasePage {

    /**
     * 分页号，从1开始
     */
    private String pageNo = "1";

    /**
     * 分页大小1000-2000，默认2000
     */
    private String pageSize = "2000";

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
