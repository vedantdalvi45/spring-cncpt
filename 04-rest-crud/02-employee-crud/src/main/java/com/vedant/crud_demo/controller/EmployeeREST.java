package com.vedant.crud_demo.controller;

import com.vedant.crud_demo.dao.EmployeeDAO;
import com.vedant.crud_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeREST {

    EmployeeDAO employeeDAO;

    public EmployeeREST(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeDAO.findAll();
    }

}
