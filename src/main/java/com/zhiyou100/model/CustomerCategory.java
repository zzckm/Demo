package com.zhiyou100.model;

import java.sql.Timestamp;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 19:50
 */
public class CustomerCategory {
    private Integer customerCategoryId;
    private  String customerCategoryName;
    private  String customerCategoryDesc;
    private  Integer status;
    private  String remark;
    private Timestamp createTime;
    private  Integer creater;
    private  Timestamp updateTime;
    private Integer updater;

    public CustomerCategory() {
    }

    public CustomerCategory(Integer customerCategoryId, String customerCategoryName, String customerCategoryDesc, Integer status, String remark, Timestamp createTime, Integer creater, Timestamp updateTime, Integer updater) {
        this.customerCategoryId = customerCategoryId;
        this.customerCategoryName = customerCategoryName;
        this.customerCategoryDesc = customerCategoryDesc;
        this.status = status;
        this.remark = remark;
        this.createTime = createTime;
        this.creater = creater;
        this.updateTime = updateTime;
        this.updater = updater;
    }

    @Override
    public String toString() {
        return "CustomerCategory{" +
                "customerCategoryId=" + customerCategoryId +
                ", customerCategoryName='" + customerCategoryName + '\'' +
                ", customerCategoryDesc='" + customerCategoryDesc + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", creater=" + creater +
                ", updateTime=" + updateTime +
                ", updater=" + updater +
                '}';
    }

    public Integer getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(Integer customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
    }

    public String getCustomerCategoryName() {
        return customerCategoryName;
    }

    public void setCustomerCategoryName(String customerCategoryName) {
        this.customerCategoryName = customerCategoryName;
    }

    public String getCustomerCategoryDesc() {
        return customerCategoryDesc;
    }

    public void setCustomerCategoryDesc(String customerCategoryDesc) {
        this.customerCategoryDesc = customerCategoryDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdater() {
        return updater;
    }

    public void setUpdater(Integer updater) {
        this.updater = updater;
    }
}
