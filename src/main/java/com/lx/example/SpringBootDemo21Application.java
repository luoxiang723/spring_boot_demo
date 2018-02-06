package com.lx.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@MapperScan("com.lx.example.mapper")
//@EnableScheduling  //定时任务
@EnableJms //启动JMS
public class SpringBootDemo21Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo21Application.class, args);
	}
}
