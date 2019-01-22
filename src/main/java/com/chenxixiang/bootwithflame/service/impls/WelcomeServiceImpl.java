package com.chenxixiang.bootwithflame.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenxixiang.bootwithflame.redis.InventoryRedisCache;
import com.chenxixiang.bootwithflame.service.interfaces.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Autowired
	InventoryRedisCache inventoryRedisCache;

	public String foo() {
		inventoryRedisCache.putIfAbsent("Pantyhose", 10);
		int k = inventoryRedisCache.get("Pantyhose");

		return "FOO method ^-^ , inventory: " + k;
	}

}
