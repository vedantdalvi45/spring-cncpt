package com.vedant.crud_demo.dao;

import com.vedant.crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
