package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

    //TODO classloader test는 해당 spring application 실행
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
