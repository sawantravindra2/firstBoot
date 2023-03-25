package com.ravi.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ravi.*" })
public class FisrtBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FisrtBootApplication.class, args);

		System.out.println("******** hello welcome with jenkins integration ************** ");

	}

}
