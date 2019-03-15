package com.makerspace.demo.team.service.impl;

import com.makerspace.demo.team.dao.TeamIntroductionMapper;
import com.makerspace.demo.team.domain.TeamIntroduction;
import com.makerspace.demo.team.service.TeamIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TeamIntroductionImpl implements TeamIntroductionService {
    @Autowired
    private TeamIntroductionMapper teamIntroductionMapper;

    @Override
    public int insertn(){
        TeamIntroduction teamIntroduction = new TeamIntroduction();
        teamIntroduction.setGmtCreate(new Date());
        teamIntroduction.setGmtModified(new Date());
        teamIntroductionMapper.insert(teamIntroduction);
        return 1;
    }
}
