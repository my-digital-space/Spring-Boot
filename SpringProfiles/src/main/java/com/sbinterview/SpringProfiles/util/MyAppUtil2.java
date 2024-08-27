package com.sbinterview.SpringProfiles.util;

import com.sbinterview.SpringProfiles.config.MyCustomConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class MyAppUtil2 {

    private MyCustomConfig myCustomConfig;

    public MyAppUtil2(MyCustomConfig myCustomConfig) {
        this.myCustomConfig = myCustomConfig;
    }

    @PostConstruct
    public void init() {
        System.out.println("\n\nCustom Text 1:" + myCustomConfig.getCustomVar1());
        System.out.println("Custom Text 2:" + myCustomConfig.getCustomVar2() + "\n\n");
    }

}
