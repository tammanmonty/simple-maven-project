package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
//@ComponentScan(basePackages	= {"com.example.demo"})
@RestController
public class HelloWorldApplication {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Tamman") String name) {
      return String.format("Hello %s!", name);
    }
    
	@GetMapping("/")
	String home() {
		return "Hello World!";
	}
    
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
