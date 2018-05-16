package com.ifi.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifi.model.Employee;

public interface EmployeeRepository extends CassandraRepository<Employee, String> {
	@Query("SELECT * FROM  employee where username= :username ALLOW FILTERING")
	public Employee findEmployeeByUsername(@Param("username") String username);
}
