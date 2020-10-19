package com.yz.zhxy.mapper;

import com.yz.zhxy.entity.ParentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface ParentInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(ParentInfo record);

    int insertSelective(ParentInfo record);

    ParentInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(ParentInfo record);

    int updateByPrimaryKey(ParentInfo record);
}