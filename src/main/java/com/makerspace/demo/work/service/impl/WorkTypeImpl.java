package com.makerspace.demo.work.service.impl;

import com.makerspace.demo.work.dao.WorkTypeMapper;
import com.makerspace.demo.work.domain.WorkType;
import com.makerspace.demo.work.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeImpl implements WorkTypeService {
    @Autowired
    private WorkTypeMapper workTypeMapper;

    @Override
    public List<WorkType> selectAllType(){
        return workTypeMapper.selectAllType();
    }
}
