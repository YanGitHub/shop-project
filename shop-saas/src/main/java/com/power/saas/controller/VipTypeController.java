package com.power.saas.controller;

import com.power.saas.common.PageUtil;
import com.power.saas.entity.VipType;
import com.power.saas.service.VipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
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
}
