package com.example.spring_student.repository;

import com.example.spring_student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDao {

    private  final List<Student> STUDENT = new ArrayList<>();

    public  List<Student> findAllStudent(){
        return STUDENT;
    }

    public Student saveStudent(Student student) {
        STUDENT.add(student);
        return student;
    }

    public Student findStudentByEmail(String email) {

        return STUDENT.stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst().orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, STUDENT.size())
                .filter(index -> STUDENT.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);

        if (studentIndex > -1) {
            STUDENT.set(studentIndex, student);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {

        var student = findStudentByEmail(email);

        if(student != null){
            STUDENT.remove(student);
        }
    }
}
