package com.yz.zhxy.mapper;

import com.yz.zhxy.entity.PlatMenuRelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface PlatMenuRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatMenuRelation record);

    int insertSelective(PlatMenuRelation record);

    PlatMenuRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatMenuRelation record);

    int updateByPrimaryKey(PlatMenuRelation record);
}