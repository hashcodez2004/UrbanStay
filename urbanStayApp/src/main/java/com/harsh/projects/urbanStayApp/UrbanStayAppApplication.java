package com.harsh.projects.urbanStayApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UrbanStayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbanStayAppApplication.class, args);
	}

}
