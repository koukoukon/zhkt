package me.hibiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 高弘昆
 * @date 2020/6/3 21:05
 */
@RestController
public class UserController {
    @GetMapping(path = "hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
