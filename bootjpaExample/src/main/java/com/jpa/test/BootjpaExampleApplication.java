package com.jpa.test;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootjpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootjpaExampleApplication.class, args);
		//ApplicationContext context = SpringApplication.run(Boot, args)
	}

}
