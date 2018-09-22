package com.power.saas.controller;

import com.power.saas.common.ID;
import com.power.saas.common.PageUtil;
import com.power.saas.entity.MenuInfo;
import com.power.saas.service.MenuInfoService;
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
@RequestMapping(value = "/menuInfo")
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String vipType() {
        return "menuInfo";
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows,
                                       MenuInfo menuInfo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer total = menuInfoService.queryByCount(menuInfo);
            PageUtil pageUtil = new PageUtil(page, rows, total);
            menuInfo.setPageUtil(pageUtil);
            List<MenuInfo> list = menuInfoService.queryByList(menuInfo);
            map.put("rows", list);
            map.put("total", total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("rows", null);
            map.put("total", 0);
        }
        return map;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(@RequestParam(value = "code", required = false) String code,
                                      @RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "realPrice", required = false) String realPrice,
                                      @RequestParam(value = "unit", required = false) String unit,
                                      @RequestParam(value = "untPrice", required = false) String untPrice,
                                      @RequestParam(value = "pointBase", required = false) String pointBase,
                                      @RequestParam(value = "typeId", required = false) String typeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            MenuInfo menuInfo = new MenuInfo();
            menuInfo.setId(ID.getNonaSec());
            menuInfo.setCode(code);
            menuInfo.setName(name);
            menuInfo.setRealPrice(Double.parseDouble(realPrice));
            menuInfo.setUnit(unit);
            menuInfo.setUntPrice(Double.parseDouble(untPrice));
            menuInfo.setPointBase(Double.parseDouble(pointBase));
            menuInfo.setTypeId(Long.parseLong(typeId));
            menuInfoService.insert(menuInfo);
            map.put("status", Boolean.TRUE);
            map.put("msg", "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", Boolean.FALSE);
            map.put("msg", "保存失败");
        }
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestParam(value = "code", required = false) String code,
                                      @RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "realPrice", required = false) String realPrice,
                                      @RequestParam(value = "unit", required = false) String unit,
                                      @RequestParam(value = "untPrice", required = false) String untPrice,
                                      @RequestParam(value = "pointBase", required = false) String pointBase,
                                      @RequestParam(value = "typeId", required = false) String typeId,
                                      @RequestParam(value = "id", required = false) Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            MenuInfo menuInfo = new MenuInfo();
            menuInfo.setId(id);
            menuInfo.setCode(code);
            menuInfo.setName(name);
            menuInfo.setRealPrice(Double.parseDouble(realPrice));
            menuInfo.setUnit(unit);
            menuInfo.setUntPrice(Double.parseDouble(untPrice));
            menuInfo.setPointBase(Double.parseDouble(pointBase));
            menuInfo.setTypeId(Long.parseLong(typeId));
            menuInfoService.updateByPrimaryKey(menuInfo);
            map.put("status", Boolean.TRUE);
            map.put("msg", "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", Boolean.FALSE);
            map.put("msg", "更新失败");
        }
        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestParam(value = "id", required = false) Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            menuInfoService.deleteByPrimaryKey(id);
            map.put("status", Boolean.TRUE);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", Boolean.FALSE);
            map.put("msg", "删除失败");
        }
        return map;
    }

}
