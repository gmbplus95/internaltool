package com.ifi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.ifi.model.Employee;
import com.ifi.model.Project;
import com.ifi.model.Request_form;
import com.ifi.model.Search;
import com.ifi.repository.EmployeeRepository;
import com.ifi.repository.ProjectRepository;
import com.ifi.repository.RequestFormRepository;
import com.ifi.repository.SelectWhere;
@EnableCassandraRepositories(basePackages = "com.ifi.repository")
@Service("AppService")
public class AppServiceImpl extends SelectWhere implements AppService {
	@Autowired
    CassandraSessionFactoryBean session;
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
		// TODO Auto-generated method stuber
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
	@Override
	public Request_form getRequestByAllId(UUID emp_id, UUID pro_id, UUID request_id) {
		return rfr.getRequestByAllId(emp_id, pro_id, request_id);
	}
	@Override
	public List<Request_form> searchRequest(Search searchModel) {
		// TODO Auto-generated method stub
		Session nativeSessionObject = session.getObject();
		Map<String, Object> keyValues = new HashMap<String, Object>();
		if(searchModel.getEmp_name()!="")
		{
		keyValues.put("emp_name", searchModel.getEmp_name());
	    }
		if(searchModel.getPro_name()!="")
		{
			keyValues.put("pro_name", searchModel.getPro_name());
		}
		if(searchModel.getFrom_date()!=null)
		{
			com.datastax.driver.core.LocalDate a=this.convert(searchModel.getFrom_date());//convert sang localDate
	    	 keyValues.put("from_date",a);
		     
		}
	
		if(searchModel.getTo_date()!=null)
		{
		com.datastax.driver.core.LocalDate a=this.convert(searchModel.getTo_date());
		keyValues.put("to_date", a);
		}
		
		if(searchModel.getStatus()!=0)
		{
		keyValues.put("status", searchModel.getStatus());
		}	
		
		com.datastax.driver.core.querybuilder.Select.Where a =super.getWhereStatement(keyValues);
		com.datastax.driver.core.querybuilder.Select c=a.allowFiltering();
		ResultSet b= nativeSessionObject.execute(c);
		MappingManager manager = new MappingManager(nativeSessionObject);

		Mapper<Request_form> mapper = manager.mapper(Request_form.class);
		Result<Request_form> request_forms = mapper.map(b);
		List<Request_form> request_list = new ArrayList<>(); 
		for (Request_form u : request_forms) {
			request_list.add(u);
		}
		return request_list;//cach 1
//		b.iterator().forEachRemaining(row ->  
//		request_list.add(new Request_form(row.getUUID("emp_id"), 
//										  row.getUUID("pro_id"),
//										  row.getUUID("request_id"),
//										  row.getString("description"),
//										  row.getString("emp_name"),
//										  row.getDate("from_date"),
//										  row.getDate("to_date"),
//										  row.getUUID("next_approve_id"),
//										  row.getSet("approved_id", UUID.class),
//										  row.getTimestamp("created_date"),
//										  row.getTimestamp("last_modified"),
//										  row.getString("pro_name"),
//										  row.getInt("status"),
//										  row.getInt("type")
//										   
//		                       )));
//		return request_list;//cach 2
	}
	//convert tu java.time.LocalDate sang com.datastax.driver.core.LocalDate
	public com.datastax.driver.core.LocalDate convert(LocalDate localDate) {
		return com.datastax.driver.core.LocalDate.fromYearMonthDay(localDate.getYear(), localDate.getMonthValue(),
				localDate.getDayOfMonth());
	}
	//convert tu com.datastax.driver.core.LocalDate sang java.time.LocalDate 
	public LocalDate convert(com.datastax.driver.core.LocalDate localDate) {
		return LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDay());
	}

}
