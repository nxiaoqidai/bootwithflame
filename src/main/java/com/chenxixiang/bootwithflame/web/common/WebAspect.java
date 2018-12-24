package com.chenxixiang.bootwithflame.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

@Aspect
public class WebAspect {
	private static Logger LOGGER = ((LoggerContext) LoggerFactory.getILoggerFactory())
			.getLogger(WebAspect.class);

}
