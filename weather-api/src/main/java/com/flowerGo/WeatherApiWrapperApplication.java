package com.flowerGo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WeatherApiWrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiWrapperApplication.class, args);
		System.out.println("Hello from springboot");
	}

}
