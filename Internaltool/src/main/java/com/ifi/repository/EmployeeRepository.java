package com.ifi.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.ifi.model.Employee;

public interface EmployeeRepository extends CassandraRepository<Employee, String> {

}
