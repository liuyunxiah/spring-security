package com.example.springsecurity.config;

import com.example.springsecurity.common.model.UserDTO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute("_user");
        if(object == null){
            writeContent(response, "please logon!");
        }
        UserDTO user = (UserDTO)object;
        String uri =  request.getRequestURI();
        if(user.getAuthents().contains("p1") && uri.contains("test1")){
            return true;
        }
        if(user.getAuthents().contains("p2") && uri.contains("test2")){
            return true;
        }
        writeContent(response, "无权限!");
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        PrintWriter p = response.getWriter();
        p.write(msg);
        p.close();
        response.resetBuffer();
    }

}
