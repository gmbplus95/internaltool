package com.ifi.model;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("employee")
public class Employee {
	    @PrimaryKeyColumn(
	      name = "emp_id", 
	      ordinal = 0, 
	      type = PrimaryKeyType.PARTITIONED)
	    private UUID emp_id;
	    @Column
	    private String emp_group;
	    @Column
	    private String emp_name;
	    @Column
	    private String username;
	    @Column
	    private Set<UUID> sub_id;
	    // standard getters and setters
		public UUID getEmp_id() {
			return emp_id;
		}
		public void setEmp_id(UUID emp_id) {
			this.emp_id = emp_id;
		}
		public String getEmp_group() {
			return emp_group;
		}
		public void setEmp_group(String emp_group) {
			this.emp_group = emp_group;
		}
		public String getEmp_name() {
			return emp_name;
		}
		public void setEmp_name(String emp_name) {
			this.emp_name = emp_name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public Set<UUID> getSub_id() {
			return sub_id;
		}
		public void setSub_id(Set<UUID> sub_id) {
			this.sub_id = sub_id;
		}
		public Employee(String emp_group, String emp_name, String username, Set<UUID> sub_id) {
			super();
			this.emp_group = emp_group;
			this.emp_name = emp_name;
			this.username = username;
			this.sub_id = sub_id;
		}
		public Employee() {
			super();
		}
	}

