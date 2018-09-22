package com.power.saas.controller;

import com.power.saas.entity.DeskInfo;
import com.power.saas.entity.DeskStatus;
import com.power.saas.entity.DeskType;
import com.power.saas.service.DeskInfoService;
import com.power.saas.service.DeskStatusService;
import com.power.saas.service.DeskTypeService;
import com.power.saas.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/9/22.
 */
@Controller
@RequestMapping("/orderFood")
public class OrderFoodController {

    @Autowired
    private DeskInfoService deskInfoService;

    @Autowired
    private DeskTypeService deskTypeService;

    @Autowired
    private DeskStatusService deskStatusService;

    @Autowired
    private OrderFoodService orderFoodService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView deskInfo(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("deskInfoList",Collections.EMPTY_LIST);
        List<DeskInfo> deskInfoList = deskInfoService.queryByList(new DeskInfo());
        if (deskInfoList.size() > 0){
            for (DeskInfo deskInfo : deskInfoList){
                //类型
                DeskType deskType = deskTypeService.selectByPrimaryKey(deskInfo.getTypeId());
                deskInfo.setDeskType(deskType);
                //状态
                DeskStatus deskStatus = deskStatusService.selectByPrimaryKey(deskInfo.getStatusId());
                deskInfo.setDeskStatus(deskStatus);
            }
            map.put("deskInfoList",deskInfoList);
        }
        return new ModelAndView("orderFood",map);
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submit(@RequestParam(value = "deskInfoId") Long deskInfoId,
                                     @RequestParam(value = "vipId") Long vipId,
                                     @RequestParam(value = "note",required = false) String note,
                                     @RequestParam(value = "item") String item,
                                     @RequestParam(value = "num") String num){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            orderFoodService.submitOrder(deskInfoId,vipId,note,item,num);
            map.put("status",Boolean.TRUE);
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",Boolean.FALSE);
        }
        return map;
    }

}
