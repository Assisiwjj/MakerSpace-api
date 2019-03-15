package com.makerspace.demo.work.service;

import com.makerspace.demo.work.domain.BasicJoint;

public interface basicJoint {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicJoint record);

    BasicJoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(BasicJoint record);
}
