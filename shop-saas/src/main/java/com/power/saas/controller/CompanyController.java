package com.power.saas.controller;

import com.power.saas.entity.Company;
import com.power.saas.entity.DeskType;
import com.power.saas.service.CompanyService;
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
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Company get() throws Exception {
        Company company =new Company();
        try {
            List<Company> list = companyService.queryByList(new Company());
            if (list.size()>0){
                company =list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "address", required = false) String address,
                                      @RequestParam(value = "mobile", required = false) String mobile,
                                      @RequestParam(value = "dutyParagraph", required = false) String dutyParagraph,
                                      @RequestParam(value = "id", required = false) Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Company company =new Company();
            company.setId(id);
            company.setName(name);
            company.setAddress(address);
            company.setMobile(mobile);
            company.setDutyParagraph(dutyParagraph);
            companyService.updateByPrimaryKey(company);
            map.put("status", Boolean.TRUE);
            map.put("msg", "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", Boolean.FALSE);
            map.put("msg", "更新失败");
        }
        return map;
    }

}
