package com.learnerscale.purchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PurchaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseApplication.class, args);

		System.out.println("-------------------------------------------------------------------");
		System.out.println("Spring Boot Application Started");
		System.out.println("Access the application in : http://127.0" + ".0.1:4444/login");
		System.out.println("--------------------------------------------------");
	}

}
