package com.makerspace.demo.team.dao;

import com.makerspace.demo.team.domain.TeamPermissions;
import com.makerspace.demo.team.domain.TeamPermissionsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeamPermissionsMapper {
    long countByExample(TeamPermissionsExample example);

    int deleteByExample(TeamPermissionsExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(TeamPermissions record);

    int insertSelective(TeamPermissions record);

    List<TeamPermissions> selectByExample(TeamPermissionsExample example);

    TeamPermissions selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") TeamPermissions record, @Param("example") TeamPermissionsExample example);

    int updateByExample(@Param("record") TeamPermissions record, @Param("example") TeamPermissionsExample example);

    int updateByPrimaryKeySelective(TeamPermissions record);

    int updateByPrimaryKey(TeamPermissions record);

    Long selectPermissions(Long teamId);
}