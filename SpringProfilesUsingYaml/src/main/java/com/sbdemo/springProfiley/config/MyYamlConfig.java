package com.sbdemo.springProfiley.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myapp")
public class MyYamlConfig {
    private String custom_text1;
    // private String custom_text2;

    public String getCustom_text1() { return custom_text1;  }
    public void setCustom_text1(String custom_text1) { this.custom_text1 = custom_text1; }

//    public String getCustom_text2() { return custom_text2; }
//    public void setCustom_text2(String custom_text2) { this.custom_text2 = custom_text2; }
}
