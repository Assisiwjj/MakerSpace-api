package com.makerspace.demo.team.dao;

import com.makerspace.demo.team.domain.Team;
import com.makerspace.demo.team.domain.TeamExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeamMapper {
    long countByExample(TeamExample example);

    int deleteByExample(TeamExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(Team record);

    int insertSelective(Team record);

    List<Team> selectByExample(TeamExample example);

    Team selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") Team record, @Param("example") TeamExample example);

    int updateByExample(@Param("record") Team record, @Param("example") TeamExample example);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

    Team selectByTeamId(Long teamId);

    List<Team> selectAllTeam();

    String selectTNameByTeamId(Long teamId);

    Long selectTeamIdByTname(String teamName);


}