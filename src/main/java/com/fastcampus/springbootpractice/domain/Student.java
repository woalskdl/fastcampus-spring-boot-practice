package com.fastcampus.springbootpractice.domain;

// Java 14 이후 나온 record 타입 활용
public record Student(
        String name,
        Integer age,
        Grade grade
) {
    public static Student of(String name, Integer age, Grade grade) {
        return new Student(name, age, grade);
    }

    public enum Grade {
        A, B, C, D, F
    }
}
