package top.gonghaojing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.gonghaojing.controller.interceptor.ProjectInterceptor;
import top.gonghaojing.controller.interceptor.ProjectInterceptor2;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    ProjectInterceptor projectInterceptor;

    @Autowired
    ProjectInterceptor2 projectInterceptor2;
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/emps", "/emps/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/emps", "/emps/*");
    }
}
