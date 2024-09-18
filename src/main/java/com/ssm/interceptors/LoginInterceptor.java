package com.ssm.interceptors;

import com.ssm.utils.JwtUtil;
import com.ssm.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        System.out.println("拦截器拦截到请求，token为：" + token);
        try {
            System.out.println(111);
            Map<String, Object> claims = JwtUtil.parseToken(token);
            System.out.println("解析出来的用户信息为：" + claims);
            // 将解析出来的用户信息放入ThreadLocal中
            ThreadLocalUtil.set(claims);
            System.out.println("ThreadLocal中存放的用户信息为：" + ThreadLocalUtil.get());
//            System.out.println(Optional.ofNullable(ThreadLocalUtil.get()));
            return true;
        } catch (Exception e) {

            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
