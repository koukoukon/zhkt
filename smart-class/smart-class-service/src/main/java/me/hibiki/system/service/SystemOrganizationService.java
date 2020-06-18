package me.hibiki.system.service;

import me.hibiki.system.domain.SystemOrganization;

import java.util.List;

public interface SystemOrganizationService{


    int deleteByPrimaryKey(Integer organizationId);

    int insert(SystemOrganization record);

    int insertSelective(SystemOrganization record);

    SystemOrganization selectByPrimaryKey(Integer organizationId);

    int updateByPrimaryKeySelective(SystemOrganization record);

    int updateByPrimaryKey(SystemOrganization record);

    List<SystemOrganization> listByOrganizationPidSystemOrganizations(Integer organizationPid);

}
