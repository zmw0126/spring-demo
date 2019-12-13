package com.eccl.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaServer
@RestController
@SpringBootApplication
public class CloudServerApplication {
	
	@GetMapping("/hi")
	public String hi() {
		return "hi, I'm eureka server!";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudServerApplication.class, args);
	}
}
