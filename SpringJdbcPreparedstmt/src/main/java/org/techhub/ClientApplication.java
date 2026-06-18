package org.techhub;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.techhub.config.DBConfig;

public class ClientApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		JdbcTemplate template = (JdbcTemplate) context.getBean("template");
		if (template != null) {
			System.out.println("Enter name  and salary of employee");
			Scanner xyz = new Scanner(System.in);
			String name = xyz.nextLine();
			int sal = xyz.nextInt();
			ParamToSQLStatement pstmt = new ParamToSQLStatement();
			pstmt.setName(name);
			pstmt.setSal(sal);
			int result = template.update("insert into emp values('0',?,?)", pstmt);
			if (result > 0) {
				System.out.println("Record save successfully.....");
			} else {
				System.out.println("Some problem is there....");
			}

		} else {
			System.out.println("Database is not connected");
		}
	}
}
