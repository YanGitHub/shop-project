package com.power.saas.controller;

import com.power.saas.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Yan on 2018/9/21.
 */
public class AuthHandlerInterceptor implements HandlerInterceptor {

    private List<String> excludeUrls;

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();

        for (String url : excludeUrls) {
            if (servletPath.contains(url)) {
                return true;
            }
        }
        HttpSession session = request.getSession();

        //用户已登录
        User user = (User) session.getAttribute("currentUser");
        if (user != null){
            return true;
        }

        //登录页面
        if (servletPath.equals("/login")){
            return true;
        }

        //登录校验
        if (servletPath.equals("/verifyLogin")){
            return true;
        }

        if (session == null || servletPath.equals("")){
            response.sendRedirect("/login");
            return false;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
