package com.ksn.asecpt;

import com.ksn.entity.annotation.SwitchDataSource;
import com.ksn.handle.HandleDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:54
 */
@Aspect
@Slf4j
@Component
@EnableAspectJAutoProxy
public class SwitchDataSourceAsecpt implements Ordered {

    @Pointcut(value = "execution(* com.ksn..*.*(..))")
    public void pointCut() {}

    @Before(value = "pointCut() && @annotation(com.ksn.entity.annotation.SwitchDataSource)")
    public void before(JoinPoint point) {
        System.out.println("前置通知");
        // 设置 处理数据源
        MethodSignature signature = (MethodSignature) point.getSignature();
        SwitchDataSource annotation = signature.getMethod().getAnnotation(SwitchDataSource.class);
        if (annotation == null) {
            HandleDataSource.putKey(SwitchDataSource.keyEnum.MASTER.getKey());
        } else {
            HandleDataSource.putKey(annotation.key().getKey());
        }
    }

    @After(value = "pointCut() && @annotation(com.ksn.entity.annotation.SwitchDataSource)")
    public void after(JoinPoint point) {
        System.out.println("最终通知");
        // 方法执行完把threadlocal的key清除掉
        HandleDataSource.clear();
    }

    @AfterReturning(value = "pointCut() && @annotation(com.ksn.entity.annotation.SwitchDataSource)", returning = "result")
    public void afterReturning(JoinPoint point, Object result) {
        System.out.println("后置通知:" + result);
    }

    @AfterThrowing(value = "pointCut() && @annotation(com.ksn.entity.annotation.SwitchDataSource)", throwing = "e")
    public void afterThrowing(JoinPoint point, Throwable e) {
        System.out.println("异常通知：" + e);
    }

    @Around(value = "pointCut() && @annotation(com.ksn.entity.annotation.SwitchDataSource)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕通知前");
        Object proceed = point.proceed();
        System.out.println("环绕通知后");
        return proceed;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
