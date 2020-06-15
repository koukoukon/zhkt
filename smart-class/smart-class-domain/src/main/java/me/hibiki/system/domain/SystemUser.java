package me.hibiki.system.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class SystemUser implements Serializable {
    private Integer userId;

    /**
    * 真实姓名
    */
    @NotNull
    @NotEmpty
    private String userName;

    /**
    * 密码
    */
    @NotNull
    @NotEmpty
    private String userPassword;

    /**
    * 手机号
    */
    @NotNull
    @NotEmpty
    private String userPhone;

    /**
    * 工号或学号
    */
    @NotNull
    @NotEmpty
    private String userNumber;

    /**
    * 组织外键id
    */
    private Integer organizationPid;

    /**
    * 角色外键id
    */
    private String rolePid;

    /**
    * 0:正常 1:禁用
    */
    private String userStatus;

    /**
    * 0:正常 1:删除
    */
    private String userDeleteFlag;

    /**
    * 创建用户id
    */
    private Integer userCreateUserPid;

    /**
    * 创建时间
    */
    private Date userCreateDate;

    /**
    * 修改用户id
    */
    private Integer userEditUserPid;

    /**
    * 修改时间
    */
    private Date userEditDate;

    private static final long serialVersionUID = 1L;
}