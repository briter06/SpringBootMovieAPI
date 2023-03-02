package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.api.services.ConfigService.IConfigService;

@SpringBootApplication
public class MovieApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieApiApplication.class, args);
		IConfigService configService = context.getBean(IConfigService.class);
		configService.initEnvironment();
	}

}
