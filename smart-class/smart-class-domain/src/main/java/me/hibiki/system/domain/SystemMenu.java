package me.hibiki.system.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class SystemMenu implements Serializable {
    private Integer menuId;

    /**
    * 菜单名称
    */
    private String menuName;

    /**
    * 自关联
    */
    private Integer menuPid;

    /**
    * 第一位,补位.之后每三位代表一个级别菜单编号
    */
    private String menuNum;

    /**
    * 菜单链接
    */
    private String menuUrl;

    /**
    * 0:本系统 1:外链
    */
    private Integer menuTarget;

    /**
    * 菜单小图标
    */
    private String menuMinIcon;

    /**
    * 菜单大图标
    */
    private String menuMaxIcon;

    /**
    * 0:显示型菜单 1:非显示型菜单
    */
    private Integer menuShow;

    /**
    * 菜单排序
    */
    private Byte menuOrder;

    private static final long serialVersionUID = 1L;
}