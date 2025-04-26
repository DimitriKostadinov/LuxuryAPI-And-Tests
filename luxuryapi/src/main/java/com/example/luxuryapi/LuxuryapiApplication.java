package com.example.luxuryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LuxuryapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuxuryapiApplication.class, args);
	}

	@GetMapping
	public String helloWorld(){
		return "Hello it's me :)";
	}
}
