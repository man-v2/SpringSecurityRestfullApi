package com.yueting.api.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimerAspect {

	// UserController的所有方法都会被处理
	@Around("execution(* com.yueting.api.rest.HelloController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("timer apect start");
		
		Object[] args = pjp.getArgs();
		for(Object obj : args) {
			System.out.println("arg is "+obj);
		}
		
		long start = new Date().getTime();
		Object object = pjp.proceed();
		
		System.out.println("time out 耗时："+(new Date().getTime() - start));
		System.out.println("timer apect end");
		return object;
	}
}
