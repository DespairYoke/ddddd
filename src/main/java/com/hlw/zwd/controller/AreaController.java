package com.hlw.zwd.controller;

import com.hlw.zwd.entity.Area;
import com.hlw.zwd.exception.Wrong;
import com.hlw.zwd.service.AreaService;
import com.hlw.zwd.service.CityService;
import com.hlw.zwd.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Controller
@RequestMapping(value = "/area")
public class AreaController {

    @Autowired
    private AreaService areaService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;


//    @Autowired
//    private Guest guest;
//
//    @GetMapping("/")
//    public String index (ModelMap model) {
//
//        model.addAttribute("name" , guest.getName());
//        model.addAttribute("sex" , guest.getSex());
//        return "index";
//    }
    @RequestMapping(value = "/home")
    public void home(){
        System.out.println("分公司地方");
    }
    /*
    添加信息
     */
    @RequestMapping(value = "/add")
    public String add(Area area,Map<String,Object> map){
        System.out.println("租房时代");
        String addInfo=areaService.insert(area);
        map.put("addInfo",addInfo);
        return "area/add";
    }
    /*
    根据ID进行查询
     */
    @RequestMapping(value = "/select")
    public String select(int id,Model model){
        Area area=areaService.selectId(id);
        model.addAttribute("area",area);
        return "area/select";
    }
    /*
    更新信息
     */
    @RequestMapping(value = "/update")
    public String update(Area area,Model model){
        try {
            areaService.update(area);
        } catch (Wrong wrong) {
            wrong.printStackTrace();
             model.addAttribute("msg","fail");
            return "area/update";
        }
        model.addAttribute("msg","success");
        return "area/update";
    }
    /**
     *根据id进行删除
     *@return String
     **/
    @RequestMapping("/delete")
    public String delete(int id,Map<String,String> map)
    {
        try {
            if (areaService.delete(id)!=0)
            {
                map.put("msg","删除成功");
            };
        } catch (Wrong wrong) {
            wrong.printStackTrace();
            map.put("msg","删除失败");
        }
        return "area/delete";
    }



}
