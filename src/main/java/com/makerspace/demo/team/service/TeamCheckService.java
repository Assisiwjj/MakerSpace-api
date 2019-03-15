package com.makerspace.demo.team.service;

import com.makerspace.demo.team.domain.TeamCheck;
import com.makerspace.demo.utils.PageBean;

public interface TeamCheckService {
    PageBean getPageBean(Integer limit, Integer page);

    int regist(TeamCheck teamCheck);

    int deleteNoPass(Long pkId);

}
