package com.hlw.zwd.mapper;

import com.hlw.zwd.entity.City;
import com.hlw.zwd.entity.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(City record);


    City selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(City record);

    void updateCode(String code, String code1);

    void deleteforCode(String code);
}