package com.yz.zhxy;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @program: swagger2
 * @description: swagger2配置类
 * @author: wangchao10
 * @create: 2020年10月19日
 **/
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class swagger2Config {

    @Bean
    public Docket buildDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//调用下面apiInfo()方法
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.yz.zhxy.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                .title("莺阵项目")
                .description("莺阵接口管理文档")
                .termsOfServiceUrl("http://localhost:8081/doc.html")
                .contact("itw")
                .version("0.0.1")
                .build();

    }
}
