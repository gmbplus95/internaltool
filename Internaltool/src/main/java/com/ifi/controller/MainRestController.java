package com.ifi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.logging.log4j.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.exceptions.ConnectionException;
import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.model.Request_form;
import com.ifi.service.AppService;

@RestController
public class MainRestController {
	@Autowired
	private AppService appService;
	@RequestMapping("/getAllEmployee")
	public @ResponseBody Payload employeesPageable() {
		Payload message=new Payload();
		Object data="";
		try {
			data=appService.getAllEmployee();
			message.setCode("Success code");
			message.setStatus("OK");
			message.setDescription("Get site data successfully");
			message.setData(data);
		} catch (ConnectionException e) {
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(Constants.LOG4J2_DEBUG);
		}
		return message;

	}
	
	@RequestMapping("/findEmployee")
	public @ResponseBody Payload findEmployeebyUsername(){
		Payload message=new Payload();
		Object data="";
		try {
			Employee a=appService.getEmployeeByUsername("boss1234");
			if(a!=null) 
				{
					message.setCode("Success code");
					message.setStatus("OK");
					message.setDescription("Get site data successfully");
					message.setData(data);
				}
			else {
				message.setCode("Success code");
				message.setStatus("OK");
				message.setDescription("Empty Data");
				message.setData(data);
			}
		} catch (ConnectionException e) {
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(Constants.LOG4J2_DEBUG);
		}
		return message;
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
