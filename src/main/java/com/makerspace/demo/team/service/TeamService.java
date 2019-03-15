package com.makerspace.demo.team.service;

import com.makerspace.demo.team.domain.Team;
import com.makerspace.demo.utils.PageBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


public interface TeamService {
    PageBean getPageBean(Integer limit, Integer page);

    Team selectByTeamId(Long teamId);

    Boolean insert(Team team);

    Team selectTeamByName(String name);

    Team login(Team team);

    Team updateTeam(Team team);

    int deleteTeam(Long teamId);

    int selectRepeat(String name);

    Boolean upload(Long teamId, MultipartFile file);

    Team updatePassword(Team team);

    String base64Data(Long teamId);

    Boolean sendRePasswordEmail(String teamName , String email, HttpServletRequest request);

    int cmpCode(String checkCode,HttpServletRequest request);

//    List<Team> selectAllTeam();
}
