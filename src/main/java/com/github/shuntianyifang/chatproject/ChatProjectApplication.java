package com.github.shuntianyifang.chatproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.shuntianyifang.chatproject.mapper")
public class ChatProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatProjectApplication.class, args);
    }
}
