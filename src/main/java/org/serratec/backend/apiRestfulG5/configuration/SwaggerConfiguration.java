package org.serratec.backend.apiRestfulG5.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.serratec.backend.exercicioh2banco.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());		
	}
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
			.title("API de Teste")
			.description("Essa Ã© uma API desenvolvida para testes diversos")
			.license("Apache License Version 2.0")
			.licenseUrl("https://www.apache.org/licensses/Licenses-2.0")
			.termsOfServiceUrl("/service.html")
			.version("1.0.0")
			.build();
		return apiInfo;
	}
	
}
