package me.hibiki.system.service;

import me.hibiki.system.domain.SystemMenu;

import java.util.List;

public interface SystemMenuService{


    int deleteByPrimaryKey(Integer menuId);

    int insert(SystemMenu record);

    int insertSelective(SystemMenu record);

    SystemMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(SystemMenu record);

    int updateByPrimaryKey(SystemMenu record);
    List<SystemMenu> listSystemMenus();

}
