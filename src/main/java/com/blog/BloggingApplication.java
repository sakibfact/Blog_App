package com.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BloggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggingApplication.class, args);

		System.out.println("Hi this is blogging application");
		
		System.out.println("hhhhhhhhhhhhhhh");
		System.out.println("byyyyyyyyyyyy");
		System.out.println("hello");
		System.out.println("kiikkgkgkkkg");
		
		
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	
	public void display() {
		
		System.out.println("HI i am  here ");
	}
}
