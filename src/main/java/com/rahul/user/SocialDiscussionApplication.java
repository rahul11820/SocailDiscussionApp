package com.rahul.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class  SocialDiscussionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialDiscussionApplication.class, args);
	}
}
