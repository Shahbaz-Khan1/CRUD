package com.empapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.dto.EmployeeDto;
import com.empapp.entity.Employee;
import com.empapp.service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/viewAddEmployee")//@webServlet
	public String viewAddEmployee()
	{
		return "add_employee";//requestDispatcher
	}
	
	//First way to add data into backend
	
	//@RequestMapping("/addEmployee")
	//public String addEmployee(Employee emp, Model map)
	//{
	//	employeeService.addEmployee(emp);
	//	map.addAttribute("msg","Record is saved");
	//	return "add_employee";
	//}
	
	// Second way to add data into backend
	
//	@RequestMapping("/addEmployee")
//	public String addEmployee(@RequestParam String name,
//			@RequestParam String email,
//			@RequestParam String mobile
//			, Model map)
//	{  
//		Employee emp= new Employee();
//		emp.setName(name);
//		emp.setEmail(email);
//		emp.setMobile(mobile);
//		employeeService.addEmployee(emp);
//		map.addAttribute("msg","Record is saved");
//		return "add_employee";
//	}
	
	
	@PostMapping("/addEmployee")
		public Employee addEmployee(EmployeeDto dto, Model map)
		{   
		Employee emp= new Employee();
		emp.setName(dto.getName());
		emp.setEmail(dto.getEmail());
		emp.setMobile(dto.getMobile());
		
			employeeService.addEmployee(emp);
			//map.addAttribute("msg","Record is saved");
			//return "add_employee";
			
			return emp;
		}
	
	@RequestMapping("/listEmployee")
	public List<Employee> getAllEmployees(ModelMap model)
	{
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		
		return  employees; 
	}
	
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam long id,Model model)
	{   
		
		employeeService.deleteEmployee(id);
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		
		return "list_employees" ; 
	}
	
	@RequestMapping("/update")
	public String getEmployeeById(@RequestParam long id,Model model)
	{   
		
		
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		Employee employee = emp.get();
		model.addAttribute("employee",employee);

		return "update_employee" ; 
	}
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(EmployeeDto dto, Model map)
	{ 
		
	Employee emp= new Employee();
	emp.setId(dto.getId());
	emp.setName(dto.getName());
	emp.setEmail(dto.getEmail());
	emp.setMobile(dto.getMobile());
	
		employeeService.addEmployee(emp);
		map.addAttribute("msg","Record is saved");
		
		return "add_employee";
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<EmployeeDto> udpateById(@RequestBody EmployeeDto e,@PathVariable long id){
		Employee updateEmployeeById = employeeService.updateEmployeeById(id, e);
		return new ResponseEntity<EmployeeDto>(e,HttpStatus.OK);
	}
	
}
