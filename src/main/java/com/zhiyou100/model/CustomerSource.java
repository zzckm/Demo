package com.zhiyou100.model;

import java.sql.Timestamp;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 19:57
 */
public class CustomerSource {
    private Integer customerSourceId;
    private String customerSourceName;
    private String customerSourceDesc;
    private Integer status;
    private String remark;
    private Timestamp createTime;
    private Integer creater;
    private Timestamp updateTime;
    private Integer updater;

    @Override
    public String toString() {
        return "CustomerSource{" +
                "customerSourceId=" + customerSourceId +
                ", customerSourceName='" + customerSourceName + '\'' +
                ", customerSourceDesc='" + customerSourceDesc + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", creater=" + creater +
                ", updateTime=" + updateTime +
                ", updater=" + updater +
                '}';
    }

    public Integer getCustomerSourceId() {
        return customerSourceId;
    }

    public void setCustomerSourceId(Integer customerSourceId) {
        this.customerSourceId = customerSourceId;
    }

    public String getCustomerSourceName() {
        return customerSourceName;
    }

    public void setCustomerSourceName(String customerSourceName) {
        this.customerSourceName = customerSourceName;
    }

    public String getCustomerSourceDesc() {
        return customerSourceDesc;
    }

    public void setCustomerSourceDesc(String customerSourceDesc) {
        this.customerSourceDesc = customerSourceDesc;
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

    public CustomerSource() {
    }

    public CustomerSource(Integer customerSourceId, String customerSourceName, String customerSourceDesc, Integer status, String remark, Timestamp createTime, Integer creater, Timestamp updateTime, Integer updater) {
        this.customerSourceId = customerSourceId;
        this.customerSourceName = customerSourceName;
        this.customerSourceDesc = customerSourceDesc;
        this.status = status;
        this.remark = remark;
        this.createTime = createTime;
        this.creater = creater;
        this.updateTime = updateTime;
        this.updater = updater;
    }
}