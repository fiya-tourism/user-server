package com.fy.user.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserVO {
    private Integer userId;

    private String userName;

    private Integer userSex;

    private Integer userAge;

    private String userPhoto;

    private String userPhone;

    private String userIdentity;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date userBir;

    private String userDwell;

    private String userEmail;

    private String userSignature;

    private Integer userCollect;

    private String userPassword;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date comCreate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date comUpdate;

    private Integer comYn;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Date getUserBir() {
        return userBir;
    }

    public void setUserBir(Date userBir) {
        this.userBir = userBir;
    }

    public String getUserDwell() {
        return userDwell;
    }

    public void setUserDwell(String userDwell) {
        this.userDwell = userDwell;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public Integer getUserCollect() {
        return userCollect;
    }

    public void setUserCollect(Integer userCollect) {
        this.userCollect = userCollect;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getComCreate() {
        return comCreate;
    }

    public void setComCreate(Date comCreate) {
        this.comCreate = comCreate;
    }

    public Date getComUpdate() {
        return comUpdate;
    }

    public void setComUpdate(Date comUpdate) {
        this.comUpdate = comUpdate;
    }

    public Integer getComYn() {
        return comYn;
    }

    public void setComYn(Integer comYn) {
        this.comYn = comYn;
    }
}