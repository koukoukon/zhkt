package me.hibiki.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import me.hibiki.system.domain.Organiztion;
import me.hibiki.system.mapper.OrganiztionMapper;
import me.hibiki.system.service.OrganiztionService;
@Service
public class OrganiztionServiceImpl implements OrganiztionService{

    @Resource
    private OrganiztionMapper organiztionMapper;

    @Override
    public int deleteByPrimaryKey(Integer organizationId) {
        return organiztionMapper.deleteByPrimaryKey(organizationId);
    }

    @Override
    public int insert(Organiztion record) {
        return organiztionMapper.insert(record);
    }

    @Override
    public int insertSelective(Organiztion record) {
        return organiztionMapper.insertSelective(record);
    }

    @Override
    public Organiztion selectByPrimaryKey(Integer organizationId) {
        return organiztionMapper.selectByPrimaryKey(organizationId);
    }

    @Override
    public int updateByPrimaryKeySelective(Organiztion record) {
        return organiztionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Organiztion record) {
        return organiztionMapper.updateByPrimaryKey(record);
    }

}
