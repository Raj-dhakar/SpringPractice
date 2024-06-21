package com.RajDhakar.REST_API_CRUD_PROJECT.DAO;

import com.RajDhakar.REST_API_CRUD_PROJECT.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{


    // define field of entity Manager

    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);

        // execute a query
        List<Employee> employees=theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findByID(int theId) {

        // get employee
        Employee dbEmployee=entityManager.find(Employee.class,theId);

        // return employee
        return dbEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee
        Employee dbEmployee=entityManager.merge(theEmployee);

        // return employee
        return dbEmployee;
    }

    @Override
    public void remove(int theId) {

        // find employee by Id
        Employee theEmployee=entityManager.find(Employee.class,theId);

        // return employee
        entityManager.remove(theEmployee);
    }
}
