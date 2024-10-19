package com.ApnaMart.ApnaMart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ApnaMart.ApnaMart.Repository")
public class ApnaMartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApnaMartApplication.class, args);
    }

}
