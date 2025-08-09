package com.ved.cruddemo.dao;


import com.ved.cruddemo.entity.Instructor;
import com.ved.cruddemo.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    boolean deleteById(int id);

}
