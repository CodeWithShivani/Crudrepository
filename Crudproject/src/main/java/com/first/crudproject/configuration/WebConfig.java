package com.first.crudproject.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer{
	@Value("${file.upload-dir}")
	private String uploadDir; 
//	System.out.println("browser saved at: " + uploadDir);;
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:"+uploadDir+"/");
	}
	

}
