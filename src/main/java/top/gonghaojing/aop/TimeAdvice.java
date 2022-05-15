package top.gonghaojing.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class TimeAdvice {
    //@Pointcut("execution(void top.gonghaojing.service.EmpDaoService.selectOne(int))")
    public void empDao(){}

    @Pointcut("execution(* top.gonghaojing.dao.EmpDao.*(..))")
    public void gettime(){}

    //@Before("empDao()")
    public void method(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));
    }

    @Around("gettime()")
    public Object getTime(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Class com = signature.getDeclaringType();
        String name = signature.getName();
        long time = System.currentTimeMillis();
        Object obj = pjp.proceed(pjp.getArgs());
        time = System.currentTimeMillis() - time;
        System.out.println(com.getName() + "-->" + name + "运行时间:" + time + "ms");
        return obj;
    }
}
