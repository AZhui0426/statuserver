package com.azhui.statuserver.statemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatemachineApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatemachineApplication.class, args);
        System.out.println("----- Statemachine模块 -----");
    }

}