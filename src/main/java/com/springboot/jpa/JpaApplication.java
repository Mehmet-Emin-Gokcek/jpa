package com.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {

			// save a few users
			repository.save(new User("Jack", "jack@gmail.com"));
			repository.save(new User("Chloe", "chloe@gmail.com"));
			repository.save(new User("Kim", "bauer@gmail.com"));
			repository.save(new User("David", "palmer@gmail.com"));
			repository.save(new User("Michelle", "dessler@gmail.com"));

			// fetch all users
			log.info("User Info found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			// fetch an individual user by ID
			User user = repository.findById(1L);
			log.info("User found with findById(1L):");
			log.info("--------------------------------");
			log.info(user.toString());
			log.info("");

		};
	}

}