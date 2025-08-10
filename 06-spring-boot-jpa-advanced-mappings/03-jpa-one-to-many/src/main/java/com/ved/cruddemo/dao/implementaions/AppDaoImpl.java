package com.ved.cruddemo.dao.implementaions;

import com.ved.cruddemo.dao.AppDao;
import com.ved.cruddemo.entity.Course;
import com.ved.cruddemo.entity.Instructor;
import com.ved.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

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
    public List<Instructor> findAllInstructors() {
        TypedQuery<Instructor> query =entityManager.createQuery("from Instructor",Instructor.class);
        return query.getResultList();
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

    @Override
    public List<Course> findCourseByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data",Course.class);
        query.setParameter("data",id);

        List<Course> courses =  query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByCourseJoinFetch(int id) {
        TypedQuery<Instructor> instructorTypedQuery = entityManager.createQuery(
                    "select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "WHERE i.id = :data", Instructor.class);

        instructorTypedQuery.setParameter("data",id);

        Instructor instructor = instructorTypedQuery.getSingleResult();
        return instructor;
    }


}
