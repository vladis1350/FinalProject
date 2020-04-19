package com.vladis1350;

import com.vladis1350.bean.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectJavaOneApplication {

	public static void main(String[] args) {
		Logger log = LogManager.getLogger(FinalProjectJavaOneApplication.class);

		if(args.length == 0) {
			SpringApplication.run(FinalProjectJavaOneApplication.class, args);
		} else
			log.info("Unknown arguments");
	}

}
