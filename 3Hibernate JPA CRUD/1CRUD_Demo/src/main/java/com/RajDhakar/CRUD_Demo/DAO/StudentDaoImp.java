package com.RajDhakar.CRUD_Demo.DAO;

import com.RajDhakar.CRUD_Demo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDAO{

    // define field for entity manager

    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    // Here we dont nedd to add @Transactional as we are just doing querying
    public Student findById(int id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student order by last_name", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> lastName(String theLastName) {
        //create Query
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student WHERE last_name=:theData", Student.class);

        //set query parameter
        theQuery.setParameter("theData",theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional // As we are updating here
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Student tempStudent=entityManager.find(Student.class,id);
        entityManager.remove(tempStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }


}
