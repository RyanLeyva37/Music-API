package com.promineotech.MusicAPI;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class MusicApiApplication {

	public static void main(String[] args) {
		
        new SpringApplicationBuilder(MusicApiApplication.class)
        .run(args);

	}

}
