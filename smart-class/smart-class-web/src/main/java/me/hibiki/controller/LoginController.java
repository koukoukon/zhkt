package me.hibiki.controller;

import me.hibiki.system.domain.SystemUser;
import me.hibiki.system.service.SystemUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/6/15 18:37
 */
@RestController
public class LoginController {
    @Resource
    private SystemUserService systemUserService;
    @PostMapping(name = "/login")
    public Map<String,Integer> login(String userName, String userPassword){
        SystemUser loginUser = systemUserService.getUserByLogin(userName, userPassword);
        Map<String, Integer> map = new HashMap<>();
        if (loginUser==null){
            map.put("success",0);
        }else {
            map.put("success",1);
        }
        return map;
    }
}
