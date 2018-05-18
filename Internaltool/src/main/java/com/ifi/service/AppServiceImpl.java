package com.ifi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Service;

import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.model.Request_form;
import com.ifi.repository.EmployeeRepository;
import com.ifi.repository.ProjectRepository;
import com.ifi.repository.RequestFormRepository;
@EnableCassandraRepositories(basePackages = "com.ifi.repository")
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
		return rfr.findAllRequest();
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
	@Override
	public Request_form getRequestFormBySendto(UUID send_to) {
		// TODO Auto-generated method stub
		return rfr.findRequestBySendto(send_to);
	}
	@Override
	public void addRequestForm(Request_form request_form) {
		rfr.save(request_form);
	}
	@Override
	public void deleteRequest(UUID emp_id,UUID pro_id,UUID request_id) {
		// TODO Auto-generated method stub
//		UUID emp_id1 = UUID.fromString(emp_id);
//		UUID pro_id1 = UUID.fromString(pro_id);
//		UUID request_id1 = UUID.fromString(request_id);
		rfr.deleteRequest(emp_id, pro_id, request_id);
	}
	@Override
	public List<Employee> getAllEmployeePaginated(int page, int size) {
		List<Employee> list=er.findAll();
		int from = Math.max(0,page*size);
		int to = Math.min(list.size(),(page+1)*size);
		return list.subList(from,to);
	}
}
