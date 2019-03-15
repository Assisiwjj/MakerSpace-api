package com.makerspace.demo.work.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Work implements Serializable {
    /**
     * 主键
     */
    private Long pkId;

    /**
     * 作品名称
     */
    private String name;

    /**
     * 技术类别
     */
    private String typeTechnology;

    /**
     * 行业类别
     */
    private String typeIndustry;

    /**
     * 所属团队
     */
    private Long affiliateTeam;

    /**
     * 所属团队名
     */
    private String teamName;

    /**
     * 开发环境及技术
     */
    private String environment;

    /**
     * 展示图片
     */
    private String showPic;

    /**
     * 作品简述
     */
    private String profile;

    /**
     * 点击量
     */
    private Long hits;

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

    /**
     * 0:未删除 1:删除
     */
    private Boolean isDelete;

    /**
     * 0:未审核 1:已审核
     */
    private Boolean isCheck;

    private static final long serialVersionUID = 1L;

    private WorkContext workContext;

    public WorkContext getWorkContext() {
        return workContext;
    }

    public void setWorkContext(WorkContext workContext) {
        this.workContext = workContext;
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

    public String getTypeTechnology() {
        return typeTechnology;
    }

    public void setTypeTechnology(String typeTechnology) {
        this.typeTechnology = typeTechnology;
    }

    public String getTypeIndustry() {
        return typeIndustry;
    }

    public void setTypeIndustry(String typeIndustry) {
        this.typeIndustry = typeIndustry;
    }

    public Long getAffiliateTeam() {
        return affiliateTeam;
    }

    public void setAffiliateTeam(Long affiliateTeam) {
        this.affiliateTeam = affiliateTeam;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getShowPic() {
        return showPic;
    }

    public void setShowPic(String showPic) {
        this.showPic = showPic;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
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
        Work other = (Work) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeTechnology() == null ? other.getTypeTechnology() == null : this.getTypeTechnology().equals(other.getTypeTechnology()))
            && (this.getTypeIndustry() == null ? other.getTypeIndustry() == null : this.getTypeIndustry().equals(other.getTypeIndustry()))
            && (this.getAffiliateTeam() == null ? other.getAffiliateTeam() == null : this.getAffiliateTeam().equals(other.getAffiliateTeam()))
            && (this.getTeamName() == null ? other.getTeamName() == null : this.getTeamName().equals(other.getTeamName()))
            && (this.getEnvironment() == null ? other.getEnvironment() == null : this.getEnvironment().equals(other.getEnvironment()))
            && (this.getShowPic() == null ? other.getShowPic() == null : this.getShowPic().equals(other.getShowPic()))
            && (this.getProfile() == null ? other.getProfile() == null : this.getProfile().equals(other.getProfile()))
            && (this.getHits() == null ? other.getHits() == null : this.getHits().equals(other.getHits()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsCheck() == null ? other.getIsCheck() == null : this.getIsCheck().equals(other.getIsCheck()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeTechnology() == null) ? 0 : getTypeTechnology().hashCode());
        result = prime * result + ((getTypeIndustry() == null) ? 0 : getTypeIndustry().hashCode());
        result = prime * result + ((getAffiliateTeam() == null) ? 0 : getAffiliateTeam().hashCode());
        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());
        result = prime * result + ((getEnvironment() == null) ? 0 : getEnvironment().hashCode());
        result = prime * result + ((getShowPic() == null) ? 0 : getShowPic().hashCode());
        result = prime * result + ((getProfile() == null) ? 0 : getProfile().hashCode());
        result = prime * result + ((getHits() == null) ? 0 : getHits().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsCheck() == null) ? 0 : getIsCheck().hashCode());
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
        sb.append(", typeTechnology=").append(typeTechnology);
        sb.append(", typeIndustry=").append(typeIndustry);
        sb.append(", affiliateTeam=").append(affiliateTeam);
        sb.append(", teamName=").append(teamName);
        sb.append(", environment=").append(environment);
        sb.append(", showPic=").append(showPic);
        sb.append(", profile=").append(profile);
        sb.append(", hits=").append(hits);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isCheck=").append(isCheck);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}