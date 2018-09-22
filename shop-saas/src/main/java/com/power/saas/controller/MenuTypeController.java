package com.power.saas.controller;

import com.power.saas.common.ID;
import com.power.saas.common.PageUtil;
import com.power.saas.entity.MenuType;
import com.power.saas.entity.VipType;
import com.power.saas.service.MenuTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/22.
 */
@Controller
@RequestMapping(value = "/menuType")
public class MenuTypeController {

    @Autowired
    private MenuTypeService menuTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String vipType() {
        return "menuType";
    }


    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows,
                                       MenuType menuType) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer total = menuTypeService.queryByCount(menuType);
            PageUtil pageUtil = new PageUtil(page, rows, total);
            menuType.setPageUtil(pageUtil);
            List<MenuType> list = menuTypeService.queryByList(menuType);
            map.put("rows", list);
            map.put("total", total);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("rows", null);
            map.put("total", 0);
        }
        return map;
    }

    @RequestMapping(value = "/combobox", method = RequestMethod.POST)
    @ResponseBody
    public List<MenuType> combobox() throws Exception {
        List<MenuType> list = new ArrayList<>();
        try {
            list = menuTypeService.queryByList(new MenuType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(@RequestParam(value = "code", required = false) String code,
                                      @RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "isDiscount", required = false) String isDiscount,
                                      @RequestParam(value = "discount", required = false) String discount) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            MenuType menuType = new MenuType();
            menuType.setId(ID.getNonaSec());
            menuType.setCode(code);
            menuType.setName(name);
            menuType.setDiscount(Double.parseDouble(discount));
            menuType.setIsDiscount(Integer.parseInt(isDiscount));
            menuTypeService.insert(menuType);
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
                                      @RequestParam(value = "isDiscount", required = false) String isDiscount,
                                      @RequestParam(value = "discount", required = false) String discount,
                                      @RequestParam(value = "id", required = false) Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            MenuType menuType = new MenuType();
            menuType.setId(id);
            menuType.setCode(code);
            menuType.setName(name);
            menuType.setDiscount(Double.parseDouble(discount));
            menuType.setIsDiscount(Integer.parseInt(isDiscount));
            menuTypeService.updateByPrimaryKey(menuType);
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
            menuTypeService.deleteByPrimaryKey(id);
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
