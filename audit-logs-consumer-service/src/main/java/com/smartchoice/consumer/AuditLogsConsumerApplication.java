package com.smartchoice.consumer;

import com.smartchoice.util.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AuditLogsConsumerApplication {
	private static final Logger logger = LoggerFactory.getLogger(AuditLogsConsumerApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AuditLogsConsumerApplication.class, args);
		ApplicationUtil.logApplicationStartup(context.getEnvironment(), logger);
	}

}
