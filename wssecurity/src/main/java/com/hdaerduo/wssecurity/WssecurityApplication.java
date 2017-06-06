package com.hdaerduo.wssecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.hdaerduo.wssecurity.config.JwtFilter;


@SpringBootApplication
public class WssecurityApplication {

	//refer to :https://aboullaite.me/spring-boot-token-authentication-using-jwt/
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*");

		return registrationBean;
	}

	
	public static void main(String[] args) {
		SpringApplication.run(WssecurityApplication.class, args);
	}
}
