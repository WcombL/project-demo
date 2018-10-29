package com.lei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

// 开启组件扫描和自动配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.lei.boot"})
@EnableMongoAuditing
public class SpringDemoApplication {

	public static void main(String[] args) {
		// 负责启动引导应用程序
		SpringApplication.run(SpringDemoApplication.class, args);
	}
}
