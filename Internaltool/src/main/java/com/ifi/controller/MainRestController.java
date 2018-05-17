package com.ifi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.model.Request_form;
import com.ifi.service.AppService;

@RestController
public class MainRestController {
	@Autowired
	private AppService appService;
	@RequestMapping("/getAllEmployee")
		public List<Employee> getAllEmployee(){
			return appService.getAllEmployee();
	}
	
	@RequestMapping("/findEmployee")
	public Set<UUID> findEmployeebyUsername(){
		Employee a=appService.getEmployeeByUsername("boss123");
		Set<UUID> myset=a.getSub_id();
		return myset;
	}

	
	@RequestMapping("/findProName")
	public List<String> findProjectName(){
		UUID a=UUID.fromString("9ccf8209-47fa-4a3c-b651-db5469d782e3");
		List<Project> list= appService.getProjectNameByEmp(a);
        List<String> list2=new ArrayList<String>();
		 for (Project s : list) {
	            list2.add(s.getPro_name());
	        }
		return list2;
}
	
	@RequestMapping("/findAllRequest")
	public List<Request_form> findAllRequest(){
		return appService.getAllRequest();
}
	
	@RequestMapping("/findAllRequestbyId")
	public List<Request_form> findAllRequestbyEmpid(){
		UUID a=UUID.fromString("9ccf8209-47fa-4a3c-b651-db5469d782e3");
		return appService.getAllRequestByEmpid(a);
}
	@RequestMapping("/findAllRequestbySubid")
	public List<List<Request_form>> findAllRequestbyEmpidSubid(){
		List<List<Request_form>> list = new ArrayList<List<Request_form>>();
		UUID a=UUID.fromString("6db3c954-a335-4cc2-83e5-fb99330b458f");
		Employee emp=appService.getEmployeeByEmpid(a);
		for(UUID myset: emp.getSub_id()) {
			list.add(appService.getAllRequestByEmpid(myset));
		};
		return list;
}
//	@RequestMapping("/findSubIdByEmpid")
//	public Set<UUID> findSubIdByEmpid(){
//		UUID a=UUID.fromString("6db3c954-a335-4cc2-83e5-fb99330b458f");
//		return appService.getListSubid(a);
//}
}
