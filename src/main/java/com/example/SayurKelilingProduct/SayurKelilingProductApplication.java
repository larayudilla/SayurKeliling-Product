package com.example.SayurKelilingProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
class SayurKelilingProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SayurKelilingProductApplication.class, args);
	}

}
