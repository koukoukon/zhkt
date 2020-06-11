package me.hibiki.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.hibiki.system.domain.SystemRole;
import me.hibiki.system.mapper.SystemRoleMapper;
import me.hibiki.system.service.SystemRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SystemRoleServiceImpl implements SystemRoleService{

    @Resource
    private SystemRoleMapper systemRoleMapper;

    @Override
    public int removeSystemRoleById(Integer roleId) {
        return systemRoleMapper.deleteSystemRoleById(roleId);
    }

    @Override
    public int saveSystemRole(SystemRole role) {
        return systemRoleMapper.insertSystemRole(role);
    }

    @Override
    public SystemRole getSystemById(Integer roleId) {
        return systemRoleMapper.getSystemRoleById(roleId);
    }

    @Override
    public int updateSystemRoleById(SystemRole systemRole) {
        return systemRoleMapper.updateSystemRoleById(systemRole);
    }

    @Override
    public PageInfo<SystemRole> listSystemRoles(int pageNum, int pageSize,SystemRole systemRole) {
        if (systemRole.getRoleStatus()==-1){
            systemRole.setRoleStatus(null);
        }
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<SystemRole>(systemRoleMapper.listSystemRoles(systemRole));
    }
}
