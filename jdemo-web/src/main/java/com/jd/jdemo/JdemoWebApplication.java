package com.jd.jdemo;

import com.jd.jdemo.common.dba.ioc.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JdemoWebApplication {
    @Bean
    public SpringContextUtil springContextUtil() {
        return new SpringContextUtil();
    }

    public static void main(String[] args) {
        SpringApplication.run(JdemoWebApplication.class, args);
    }
}
