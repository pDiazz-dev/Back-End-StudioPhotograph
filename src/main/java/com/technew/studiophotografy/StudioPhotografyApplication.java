package com.technew.studiophotografy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudioPhotografyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudioPhotografyApplication.class, args);
    }

}
