package com.example.spring_student.service;

import com.example.spring_student.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

     List<Student> findAllStudent();

     Student saveStudent(Student student);

     Student findStudentByEmail(String email);

     Student updateStudent(Student student);

     void deleteStudent(String email);
}
