package com.example.spring_student.repository;

import com.example.spring_student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    void deleteStudentByEmail(String email);

    Student findStudentByEmail(String email);
}

