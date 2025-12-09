package com.gp.user_profile_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UserProfileServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(UserProfileServiceApplication.class, args);

		Environment env = ctx.getEnvironment();
		System.out.println("SPRING BOOTSTRAP SERVERS = " +"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@##################################@@@@@@@@@@@@@@@@@@@@@@@@@@@@#########################@#################################"+
				env.getProperty("spring.kafka.bootstrap-servers"));

		//SpringApplication.run(UserProfileServiceApplication.class, args);
	}

}
