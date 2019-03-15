package com.makerspace.demo.team.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TeamCheck implements Serializable {
    /**
     * 主键
     */
    private Long pkId;

    /**
     * 团队名称
     */
    private String teamName;

    /**
     * 账户名(邮箱)
     */
    private String name;

    /**
     * 团队负责人
     */
    private String manager;

    /**
     * 负责人联系电话
     */
    private String mTelephone;

    /**
     * 指导老师
     */
    private String teacher;

    /**
     * 指导老师联系电话
     */
    private String tTelephone;

    /**
     * 所属学院
     */
    private String affiliationCollege;

    /**
     * 注册目的
     */
    private String purpose;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getmTelephone() {
        return mTelephone;
    }

    public void setmTelephone(String mTelephone) {
        this.mTelephone = mTelephone;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String gettTelephone() {
        return tTelephone;
    }

    public void settTelephone(String tTelephone) {
        this.tTelephone = tTelephone;
    }

    public String getAffiliationCollege() {
        return affiliationCollege;
    }

    public void setAffiliationCollege(String affiliationCollege) {
        this.affiliationCollege = affiliationCollege;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TeamCheck other = (TeamCheck) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getTeamName() == null ? other.getTeamName() == null : this.getTeamName().equals(other.getTeamName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getManager() == null ? other.getManager() == null : this.getManager().equals(other.getManager()))
            && (this.getmTelephone() == null ? other.getmTelephone() == null : this.getmTelephone().equals(other.getmTelephone()))
            && (this.getTeacher() == null ? other.getTeacher() == null : this.getTeacher().equals(other.getTeacher()))
            && (this.gettTelephone() == null ? other.gettTelephone() == null : this.gettTelephone().equals(other.gettTelephone()))
            && (this.getAffiliationCollege() == null ? other.getAffiliationCollege() == null : this.getAffiliationCollege().equals(other.getAffiliationCollege()))
            && (this.getPurpose() == null ? other.getPurpose() == null : this.getPurpose().equals(other.getPurpose()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getManager() == null) ? 0 : getManager().hashCode());
        result = prime * result + ((getmTelephone() == null) ? 0 : getmTelephone().hashCode());
        result = prime * result + ((getTeacher() == null) ? 0 : getTeacher().hashCode());
        result = prime * result + ((gettTelephone() == null) ? 0 : gettTelephone().hashCode());
        result = prime * result + ((getAffiliationCollege() == null) ? 0 : getAffiliationCollege().hashCode());
        result = prime * result + ((getPurpose() == null) ? 0 : getPurpose().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", teamName=").append(teamName);
        sb.append(", name=").append(name);
        sb.append(", manager=").append(manager);
        sb.append(", mTelephone=").append(mTelephone);
        sb.append(", teacher=").append(teacher);
        sb.append(", tTelephone=").append(tTelephone);
        sb.append(", affiliationCollege=").append(affiliationCollege);
        sb.append(", purpose=").append(purpose);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}