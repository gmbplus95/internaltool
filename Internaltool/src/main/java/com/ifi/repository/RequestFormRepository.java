package com.ifi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifi.model.Request_form;

public interface RequestFormRepository extends CassandraRepository<Request_form,UUID>{
	@Query("SELECT * FROM  request_form where emp_id= :emp_id")
	public List<Request_form> findRequestByEmpid(@Param("emp_id") UUID emp_id);
}
