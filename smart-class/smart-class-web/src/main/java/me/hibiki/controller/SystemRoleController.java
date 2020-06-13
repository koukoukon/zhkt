package me.hibiki.controller;

import com.github.pagehelper.PageInfo;
import me.hibiki.system.domain.SystemRole;
import me.hibiki.system.service.SystemRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/6/8 10:54
 */
@RestController
@RequestMapping(path = "/admin/role")
public class SystemRoleController {
    @Resource
    private SystemRoleService systemRoleService;

    @GetMapping
    public Map<String, Object> listsSystemRoles(int pageNum, int pageSize, SystemRole systemRole) {
        PageInfo<SystemRole> pageInfo = systemRoleService.listSystemRoles(pageNum, pageSize, systemRole);
        List<SystemRole> systemRoles = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "数据请求成功");
        map.put("count", total);
        map.put("data", systemRoles);
        return map;
    }

    @PostMapping
    public Map<String, Integer> addSystemRole(String roleName, String roleDescription) {
        SystemRole systemRole = new SystemRole();
        systemRole.setRoleName(roleName);
        systemRole.setRoleDescription(roleDescription);
        systemRole.setRoleDefault(0);
        systemRole.setRoleStatus(0);
        systemRole.setRoleCreateDate(new Date());
        int i = systemRoleService.saveSystemRole(systemRole);
        Map<String, Integer> map = new HashMap<>();
        map.put("success", i);
        return map;
    }

    @GetMapping(path = "/{roleId}")
    public Map<String, Object> getSystemRoleById(@PathVariable Integer roleId) {
        SystemRole systemRole = systemRoleService.getSystemById(roleId);
        Map<String, Object> map = new HashMap<>();
        if (systemRole != null) {
            map.put("code", 0);
            map.put("msg", "数据请求成功");
            map.put("data", systemRole);
        } else {
            map.put("code", -1);
            map.put("msg", "数据请求失败");
            map.put("data", null);
        }
        return map;
    }

    @PutMapping(path = "/{roleId}")
    public Map<String, Integer> editUser(@PathVariable Integer roleId,SystemRole systemRole) {
        systemRole.setRoleId(roleId);
        systemRole.setRoleEditDate(new Date());
        System.out.println(systemRole.getRoleStatus());
        int i = systemRoleService.updateSystemRoleById(systemRole);
        Map<String, Integer> map = new HashMap<>();
        map.put("success", i);
        return map;
    }

    @DeleteMapping(path = "/{roleId}")
    public Map<String, Integer> removeSystemRole(@PathVariable Integer roleId) {
        int i = systemRoleService.removeSystemRoleById(roleId);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("success", i);
        return map;
    }

}
