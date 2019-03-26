package com.zhiyou100.model;

import java.sql.Timestamp;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 19:52
 */
public class CustomerState {
   private Integer customerStateId ;
    private String customerStateName;
    private String customerStateDesc;
    private Integer status;
    private  String remark;
    private Timestamp createTime;
    private  Integer creater;
    private Timestamp updateTime;
    private Integer updater;

    @Override
    public String toString() {
        return "CustomerState{" +
                "customerStateId=" + customerStateId +
                ", customerStateName='" + customerStateName + '\'' +
                ", customerStateDesc='" + customerStateDesc + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", creater=" + creater +
                ", updateTime=" + updateTime +
                ", updater=" + updater +
                '}';
    }

    public Integer getCustomerStateId() {
        return customerStateId;
    }

    public void setCustomerStateId(Integer customerStateId) {
        this.customerStateId = customerStateId;
    }

    public String getCustomerStateName() {
        return customerStateName;
    }

    public void setCustomerStateName(String customerStateName) {
        this.customerStateName = customerStateName;
    }

    public String getCustomerStateDesc() {
        return customerStateDesc;
    }

    public void setCustomerStateDesc(String customerStateDesc) {
        this.customerStateDesc = customerStateDesc;
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

    public CustomerState() {
    }

    public CustomerState(Integer customerStateId, String customerStateName, String customerStateDesc, Integer status, String remark, Timestamp createTime, Integer creater, Timestamp updateTime, Integer updater) {
        this.customerStateId = customerStateId;
        this.customerStateName = customerStateName;
        this.customerStateDesc = customerStateDesc;
        this.status = status;
        this.remark = remark;
        this.createTime = createTime;
        this.creater = creater;
        this.updateTime = updateTime;
        this.updater = updater;
    }
}
