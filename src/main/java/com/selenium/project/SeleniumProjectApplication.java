package com.selenium.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SeleniumProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumProjectApplication.class, args);
		//new FormSeleniumService().process();
		//new TimeSeleniumService().process();
	}

}
