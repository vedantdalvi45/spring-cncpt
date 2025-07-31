package com.vedant.crud_demo.repositories;

import com.vedant.crud_demo.dao.EmployeeDAO;
import com.vedant.crud_demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    EntityManager entityManager;


    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }
}
