package com.hlw.zwd.service;

import com.hlw.zwd.entity.City;
import com.hlw.zwd.exception.Wrong;

public interface CityService {
    public String insert(City city);

    public City selectId(int id);

    public int update(City city) throws Wrong;

    public int delete(int id) throws Wrong;

    void updateCode(String code, String code1);

    void deleteforCode(String code);
}
