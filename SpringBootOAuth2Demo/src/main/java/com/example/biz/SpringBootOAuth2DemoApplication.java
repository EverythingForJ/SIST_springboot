package com.example.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class SpringBootOAuth2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOAuth2DemoApplication.class, args);
	}

}
