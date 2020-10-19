package com.yz.zhxy.mapper;

import com.yz.zhxy.entity.PlatForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface PlatFormMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatForm record);

    int insertSelective(PlatForm record);

    PlatForm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatForm record);

    int updateByPrimaryKey(PlatForm record);
}