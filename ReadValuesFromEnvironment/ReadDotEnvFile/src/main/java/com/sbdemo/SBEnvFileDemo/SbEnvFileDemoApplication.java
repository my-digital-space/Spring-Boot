package com.sbdemo.SBEnvFileDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.Properties;

@SpringBootApplication
public class SbEnvFileDemoApplication implements CommandLineRunner {

    @Value("${DOT_ENV_FILE_TEST_1}")
    private String DOT_ENV_FILE_TEST_1;

    public static void main(String[] args) {
        SpringApplication.run(SbEnvFileDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\nMy var from .env file=" + DOT_ENV_FILE_TEST_1);

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("MyCustomEnvFile.env")) {
            properties.load(fis);
            properties.forEach((key, value) -> System.setProperty((String) key, (String) value));

            String MY_CUSTOM_ENV_FILE_TEST_1 = System.getProperty("MY_CUSTOM_ENV_FILE_TEST_1");
            System.out.println("My var from MyCustomEnvFile.env file=" + MY_CUSTOM_ENV_FILE_TEST_1 + " \n\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
