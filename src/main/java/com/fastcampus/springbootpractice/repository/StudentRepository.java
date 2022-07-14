package com.fastcampus.springbootpractice.repository;

import com.fastcampus.springbootpractice.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.nativex.hint.AotProxyHint;
import org.springframework.nativex.hint.ProxyBits;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

@AotProxyHint(targetClass = com.fastcampus.springbootpractice.repository.StudentRepository.class, proxyFeatures = ProxyBits.IS_STATIC)
@RequiredArgsConstructor
//@Repository
@Component
public class StudentRepository {

    private final Map<String, Student> storage;

    // Cache 로 등록함으로써 실질적으로 이 함수는 3번 호출함에도 불구하고 1번밖에 실행안됨.
    @Cacheable("student")
    public Student getStudent(String name) {
        System.out.println("[repo] 나의 통행료는 무척 비싸다!");
        return storage.get(name);
    }

    public void enroll(String name, Integer age, Student.Grade grade) {
//        storage.put(name, Student.of(name, age, grade));
        storage.put(name, Student.of(name, age, grade));
    }

}
