package com.ifi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.model.Request_form;
import com.ifi.repository.EmployeeRepository;
import com.ifi.repository.ProjectRepository;
import com.ifi.repository.RequestFormRepository;

@Service("AppService")
public class AppServiceImpl implements AppService {
	@Autowired
	EmployeeRepository er;
	@Autowired
	ProjectRepository pr;
	@Autowired
	RequestFormRepository rfr;
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
	@Override
	public List<Request_form> getAllRequest() {
		// TODO Auto-generated method stub
		return rfr.findAll();
	}
	@Override
	public List<Request_form> getAllRequestByEmpid(UUID emp_id) {
		// TODO Auto-generated method stub
		return rfr.findRequestByEmpid(emp_id);
		}
//	@Override
//	public Set<UUID> getListSubid(UUID emp_id) {
//		// TODO Auto-generated method stub
//		return er.findAllSubId(emp_id);
//	}
	@Override
	public Employee getEmployeeByEmpid(UUID emp_id) {
		// TODO Auto-generated method stub
		return er.findEmployeeByEmpid(emp_id);
	}
}
