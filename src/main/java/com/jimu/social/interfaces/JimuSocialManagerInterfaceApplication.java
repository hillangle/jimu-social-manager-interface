package com.jimu.social.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.jimu.social.interfaces.mapper")
public class JimuSocialManagerInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JimuSocialManagerInterfaceApplication.class, args);
    }

}
