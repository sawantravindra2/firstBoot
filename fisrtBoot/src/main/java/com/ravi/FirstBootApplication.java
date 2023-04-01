package com.ravi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ravi.*" })
public class FirstBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstBootApplication.class, args);

		System.out.println("******** hello welcome with jenkins integration ************** ");

	}

}
