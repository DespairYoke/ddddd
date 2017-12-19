package com.hlw.zwd.service;

import com.hlw.zwd.entity.Area;
import com.hlw.zwd.entity.Province;
import com.hlw.zwd.exception.Wrong;

public interface ProvinceService {
    public String insert(Province province);

    public Province selectId(int id);

    public int update(Province province) throws Wrong;

    public int delete(int id) throws Wrong;
}
