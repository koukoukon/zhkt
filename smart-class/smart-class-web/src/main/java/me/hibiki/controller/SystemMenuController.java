package me.hibiki.controller;

import me.hibiki.system.domain.SystemMenu;
import me.hibiki.system.service.SystemMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/6/5 11:00
 */
@RestController
@RequestMapping(path = "/admin/menu")
public class SystemMenuController {
    @Resource
    private SystemMenuService systemMenuService;

    @GetMapping
    public List<SystemMenu> listSystemMenus() {
        return systemMenuService.listSystemMenus();
    }
    @PostMapping(path = "grant")
    public Map<String,Integer> roleGrant(Integer roleId, String menuIds){
        return  null;
    }
}
