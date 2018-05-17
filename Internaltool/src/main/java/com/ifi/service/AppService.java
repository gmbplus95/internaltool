package com.ifi.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.model.Request_form;

public interface AppService {
	List<Employee> getAllEmployee();//lấy tất cả Employee
	Employee getEmployeeByUsername(String username);//Lấy thông tin employee dựa vào username
	List<Project> getProjectNameByEmp(UUID emp_id);//lấy thông tin project của empid
	List<Project> getAllProject();//lấy tất cả project
	List<Request_form> getAllRequest();//lấy tất cả request
	List<Request_form> getAllRequestByEmpid(UUID emp_id);//lấy tất cả request dựa vào empid
	Employee getEmployeeByEmpid(UUID emp_id);
//	Set<UUID> getListSubid(UUID emp_id);
}