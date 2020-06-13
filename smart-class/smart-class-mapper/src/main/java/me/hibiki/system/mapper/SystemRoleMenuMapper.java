package me.hibiki.system.mapper;

import me.hibiki.system.domain.SystemRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/06/12 10:37
 */
public interface SystemRoleMenuMapper {
    List<SystemRoleMenu>  listByRolePidRoleMenus(Integer rolePid);
    int insertByList(@Param("rolePid") Integer roleId,@Param("menuPids") List<Integer> menuIds);
    int deleteRoleMenuByRolePid(Integer rolePid);
}
