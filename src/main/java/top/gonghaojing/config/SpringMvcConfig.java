package top.gonghaojing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"top.gonghaojing.controller", "top.gonghaojing.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
