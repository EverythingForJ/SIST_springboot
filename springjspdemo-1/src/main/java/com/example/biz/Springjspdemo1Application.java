package com.example.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class Springjspdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springjspdemo1Application.class, args);
	}

}
