package com.sbinterview.SpringProfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProfilesApplication.class, args);
//		SpringApplication app = new SpringApplication(SpringProfilesApplication.class);
//		app.setAdditionalProfiles("prod");
//		app.run(args);
	}

}
