package com.ifi.service;

import java.util.List;
import java.util.UUID;

import com.ifi.model.Employee;
import com.ifi.model.Project;

public interface EmployeeService {
		List<Employee> getAllEmployee();
		Employee getEmployeeByUsername(String username);
		List<Project> getProjectNameByEmp(UUID emp_id);
		List<Project> getAllProject();
	}

