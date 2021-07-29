package com.jisen.rws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootRwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRwsApplication.class, args);
    }

}
