package me.hibiki.controller;

import com.github.pagehelper.PageInfo;
import me.hibiki.system.domain.ResultBean;
import me.hibiki.system.domain.ResultMapBean;
import me.hibiki.system.domain.SystemUser;
import me.hibiki.system.service.SystemUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/6/15 8:52
 */
@RestController
@RequestMapping(path = "/admin/user")
public class SystemUserController {
    @Resource
    private SystemUserService systemUserService;

    @GetMapping
    public ResultMapBean<SystemUser> listSystemUsers(int pageNum, int pageSize) {
        PageInfo<SystemUser> pageInfo = systemUserService.listSystemUsers(pageNum, pageSize);
        ResultMapBean<SystemUser> resultMapBean = new ResultMapBean<>();
        resultMapBean.setCode(0);
        resultMapBean.setMsg("数据请求成功");
        resultMapBean.setCount(pageInfo.getTotal());
        resultMapBean.setData(pageInfo.getList());
        return resultMapBean;
    }
    @PostMapping(params = {"userName","userPassword","userPhone","userNumber"})
    public ResultBean  saveSystemUser(@Validated SystemUser systemUser){
//        SystemUser systemUser = new SystemUser();
//        systemUser.setUserName(userName);
//        systemUser.setUserPassword(userPassword);
//        systemUser.setUserPhone(userPhone);
//        systemUser.setUserNumber(userNumber);
        systemUser.setUserCreateUserPid(0);
        systemUser.setUserCreateDate(new Date());
        systemUser.setOrganizationPid(3);
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(systemUserService.saveSystemUser(systemUser));
        return resultBean;
    }
    @DeleteMapping(path = "/{userId}")
    public Map<String,Integer> removeSystemUser(@PathVariable Integer userId){
        int i = systemUserService.removeSystemUserByUserId(userId);
        Map<String, Integer> map = new HashMap<>();
        map.put("success",i);
        return map;
    }
    @GetMapping(path = "/{userId}")
    public SystemUser getSystemUserByUserId(@PathVariable Integer userId){
        return systemUserService.getSystemUserByUserId(userId);
    }
    @PutMapping(path = "/{userId}")
    public ResultBean editRole(@PathVariable Integer userId, @Validated SystemUser systemUser) {
        systemUser.setUserId(userId);
        systemUser.setUserEditUserPid(0);
        systemUser.setUserEditDate(new Date());
        int i = systemUserService.updateByPrimaryKeySelective(systemUser);
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(i);
        return resultBean;
    }
}
