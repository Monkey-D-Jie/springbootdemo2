package com.jf.mydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.jf.mydemo.dao.**")
@EnableScheduling
//开启事务管理
//@EnableTransactionManagement
@ServletComponentScan
public class Springbootdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo2Application.class, args);
	}

}
