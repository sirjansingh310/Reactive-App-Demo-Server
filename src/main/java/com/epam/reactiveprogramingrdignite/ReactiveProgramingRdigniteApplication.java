package com.epam.reactiveprogramingrdignite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ReactiveProgramingRdigniteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgramingRdigniteApplication.class, args);
	}

}
