package me.hibiki.controller;

import me.hibiki.system.domain.SystemRoleMenu;
import me.hibiki.system.service.SystemRoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/6/12 11:26
 */
@RestController
@RequestMapping(path = "/admin/roleMenu")
public class SystemRoleMenuController {
    @Resource
    private SystemRoleMenuService systemRoleMenuService;
    @GetMapping
    public List<SystemRoleMenu>  listByRolePidRoleMenus(Integer roleId){
        return  systemRoleMenuService.listByRolePidRoleMenus(roleId);
    }
    @PostMapping
    @ResponseBody
    public Map<String,Integer> roleGrant(@RequestBody Map<String,Object> requestMap){
        System.out.println(requestMap);
        String  roleId =(String) requestMap.get("roleId");
        System.out.println(roleId);
        List<Integer> menuIds = (List<Integer>) requestMap.get("menuIds");
        System.out.println(menuIds);
        int i = systemRoleMenuService.roleGrant(Integer.parseInt(roleId), menuIds);
        Map<String, Integer> map = new HashMap<>();
        map.put("success",i);
        return  map;
    }

}
