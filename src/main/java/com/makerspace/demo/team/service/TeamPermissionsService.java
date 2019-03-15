package com.makerspace.demo.team.service;

import com.makerspace.demo.team.domain.TeamPermissions;

public interface TeamPermissionsService {
    int insert(Long pkId);

    TeamPermissions selectPermissions(Long pkId);

    Boolean judgment(Long teanId);

}
