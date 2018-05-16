package com.ifi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.repository.EmployeeRepository;
import com.ifi.repository.ProjectRepository;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository er;
	@Autowired
	ProjectRepository pr;
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return er.findAll();
	}
	@Override
	public Employee getEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		return er.findEmployeeByUsername(username);
	}
	@Override
	public List<Project> getProjectNameByEmp(UUID emp_id) {
		// TODO Auto-generated method stub
		return pr.findProjectByEmployee(emp_id);
	}
	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}
}