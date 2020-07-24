package com.cgi.example.amqpwebsocketapacheqpid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan
@EnableConfigurationProperties(ApplicationProperties.class)
public class AmqpWebsocketApacheQpidApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AmqpWebsocketApacheQpidApplication.class, args);

		MyController myController = context.getBean(MyController.class);
		myController.sendMessage("Hello world");

	}

}
