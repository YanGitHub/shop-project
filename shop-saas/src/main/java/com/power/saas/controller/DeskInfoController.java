package com.power.saas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yan on 2018/9/22.
 */
@Controller
@RequestMapping("/deskInfo")
public class DeskInfoController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String deskInfo(){
        return "";
    }


}
