package org.techhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"org.techhub"})
public class DBConfig {

	@Bean(name="dataSource")
	public DriverManagerDataSource getDataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/aug2025","root","AratiSQL@8");
	}
	@Bean(name="template")
	public JdbcTemplate getTemplate() {
		return new JdbcTemplate(this.getDataSource());
	}
}
