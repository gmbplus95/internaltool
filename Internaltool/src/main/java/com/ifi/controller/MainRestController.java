package com.ifi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.service.EmployeeService;

@RestController
public class MainRestController {
	@Autowired
	private EmployeeService employeeService;
	@RequestMapping("/getAllEmployee")
		public List<Employee> getAllEmployee(){
			return employeeService.getAllEmployee();
	}
	
	@RequestMapping("/findEmployee")
	public Employee findEmployeebyUsername(){
		return employeeService.getEmployeeByUsername("vanbac998");
}
	
	@RequestMapping("/findProName")
	public List<String> findProjectName(){
		UUID a=UUID.fromString("9ccf8209-47fa-4a3c-b651-db5469d782e3");
		List<Project> list= employeeService.getProjectNameByEmp(a);
        List<String> list2=new ArrayList<String>();
		 for (Project s : list) {
	            list2.add(s.getPro_name());
	        }
		return list2;

}
}
