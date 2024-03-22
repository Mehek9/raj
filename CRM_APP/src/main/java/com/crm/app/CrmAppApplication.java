package com.crm.app;

import org.modelmapper.ModelMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(description="LOKIS CRM DOCUMENTATION"))
public class CrmAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
	
}
