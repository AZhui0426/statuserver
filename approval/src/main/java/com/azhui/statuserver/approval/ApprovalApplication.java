package com.azhui.statuserver.approval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApprovalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApprovalApplication.class, args);
        System.out.println("----- Approval模块 -----");
    }

}
