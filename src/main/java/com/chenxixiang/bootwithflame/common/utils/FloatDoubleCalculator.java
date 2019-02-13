package com.chenxixiang.bootwithflame.common.utils;

import java.math.BigDecimal;

public class FloatDoubleCalculator {

	public static float floatAdd(float f1, float f2) {
		BigDecimal a = new BigDecimal(String.valueOf(f1));
		BigDecimal b = new BigDecimal(String.valueOf(f2));
		return a.add(b).floatValue();
	}

	public static float floatSubtract(float f1, float f2) {
		BigDecimal a = new BigDecimal(String.valueOf(f1));
		BigDecimal b = new BigDecimal(String.valueOf(f2));
		return a.subtract(b).floatValue();
	}
}
