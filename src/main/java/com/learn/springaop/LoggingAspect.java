package com.learn.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	// point cut
	@Before("execution(* com.learn.springaop.ShoppingCart.checkout(..))")
	public void beforeLoggers(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("Arguement passed: "+jp.getArgs()[0].toString());
		System.out.println("before loggers");
	}
	
	@After("execution(* com.learn.springaop..checkout(..))")
//	@After("execution(* com.learn.springaop.*.checkout(..))")
	public void afterLoggers() {
		System.out.println("after loggers");
	}

	@Pointcut("execution(* com.learn.springaop.ShoppingCart.quantity(..))")
	public void afterReturningPointCut() {}
	
	@AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
	public void afterReturning(int retVal) {
		System.out.println("After Returning: "+retVal);
	}
	
}
