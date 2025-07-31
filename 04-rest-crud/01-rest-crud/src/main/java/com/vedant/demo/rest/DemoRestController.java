package com.vedant.demo.rest;

import com.vedant.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    List<Student> studentList = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World !";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        studentList.add(new Student(studentList.size(),"Ajay","Kumar"));
        studentList.add(new Student(studentList.size(),"Raj","Kumar"));
        studentList.add(new Student(studentList.size(),"Vijay","Kumar"));
        return studentList;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id){
        if (id >= 0 || id > studentList.size())
            throw new StudentNotFoundException("Student not found of id "+id);
        return studentList.get(id-1);
    }

}
