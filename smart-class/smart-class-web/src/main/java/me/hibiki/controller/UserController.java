package me.hibiki.controller;

import me.hibiki.system.domain.User;
import me.hibiki.system.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/6/3 21:05
 */
@RestController
@RequestMapping(path = "/admin/user")
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping
    @ResponseBody
    public List<User> listUsers(){
        List<User> users = userService.listUsers();
        return users;
    }

}
