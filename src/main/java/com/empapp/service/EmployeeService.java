package com.empapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empapp.dto.EmployeeDto;
import com.empapp.entity.Employee;
import com.empapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void addEmployee(Employee emp)
	{
		employeeRepository.save(emp);
	}

	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees;
	}

	public void deleteEmployee(long id) {

		employeeRepository.deleteById(id);
	}

	public Optional<Employee> getEmployeeById(long id) {

		return employeeRepository.findById(id);
		
	}
	
	public void updateEmployee(Employee emp)
	{
		employeeRepository.save(emp);
	}
	
	public Employee updateEmployeeById(long id,EmployeeDto e)
	
	{
		Employee emp = employeeRepository.findById(id).get();
		
		emp.setName(e.getName());
		emp.setEmail(e.getEmail());
		emp.setMobile(e.getMobile());
		employeeRepository.save(emp);
		return emp;
		
		
	}
}
