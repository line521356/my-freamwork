package com.lucius.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @author Lucius
 * create by 2017/10/30
 * @Emial lucius_521356@163.com
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.lucius"})
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
