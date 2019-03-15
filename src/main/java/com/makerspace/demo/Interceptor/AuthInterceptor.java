package com.makerspace.demo.Interceptor;

import com.makerspace.demo.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
public class AuthInterceptor extends HandlerInterceptorAdapter{
    /**
     *预处理回调方法，实现处理器的预处理（如登录检查）。
     *第三个参数为响应的处理器，即controller。
     *返回true，表示继续流程，调用下一个拦截器或者处理器。
     *返回false，表示流程中断，通过response产生响应。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("-------------------preHandle");
//         验证用户是否登陆
        System.out.println(request.getRequestURI());
        System.out.println(request.getSession().getId());
        if(!(request.getRequestURI().contains("work/list")&&request.getMethod().equals("GET"))
           &&!(request.getRequestURI().contains("team/list")&&request.getMethod().equals("GET"))
           &&!(request.getRequestURI().contains("login")&&request.getMethod().equals("POST"))
                &&!(request.getRequestURI().contains("team/regist"))
                &&!(request.getRequestURI().contains("team/getName"))
                &&!(request.getRequestURI().contains("login/forget"))
                &&!(request.getRequestURI().contains("login/forget/repassword"))
                &&!(request.getRequestURI().contains("type"))
                &&!(request.getRequestURI().contains("work/count"))
                &&!(request.getRequestURI().contains("image")&&request.getMethod().equals("GET"))) {
            String header = request.getHeader("X-Token");

            if (header == null || header.isEmpty()) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                PrintWriter writer = response.getWriter();
                writer.write("无效的身份认证");
                return false;
            } else {
                try {
                    JwtUtil jwtUtil = new JwtUtil();
                    Claims claims = jwtUtil.parseJWT(header);
                    request.setAttribute("teamId", claims.getId());
                    return true;
                } catch (Exception e) {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter out = null;
                    PrintWriter writer = response.getWriter();
                    writer.write("无效的身份认证");
                }
            }
        }
          return true;
    }

    /**
     *当前请求进行处理之后，也就是Controller 方法调用之后执行，
     *但是它会在DispatcherServlet 进行视图返回渲染之前被调用。
     *此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("-------------------postHandle");
    }

    /**
     *方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     *这个方法的主要作用是用于进行资源清理工作的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("-------------------afterCompletion");
    }
}
