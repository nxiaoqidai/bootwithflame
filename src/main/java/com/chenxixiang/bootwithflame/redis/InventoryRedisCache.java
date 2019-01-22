package com.chenxixiang.bootwithflame.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

@Repository
public class InventoryRedisCache {

	public static final String CACHE_KEY = "INVENTORY_CACHE";

	@Autowired
	StringRedisTemplate srTemplate;

	public int putIfAbsent(String key, Integer remaining) {
		if (!srTemplate.opsForHash().hasKey(CACHE_KEY, key)) {
			srTemplate.opsForHash().putIfAbsent(CACHE_KEY, key,
					JSON.toJSONString(remaining, SerializerFeature.WriteMapNullValue));
			return 1;
		}
		return -1;
	}

	public int get(String key) {
		Object object = srTemplate.opsForHash().get(CACHE_KEY, key);
		Integer result;
		if (object != null) {
			result = JSON.parseObject(object.toString(), Integer.class);
			return result;
		}

		return 0;
	}
}
