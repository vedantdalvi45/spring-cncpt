package com.ved.cruddemo;

import com.ved.cruddemo.dao.AppDao;
import com.ved.cruddemo.entity.Instructor;
import com.ved.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner ->{
//			createInstructor(appDao);

//			findInstructor(appDao);
//			deleteInstructor(appDao);

		};

	}

	void createInstructor(AppDao appDao){
		Instructor instructor = new Instructor("Raj","Kumar","raj@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("raj YT","xx");
		instructor.setInstructorDetail(instructorDetail);
		System.out.println(instructor.toString());
		try {
			appDao.save(instructor);
			System.out.println("Done");
		}catch (DataIntegrityViolationException e){
			System.out.println(e.getClass()+" : "+e.getLocalizedMessage());
		}

	}

	void findInstructor(AppDao appDao){
		System.out.println(appDao.findInstructorById(2));
	}

	void deleteInstructor(AppDao appDao){

		System.out.println("Instructor Deleted Status : "+ appDao.deleteById(1));
	}


}
