package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@EnableBatchProcessing
public class TpjSbh2Application {

	public static void main(String[] args) {
		SpringApplication.run(TpjSbh2Application.class, args);
	}
	
//	@Bean
//	public ServletRegistrationBean h2servletRegistration() {
//	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
//	    registration.addUrlMappings("/console/*");
//	    return registration;
//	}

}
