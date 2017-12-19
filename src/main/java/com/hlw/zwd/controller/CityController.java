package com.hlw.zwd.controller;

import com.hlw.zwd.entity.City;
import com.hlw.zwd.exception.Wrong;
import com.hlw.zwd.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    //City
    /*
    添加信息
     */
    @RequestMapping(value = "/add")
    public String add(City city, Map<String, Object> map) {
        System.out.println("租房时代");
        String addInfo = cityService.insert(city);
        map.put("addInfo", addInfo);
        return "city/add";
    }

    /*
    根据ID进行查询
     */
    @RequestMapping(value = "/select")
    public String select(int id, Model model) {
        City city = cityService.selectId(id);
        model.addAttribute("city", city);
        return "city/select";
    }

    /*
    更新信息
     */
    @RequestMapping(value = "/update")
    public String update(City city, Model model) {
        try {
            cityService.update(city);
        } catch (Wrong wrong) {
            wrong.printStackTrace();
            model.addAttribute("msg", "fail");
            return "city/update";
        }
        model.addAttribute("msg", "success");
        return "city/update";
    }

    /**
     * 根据id进行删除
     *
     * @return String
     **/
    @RequestMapping(value = "/delete")
    public String delete(int id, Map<String, String> map) {
        try {
            if (cityService.delete(id) != 0) {
                map.put("msg", "删除成功");
            }
            ;
        } catch (Wrong wrong) {
            wrong.printStackTrace();
            map.put("msg", "删除失败");
        }
        return "city/delete";

    }
}
