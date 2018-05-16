package com.ifi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifi.model.Project;

public interface ProjectRepository extends CassandraRepository<Project, UUID> {
	@Query("SELECT * FROM  project where emp_id= :emp_id ALLOW FILTERING")
	public List<Project> findProjectByEmployee(@Param("emp_id") UUID emp_id);
}
