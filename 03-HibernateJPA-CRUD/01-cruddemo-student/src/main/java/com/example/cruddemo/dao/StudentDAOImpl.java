package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

//    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("From Student ORDER BY lastName",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String name) {

        //Create Query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student WHERE lastName = :theLastName",Student.class);

        //Set Parameters
        typedQuery.setParameter("theLastName",name);

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(Student.class,id));
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRows;
    }


}
