package com.fastcampus.springbootpractice;

import com.fastcampus.springbootpractice.properties.MyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@ConfigurationPropertiesScan
// @Configuration annotation 생략할 경우
@SpringBootApplication
public class SpringBootPracticeApplication {

//    private final Integer height;
//    private final Environment env;
//    private final ApplicationContext applicationContext;
    private final MyProperties myProperties;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPracticeApplication.class, args);
    }

    @PostConstruct
    public void asd() {
//        System.out.println("[@Value] : " + height);
//        System.out.println("[Environment] : " + env.getProperty("my.height"));
//        System.out.println("[ApplicationContext] : " + applicationContext.getEnvironment().getProperty("my.height"));
        System.out.println("[ConfigurationProps] : " + myProperties.getHeight());
    }
}
