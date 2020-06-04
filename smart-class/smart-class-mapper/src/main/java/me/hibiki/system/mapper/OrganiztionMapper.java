package me.hibiki.system.mapper;

import me.hibiki.system.domain.Organiztion;

public interface OrganiztionMapper {
    int deleteByPrimaryKey(Integer organizationId);

    int insert(Organiztion record);

    int insertSelective(Organiztion record);

    Organiztion selectByPrimaryKey(Integer organizationId);

    int updateByPrimaryKeySelective(Organiztion record);

    int updateByPrimaryKey(Organiztion record);
}