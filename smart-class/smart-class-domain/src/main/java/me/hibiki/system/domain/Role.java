package me.hibiki.system.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Role implements Serializable {
    private Integer roleId;

    /**
    * 角色名称
    */
    private String roleName;

    /**
    * 0:用户创建的 1:系统内置的
    */
    private Integer roleDefault;

    /**
    * 0:有效 1:禁用
    */
    private Integer roleStatus;

    /**
    * 用户描述
    */
    private String roleDescription;

    /**
    * 创建人id
    */
    private Integer roleCreateUserPid;

    /**
    * 创建时间
    */
    private Date roleCreateDate;

    /**
    * 修改人id
    */
    private Integer roleEditUserPid;

    /**
    * 修改时间
    */
    private Date roleEditDate;

    private static final long serialVersionUID = 1L;
}