package com.virtualmind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.virtualmind"})
public class TopicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopicsApplication.class, args);
	}

}
