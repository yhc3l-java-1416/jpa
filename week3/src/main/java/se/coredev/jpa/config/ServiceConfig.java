package se.coredev.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import se.coredev.jpa.service.EmployeeService;

@Configuration
public class ServiceConfig {

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeService();
	}

}
