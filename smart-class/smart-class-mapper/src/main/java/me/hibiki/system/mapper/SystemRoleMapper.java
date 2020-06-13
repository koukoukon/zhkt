package me.hibiki.system.mapper;

import me.hibiki.system.domain.SystemRole;

import java.util.List;

public interface SystemRoleMapper {
    int deleteSystemRoleById(Integer roleId);

    int insertSystemRole(SystemRole role);

    SystemRole getSystemRoleById(Integer roleId);

    int updateSystemRoleById(SystemRole record);

    List<SystemRole> listSystemRoles(SystemRole systemRole);

}