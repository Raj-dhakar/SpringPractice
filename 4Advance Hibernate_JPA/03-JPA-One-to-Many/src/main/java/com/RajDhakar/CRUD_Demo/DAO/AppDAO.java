package com.RajDhakar.CRUD_Demo.DAO;

import com.RajDhakar.CRUD_Demo.entity.Course;
import com.RajDhakar.CRUD_Demo.entity.Instructor;
import com.RajDhakar.CRUD_Demo.entity.InstructorDetail;
import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theid);

    void deleteOnlyInstructorDetailById(int theid);

    List<Course> findCourseByInstructorId(int theId);
}
