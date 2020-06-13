package me.hibiki.system.service.impl;

import me.hibiki.system.domain.SystemRoleMenu;
import me.hibiki.system.mapper.SystemRoleMenuMapper;
import me.hibiki.system.service.SystemRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/6/12 11:23
 */
@Service
public class SystemRoleMenuServiceImpl implements SystemRoleMenuService {
    @Resource
    private SystemRoleMenuMapper systemRoleMenuMapper;
    @Override
    public List<SystemRoleMenu> listByRolePidRoleMenus(Integer rolePid) {
        return systemRoleMenuMapper.listByRolePidRoleMenus(rolePid);
    }

    @Override
    public int roleGrant(Integer roleId, List<Integer> menuIds) {
        systemRoleMenuMapper.deleteRoleMenuByRolePid(roleId);
        int i =0;
        if (menuIds.size()>0){
             i = systemRoleMenuMapper.insertByList(roleId, menuIds);
        }
        return i;
    }
}
