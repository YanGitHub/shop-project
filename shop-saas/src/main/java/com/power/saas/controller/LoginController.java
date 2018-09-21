package com.power.saas.controller;

import com.power.saas.entity.User;
import com.power.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/9/21.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/verifyLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> verifyLogin(HttpServletRequest request,User user){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status",Boolean.FALSE);
        List<User> users = userService.queryByList(user);
        if (users.size() == 1){
            session.setAttribute("currentUser",users.get(0));
            //是否是管理员
            session.setAttribute("isManager",users.get(0).getType());
            map.put("status",Boolean.TRUE);
        }
        return map;
    }

}
