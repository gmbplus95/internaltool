package com.ifi.model;

import java.time.LocalDate;
//import com.datastax.driver.core.LocalDate;

public class Search {
	private String emp_name;
	private String pro_name;
	private LocalDate from_date;
	private LocalDate to_date;
	private int status;
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
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public Search(String emp_name, String pro_name, LocalDate from_date, LocalDate to_date, int status) {
		super();
		this.emp_name = emp_name;
		this.pro_name = pro_name;
		this.from_date = from_date;
		this.to_date = to_date;
		this.status = status;
	}
	public Search() {
		super();
	}
	
}
