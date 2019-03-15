package com.makerspace.demo.team.dao;

import com.makerspace.demo.team.domain.TeamCheck;
import com.makerspace.demo.team.domain.TeamCheckExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeamCheckMapper {
    long countByExample(TeamCheckExample example);

    int deleteByExample(TeamCheckExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(TeamCheck record);

    int insertSelective(TeamCheck record);

    List<TeamCheck> selectByExample(TeamCheckExample example);

    TeamCheck selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") TeamCheck record, @Param("example") TeamCheckExample example);

    int updateByExample(@Param("record") TeamCheck record, @Param("example") TeamCheckExample example);

    int updateByPrimaryKeySelective(TeamCheck record);

    int updateByPrimaryKey(TeamCheck record);

    int deleteByIsCheck(String name);
}