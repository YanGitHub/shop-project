package com.power.saas.controller;

import com.power.saas.common.ID;
import com.power.saas.common.PageUtil;
import com.power.saas.entity.DeskType;
import com.power.saas.service.DeskTypeService;
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
@RequestMapping(value = "/deskType")
public class DeskTypeController {


    @Autowired
    private DeskTypeService deskTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String vipType() {
        return "deskType";
    }


    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows,
                                       DeskType deskType) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer total = deskTypeService.queryByCount(deskType);
            PageUtil pageUtil = new PageUtil(page, rows, total);
            deskType.setPageUtil(pageUtil);
            List<DeskType> list = deskTypeService.queryByList(deskType);
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
    public List<DeskType> combobox() throws Exception {
        List<DeskType> list = new ArrayList<>();
        try {
            list = deskTypeService.queryByList(new DeskType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(@RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "num", required = false) String num) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            DeskType deskType = new DeskType();
            deskType.setId(ID.getNonaSec());
            deskType.setType(type);
            deskType.setNum(Integer.parseInt(num));
            deskTypeService.insert(deskType);
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
    public Map<String, Object> update(@RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "num", required = false) String num,
                                      @RequestParam(value = "id", required = false) Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            DeskType deskType = new DeskType();
            deskType.setId(id);
            deskType.setType(type);
            deskType.setNum(Integer.parseInt(num));
            deskTypeService.updateByPrimaryKey(deskType);
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
            deskTypeService.deleteByPrimaryKey(id);
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
