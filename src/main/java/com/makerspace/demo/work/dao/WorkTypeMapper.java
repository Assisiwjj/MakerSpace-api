package com.makerspace.demo.work.dao;

import com.makerspace.demo.work.domain.WorkType;
import com.makerspace.demo.work.domain.WorkTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WorkTypeMapper {
    long countByExample(WorkTypeExample example);

    int deleteByExample(WorkTypeExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(WorkType record);

    int insertSelective(WorkType record);

    List<WorkType> selectByExample(WorkTypeExample example);

    WorkType selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") WorkType record, @Param("example") WorkTypeExample example);

    int updateByExample(@Param("record") WorkType record, @Param("example") WorkTypeExample example);

    int updateByPrimaryKeySelective(WorkType record);

    int updateByPrimaryKey(WorkType record);

    List<WorkType> selectAllType();
}