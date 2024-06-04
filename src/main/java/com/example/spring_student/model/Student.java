package com.example.spring_student.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="fullName")
    private  String name;
    private LocalDate dateBirthday;
    @Transient
    private  int age;
    @Column(unique = true)
    private String email;
    private  String imgUrl;


    public int getAge() {
        return Period.between(dateBirthday, LocalDate.now()).getYears();
    }
}
