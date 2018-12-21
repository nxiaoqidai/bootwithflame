package com.chenxixiang.bootwithflame.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
// @Aspect
public class ParamCheckAOP {

	private final Logger Logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(public * com.chenxixiang.bootwithflame.web..*.*(..))")
	public void checkNullParam() {
	}

	@Before("checkParam()")
	public void doBefore(JoinPoint joinPoint) {
	}
}
