package com.RajDhakar.REST_API_CRUD_PROJECT.REST;

import com.RajDhakar.REST_API_CRUD_PROJECT.DAO.EmployeeDAO;
import com.RajDhakar.REST_API_CRUD_PROJECT.DAO.EmployeeDAOImpl;
import com.RajDhakar.REST_API_CRUD_PROJECT.Entity.Employee;
import com.RajDhakar.REST_API_CRUD_PROJECT.SERVICE.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // Inject employee DAO (use consructor Injection)

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // expose employees and return a list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee= employeeService.findByID(employeeId);

        if(theEmployee==null){
            throw  new RuntimeException("Employee id not Found - "+employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST employee - add new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON...set id to 0
        // this is to force a save of new item... instead of updating

        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee=employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee=employeeService.findByID(employeeId);

        if(tempEmployee==null) throw new RuntimeException("Employee id not Found- "+employeeId);

        employeeService.remove(employeeId);

        return "Deleted Employee id is -: "+employeeId;
    }
}
