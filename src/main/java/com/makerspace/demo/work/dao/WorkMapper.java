package com.makerspace.demo.work.dao;

import com.makerspace.demo.work.domain.Work;
import com.makerspace.demo.work.domain.WorkExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    Work selectByWorkId(Long pkId);

    int updateHitsByWorkId(Long pkId);

    List<Work> selectByteamId(Long teamId);

    Boolean updateWorkTName(@Param("affiliateTeam") Long teamId,@Param("teamName") String teamName);

    List countByTechnology();

    List countByIndustry();
}