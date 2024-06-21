package com.RajDhakar.REST_Demo.REST;

import com.RajDhakar.REST_Demo.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    // define the @PostConstruct to load the data only once

    @PostConstruct
    public void loadData(){

        theStudent=new ArrayList<>();

        theStudent.add(new Student("Raj1","Dhakar"));
        theStudent.add(new Student("Raj2","Dhakar"));
        theStudent.add(new Student("Raj3","Dhakar"));
    }

    // define endpoint for "/student" return a list of student

    @GetMapping("/students")
    public List<Student> getStudent(){

        return theStudent;
    }

    // define endpoint or "/student/{studentId}" - return student at Index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId>=theStudent.size() || studentId<0)
            throw new StudentNotFoundException("Student id not Found - "+studentId);
        return theStudent.get(studentId);
    }


}
