package me.hibiki.system.domain;

import lombok.Data;

/**
 * @author 高弘昆
 * @date 2020/06/12 10:34
 */
@Data
public class SystemRoleMenu {
    private Integer menuId;
    private Integer menuPid;
    private String menuName;
    private Integer checked;
}
