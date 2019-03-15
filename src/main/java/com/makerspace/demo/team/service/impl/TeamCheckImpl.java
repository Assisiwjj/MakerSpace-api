package com.makerspace.demo.team.service.impl;

import com.makerspace.demo.team.dao.TeamCheckMapper;
import com.makerspace.demo.team.domain.TeamCheck;
import com.makerspace.demo.team.domain.TeamCheckExample;
import com.makerspace.demo.team.domain.TeamExample;
import com.makerspace.demo.team.service.TeamCheckService;
import com.makerspace.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TeamCheckImpl implements TeamCheckService {
    @Autowired
    private TeamCheckMapper teamCheckMapper;


    @Override
    public PageBean getPageBean(Integer limit, Integer page){
        try {
            TeamCheckExample example = new TeamCheckExample();
            int count = (int) teamCheckMapper.countByExample(example);
            if(count>0) {
                PageBean pageBean = new PageBean(page, count, limit);
                example.setLimit(limit);
                example.setOffset(pageBean.getStart());
                pageBean.setList((teamCheckMapper.selectByExample(example)));
                return pageBean;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public int regist(TeamCheck teamCheck){
        teamCheck.setGmtCreate(new Date());
        teamCheck.setGmtModified(new Date());
        return teamCheckMapper.insert(teamCheck);
    }

    @Override
    public int deleteNoPass(Long pkId){
        return teamCheckMapper.deleteByPrimaryKey(pkId);
    }
}
