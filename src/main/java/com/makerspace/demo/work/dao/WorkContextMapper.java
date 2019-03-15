package com.makerspace.demo.work.dao;

import com.makerspace.demo.work.domain.WorkContext;
import com.makerspace.demo.work.domain.WorkContextExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WorkContextMapper {
    long countByExample(WorkContextExample example);

    int deleteByExample(WorkContextExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(WorkContext record);

    int insertSelective(WorkContext record);

    List<WorkContext> selectByExampleWithBLOBs(WorkContextExample example);

    List<WorkContext> selectByExample(WorkContextExample example);

    WorkContext selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") WorkContext record, @Param("example") WorkContextExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkContext record, @Param("example") WorkContextExample example);

    int updateByExample(@Param("record") WorkContext record, @Param("example") WorkContextExample example);

    int updateByPrimaryKeySelective(WorkContext record);

    int updateByPrimaryKeyWithBLOBs(WorkContext record);

    int updateByPrimaryKey(WorkContext record);
}