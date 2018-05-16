package com.ifi.model;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;



@Table("project")
public class Project {
	@PrimaryKeyColumn(
		      name = "pro_id", 
		      ordinal = 0, 
		      type = PrimaryKeyType.PARTITIONED)
		    private UUID pro_id;
		    @PrimaryKeyColumn(
		    	      name = "emp_id", 
		    	      ordinal = 1, 
		    	      type = PrimaryKeyType.CLUSTERED, 
		    	      ordering = Ordering.ASCENDING)
		    private UUID emp_id;
		    @PrimaryKeyColumn(
		    	      name = "join_time", 
		    	      ordinal = 2, 
		    	      type = PrimaryKeyType.CLUSTERED, 
		    	      ordering = Ordering.ASCENDING)
		    private Date join_time;
		    @Column
		    private String pro_name;
		    @Column
		    private LocalDate time_start;
		    @Column
		    private LocalDate time_end;
			public UUID getPro_id() {
				return pro_id;
			}
			public void setPro_id(UUID pro_id) {
				this.pro_id = pro_id;
			}
			public UUID getEmp_id() {
				return emp_id;
			}
			public void setEmp_id(UUID emp_id) {
				this.emp_id = emp_id;
			}
			public Date getJoin_time() {
				return join_time;
			}
			public void setJoin_time(Date join_time) {
				this.join_time = join_time;
			}
			public String getPro_name() {
				return pro_name;
			}
			public void setPro_name(String pro_name) {
				this.pro_name = pro_name;
			}
			public LocalDate getTime_start() {
				return time_start;
			}
			public void setTime_start(LocalDate time_start) {
				this.time_start = time_start;
			}
			public LocalDate getTime_end() {
				return time_end;
			}
			public void setTime_end(LocalDate time_end) {
				this.time_end = time_end;
			}
			public Project(UUID emp_id, Date join_time, String pro_name, LocalDate time_start, LocalDate time_end) {
				super();
				this.emp_id = emp_id;
				this.join_time = join_time;
				this.pro_name = pro_name;
				this.time_start = time_start;
				this.time_end = time_end;
			}
			public Project() {
				super();
			}
		    
}


//timestamp trong cassandra kieu Date, date trong cassandra kieu java.time.LocalDate;
