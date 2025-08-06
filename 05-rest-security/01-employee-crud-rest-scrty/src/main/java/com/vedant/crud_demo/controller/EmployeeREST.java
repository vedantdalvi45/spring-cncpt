package com.vedant.crud_demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vedant.crud_demo.entity.Employee;
import com.vedant.crud_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeREST {

    EmployeeService employeeService;
    @Autowired
    ObjectMapper objectMapper;

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
    public Optional<Employee> getEmployee(@PathVariable int id){
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

    @PatchMapping("/employees/{empId}")
    public Employee getPatchEmployee(@PathVariable int empId, @RequestBody Map<String, Object> patchPayload){
        Optional<Employee> employee = employeeService.findById(empId);

        if (employee.isEmpty())
            throw new RuntimeException("ID not found "+empId);

        if (patchPayload.containsKey("id"))
            throw new RuntimeException("ID not allowed in Request Body "+empId);

        Employee patchedEmployee = apply(patchPayload, employee.orElse(null));
        return employeeService.update(patchedEmployee);
    }

    private Employee apply(Map<String,Object> patchPayload,Employee employee){
        ObjectNode empNode = objectMapper.convertValue(employee,ObjectNode.class);
        ObjectNode patchEmpNode = objectMapper.convertValue(patchPayload,ObjectNode.class);

        empNode.setAll(patchEmpNode);
        return objectMapper.convertValue(empNode,Employee.class);
    }

}
