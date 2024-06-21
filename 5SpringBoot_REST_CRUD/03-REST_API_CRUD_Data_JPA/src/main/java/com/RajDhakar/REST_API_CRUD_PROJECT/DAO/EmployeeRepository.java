package com.RajDhakar.REST_API_CRUD_PROJECT.DAO;

import com.RajDhakar.REST_API_CRUD_PROJECT.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    // that's it no need to write any code
}
