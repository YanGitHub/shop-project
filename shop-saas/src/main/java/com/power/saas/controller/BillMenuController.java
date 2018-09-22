package com.power.saas.controller;

import com.power.saas.common.PageUtil;
import com.power.saas.entity.Bill;
import com.power.saas.entity.BillMenu;
import com.power.saas.entity.DeskInfo;
import com.power.saas.service.BillMenuService;
import com.power.saas.service.BillService;
import com.power.saas.service.DeskInfoService;
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
@RequestMapping(value = "/billMenu")
public class BillMenuController {

    @Autowired
    private BillMenuService billMenuService;

    @Autowired
    private DeskInfoService deskInfoService;

    @Autowired
    private BillService billService;


    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows,
                                       BillMenu billMenu) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer total = billMenuService.queryByCount(billMenu);
            PageUtil pageUtil = new PageUtil(page, rows, total);
            billMenu.setPageUtil(pageUtil);
            List<BillMenu> list = billMenuService.queryByList(billMenu);
            map.put("rows", list);
            map.put("total", total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("rows", null);
            map.put("total", 0);
        }
        return map;
    }

    @RequestMapping(value = "/getListByDeskId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getListByDeskId(Long deskInfoId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            DeskInfo deskInfo = deskInfoService.selectByPrimaryKey(deskInfoId);
            Bill bill = billService.selectByPrimaryKey(deskInfo.getBillId());
            BillMenu billMenu = new BillMenu();
            billMenu.setBillNo(bill.getBillNo());
            List<BillMenu> list = billMenuService.queryByList(billMenu);
            map.put("rows", list);
            map.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("rows", null);
            map.put("total", 0);
        }
        return map;
    }
}
