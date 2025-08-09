package com.ved.cruddemo.dao.implementaions;

import com.ved.cruddemo.dao.AppDao;
import com.ved.cruddemo.entity.Instructor;
import com.ved.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public boolean deleteById(int id) {
        Instructor instructor = findInstructorById(id);
        if (instructor != null){
            entityManager.remove(instructor);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public boolean deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = findInstructorDetailById(id);
        if (instructorDetail != null){
            entityManager.remove(instructorDetail);
            instructorDetail.getInstructor().setInstructorDetail(null);
            return true;
        }else {
            return false;
        }
    }

}
