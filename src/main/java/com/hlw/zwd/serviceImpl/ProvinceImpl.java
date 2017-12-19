package com.hlw.zwd.serviceImpl;

import com.hlw.zwd.entity.City;
import com.hlw.zwd.entity.Province;
import com.hlw.zwd.exception.Wrong;
import com.hlw.zwd.mapper.ProvinceMapper;
import com.hlw.zwd.service.CityService;
import com.hlw.zwd.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityService cityService;
    @Override
    public String insert(Province province) {
        int count=provinceMapper.insert(province);
        if(count!=0)
        {
            return "添加成功！";
        }
        return "添加失败";
    }

    @Override
    public Province selectId(int id) {
        return provinceMapper.selectByPrimaryKey(id);
        //        if (provinceMapper.selectByPrimaryKey(id)==null)
//        {
//            throws Wrong("此id不在查询中");
//        };
    }

    @Override
    public int update(Province province) throws Wrong {

        Integer a;
        cityService.updateCode(selectId(province.getId()).getCode(),province.getCode());
        if ((a=provinceMapper.updateByPrimaryKey(province))==0)
        {
            throw new Wrong("fail");
        };

        return a;
    }

    @Override
    public int delete(int id) throws Wrong {
        System.out.println("呵呵呵");
        Province province=selectId(id);
        System.out.println("哈哈哈哈"+province.getCode());
        cityService.deleteforCode(province.getCode());
        return provinceMapper.deleteByPrimaryKey(id);
    }
}
