package top.gonghaojing.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"top.gonghaojing.service", "top.gonghaojing.aop"})
@Import({JdbcConfig.class, MybatisConfig.class})
@PropertySource({"classpath:jdbc.properties"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfig {
}
