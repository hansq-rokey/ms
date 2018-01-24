package com.fengzhuo.tudou.ms.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserScoreStatistics {
    private Long id;

    private String userName;

    private String phone;

    private String idNo;

    private BigDecimal zhimaScore;

    private BigDecimal huluScore;

    private BigDecimal tongdunScore;

    private BigDecimal udScore;

    private BigDecimal newUdScore;

    private BigDecimal modelScore;

    private BigDecimal ppxScore;

    private BigDecimal borrowTimesScore;

    private String mobileType;

    private Date createTime;

    private Integer overDay;

    private Long teamId;

    private String blackBox;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public BigDecimal getZhimaScore() {
        return zhimaScore;
    }

    public void setZhimaScore(BigDecimal zhimaScore) {
        this.zhimaScore = zhimaScore;
    }

    public BigDecimal getHuluScore() {
        return huluScore;
    }

    public void setHuluScore(BigDecimal huluScore) {
        this.huluScore = huluScore;
    }

    public BigDecimal getTongdunScore() {
        return tongdunScore;
    }

    public void setTongdunScore(BigDecimal tongdunScore) {
        this.tongdunScore = tongdunScore;
    }

    public BigDecimal getUdScore() {
        return udScore;
    }

    public void setUdScore(BigDecimal udScore) {
        this.udScore = udScore;
    }

    public BigDecimal getNewUdScore() {
        return newUdScore;
    }

    public void setNewUdScore(BigDecimal newUdScore) {
        this.newUdScore = newUdScore;
    }

    public BigDecimal getModelScore() {
        return modelScore;
    }

    public void setModelScore(BigDecimal modelScore) {
        this.modelScore = modelScore;
    }

    public BigDecimal getPpxScore() {
        return ppxScore;
    }

    public void setPpxScore(BigDecimal ppxScore) {
        this.ppxScore = ppxScore;
    }

    public BigDecimal getBorrowTimesScore() {
        return borrowTimesScore;
    }

    public void setBorrowTimesScore(BigDecimal borrowTimesScore) {
        this.borrowTimesScore = borrowTimesScore;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType == null ? null : mobileType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOverDay() {
        return overDay;
    }

    public void setOverDay(Integer overDay) {
        this.overDay = overDay;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getBlackBox() {
        return blackBox;
    }

    public void setBlackBox(String blackBox) {
        this.blackBox = blackBox == null ? null : blackBox.trim();
    }
}