package com.ifi.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("request_form")
public class Request_form {
	@PrimaryKeyColumn(
		      name = "emp_id", 
		      ordinal = 0, 
		      type = PrimaryKeyType.PARTITIONED)
		    private UUID emp_id;
	@PrimaryKeyColumn(
  	      name = "pro_id", 
  	      ordinal = 1, 
  	      type = PrimaryKeyType.CLUSTERED, 
  	      ordering = Ordering.ASCENDING)
			private UUID pro_id;
	@PrimaryKeyColumn(
	  	      name = "request_id", 
	  	      ordinal = 2, 
	  	      type = PrimaryKeyType.CLUSTERED, 
	  	      ordering = Ordering.ASCENDING)
				private UUID request_id;
	
	@Column
    @CreatedDate
    private Date created_date;
	@Column
    @LastModifiedDate
    private Date last_modified;
	@Column
	private String emp_name;
	@Column
	private String pro_name;
	@Column
	private LocalDate from_date;
	@Column
	private LocalDate to_date;
	@Column
	private String description;
	@Column
	private int type;
	@Column
	private int status;
	public UUID getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(UUID emp_id) {
		this.emp_id = emp_id;
	}
	public UUID getPro_id() {
		return pro_id;
	}
	public void setPro_id(UUID pro_id) {
		this.pro_id = pro_id;
	}
	public UUID getRequest_id() {
		return request_id;
	}
	public void setRequest_id(UUID request_id) {
		this.request_id = request_id;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getLast_modified() {
		return last_modified;
	}
	public void setLast_modified(Date last_modified) {
		this.last_modified = last_modified;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public LocalDate getFrom_date() {
		return from_date;
	}
	public void setFrom_date(LocalDate from_date) {
		this.from_date = from_date;
	}
	public LocalDate getTo_date() {
		return to_date;
	}
	public void setTo_date(LocalDate to_date) {
		this.to_date = to_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Request_form(UUID pro_id, UUID request_id, Date created_date, Date last_modified, String emp_name,
			String pro_name, LocalDate from_date, LocalDate to_date, String description, int type, int status) {
		super();
		this.pro_id = pro_id;
		this.request_id = request_id;
		this.created_date = created_date;
		this.last_modified = last_modified;
		this.emp_name = emp_name;
		this.pro_name = pro_name;
		this.from_date = from_date;
		this.to_date = to_date;
		this.description = description;
		this.type = type;
		this.status = status;
	}
	public Request_form() {
		super();
	}
	
	
}
