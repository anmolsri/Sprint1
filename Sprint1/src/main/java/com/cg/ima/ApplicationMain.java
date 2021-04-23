package com.cg.ima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg.ima")
public class ApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}

}
