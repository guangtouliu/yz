package com.yz.zhxy.config;

import com.yz.zhxy.intercept.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 曹健
 * @date 2020/10/14 14:24
 * @Description
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;
//    @Autowired
//    private ResourcesConfig resourcesConfig;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns(
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-ui.html/**",

                        "/admin/login/userLogin",
                        "/admin/login/test",
                        "/**.html",
                        "/**/*.js",
                        "/**/*.jpg",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.css",
                        "/**/*.ts",
                        "/personage/addPersonage",
                        "/file/uploadFile",
                        "/file/uploadFileOfBatch",
                        "/file/download",
                        "/file/uploadRichTextFile");
        super.addInterceptors(registry);
    }

    /**
     * @Description: 静态资源访问设置
     * @Author: Mr.Jkx
     * @date: 2020/3/18 16:45
     * file：静态资源所在目录
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

}
