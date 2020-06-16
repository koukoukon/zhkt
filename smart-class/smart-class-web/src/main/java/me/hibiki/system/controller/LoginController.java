package me.hibiki.system.controller;

import me.hibiki.system.domain.SystemUser;
import me.hibiki.system.service.SystemUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/6/15 18:37
 */
@Controller

public class LoginController {
    @Resource
    private SystemUserService systemUserService;
    @PostMapping(path = "/login")
    @ResponseBody
    public Map<String,Integer> login(String userName, String userPassword, HttpSession httpSession){
        SystemUser loginUser = systemUserService.getUserByLogin(userName, userPassword);
        Map<String, Integer> map = new HashMap<>();
        if (loginUser==null){
            map.put("success",0);
        }else {
            httpSession.setAttribute("loginUser",loginUser);
            map.put("success",1);
        }
        return map;
    }
    @GetMapping(path = "/admin/logout")
    public String logout(HttpServletRequest request){
        System.out.println("退出登录");
        request.getSession().removeAttribute("loginUser");
        return "redirect:/login.html";
    }
}
