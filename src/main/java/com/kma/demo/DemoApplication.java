package com.kma.demo;


import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		if(logger.isDebugEnabled()) {
			logger.debug("Hello World");
			Marker notifyAdmin = MarkerFactory.getMarker("NOTIFY_ADMIN");
			logger.error(notifyAdmin, "This is a serious an error requiring the admin's attention", new Exception("Just testing"));
			MDC.put("first", "Richard");
			logger.info("I am not a crook.");
		}
		SpringApplication.run(DemoApplication.class, args);
	}

}
