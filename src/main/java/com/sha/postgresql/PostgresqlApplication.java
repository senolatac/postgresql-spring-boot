package com.sha.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PostgresqlApplication {

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        //This will create encrypted, secure,... password.
        //This will internally generate a random salt so you will handle different result for each call.
        return new BCryptPasswordEncoder();
    }

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlApplication.class, args);
	}

}
