package me.hibiki.system.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemOrganization implements Serializable {
    private Integer organizationId;

    private String organizationName;

    /**
    * 组织结构编号，第一位为补位，
    */
    private String organizationNumber;

    /**
    * 自关联
    */
    private Integer organizationPid;

    /**
    * 0:正常 1:禁用
    */
    private String organizationStatus;

    private static final long serialVersionUID = 1L;
}