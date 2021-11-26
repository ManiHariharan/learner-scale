package com.hari.haran.crackers.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.hari.haran.crackers.app.cons.SettingCons;

/**
 * ECommerceApplication is the main application class to start Spring Boot
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
@SpringBootApplication
@ComponentScan({ "com.hari.haran.crackers.app.controller" })
public class ECommerceApplication {

	static String currentPlayer = "Rohit";

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);

		System.out.println("--------------");
		System.out.println(String.format("%s - Spring Boot Application Started", SettingCons.APP_NAME));
		System.out.println("--------------");
		System.out.println("Access the application in : http://127.0" + ".0.1:8080/health");
		System.out.println("--------------------------------------------------");

		int newScore = 2;
		
		Map<String, Integer> scoreMap = new HashMap<>();
		int curScore = scoreMap.getOrDefault(currentPlayer, 0);
		scoreMap.put(currentPlayer, curScore + newScore);
	}

}