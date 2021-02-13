package com.robosoft.evaluation.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The Class SwaggerConfiguration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	  
  	/**
  	 * Transaction api.
  	 *
  	 * @return the docket
  	 */
  	@Bean
	    public Docket transactionApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.camelot.transactions"))
	                .paths(regex("/api.*"))
	                .build()
	                .apiInfo(metaData());
	    }

	    /**
    	 * Meta data.
    	 *
    	 * @return the api info
    	 */
    	private ApiInfo metaData() {
	        return new ApiInfoBuilder().title("Camelot API").version("1.0.0").build();
	    }
}
