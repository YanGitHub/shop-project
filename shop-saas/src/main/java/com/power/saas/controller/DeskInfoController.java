package com.power.saas.controller;

import com.power.saas.common.ID;
import com.power.saas.common.PageUtil;
import com.power.saas.entity.DeskInfo;
import com.power.saas.entity.DeskInfo;
import com.power.saas.entity.DeskStatus;
import com.power.saas.service.DeskInfoService;
import com.power.saas.service.DeskStatusService;
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
 * Created by Yan on 2018/9/22.
 */
@Controller
@RequestMapping("/deskInfo")
public class DeskInfoController {

    
    @Autowired
    private DeskInfoService deskInfoService;

    @Autowired
    private DeskStatusService deskStatusService;
    
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String deskInfo(){
        return "deskInfo";
    }

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getList(@RequestParam(value = "page",defaultValue = "1")int page,
                                      @RequestParam(value = "rows",defaultValue = "10")int rows,
                                      DeskInfo deskInfo)throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            Integer total = deskInfoService.queryByCount(deskInfo);
            PageUtil pageUtil = new PageUtil(page,rows,total);
            deskInfo.setPageUtil(pageUtil);
            List<DeskInfo> list = deskInfoService.queryByList(deskInfo);
            map.put("rows",list);
            map.put("total",total);
        }catch (Exception e){
            e.printStackTrace();
            map.put("rows",null);
            map.put("total",0);
        }
        return map;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(@RequestParam(value = "code",required =false) String code,
                                      @RequestParam(value = "name",required =false) String name,
                                      @RequestParam(value = "typeId",required =false)String typeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            DeskInfo deskInfo=new DeskInfo();
            deskInfo.setId(ID.getNonaSec());
            deskInfo.setCode(code);
            deskInfo.setName(name);
            deskInfo.setTypeId(Long.parseLong(typeId));
            Long id=ID.getNonaSec();
            deskInfo.setStatusId(id);
            deskInfoService.insert(deskInfo);
            DeskStatus deskStatus =new DeskStatus();
            deskStatus.setId(id);
            deskStatus.setStatus("无人用餐");
            deskStatus.setPersonNum(0);
            deskStatusService.insert(deskStatus);
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
    public Map<String, Object> update(@RequestParam(value = "code",required =false) String code,
                                      @RequestParam(value = "name",required =false) String name,
                                      @RequestParam(value = "typeId",required =false)String typeId,
                                      @RequestParam(value = "id",required =false)Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            DeskInfo deskInfo=new DeskInfo();
            deskInfo.setId(id);
            deskInfo.setCode(code);
            deskInfo.setName(name);
            deskInfo.setTypeId(Long.parseLong(typeId));
            deskInfoService.updateByPrimaryKey(deskInfo);
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
            deskInfoService.deleteByPrimaryKey(id);
            deskStatusService.deleteByPrimaryKey(id);
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
