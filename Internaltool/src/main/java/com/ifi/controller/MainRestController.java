package com.ifi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.exceptions.ConnectionException;
import com.datastax.driver.core.utils.UUIDs;
import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.model.Request_form;
import com.ifi.service.AppService;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class MainRestController {
	@Autowired
	private AppService appService;

	@RequestMapping("/getAllEmployee")
	public @ResponseBody Payload employeesPageable() {
		Payload message = new Payload();
		Object data = "";
		try {
			data = appService.getAllEmployee();
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
	
	@RequestMapping("/getAllEmployeePaginated")
	public List<Employee> getAllEmployeePaginated(@RequestParam("page") int page,@RequestParam("size") int size){
		if(page>0 && size>0) {
			return appService.getAllEmployeePaginated(page-1, size);
		}
		return appService.getAllEmployee();
	}
		
	@RequestMapping("/findEmployee")
	public @ResponseBody Payload findEmployeebyUsername() {
		Payload message = new Payload();
		Object data = "";
		try {
			Employee a = appService.getEmployeeByUsername("boss123");
			if (a != null) {
				message.setCode("Success code");
				message.setStatus("OK");
				message.setDescription("Get site data successfully");
				message.setData(a);
			} else {
				message.setCode("Success code");
				message.setStatus("OK");
				message.setDescription("Empty Data");
				message.setData(a);
			}
		} catch (ConnectionException e) {
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setCode("Error!!");
			message.setStatus(Constants.LOG4J2_DEBUG);
		}
		return message;
	}

	@RequestMapping("/findProName")
	public List<String> findProjectName() {
		UUID a = UUID.fromString("9ccf8209-47fa-4a3c-b651-db5469d782e3");
		List<Project> list = appService.getProjectNameByEmp(a);
		List<String> list2 = new ArrayList<String>();
		for (Project s : list) {
			list2.add(s.getPro_name());
		}
		return list2;
	}

	@RequestMapping("/findAllRequest")
	public List<Request_form> findAllRequest() {
		return appService.getAllRequest();
	}

	@RequestMapping("/findAllRequestbyId")
	public List<Request_form> findAllRequestbyEmpid() {
		UUID a = UUID.fromString("9ccf8209-47fa-4a3c-b651-db5469d782e3");
		List<Request_form> list=appService.getAllRequestByEmpid(a);
		return list;
	}

//	@RequestMapping("/findAllRequestbySubid")
//	public List<List<Request_form>> findAllRequestbyEmpidSubid() {
//		List<List<Request_form>> list = new ArrayList<List<Request_form>>();
//		UUID a = UUID.fromString("9cc09-47fa-4a3c-b651-db5469d782e3");
//		Employee emp = appService.getEmployeeByEmpid(a);
//		for (UUID myset : emp.getSub_id()) {
//			list.add(appService.getAllRequestByEmpid(myset));
//		}
//		;
//		return list;
//	}

	@RequestMapping(value = "/addRequestform")
	public void addRequestform(@Valid @RequestBody Request_form request_form) {
		request_form.setRequest_id(UUIDs.random());//đặt request_id random uuid
		request_form.setStatus(0);//mặc định là 0: chờ được duyệt
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			try {
				Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timeStamp);
				request_form.setCreated_date(date1);
				request_form.setLast_modified(date1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			appService.addRequestForm(request_form);
	}
	
	@RequestMapping("/deleteForm")
	public @ResponseBody Payload deleteForm() {
		Payload message = new Payload();
		Object data = "";
		try {
			UUID emp_id = UUID.fromString("9ccf8209-47fa-4a3c-b651-db5469d782e3");
			UUID pro_id = UUID.fromString("f2b4e014-e51c-48ed-b28f-823f1f911ea9");
  			UUID request_id = UUID.fromString("00cc226f-0b36-471f-8894-83c0883d06bc");
			appService.deleteRequest(emp_id,pro_id,request_id);
			message.setCode("Success code");
			message.setStatus("OK");
			message.setDescription("Delete Success");
			message.setData(data);
		} catch (ConnectionException e) {
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(Constants.LOG4J2_DEBUG);
		}
		return message;

	}
	
}
