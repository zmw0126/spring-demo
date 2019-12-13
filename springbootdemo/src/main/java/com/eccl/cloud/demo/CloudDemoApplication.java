package com.eccl.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@EnableSwagger2 //api地址：http://localhost:8803/swagger-ui.html
@MapperScan("com.eccl.cloud.demo.dao")
@EnableFeignClients
//@EnableEurekaClient
@EnableHystrix
@RestController
@SpringBootApplication
public class CloudDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudDemoApplication.class, args);
	}
}
