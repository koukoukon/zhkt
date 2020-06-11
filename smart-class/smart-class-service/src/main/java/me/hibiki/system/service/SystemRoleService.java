package me.hibiki.system.service;

import com.github.pagehelper.PageInfo;
import me.hibiki.system.domain.SystemRole;

public interface SystemRoleService{


    int removeSystemRoleById(Integer roleId);


    int saveSystemRole(SystemRole role);

    SystemRole getSystemById(Integer roleId);

    int updateSystemRoleById(SystemRole systemRole);

    PageInfo<SystemRole> listSystemRoles(int pageNum, int pageSize,SystemRole systemRole);
}
