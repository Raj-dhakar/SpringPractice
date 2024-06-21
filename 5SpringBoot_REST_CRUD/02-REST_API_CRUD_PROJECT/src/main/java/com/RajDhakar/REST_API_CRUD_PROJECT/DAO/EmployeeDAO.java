package com.RajDhakar.REST_API_CRUD_PROJECT.DAO;

import com.RajDhakar.REST_API_CRUD_PROJECT.Entity.Employee;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findByID(int theId);

    Employee save(Employee theEmployee);

    void remove(int theId);
}
