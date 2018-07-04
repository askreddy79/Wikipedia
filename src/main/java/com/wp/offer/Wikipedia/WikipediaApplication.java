package com.wp.offer.Wikipedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com.wp.offer.Wikipedia")
@EnableJpaRepositories("com.wp.offer.Wikipedia.repository")
public class WikipediaApplication extends SpringBootServletInitializer{
	private static final Logger log = LoggerFactory.getLogger(WikipediaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WikipediaApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WikipediaApplication.class);
	}
}
