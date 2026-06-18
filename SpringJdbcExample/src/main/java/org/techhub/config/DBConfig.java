package org.techhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"org.techub"})
public class DBConfig {

    @Bean(name="dataSource")
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // ✅ must set driver
        dataSource.setUrl("jdbc:mysql://localhost:3306/aug2025");
        dataSource.setUsername("root");
        dataSource.setPassword("AratiSQL@8");
        return dataSource;
    }

    @Bean(name="template")
    public JdbcTemplate getTemplate() {
        return new JdbcTemplate(getDataSource());
    }
}
