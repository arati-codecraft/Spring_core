package org.techhub;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
public class ParamToSQLStatement implements PreparedStatementSetter {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	private int sal;
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		 ps.setString(1, this.getName());
		 ps.setInt(2,this.getSal());
	}

}

