package com.vedant.demo.rest;

import com.vedant.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        studentList.add(new Student(studentList.size()+1,"Ajay","Kumar"));
        studentList.add(new Student(studentList.size()+1,"Raj","Kumar"));
        studentList.add(new Student(studentList.size()+1,"Vijay","Kumar"));
        return studentList;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id){
        if (id >= 0 || id > studentList.size())
            throw new StudentNotFoundException("Student not found of id "+id);
        return studentList.get(id-1);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exeption){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exeption.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }

}
