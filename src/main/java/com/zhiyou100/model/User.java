package com.zhiyou100.model;

    import java.sql.Timestamp;

/**
 * @Author: 张峥
 * @Date: 2019/2/25 15:13
 */
public class User {
    private Integer userId;
    private Integer departmentId;
    private Integer roleId;
    private String username;
    private Integer isMale;
    private String mobile;
    private Integer age;
    private String address;
    private Integer isAdmin;
    private Integer isSystem;
    private String password;
    private String tel;
    private String idNum;
    private String email;
    private String hobby;
    private Integer education;
    private String cardNum;
    private String nation;
    private Integer marry;
    private Integer status;
    private Integer remark;
    private Timestamp createTime;
    private Integer creater;
    private Timestamp updateTime;
    private Integer updater;
    private String keyword;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", departmentId=" + departmentId +
                ", roleId=" + roleId +
                ", username='" + username + '\'' +
                ", isMale=" + isMale +
                ", mobile='" + mobile + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", isAdmin=" + isAdmin +
                ", isSystem=" + isSystem +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", idNum='" + idNum + '\'' +
                ", email='" + email + '\'' +
                ", hobby='" + hobby + '\'' +
                ", education=" + education +
                ", cardNum='" + cardNum + '\'' +
                ", nation='" + nation + '\'' +
                ", marry=" + marry +
                ", status=" + status +
                ", remark=" + remark +
                ", createTime=" + createTime +
                ", creater=" + creater +
                ", updateTime=" + updateTime +
                ", updater=" + updater +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIsMale() {
        return isMale;
    }

    public void setIsMale(Integer isMale) {
        this.isMale = isMale;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getMarry() {
        return marry;
    }

    public void setMarry(Integer marry) {
        this.marry = marry;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public User() {
    }
}