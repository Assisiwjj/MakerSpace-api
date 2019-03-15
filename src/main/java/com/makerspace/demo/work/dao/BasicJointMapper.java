package com.makerspace.demo.work.dao;

import com.makerspace.demo.work.domain.BasicJoint;
import com.makerspace.demo.work.domain.BasicJointExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BasicJointMapper {
    long countByExample(BasicJointExample example);

    int deleteByExample(BasicJointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BasicJoint record);

    int insertSelective(BasicJoint record);

    List<BasicJoint> selectByExample(BasicJointExample example);

    BasicJoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BasicJoint record, @Param("example") BasicJointExample example);

    int updateByExample(@Param("record") BasicJoint record, @Param("example") BasicJointExample example);

    int updateByPrimaryKeySelective(BasicJoint record);

    int updateByPrimaryKey(BasicJoint record);
}