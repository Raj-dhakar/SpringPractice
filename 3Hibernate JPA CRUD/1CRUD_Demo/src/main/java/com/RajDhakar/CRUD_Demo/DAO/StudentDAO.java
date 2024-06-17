package com.RajDhakar.CRUD_Demo.DAO;

import com.RajDhakar.CRUD_Demo.Entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> lastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
