package com.example.SayurKelilingProduct.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        final Docket build = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(Predicates.or(
                        RequestHandlerSelectors.basePackage("com.example.SayurKelilingProduct")
                ))
                .paths(PathSelectors.any())
                .build();
        return build;
    }
}