package com.empapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
