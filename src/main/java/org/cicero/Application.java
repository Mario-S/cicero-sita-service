package org.cicero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author schroeder
 */
@SpringBootApplication
@EnableSwagger2
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
          .select()    
          .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
          .paths(PathSelectors.any())
          .build();                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Cicero Sita Service")
                .description("This service provide endpoints to be used by the cicero app for trip planning")
                .contact(new Contact("mario-s", "https://www.facebook.com/cicero.app.travel/", ""))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

    
}
