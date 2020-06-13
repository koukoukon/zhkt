package me.hibiki.system.service;

import me.hibiki.system.domain.SystemRoleMenu;

import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/6/12 11:22
 */
public interface SystemRoleMenuService {
    List<SystemRoleMenu> listByRolePidRoleMenus(Integer rolePid);
    int roleGrant(Integer roleId,List<Integer> menuIds);
}
