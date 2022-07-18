package com.fastcampus.springbootpractice.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ConstructorBinding
@Getter
@Setter
@RequiredArgsConstructor
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
