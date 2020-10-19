package com.yz.zhxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.yz.zhxy.mapper")
@ServletComponentScan
@EnableScheduling
public class ZhxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhxyApplication.class, args);
    }

}
