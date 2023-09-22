package com.breallencs.mytripyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.breallencs.mytripyapi.core.config.property.MyTripyApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(MyTripyApiProperty.class)
public class MytripyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytripyApiApplication.class, args);
	}

}
