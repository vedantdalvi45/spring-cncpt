package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);

//            createMultipleStudents(studentDAO);

            try {
                System.out.println(findStudentById(studentDAO,3).toString());
            }catch (NullPointerException e){
                System.out.println(e.getLocalizedMessage());
            }

            System.out.println("findAll()");
            for(Student s:findAllStudents(studentDAO)){
                System.out.println(s.toString());
            }
        };
    }

    private List<Student> findAllStudents(StudentDAO studentDAO) {
        return studentDAO.findAll();
    }

    private Student findStudentById(StudentDAO studentDAO,int id){
        return studentDAO.findById(id);
    }
    private void createMultipleStudents(StudentDAO studentDAO) {
        //create multiple students
        System.out.println("Creating 3 Students ");
        Student student1 = new Student("Ajay", "Varak", "abc@gmail.com");
        Student student2 = new Student("Priya", "Sharma", "priya.sharma@example.com");
        Student student3 = new Student("Rahul", "Mehta", "rahul.mehta@example.com");
        Student student4 = new Student("Sneha", "Patil", "sneha.patil@example.com");
        //save students
        System.out.println("Saving The Student");
        try {
//            studentDAO.save(student1);
            studentDAO.save(student2);
            studentDAO.save(student3);
            studentDAO.save(student4);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Exeption +" + e.getMessage());
        }
    }

    private void createStudent(StudentDAO studentDAO) {

        //Create Student Object
        System.out.println("Creating New Student ");
        Student student1 = new Student("Ajay", "Varak", "abc@gmail.com");

        //Save Student Object
        System.out.println("Saving The Student");
        try {
            studentDAO.save(student1);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Exeption +" + e.getMessage());
        }


        //display the id of saved student
        System.out.println("Student Id " + student1.getId());
    }
}
