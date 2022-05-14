package com.server.firstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FirstSpringAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(FirstSpringAppApplication.class, args);
        System.out.println("Hello Jeevan");
    }

}
