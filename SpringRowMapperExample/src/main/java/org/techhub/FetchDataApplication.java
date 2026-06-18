package org.techhub;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class FetchDataApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		JdbcTemplate template = (JdbcTemplate) context.getBean("template");
		RowMapper r = (ResultSet rs, int rowNum)->{
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSal(rs.getInt(3));
				return emp;
			};
		List<Employee> list = template.query("select *from emp", r);
		for (Employee e : list) {
			System.out.println(e.getId() + "\t" + e.getName() + "\t" + e.getSal());
		}
	}

}
