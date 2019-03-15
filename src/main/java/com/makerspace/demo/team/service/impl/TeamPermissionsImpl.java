package com.makerspace.demo.team.service.impl;

import com.makerspace.demo.team.dao.TeamPermissionsMapper;
import com.makerspace.demo.team.domain.TeamPermissions;
import com.makerspace.demo.team.service.TeamPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TeamPermissionsImpl implements TeamPermissionsService {
    @Autowired
    private TeamPermissionsMapper teamPermissionsMapper;

    @Override
    public int insert(Long pkId)throws RuntimeException{
        try {
            TeamPermissions teamPermissions = new TeamPermissions();
            teamPermissions.setGmtCreate(new Date());
            teamPermissions.setGmtModified(new Date());
            teamPermissions.setTeamId(pkId);
            teamPermissions.setPermissionsId(1L);
            return teamPermissionsMapper.insert(teamPermissions);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public TeamPermissions selectPermissions(Long pkId) throws RuntimeException{
        try {
            if (pkId!=null){
                return teamPermissionsMapper.selectByPrimaryKey(pkId);
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Boolean judgment(Long teanId)throws RuntimeException{
        try {
            if (teanId!=null){
                if (teamPermissionsMapper.selectPermissions(teanId)==1L){
                    return true;//普通团队
                }else {
                    return false;//管理员
                }
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
