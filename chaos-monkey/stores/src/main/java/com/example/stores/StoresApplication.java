package com.example.stores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class StoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoresApplication.class, args);
	}

}
