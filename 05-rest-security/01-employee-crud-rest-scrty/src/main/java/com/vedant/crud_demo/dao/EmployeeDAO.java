package com.vedant.crud_demo.dao;

import com.vedant.crud_demo.entity.Employee;
import com.vedant.crud_demo.service.EmployeeService;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    public List<Employee> addAll(List<Employee> employees);

    Employee update(Employee employee);
}
