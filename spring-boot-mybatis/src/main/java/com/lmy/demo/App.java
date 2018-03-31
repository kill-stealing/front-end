package com.lmy.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lmy.demo.websocket.SpringBean;

@SpringBootApplication
@MapperScan("com.lmy.*")
// 扫描：该包下相应的class，主要是mybatis的持久化类
public class App {

	@Bean
	public SpringBean getSpringContext() {
		return new SpringBean();
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
