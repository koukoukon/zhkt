package me.hibiki.system.interceptor;

import me.hibiki.system.domain.SystemUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 高弘昆
 * @date 2020/6/16 10:50
 */
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        SystemUser loginUser = (SystemUser) session.getAttribute("loginUser");
        System.out.println("拦截器"+loginUser);
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
        return true;
    }

}
