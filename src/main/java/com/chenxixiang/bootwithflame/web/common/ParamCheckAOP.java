package com.chenxixiang.bootwithflame.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
// @Aspect
public class ParamCheckAOP {

	@Pointcut("execution(public * com.chenxixiang.bootwithflame.web..*.*(..))")
	public void checkNullParam() {
	}

	@Before("checkParam()")
	public void doBefore(JoinPoint joinPoint) {
	}
}
