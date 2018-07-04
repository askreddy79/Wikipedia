package com.wp.offer.Wikipedia.api.rest.docs;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by suneel on 04/07/2018.
 */
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        String description = "WikiPedia Offer";
        return new ApiInfoBuilder()
                .title("WikiPedia")
                .description(description)
                .termsOfServiceUrl("github")
                .license("askreddy79")
                .licenseUrl("")
                .version("1.0")
                .build();
    }
}
