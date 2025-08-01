package com.vedant.crud_demo.controller;

import com.vedant.crud_demo.entity.Employee;
import com.vedant.crud_demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeREST {

    EmployeeService employeeService;

    public EmployeeREST(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.findById(id);
    }

    @DeleteMapping("/employees/{id}")
    public  void deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
    }

    @PostMapping("/employees/all")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees){
        return employeeService.addAll(employees);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

}
