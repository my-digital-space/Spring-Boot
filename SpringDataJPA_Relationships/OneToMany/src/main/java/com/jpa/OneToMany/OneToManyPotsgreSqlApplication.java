package com.jpa.OneToMany;

import com.jpa.OneToMany.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyPotsgreSqlApplication implements CommandLineRunner {

	@Autowired
	private AppService appService;

	public static void main(String[] args) {
		SpringApplication.run(OneToManyPotsgreSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appService.saveData();
	}
}
