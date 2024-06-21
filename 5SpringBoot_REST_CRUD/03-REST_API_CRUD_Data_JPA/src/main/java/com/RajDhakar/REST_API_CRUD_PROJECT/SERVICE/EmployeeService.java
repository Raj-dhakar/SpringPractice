package com.RajDhakar.REST_API_CRUD_PROJECT.SERVICE;

import com.RajDhakar.REST_API_CRUD_PROJECT.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findByID(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
