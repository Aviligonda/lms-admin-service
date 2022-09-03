package com.bridgelabz.lmsadminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LmsAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsAdminServiceApplication.class, args);
    }

}
