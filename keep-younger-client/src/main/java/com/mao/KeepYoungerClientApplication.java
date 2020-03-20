package com.mao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KeepYoungerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeepYoungerClientApplication.class, args);
	}

}
