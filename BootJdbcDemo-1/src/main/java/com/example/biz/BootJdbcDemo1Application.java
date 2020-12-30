package com.example.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class BootJdbcDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootJdbcDemo1Application.class, args);
	}

}
