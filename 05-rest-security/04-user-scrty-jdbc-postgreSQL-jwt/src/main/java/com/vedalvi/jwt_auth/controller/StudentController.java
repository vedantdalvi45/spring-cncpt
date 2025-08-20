package com.vedalvi.jwt_auth.controller;

import com.vedalvi.jwt_auth.entity.Student;
import com.vedalvi.jwt_auth.exception.CustomExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> studentList = new ArrayList<>(List.of(
            new Student(1,"Raj",89.50f),
            new Student(2,"Shyam",78.25f),
            new Student(3,"Baburao",65.75f),
            new Student(4,"Raju",92.00f),
            new Student(5,"Anuradha",88.10f)
    ));
    public ResponseEntity<List<Student>> getStudents() {

            return ResponseEntity.ok(studentList);

    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

//    @PostMapping("/student")
//    public Student addStudent(@RequestBody Student student){
//        studentList.add(student);
//        return student;
//    }
}
