package com.power.saas.controller;

import com.power.saas.common.ID;
import com.power.saas.common.PageUtil;
import com.power.saas.entity.VipType;
import com.power.saas.service.VipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/9/22.
 */
@Controller
@RequestMapping(value = "/vipType")
public class VipTypeController {


    @Autowired
    private VipTypeService vipTypeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String vipType(){
        return "vipType";
    }


    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getList(@RequestParam(value = "page",defaultValue = "1")int page,
                                      @RequestParam(value = "rows",defaultValue = "10")int rows,
                                      VipType vipType)throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            Integer total = vipTypeService.queryByCount(vipType);
            PageUtil pageUtil = new PageUtil(page,rows,total);
            vipType.setPageUtil(pageUtil);
            List<VipType> list = vipTypeService.queryByList(vipType);
            map.put("rows",list);
            map.put("total",total);
        }catch (Exception e){
            e.printStackTrace();
            map.put("rows",null);
            map.put("total",0);
        }
        return map;
    }

    @RequestMapping(value = "/combobox",method = RequestMethod.POST)
    @ResponseBody
    public List<VipType> combobox()throws Exception {
        List<VipType> list =new ArrayList<>();
        try {
             list = vipTypeService.queryByList(new VipType());
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(@RequestParam(value = "name",required =false) String name,
                                      @RequestParam(value = "price",required =false)String price,
                                      @RequestParam(value = "discount",required =false)String discount) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            VipType vipType=new VipType();
            vipType.setId(ID.getNonaSec());
            vipType.setDiscount(Double.parseDouble(discount));
            vipType.setName(name);
            vipType.setPrice(Double.parseDouble(price));
            vipTypeService.create(vipType);
            map.put("status",Boolean.TRUE);
            map.put("msg","保存成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",Boolean.FALSE);
            map.put("msg","保存失败");
        }
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestParam(value = "name",required =false) String name,
                                      @RequestParam(value = "price",required =false)String price,
                                      @RequestParam(value = "discount",required =false)String discount,
                                      @RequestParam(value = "id",required =false)Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            VipType vipType=new VipType();
            vipType.setDiscount(Double.parseDouble(discount));
            vipType.setId(id);
            vipType.setName(name);
            vipType.setPrice(Double.parseDouble(price));
            vipTypeService.updateByPrimaryKey(vipType);
            map.put("status",Boolean.TRUE);
            map.put("msg","更新成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",Boolean.FALSE);
            map.put("msg","更新失败");
        }
        return map;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestParam(value = "id",required =false) Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            vipTypeService.deleteByPrimaryKey(id);
            map.put("status",Boolean.TRUE);
            map.put("msg","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",Boolean.FALSE);
            map.put("msg","删除失败");
        }
        return map;
    }
}
