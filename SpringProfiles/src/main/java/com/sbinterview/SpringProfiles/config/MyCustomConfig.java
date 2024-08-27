package com.sbinterview.SpringProfiles.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:MyCustomConfig.properties")
public class MyCustomConfig {
    @Value("${myApp.customVar1}")
    private String customVar1;

    @Value("${myApp.customVar2}")
    private String customVar2;

    public String getCustomVar1() {  return customVar1;  }
    public void setCustomVar1(String customVar1) {    this.customVar1 = customVar1;   }

    public String getCustomVar2() {  return customVar2;  }
    public void setCustomVar2(String customVar2) {   this.customVar2 = customVar2;  }

}
