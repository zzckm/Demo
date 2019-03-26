package com.zhiyou100.model;

import java.sql.Timestamp;

/**
 * @Author: 张峥
 * @Date: 2019/2/27 9:54
 */
public class Message {
   private Integer messageId;
    private String subject;
    private String content;
    private Integer sender;
    private String senderName;
    private Timestamp saveTime;
    private Timestamp sendTime;
   private Integer sendDelete;
   private Integer sendStatus;
   private Timestamp sendUpdateTime;
   private Integer  receiver;
   private String receiverName;
   private Integer receiveDelete;
    private Integer receiveStatus;
   private Timestamp receiveUpdateTime;
   private  String keyword;
   private  User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", sender=" + sender +
                ", senderName='" + senderName + '\'' +
                ", saveTime=" + saveTime +
                ", sendTime=" + sendTime +
                ", sendDelete=" + sendDelete +
                ", sendStatus=" + sendStatus +
                ", sendUpdateTime=" + sendUpdateTime +
                ", receiver=" + receiver +
                ", receiverName='" + receiverName + '\'' +
                ", receiveDelete=" + receiveDelete +
                ", receiveStatus=" + receiveStatus +
                ", receiveUpdateTime=" + receiveUpdateTime +
                ", keyword='" + keyword + '\'' +
                ", user=" + user +
                '}';
    }

    public Message() {
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Timestamp getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Timestamp saveTime) {
        this.saveTime = saveTime;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSendDelete() {
        return sendDelete;
    }

    public void setSendDelete(Integer sendDelete) {
        this.sendDelete = sendDelete;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Timestamp getSendUpdateTime() {
        return sendUpdateTime;
    }

    public void setSendUpdateTime(Timestamp sendUpdateTime) {
        this.sendUpdateTime = sendUpdateTime;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getReceiveDelete() {
        return receiveDelete;
    }

    public void setReceiveDelete(Integer receiveDelete) {
        this.receiveDelete = receiveDelete;
    }

    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public Timestamp getReceiveUpdateTime() {
        return receiveUpdateTime;
    }

    public void setReceiveUpdateTime(Timestamp receiveUpdateTime) {
        this.receiveUpdateTime = receiveUpdateTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Message(Integer messageId, String subject, String content, Integer sender, String senderName, Timestamp saveTime, Timestamp sendTime, Integer sendDelete, Integer sendStatus, Timestamp sendUpdateTime, Integer receiver, String receiverName, Integer receiveDelete, Integer receiveStatus, Timestamp receiveUpdateTime, String keyword, User user) {
        this.messageId = messageId;
        this.subject = subject;
        this.content = content;
        this.sender = sender;
        this.senderName = senderName;
        this.saveTime = saveTime;
        this.sendTime = sendTime;
        this.sendDelete = sendDelete;
        this.sendStatus = sendStatus;
        this.sendUpdateTime = sendUpdateTime;
        this.receiver = receiver;
        this.receiverName = receiverName;
        this.receiveDelete = receiveDelete;
        this.receiveStatus = receiveStatus;
        this.receiveUpdateTime = receiveUpdateTime;
        this.keyword = keyword;
        this.user = user;
    }
}
