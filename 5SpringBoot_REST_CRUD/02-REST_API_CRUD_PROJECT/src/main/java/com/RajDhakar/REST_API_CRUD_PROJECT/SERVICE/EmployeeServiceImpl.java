package com.RajDhakar.REST_API_CRUD_PROJECT.SERVICE;

import com.RajDhakar.REST_API_CRUD_PROJECT.DAO.EmployeeDAO;
import com.RajDhakar.REST_API_CRUD_PROJECT.DAO.EmployeeDAOImpl;
import com.RajDhakar.REST_API_CRUD_PROJECT.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findByID(int theId) {
        return employeeDAO.findByID(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {

        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void remove(int theId) {
        employeeDAO.remove(theId);
    }
}
