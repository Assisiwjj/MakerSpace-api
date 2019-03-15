package com.makerspace.demo.team.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Team implements Serializable {
    /**
     * 主键
     */
    private Long pkId;

    /**
     * 账户名
     */
    private String name;

    /**
     * 账户密码
     */
    private String password;

    /**
     * 团队名称
     */
    private String teamName;

    /**
     * 指导老师
     */
    private String teacher;

    /**
     * 联系电话
     */
    private String tTelephone;

    /**
     * 团队成员
     */
    private String member;

    /**
     * 团队负责人
     */
    private String manager;

    /**
     * 负责人联系电话
     */
    private String mTelephone;

    /**
     * 团队简介
     */
    private String profile;

    /**
     * 团队封面图片
     */
    private String coverPic;

    /**
     * 所属学院
     */
    private String affiliationCollege;

    /**
     * 0:未删除 1:删除
     */
    private Boolean isDelete;

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

    private TeamIntroduction teamIntroduction;

    public TeamIntroduction getTeamIntroduction() {
        return teamIntroduction;
    }

    public void setTeamIntroduction(TeamIntroduction teamIntroduction) {
        this.teamIntroduction = teamIntroduction;
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getAffiliationCollege() {
        return affiliationCollege;
    }

    public void setAffiliationCollege(String affiliationCollege) {
        this.affiliationCollege = affiliationCollege;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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
        Team other = (Team) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getTeamName() == null ? other.getTeamName() == null : this.getTeamName().equals(other.getTeamName()))
            && (this.getTeacher() == null ? other.getTeacher() == null : this.getTeacher().equals(other.getTeacher()))
            && (this.gettTelephone() == null ? other.gettTelephone() == null : this.gettTelephone().equals(other.gettTelephone()))
            && (this.getMember() == null ? other.getMember() == null : this.getMember().equals(other.getMember()))
            && (this.getManager() == null ? other.getManager() == null : this.getManager().equals(other.getManager()))
            && (this.getmTelephone() == null ? other.getmTelephone() == null : this.getmTelephone().equals(other.getmTelephone()))
            && (this.getProfile() == null ? other.getProfile() == null : this.getProfile().equals(other.getProfile()))
            && (this.getCoverPic() == null ? other.getCoverPic() == null : this.getCoverPic().equals(other.getCoverPic()))
            && (this.getAffiliationCollege() == null ? other.getAffiliationCollege() == null : this.getAffiliationCollege().equals(other.getAffiliationCollege()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());
        result = prime * result + ((getTeacher() == null) ? 0 : getTeacher().hashCode());
        result = prime * result + ((gettTelephone() == null) ? 0 : gettTelephone().hashCode());
        result = prime * result + ((getMember() == null) ? 0 : getMember().hashCode());
        result = prime * result + ((getManager() == null) ? 0 : getManager().hashCode());
        result = prime * result + ((getmTelephone() == null) ? 0 : getmTelephone().hashCode());
        result = prime * result + ((getProfile() == null) ? 0 : getProfile().hashCode());
        result = prime * result + ((getCoverPic() == null) ? 0 : getCoverPic().hashCode());
        result = prime * result + ((getAffiliationCollege() == null) ? 0 : getAffiliationCollege().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", teamName=").append(teamName);
        sb.append(", teacher=").append(teacher);
        sb.append(", tTelephone=").append(tTelephone);
        sb.append(", member=").append(member);
        sb.append(", manager=").append(manager);
        sb.append(", mTelephone=").append(mTelephone);
        sb.append(", profile=").append(profile);
        sb.append(", coverPic=").append(coverPic);
        sb.append(", affiliationCollege=").append(affiliationCollege);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}