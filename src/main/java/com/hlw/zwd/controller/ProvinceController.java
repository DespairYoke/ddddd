package com.hlw.zwd.controller;

import com.hlw.zwd.entity.Province;
import com.hlw.zwd.exception.Wrong;
import com.hlw.zwd.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
@RequestMapping(value = "/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    //City
    /*
    添加信息
     */
    @RequestMapping(value = "/add")
    public String add(Province province, Map<String, Object> map) {
        System.out.println("租房时代");
        String addInfo = provinceService.insert(province);
        map.put("addInfo", addInfo);
        return "province/add";
    }

    /*
    根据ID进行查询
     */
    @RequestMapping(value = "/select")
    public String select(int id, Model model) {
        Province province = provinceService.selectId(id);
        model.addAttribute("province", province);
        return "province/select";
    }

    /*
    更新信息
     */
    @RequestMapping(value = "/update")
    public String update(Province province, Model model) {
        try {
            provinceService.update(province);
        } catch (Wrong wrong) {
            wrong.printStackTrace();
            model.addAttribute("msg", "fail");
            return "province/update";
        }
        model.addAttribute("msg", "success");
        return "province/update";
    }

    /**
     * 根据id进行删除
     *
     * @return String
     **/
    @RequestMapping(value = "/delete")
    public String delete(int id, Map<String, String> map) {
        try {
            if (provinceService.delete(id) != 0) {
                map.put("msg", "删除成功");
            }
            ;
        } catch (Wrong wrong) {
            wrong.printStackTrace();
            map.put("msg", "删除失败");
        }
        return "province/delete";

    }
}
