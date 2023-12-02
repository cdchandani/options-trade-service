package com.chanchal.optionstradeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OptionsTradeServiceApplication implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(OptionsTradeServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OptionsTradeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Options Trade Service started");
	}
}
