package com.vladis1350;

import com.vladis1350.bean.Product;
import com.vladis1350.constant.ProjectArguments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class FinalProjectJavaOneApplication {

	public static void main(String[] args) {
		Logger log = LogManager.getLogger(FinalProjectJavaOneApplication.class);
        if(!args[0].equals(ProjectArguments.START)) {
            log.info("Unknown arguments");
        } else {
            SpringApplication.run(FinalProjectJavaOneApplication.class, args);
        }
    }

}
