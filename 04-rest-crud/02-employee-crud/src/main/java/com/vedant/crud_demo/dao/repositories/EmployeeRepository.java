package com.vedant.crud_demo.dao.repositories;

import com.vedant.crud_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
