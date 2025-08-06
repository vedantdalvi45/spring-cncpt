package com.vedant.crud_demo.service.impl;

import com.vedant.crud_demo.dao.EmployeeDAO;
import com.vedant.crud_demo.dao.repositories.EmployeeRepository;
import com.vedant.crud_demo.entity.Employee;
import com.vedant.crud_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO =  employeeDAO;
    }

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Employee> addAll(List<Employee> employees) {
        return employeeDAO.addAll(employees);
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        return employeeDAO.update(employee);
    }
}
