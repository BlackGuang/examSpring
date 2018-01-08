package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.imooc.mapper")
public class FuckApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuckApplication.class, args);
	}
}
