package org.techhub;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"org.techhub"})
public class DbConfig {
	@Bean(name="dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource("jdbc:mysql://localhost:3306/aug2025","root", "AratiSQL@8");
		 return dataSource;
	}


}
