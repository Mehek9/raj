package com.crm.app.admin;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info=@Info(description="LOKIS CRM Documentation"))
public class CrmAppAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmAppAdminApplication.class, args);
	}

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
	
	
}
