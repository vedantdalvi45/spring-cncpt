package com.ved.cruddemo.dao;


import com.ved.cruddemo.entity.Course;
import com.ved.cruddemo.entity.Instructor;
import com.ved.cruddemo.entity.InstructorDetail;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppDao {

    void save(Instructor instructor);

    List<Instructor> findAllInstructors();

    Instructor findInstructorById(int id);

    boolean deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    boolean deleteInstructorDetailById(int id);

    List<Course> findCourseByInstructorId(int id);

    Instructor findInstructorByCourseJoinFetch(int id);


}
