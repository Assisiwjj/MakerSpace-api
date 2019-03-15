package com.makerspace.demo.team.dao;

import com.makerspace.demo.team.domain.TeamIntroduction;
import com.makerspace.demo.team.domain.TeamIntroductionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeamIntroductionMapper {
    long countByExample(TeamIntroductionExample example);

    int deleteByExample(TeamIntroductionExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(TeamIntroduction record);

    int insertSelective(TeamIntroduction record);

    List<TeamIntroduction> selectByExampleWithBLOBs(TeamIntroductionExample example);

    List<TeamIntroduction> selectByExample(TeamIntroductionExample example);

    TeamIntroduction selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") TeamIntroduction record, @Param("example") TeamIntroductionExample example);

    int updateByExampleWithBLOBs(@Param("record") TeamIntroduction record, @Param("example") TeamIntroductionExample example);

    int updateByExample(@Param("record") TeamIntroduction record, @Param("example") TeamIntroductionExample example);

    int updateByPrimaryKeySelective(TeamIntroduction record);

    int updateByPrimaryKeyWithBLOBs(TeamIntroduction record);

    int updateByPrimaryKey(TeamIntroduction record);
}