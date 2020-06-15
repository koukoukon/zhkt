package me.hibiki.system.service;

import com.github.pagehelper.PageInfo;
import me.hibiki.system.domain.SystemUser;

public interface SystemUserService{
    int removeSystemUserByUserId(Integer userId);
    SystemUser getSystemUserByUserId(Integer userId);
    int updateByPrimaryKeySelective(SystemUser record);
    PageInfo<SystemUser> listSystemUsers(int pageNum,int pageSize);
    SystemUser getUserByLogin(String userName,String userPassword);
    int saveSystemUser(SystemUser systemUser);
}
