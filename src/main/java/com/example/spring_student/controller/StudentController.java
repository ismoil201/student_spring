package com.example.spring_student.controller;

import com.example.spring_student.service.StudentService;
import com.example.spring_student.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {


    private final  StudentService service ;
    @GetMapping
    public List<Student>  findAllStudent(){
        //todo
        return service.findAllStudent();
    }

    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student){
        service.saveStudent(student);
        return "Student saved successfully";
    }

    @GetMapping("/{email}")
    public Student findStudentByEmail(@PathVariable String email){
        return  service.findStudentByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email){
        service.deleteStudent(email);
    }


}
