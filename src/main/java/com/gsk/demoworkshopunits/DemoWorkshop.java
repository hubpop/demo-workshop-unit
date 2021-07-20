package com.gsk.demoworkshopunits;

import com.gsk.demoworkshopunits.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DemoWorkshop {

	public static void main(String[] args) {
		SpringApplication.run(DemoWorkshop.class, args);
	}

	@Bean
	public UserRepository userRepositoryBean(){
		return new UserRepository();
	}

}
