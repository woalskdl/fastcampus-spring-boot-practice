package com.fastcampus.springbootpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
// Java 14 이후 나온 record 타입 활용
public record Student  (
        String name,
        Integer age,
        Grade grade
) implements Serializable
{
    public static Student of(String name, Integer age, Grade grade) {
        return new Student(name, age, grade);
    }

    public enum Grade {
        A, B, C, D, F
    }
}
 */

///* class 를 사용할 경우
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Data
public class Student implements Serializable {
    private String name;
    private Integer age;
    private Grade grade;

    public enum Grade {
        A, B, C, D, F
    }
}
//*/
