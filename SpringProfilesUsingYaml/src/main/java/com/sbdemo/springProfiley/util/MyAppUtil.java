package com.sbdemo.springProfiley.util;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.sbdemo.springProfiley.config.MyYamlConfig;

@Service
public class MyAppUtil {

    private MyYamlConfig myYamlConfig;

    public MyAppUtil(MyYamlConfig myYamlConfig) {
        this.myYamlConfig = myYamlConfig;
    }

    @PostConstruct
    public void init() {
        System.out.println("\n\nText 1:" + myYamlConfig.getCustom_text1()+"\n\n");
    }
}
