package com.ifi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifi.model.Employee;
import com.ifi.repository.EmployeeRepository;

@RestController
public class MainRestController {
	@Autowired
	EmployeeRepository employeeRepo;
	@RequestMapping("/getAllEmployee")
		public List<Employee> getAllEmployee(){
			return employeeRepo.findAll();
	}
}
