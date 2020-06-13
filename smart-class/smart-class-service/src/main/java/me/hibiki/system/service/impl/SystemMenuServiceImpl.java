package me.hibiki.system.service.impl;

import me.hibiki.system.domain.SystemMenu;
import me.hibiki.system.mapper.SystemMenuMapper;
import me.hibiki.system.service.SystemMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemMenuServiceImpl implements SystemMenuService{

    @Resource
    private SystemMenuMapper systemMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return systemMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insert(SystemMenu record) {
        return systemMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SystemMenu record) {
        return systemMenuMapper.insertSelective(record);
    }

    @Override
    public SystemMenu selectByPrimaryKey(Integer menuId) {
        return systemMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(SystemMenu record) {
        return systemMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SystemMenu record) {
        return systemMenuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SystemMenu> listSystemMenus() {
        return systemMenuMapper.listSystemMenus();
    }

}
