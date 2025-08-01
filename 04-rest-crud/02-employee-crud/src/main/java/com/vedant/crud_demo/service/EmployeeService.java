package com.vedant.crud_demo.service;

import com.vedant.crud_demo.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    List<Employee> addAll(List<Employee> employees);

    Employee update(Employee employee);
}
