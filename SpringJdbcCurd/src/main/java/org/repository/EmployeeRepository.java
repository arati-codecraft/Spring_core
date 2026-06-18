package org.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Employee emp) {
        String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getSalary());
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"))
        );
    }

    public int updateSalary(int id, double salary) {
        String sql = "UPDATE employee SET salary=? WHERE id=?";
        return jdbcTemplate.update(sql, salary, id);
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}

