package com.vedant.crud_demo.service;

import com.vedant.crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    List<Employee> addAll(List<Employee> employees);

    Employee update(Employee employee);
}
