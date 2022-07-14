package com.fastcampus.springbootpractice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

//@Configuration
@ConstructorBinding
@ConfigurationProperties("my")
public class MyProperties {

    private Integer height;

    public MyProperties(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }
}
