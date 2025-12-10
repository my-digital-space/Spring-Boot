package com.demo.RelaxedBinding;

import com.demo.RelaxedBinding.config.MySecretsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RelaxedBindingApplication implements CommandLineRunner {

	@Autowired
	MySecretsConfig mySecretsConfig;

	public static void main(String[] args) {
		SpringApplication.run(RelaxedBindingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\nmyKeyValue = " + mySecretsConfig.getMySecretKey1());
		System.out.println("\n\n");
	}
}
