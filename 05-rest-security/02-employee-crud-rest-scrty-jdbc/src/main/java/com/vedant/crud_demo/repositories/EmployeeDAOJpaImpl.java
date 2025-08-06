package com.vedant.crud_demo.repositories;
import com.vedant.crud_demo.dao.EmployeeDAO;
import com.vedant.crud_demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }


    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Employee.class,id));
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        return entityManager.merge(employee);
    }

    @Transactional
    @Override
    public List<Employee> addAll(List<Employee> employees) {
        List<Employee> employeeList =  new ArrayList<>();
        for (Employee employee : employees){
            employeeList.add(entityManager.merge(employee));
        }
        return employeeList;
    }



}
