package com.demo.RelaxedBinding.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "myapp.mysecret.getkey")
public class MySecretsConfig implements Serializable {
    private String mySecretKey1;

    public String getMySecretKey1() {
        return mySecretKey1;
    }

    public void setMySecretKey1(String mySecretKey1) {
        this.mySecretKey1 = mySecretKey1;
    }
}
