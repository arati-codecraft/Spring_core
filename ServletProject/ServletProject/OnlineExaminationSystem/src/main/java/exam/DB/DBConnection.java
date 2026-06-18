package exam.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection con;

	public static Connection getConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/online_exam_system",
			"root",
			"Ashu@#8698");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return con;
	}
}