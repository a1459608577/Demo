package com.ksn.Aspect;

import com.alibaba.fastjson.JSON;
import com.ksn.annotation.TestAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.support.RequestHandledEvent;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/4 17:49
 */
@Aspect
@Slf4j
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TestAspect {

    @Pointcut("execution(* com.ksn..*.*(..))")
    private void proxy() {};

//    @Before(value = "proxy() && @annotation(com.ksn.annotation.TestAnnotation) || @within(com.ksn.annotation.TestAnnotation)")
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature)point.getSignature();
        TestAnnotation annotation = null;
        annotation = signature.getMethod().getAnnotation(TestAnnotation.class);
        if (annotation == null) {
            annotation = point.getTarget().getClass().getAnnotation(TestAnnotation.class);
        }
        System.out.println("方法名" + annotation);
        String name = point.getSignature().getName();
        String declaringTypeName = point.getSignature().getDeclaringTypeName();
        Class<?> aClass = point.getTarget().getClass();
        log.error("【{}】类的【{}】方法执行了前置通知方法 【{}】", aClass.getName(), name, declaringTypeName);
    }

//    @After(value = "proxy() && @annotation(com.ksn.annotation.TestAnnotation) || @within(com.ksn.annotation.TestAnnotation)")
    public void after(JoinPoint point) {
        String name = point.getSignature().getName();
        String declaringTypeName = point.getSignature().getDeclaringTypeName();
        Class<?> aClass = point.getTarget().getClass();
        log.error("【{}】类的【{}】方法执行了最终通知方法 【{}】", aClass.getName(), name, declaringTypeName);
    }

//    @AfterThrowing(value = "proxy() && @annotation(com.ksn.annotation.TestAnnotation) || @within(com.ksn.annotation.TestAnnotation)", throwing = "e")
    public void afterThrow(JoinPoint point, Throwable e) {
        log.error(e.getMessage());
        String name = point.getSignature().getName();
        String declaringTypeName = point.getSignature().getDeclaringTypeName();
        Class<?> aClass = point.getTarget().getClass();
        log.error("【{}】类的【{}】方法执行了异常通知方法 【{}】", aClass.getName(), name, declaringTypeName);
    }

//    @AfterReturning(value = "proxy() && @annotation(com.ksn.annotation.TestAnnotation) || @within(com.ksn.annotation.TestAnnotation)", returning = "res")
    public void afterReturning(JoinPoint point, Object res) {
        String name = point.getSignature().getName();
        String declaringTypeName = point.getSignature().getDeclaringTypeName();
        Class<?> aClass = point.getTarget().getClass();
        log.error("【{}】类的【{}】方法执行了后置通知方法 【{}】", aClass.getName(), name, declaringTypeName);
    }

    @Around(value = "proxy() && @annotation(com.ksn.annotation.TestAnnotation) || @within(com.ksn.annotation.TestAnnotation)")
    public Object aound(ProceedingJoinPoint point) throws Throwable {
        HashMap<String, String> map = new HashMap<>();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String name = point.getSignature().getName();
        String declaringTypeName = point.getSignature().getDeclaringTypeName();
        Class<?> aClass = point.getTarget().getClass();
        Object proceed = point.proceed();
        System.out.println(proceed);
        log.error("【{}】类的【{}】方法执行了环绕通知方法 【{}】", aClass.getName(), name, declaringTypeName);
        map.put("asdf", "asdf");
        System.out.println(JSON.toJSONString(map));
        byte[] bytes = JSON.toJSONString(map).getBytes();
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        return proceed;
    }
}
