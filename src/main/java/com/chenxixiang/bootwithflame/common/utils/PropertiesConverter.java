package com.chenxixiang.bootwithflame.common.utils;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import com.chenxixiang.bootwithflame.service.impls.UserServiceImpl;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

public class PropertiesConverter {

	private static Logger LOGGER = ((LoggerContext) LoggerFactory.getILoggerFactory())
			.getLogger(UserServiceImpl.class);

	public static <T, O> T convertObj(O originObj, Class<T> clazz) {
		if (originObj == null || clazz == null) {
			throw new IllegalArgumentException("Object convert param must not be null.");
		}
		T targetObj;
		try {
			targetObj = clazz.newInstance();
			BeanUtils.copyProperties(originObj, targetObj);
		} catch (BeansException | InstantiationException | IllegalAccessException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
		return targetObj;
	}

}
