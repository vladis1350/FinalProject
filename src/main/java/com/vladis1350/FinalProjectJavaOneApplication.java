package com.vladis1350;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectJavaOneApplication {

	public static void main(String[] args) {
		Logger log = LogManager.getLogger(FinalProjectJavaOneApplication.class);

        if(args.length != 0) {
            log.info("Unknown arguments");
        } else {
            SpringApplication.run(FinalProjectJavaOneApplication.class, args);
        }
    }

}
