package com.RajDhakar.REST_API_CRUD_PROJECT.SERVICE;

import com.RajDhakar.REST_API_CRUD_PROJECT.DAO.EmployeeDAO;
import com.RajDhakar.REST_API_CRUD_PROJECT.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findByID(int theId);

    Employee save(Employee theEmployee);

    void remove(int theId);
}
