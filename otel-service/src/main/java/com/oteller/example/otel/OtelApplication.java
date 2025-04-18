package com.oteller.example.otel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OtelApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtelApplication.class, args);
	}

}
