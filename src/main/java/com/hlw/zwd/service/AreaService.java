package com.hlw.zwd.service;

import com.hlw.zwd.entity.Area;
import com.hlw.zwd.exception.Wrong;

public interface AreaService {
    public String insert(Area area);

    public Area selectId(int id);

    public int update(Area area) throws Wrong;

    public int delete(int id) throws Wrong;

    public void deleteforCode(String code);

    void updateCode(String code, String code1);
}
