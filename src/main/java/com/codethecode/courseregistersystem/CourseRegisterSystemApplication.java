package com.codethecode.courseregistersystem;

import com.codethecode.courseregistersystem.controller.AdminController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaAuditing
// @ComponentScan(basePackageClasses = AdminController.class)
public class CourseRegisterSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseRegisterSystemApplication.class, args);
	}
}
