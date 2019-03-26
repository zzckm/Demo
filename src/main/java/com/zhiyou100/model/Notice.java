package com.zhiyou100.model;

/**
 * @Author: 张峥
 * @Date: 2019/2/25 15:13
 */

import java.sql.Timestamp;

public class Notice {
    private Integer notice_id;
    private Integer receive_id;
    private String subject;
    private String text;
    private Timestamp pub_time;
    private Timestamp expire_time;
    private Integer status;
    private String remark;
    private Timestamp create_time;
    private Integer creater;
    private Timestamp update_time;
    private Integer updater;
    private String keyword;

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", receive_id=" + receive_id +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", pub_time=" + pub_time +
                ", expire_time=" + expire_time +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", create_time=" + create_time +
                ", creater=" + creater +
                ", update_time=" + update_time +
                ", updater=" + updater +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public Integer getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(Integer notice_id) {
        this.notice_id = notice_id;
    }

    public Integer getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(Integer receive_id) {
        this.receive_id = receive_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getPub_time() {
        return pub_time;
    }

    public void setPub_time(Timestamp pub_time) {
        this.pub_time = pub_time;
    }

    public Timestamp getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Timestamp expire_time) {
        this.expire_time = expire_time;
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

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public Integer getUpdater() {
        return updater;
    }

    public void setUpdater(Integer updater) {
        this.updater = updater;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Notice(Integer notice_id, Integer receive_id, String subject, String text, Timestamp pub_time, Timestamp expire_time, Integer status, String remark, Timestamp create_time, Integer creater, Timestamp update_time, Integer updater, String keyword) {
        this.notice_id = notice_id;
        this.receive_id = receive_id;
        this.subject = subject;
        this.text = text;
        this.pub_time = pub_time;
        this.expire_time = expire_time;
        this.status = status;
        this.remark = remark;
        this.create_time = create_time;
        this.creater = creater;
        this.update_time = update_time;
        this.updater = updater;
        this.keyword = keyword;
    }

    public Notice() {
    }
}
