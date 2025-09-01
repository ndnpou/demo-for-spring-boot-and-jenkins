package com.example.demo_for_spring_boot_and_jenkins;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoForSpringBootAndJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoForSpringBootAndJenkinsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Command-line arguments received: " + args.length);
			for (String arg : args) {
				System.out.println(arg);
			}
		};
	}
}
