// package com.example.demo.config;
//
//
// import io.swagger.annotations.ApiOperation;
// import org.springframework.context.annotation.Bean;
// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.service.ApiKey;
// import springfox.documentation.service.AuthorizationScope;
// import springfox.documentation.service.SecurityReference;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spi.service.contexts.SecurityContext;
// import springfox.documentation.spring.web.plugins.Docket;
//
// import java.util.List;
//
// import static com.google.common.collect.Lists.newArrayList;
//
// public class BaseSwaggerConfig {
//
//     @Bean
//     public Docket createRestApi() {
//         return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                 // 加了ApiOperation注解的类，才生成接口文档
//                 .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                 // 包下的类，才生成接口文档
//                 // .apis(RequestHandlerSelectors.basePackage("com.lunz.frb.api.controller"))
//                 // .apis(RequestHandlerSelectors.basePackage("com.cnadmart.modules.*.controller"))
//                 .paths(PathSelectors.any()).build().securitySchemes(securitySchemes())
//                 .securityContexts(securityContexts());
//     }
//
//     public ApiInfo apiInfo() {
//         return new ApiInfoBuilder().title("INS").description("")
//                 .termsOfServiceUrl("swagger-ui.html").version("1.0.0").build();
//     }
//
//     public List<ApiKey> securitySchemes() {
//         return newArrayList(new ApiKey("Authorization-Token", ServletUtils.Token, "header"));
//     }
//
//     public List<SecurityContext> securityContexts() {
//         return newArrayList(SecurityContext.builder().securityReferences(defaultAuth())
//                 .forPaths(PathSelectors.regex("^(?!demo1).*$")).build());
//     }
//
//     public List<SecurityReference> defaultAuth() {
//         AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//         AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//         authorizationScopes[0] = authorizationScope;
//         return newArrayList(new SecurityReference("Authorization-Token", authorizationScopes));
//     }
// }