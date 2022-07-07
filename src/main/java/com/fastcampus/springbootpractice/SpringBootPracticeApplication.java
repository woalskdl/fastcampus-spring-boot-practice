package com.fastcampus.springbootpractice;

import com.fastcampus.springbootpractice.properties.MyProperties;
import com.fastcampus.springbootpractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

//@EnableCaching
//@RequiredArgsConstructor
@ConfigurationPropertiesScan
// @Configuration annotation 생략할 경우
@SpringBootApplication
public class SpringBootPracticeApplication {

//    private final Integer height;
//    private final Environment env;
//    private final ApplicationContext applicationContext;
    private final MyProperties myProperties;
    private final StudentService studentService;
    private final String username;
    private final String password;

    public SpringBootPracticeApplication(MyProperties myProperties,
                                         StudentService studentService,
                                         @Value("${spring.datasource.username}") String username,
                                         @Value("${spring.datasource.password}") String password) {
        this.myProperties = myProperties;
        this.studentService = studentService;
        this.username = username;
        this.password = password;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPracticeApplication.class, args);
    }

    /*@PostConstruct
    public void asd() {
//        System.out.println("[@Value] : " + height);
//        System.out.println("[Environment] : " + env.getProperty("my.height"));
//        System.out.println("[ApplicationContext] : " + applicationContext.getEnvironment().getProperty("my.height"));
        System.out.println("[ConfigurationProps] : " + myProperties.getHeight());
    }*/

//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
    @Bean
    public ApplicationRunner applicationRunner() {
//        studentService.printStudent("jack");
//        studentService.printStudent("jack");
//        studentService.printStudent("jack");

        return args -> {
            System.out.println("id : " + username);
            System.out.println("password : " + password);
        };
    }

}
