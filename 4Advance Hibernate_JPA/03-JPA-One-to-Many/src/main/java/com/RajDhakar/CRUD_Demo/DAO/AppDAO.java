package com.RajDhakar.CRUD_Demo.DAO;

import com.RajDhakar.CRUD_Demo.entity.Instructor;
import com.RajDhakar.CRUD_Demo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theid);

    void deleteOnlyInstructorDetailById(int theid);
}
