package me.hibiki.system.controller;

import com.github.pagehelper.PageInfo;
import me.hibiki.system.annotation.RoleAnnotation;
import me.hibiki.system.domain.ResultBean;
import me.hibiki.system.domain.ResultMapBean;
import me.hibiki.system.domain.SystemUser;
import me.hibiki.system.service.SystemUserService;
import me.hibiki.system.util.Md5Util;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @RoleAnnotation(value = {2})
    public ResultMapBean listSystemUsers(int pageNum, int pageSize) {
        PageInfo<SystemUser> pageInfo = systemUserService.listSystemUsers(pageNum, pageSize);
        ResultMapBean resultMapBean = new ResultMapBean();
        resultMapBean.setCode(0);
        resultMapBean.setMsg("数据请求成功");
        resultMapBean.setCount(pageInfo.getTotal());
        resultMapBean.setData(pageInfo.getList());
        return resultMapBean;
    }
    @PostMapping(params = {"userName","userPassword","userPhone","userNumber"})
    @RoleAnnotation(value = {8})
    public ResultBean  saveSystemUser(@Validated SystemUser systemUser,@SessionAttribute("loginUser") SystemUser loginUser){
        @NotNull @NotEmpty String userPassword = systemUser.getUserPassword();
//        StringUtils.isEmpty()
        userPassword = Md5Util.md5PasswordBySalt(userPassword);
        systemUser.setUserPassword(userPassword);
        systemUser.setUserCreateUserPid(loginUser.getUserId());
        systemUser.setUserCreateDate(new Date());
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(systemUserService.saveSystemUser(systemUser));
        return resultBean;
    }
    @DeleteMapping(path = "/{userId}")
    @RoleAnnotation(value = {7})
    public Map<String,Integer> removeSystemUser(@PathVariable Integer userId){
        int i = systemUserService.removeSystemUserByUserId(userId);
        Map<String, Integer> map = new HashMap<>();
        map.put("success",i);
        return map;
    }
    @RoleAnnotation(value = {1})
    @GetMapping(path = "/{userId}")
    public SystemUser getSystemUserByUserId(@PathVariable Integer userId){
        return systemUserService.getSystemUserByUserId(userId);
    }
    @RoleAnnotation(value = {10})
    @PutMapping(path = "/{userId}")
    public ResultBean editRole(@PathVariable Integer userId, @Validated SystemUser systemUser,@SessionAttribute("loginUser") SystemUser loginUser) {
        systemUser.setUserId(userId);
        systemUser.setUserEditUserPid(loginUser.getUserId());
        systemUser.setUserEditDate(new Date());
        int i = systemUserService.updateByPrimaryKeySelective(systemUser);
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(i);
        return resultBean;
    }


}
