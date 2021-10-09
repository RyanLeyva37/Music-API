package com.promineotech.MusicAPI;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MusicApiApplication extends SpringBootServletInitializer {
	
	
	//@Autowired
	//private ApplicationContext context;
	
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
       return application.sources(MusicApiApplication.class);
    }

	public static void main(String[] args) {
		
        new SpringApplicationBuilder(MusicApiApplication.class)
        .run(args);
