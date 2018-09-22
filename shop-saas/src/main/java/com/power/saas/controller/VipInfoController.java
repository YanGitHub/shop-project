package com.power.saas.controller;

import com.power.saas.common.ID;
import com.power.saas.common.PageUtil;
import com.power.saas.entity.VipInfo;
import com.power.saas.entity.VipType;
import com.power.saas.service.VipInfoService;
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
@RequestMapping(value = "/vipInfo")
public class VipInfoController {

    @Autowired
    private VipInfoService vipInfoService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String vipType(){
        return "vipInfo";
    }

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getList(@RequestParam(value = "page",defaultValue = "1")int page,
                                      @RequestParam(value = "rows",defaultValue = "10")int rows,
                                      VipInfo vipInfo)throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            Integer total = vipInfoService.queryByCount(vipInfo);
            PageUtil pageUtil = new PageUtil(page,rows,total);
            vipInfo.setPageUtil(pageUtil);
            List<VipInfo> list = vipInfoService.queryByList(vipInfo);
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
                                      @RequestParam(value = "tel",required =false)String tel,
                                      @RequestParam(value = "pwd",required =false)String pwd,
                                      @RequestParam(value = "note",required =false)String note,
                                      @RequestParam(value = "vipType",required =false)String vipType) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            VipInfo vipInfo=new VipInfo();
            vipInfo.setId(ID.getNonaSec());
            vipInfo.setCode(code);
            vipInfo.setName(name);
            vipInfo.setTel(tel);
            vipInfo.setPwd(pwd);
            vipInfo.setNote(note);
            vipInfo.setVipType(vipType);
            vipInfoService.insert(vipInfo);
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
                                      @RequestParam(value = "tel",required =false)String tel,
                                      @RequestParam(value = "pwd",required =false)String pwd,
                                      @RequestParam(value = "note",required =false)String note,
                                      @RequestParam(value = "vipType",required =false)String vipType,
                                      @RequestParam(value = "id",required =false)Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            VipInfo vipInfo=new VipInfo();
            vipInfo.setId(id);
            vipInfo.setCode(code);
            vipInfo.setName(name);
            vipInfo.setTel(tel);
            vipInfo.setPwd(pwd);
            vipInfo.setNote(note);
            vipInfo.setVipType(vipType);
            vipInfoService.updateByPrimaryKey(vipInfo);
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
    public Map<String, Object> delete(@RequestParam(value = "id",required =false) Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            vipInfoService.deleteByPrimaryKey(id);
            map.put("status",Boolean.TRUE);
            map.put("msg","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",Boolean.FALSE);
            map.put("msg","删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    @ResponseBody
    public List<VipInfo> getAll(VipInfo vipInfo)throws Exception {
        List<VipInfo> list = new ArrayList<VipInfo>();
        try {
            list = vipInfoService.queryByList(vipInfo);
        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }
}
