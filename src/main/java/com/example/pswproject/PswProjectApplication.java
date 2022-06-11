package com.example.pswproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PswProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PswProjectApplication.class, args);
    }

}
