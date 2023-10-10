package com.ambokiledailybackendprogrammer.cryptospringbootAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan("com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity")
@EnableScheduling
public class CryptospringbootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptospringbootApiApplication.class, args);
	}

}
