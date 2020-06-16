package me.hibiki.system.controller;

import com.github.pagehelper.PageInfo;
import me.hibiki.system.domain.SystemRole;
import me.hibiki.system.domain.SystemUser;
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
    public Map<String, Integer> addSystemRole(String roleName, String roleDescription, @SessionAttribute("loginUser")SystemUser loginUser) {
        SystemRole systemRole = new SystemRole();
        systemRole.setRoleName(roleName);
        systemRole.setRoleDescription(roleDescription);
        systemRole.setRoleDefault(0);
        systemRole.setRoleStatus(0);
        systemRole.setRoleCreateDate(new Date());
        systemRole.setRoleCreateUserPid(loginUser.getUserId());
        int i = systemRoleService.saveSystemRole(systemRole);
        Map<String, Integer> map = new HashMap<>();
        map.put("success", i);
        return map;
    }

    @GetMapping(path = "/{roleId}")
    public SystemRole getSystemRoleById(@PathVariable Integer roleId) {
        return systemRoleService.getSystemById(roleId);
    }

    @PutMapping(path = "/{roleId}")
    public Map<String, Integer> editRole(@PathVariable Integer roleId,SystemRole systemRole,@SessionAttribute("loginUser")SystemUser loginUser) {
        systemRole.setRoleId(roleId);
        systemRole.setRoleEditUserPid(loginUser.getUserId());
        systemRole.setRoleEditDate(new Date());
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
