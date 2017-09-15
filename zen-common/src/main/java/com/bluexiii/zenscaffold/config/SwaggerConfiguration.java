package com.bluexiii.zenscaffold.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Value("${custom.baseurl}")
    private String baseUrl;
    @Value("${custom.description}")
    private String description;
    @Value("${custom.version}")
    private String version;
    @Value("${custom.title}")
    private String title;

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("Authorization")
                                .description("认证信息")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build()))
                .groupName(null)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex(baseUrl + "/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .termsOfServiceUrl("http://www.foo.bar")
                .license("LICENSE")
                .licenseUrl("http://www.foo.bar")
                .build();
    }
}