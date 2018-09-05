package com.cg.student.StudentDemo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg.student.StudentDemo")
public class StudentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDemoApplication.class, args);
	}
}
