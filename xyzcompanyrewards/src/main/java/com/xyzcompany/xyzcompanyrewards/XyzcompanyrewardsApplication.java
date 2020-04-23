package com.xyzcompany.xyzcompanyrewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class XyzcompanyrewardsApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XyzcompanyrewardsApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(XyzcompanyrewardsApplication.class, args);
	}

}
