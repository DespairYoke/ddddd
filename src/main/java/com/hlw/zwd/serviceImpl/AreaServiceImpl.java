package com.hlw.zwd.serviceImpl;

import com.hlw.zwd.entity.Area;
import com.hlw.zwd.exception.Wrong;
import com.hlw.zwd.mapper.AreaMapper;
import com.hlw.zwd.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public String insert(Area area) {
        int count=areaMapper.insert(area);
        if(count!=0)
        {
            return "添加成功！";
        }
        return "添加失败";
    }

    @Override
    public Area selectId(int id) {
        return areaMapper.selectByPrimaryKey(id);
        //        if (areaMapper.selectByPrimaryKey(id)==null)
//        {
//            throws Wrong("此id不在查询中");
//        };
    }

    @Override
    public int update(Area area) throws Wrong {

        if (areaMapper.updateByPrimaryKey(area)==0)
        {
            throw new Wrong("fail");
        };
        return areaMapper.updateByPrimaryKey(area);
    }

    @Override
    public int delete(int id) throws Wrong {
        return areaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteforCode(String code) {
        System.out.println("啊啊啊啊");
        areaMapper.deleteforCode(code);
    }

    @Override
    public void updateCode(String code, String citycode) {
        areaMapper.updateCode(code,citycode);
    }
}
