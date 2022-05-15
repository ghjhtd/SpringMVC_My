package top.gonghaojing.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProjectInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            System.out.println("Cookies:-------");
            for(Cookie cookie : cookies){
                System.out.println(cookie.getName() + "--->" + cookie.getValue());
            }
        }
        System.out.println("Content-Type:" + request.getHeader("Content-Type"));
        System.out.println("RemoteAddr:" + request.getRemoteAddr());
        System.out.println("RemoteHost:" + request.getRemoteHost());
        System.out.println("LocalName:" + request.getLocalName());
        System.out.println("ServerName:" + request.getServerName());
        System.out.println("RemoteUse:" + request.getRemoteUser());
        System.out.println("preHandle1...");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1...");
    }
}
