package com.makerspace.demo.team.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TeamPermissions implements Serializable {
    /**
     * 主键
     */
    private Long pkId;

    /**
     * 团队id
     */
    private Long teamId;

    /**
     * 0:管理员 1:普通团队
     */
    private Long permissionsId;

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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Long permissionsId) {
        this.permissionsId = permissionsId;
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
        TeamPermissions other = (TeamPermissions) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getTeamId() == null ? other.getTeamId() == null : this.getTeamId().equals(other.getTeamId()))
            && (this.getPermissionsId() == null ? other.getPermissionsId() == null : this.getPermissionsId().equals(other.getPermissionsId()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());
        result = prime * result + ((getPermissionsId() == null) ? 0 : getPermissionsId().hashCode());
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
        sb.append(", teamId=").append(teamId);
        sb.append(", permissionsId=").append(permissionsId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}