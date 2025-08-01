package com.vedant.crud_demo.service.impl;

import com.vedant.crud_demo.dao.EmployeeDAO;
import com.vedant.crud_demo.entity.Employee;
import com.vedant.crud_demo.service.EmployeeService;
import jakarta.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO =  employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {

        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public List<Employee> addAll(List<Employee> employees) {
        return employeeDAO.addAll(employees);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDAO.update(employee);
    }
}
