package com.hlw.zwd.serviceImpl;

import com.hlw.zwd.entity.City;
import com.hlw.zwd.exception.Wrong;
import com.hlw.zwd.mapper.CityMapper;
import com.hlw.zwd.service.AreaService;
import com.hlw.zwd.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private AreaService areaService;
    @Override
    public String insert(City city) {
        int count=cityMapper.insert(city);
        if(count!=0)
        {
            return "添加成功！";
        }
        return "添加失败";
    }

    @Override
    public City selectId(int id) {
        return cityMapper.selectByPrimaryKey(id);
        //        if (cityMapper.selectByPrimaryKey(id)==null)
//        {
//            throws Wrong("此id不在查询中");
//        };
    }

    @Override
    public int update(City city) throws Wrong {
            Integer a;
        areaService.updateCode(selectId(city.getId()).getCode(),city.getCode());
        if ((a=cityMapper.updateByPrimaryKey(city))==0)
        {
            throw new Wrong("fail");
        };

        return a;
    }

    @Override
    public int delete(int id) throws Wrong {
        System.out.println("呵呵呵");
        City city=selectId(id);
        System.out.println("哈哈哈哈"+city.getCode());
        areaService.deleteforCode(city.getCode());
        return cityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateCode(String code, String code1) {
        cityMapper.updateCode(code,code1);
    }

    /**
     * 通过code删除数据
     * @param code
     */
    @Override
    public void deleteforCode(String code) {
        cityMapper.deleteforCode(code);
    }
}
