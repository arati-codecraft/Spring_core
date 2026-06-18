package org.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public void addEmployee(Employee emp) {
        repo.save(emp);
    }

    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    public void updateEmployeeSalary(int id, double salary) {
        repo.updateSalary(id, salary);
    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}
