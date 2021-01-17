package com.smartchoice.prices;

import com.smartchoice.util.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PricesApplication {
	private static final Logger logger = LoggerFactory.getLogger(PricesApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PricesApplication.class, args);
		ApplicationUtil.logApplicationStartup(context.getEnvironment(), logger);
	}

}
