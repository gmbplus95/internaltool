package com.ifi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.datastax.driver.core.querybuilder.QueryBuilder;

public class SelectWhere {
	protected com.datastax.driver.core.querybuilder.Select.Where getSelectStatement(Map<String, Object> keyValues) {
		  List<String> keys = new ArrayList<>();
		  List<Object> values = new ArrayList<>();
		  for (Entry<String, Object> entry : keyValues.entrySet()) {
		   keys.add(entry.getKey());
		   values.add(entry.getValue());
		  }
		  com.datastax.driver.core.querybuilder.Select.Where where = null;
		  for (int i = 0; i < keys.size(); i++) {
		   String key = keys.get(i);
		   Object value = values.get(i);
	
		   if (i == 0) {
		    where = QueryBuilder.select().from("internaltool", "request_form").where(QueryBuilder.eq(key, value));
		   } else {
		    where = where.and(QueryBuilder.eq(key, value));
		   }
		  }
		  return where;
		 }
}
