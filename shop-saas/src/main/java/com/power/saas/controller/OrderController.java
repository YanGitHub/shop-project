package com.power.saas.controller;

import com.power.saas.common.PageUtil;
import com.power.saas.entity.Order;
import com.power.saas.entity.VipInfo;
import com.power.saas.service.OrderService;
import com.power.saas.service.VipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/22.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String vipType(){
        return "order";
    }

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getList(@RequestParam(value = "page",defaultValue = "1")int page,
                                      @RequestParam(value = "rows",defaultValue = "10")int rows,
                                      Order order)throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            Integer total = orderService.queryByCount(order);
            PageUtil pageUtil = new PageUtil(page,rows,total);
            order.setPageUtil(pageUtil);
            List<Order> list = orderService.queryByList(order);
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
