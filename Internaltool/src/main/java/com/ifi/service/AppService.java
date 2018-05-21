package com.ifi.service;

import java.util.List;
import java.util.UUID;

import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.model.Request_form;
import com.ifi.model.Search;

public interface AppService {
	// TEST
	List<Employee> getAllEmployee();//lấy tất cả Employee
	
	// REAL
	
	Employee getEmployeeByUsername(String username);//Lấy thông tin employee dựa vào username
	List<Project> getProjectNameByEmp(UUID emp_id);//lấy thông tin project của empid
	void addRequestForm(Request_form request_form);
	void deleteRequest(UUID emp_id,UUID pro_id,UUID request_id);
	List<Request_form> getAllRequestByEmpid(UUID emp_id);//lấy tất cả request dựa vào empid
	List<Request_form> searchRequest(Search searchModel);

	
	
	
	
	
	
	List<Project> getAllProject();//lấy tất cả project
	List<Request_form> getAllRequest();//lấy tất cả request
	Employee getEmployeeByEmpid(UUID emp_id);		//lấy được emp dựa vào empid
	Request_form getRequestFormBySendto(UUID send_to);//lấy request dựa vào send_to id
	List<Employee> getAllEmployeePaginated(int start,int size);
	Request_form getRequestByAllId(UUID emp_id,UUID pro_id,UUID request_id);
//	Set<UUID> getListSubid(UUID emp_id);
}
