package com.codethecode.courseregistersystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@EnableSwagger2
//@EnableWebMvc
@ComponentScan(basePackages = {"com.codethecode.courseregistersystem"})
@Configuration
public class SwaggerConfig {
//    @Bean
//    public Docket apiDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public Docket mainConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
//                .pathMapping("/swagger")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }

}