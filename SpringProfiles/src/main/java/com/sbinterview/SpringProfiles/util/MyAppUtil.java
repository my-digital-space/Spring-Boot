package com.sbinterview.SpringProfiles.util;

import com.sbinterview.SpringProfiles.config.MyAppProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyAppUtil {

    @Value("${spring.application.name}")
    String appName;

    @Value("${spring.profiles.active}")
    String currentActiveProfile;

    @Autowired
    private Environment environment;

    private MyAppProperties myAppProperties;

    public MyAppUtil(MyAppProperties myAppProperties) {
        this.myAppProperties = myAppProperties;
    }

    @PostConstruct
    public void init(){
        System.out.println("\n\nText 1:"+myAppProperties.getCustom_text1());
        System.out.println("Text 2:"+myAppProperties.getCustom_text2()+"\n\n");

        System.out.println("appName:"+appName+"\n\n");
        System.out.println("currentActiveProfile using @Value():"+currentActiveProfile+"\n");
        System.out.println("currentActiveProfile using Environment:"+ Arrays.toString(environment.getActiveProfiles()) +"\n\n");
    }


}
