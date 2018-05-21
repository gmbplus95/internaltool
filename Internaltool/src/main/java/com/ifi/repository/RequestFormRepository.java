package com.ifi.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifi.model.Request_form;

public interface RequestFormRepository extends CassandraRepository<Request_form,UUID>{
	@Query("SELECT * FROM  request_form")
	public List<Request_form> findAllRequest();
	
	@Query("SELECT * FROM  request_form where emp_id= :emp_id")
	public List<Request_form> findRequestByEmpid(@Param("emp_id") UUID emp_id);
	
	@Query("SELECT * FROM request_form where send_to=:send_to ALLOW FILTERING" )
	public Request_form findRequestBySendto(@Param("send_to") UUID send_to);
	
	@Query("DELETE FROM request_form where emp_id=:emp_id and pro_id=:pro_id and request_id=:request_id")
	public void deleteRequest(@Param("emp_id") UUID emp_id,@Param("pro_id") UUID pro_id,@Param("request_id") UUID request_id);
	
	@Query("SELECT * from request_form where emp_id=:emp_id and pro_id=:pro_id and request_id=:request_id")
	public Request_form getRequestByAllId(@Param("emp_id") UUID emp_id,@Param("pro_id") UUID pro_id,@Param("request_id") UUID request_id);
	
	//các truy vấn phục vụ cho Search
	@Query("SELECT * FROM  request_form where emp_name= :emp_name and pro_name =:pro_name and from_date=:from_date and to_date=:to_date and status=:status ALLOW FILTERING")
	public List<Request_form> searchRequest1(@Param("emp_name") String emp_name,@Param("pro_name") String pro_name,@Param("from_date") LocalDate from_date,@Param("to_date") LocalDate to_date,@Param("status") int status);

}
