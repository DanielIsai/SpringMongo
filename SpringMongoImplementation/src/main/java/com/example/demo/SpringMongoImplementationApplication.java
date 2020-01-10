package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@SpringBootApplication
@PropertySource("classpath:message.properties")
public class SpringMongoImplementationApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoImplementationApplication.class, args);
	}

}
