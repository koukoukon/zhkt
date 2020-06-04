package me.hibiki.system.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Organiztion implements Serializable {
    private Integer organizationId;

    private String organizationName;

    /**
    * 组织结构编号，第一位为补位，
    */
    private String organizationNumber;

    /**
    * 自关联
    */
    private Integer organiztionPid;

    /**
    * 0:正常 1:禁用
    */
    private String organiztionStatus;

    private static final long serialVersionUID = 1L;
}