package me.hibiki.system.service;

import me.hibiki.system.domain.Organiztion;
public interface OrganiztionService{


    int deleteByPrimaryKey(Integer organizationId);

    int insert(Organiztion record);

    int insertSelective(Organiztion record);

    Organiztion selectByPrimaryKey(Integer organizationId);

    int updateByPrimaryKeySelective(Organiztion record);

    int updateByPrimaryKey(Organiztion record);

}
