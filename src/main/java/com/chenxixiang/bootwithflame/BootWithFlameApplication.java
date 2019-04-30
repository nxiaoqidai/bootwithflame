package com.chenxixiang.bootwithflame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootWithFlameApplication {

	public static void main(String[] args) {
//		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(BootWithFlameApplication.class, args);
	}
}
