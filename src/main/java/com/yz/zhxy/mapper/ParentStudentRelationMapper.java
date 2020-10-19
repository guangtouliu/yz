package com.yz.zhxy.mapper;

import com.yz.zhxy.entity.ParentStudentRelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface ParentStudentRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ParentStudentRelation record);

    int insertSelective(ParentStudentRelation record);

    ParentStudentRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ParentStudentRelation record);

    int updateByPrimaryKey(ParentStudentRelation record);
}