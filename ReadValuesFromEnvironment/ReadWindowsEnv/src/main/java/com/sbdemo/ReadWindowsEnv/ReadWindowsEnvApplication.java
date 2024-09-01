package com.sbdemo.ReadWindowsEnv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadWindowsEnvApplication implements CommandLineRunner {

	@Value("${myEnvVar}")
	private String myEnvVar;

	public static void main(String[] args) {
		SpringApplication.run(ReadWindowsEnvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\nmyEnvVar:"+myEnvVar+" \n\n");
	}
}
