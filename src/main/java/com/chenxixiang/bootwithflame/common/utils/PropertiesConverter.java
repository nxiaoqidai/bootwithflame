package com.chenxixiang.bootwithflame.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

public class PropertiesConverter {

	public static <T, O> T convertObj(O originObj, Class<T> clazz) {
		if (originObj == null || clazz == null) {
			throw new IllegalArgumentException("Object convert param must not be null.");
		}
		T targetObj;
		try {
			targetObj = clazz.newInstance();
			BeanUtils.copyProperties(originObj, targetObj);
		} catch (BeansException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
		return targetObj;
	}

	public static <T, O> T mapProperties(O mapFromObject, T mapToObject) {
		if (mapFromObject == null || mapToObject == null) {
			throw new IllegalArgumentException("Object convert param must not be null.");
		}
		BeanUtils.copyProperties(mapFromObject, mapToObject);
		return mapToObject;
	}

}
