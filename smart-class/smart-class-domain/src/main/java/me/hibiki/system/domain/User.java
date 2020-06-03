package me.hibiki.system.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User implements Serializable {
    private Integer userId;

    /**
    * 真实姓名
    */
    private String userName;

    /**
    * 密码
    */
    private String userPassword;

    /**
    * 手机号
    */
    private String userPhone;

    /**
    * 工号或学号
    */
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