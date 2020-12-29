package com.example.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class MyBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBootWebApplication.class, args);
	}

}
