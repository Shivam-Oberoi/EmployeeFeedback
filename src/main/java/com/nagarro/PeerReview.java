package com.nagarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nagarro")
public class PeerReview {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PeerReview.class, args);
	}

}