package com.sbinterview.SpringProfiles.svc;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev")
public class MyDevService {

    @PostConstruct
    public void init(){
        System.out.println("\n\nMy Dev component loaded.\n\n");
    }

}
