package me.hibiki.system.interceptor;

import me.hibiki.system.annotation.RoleAnnotation;
import me.hibiki.system.domain.SystemUser;
import me.hibiki.system.exception.SystemException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/6/16 10:50
 */
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        SystemUser loginUser = (SystemUser) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
        //权限校验
//        HandlerMethod.class.isInstance(handler.getClass());
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RoleAnnotation roleAnnotation = handlerMethod.getMethodAnnotation(RoleAnnotation.class);
            if (roleAnnotation != null) {
                List<Integer> menuIds = (List<Integer>) session.getAttribute("menuIds");
                System.out.println("当前登录用户所拥有的权限" + menuIds);
                int[] value = roleAnnotation.value();
                System.out.println("执行方法所需的权限" + Arrays.toString(value));
                if (!hasAuthority(value,menuIds)){
                    throw new SystemException("无权限执行该操作");
                }
            } else {
                System.out.println("不需要权限");
            }
        }
        return true;
    }

    /**
     *
     * @param value 方法执行所需的权限数组
     * @param list 用户所拥有的权限集合
     * @return 是否拥有权限执行
     */
    private boolean hasAuthority(int[] value, List<Integer> list) {
        for (int i : value) {
            if (!list.contains(i)){
                return false;
            }
        }
        return true;
    }

}
