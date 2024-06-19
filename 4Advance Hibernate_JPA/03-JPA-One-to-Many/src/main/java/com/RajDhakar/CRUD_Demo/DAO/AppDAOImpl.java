package com.RajDhakar.CRUD_Demo.DAO;

import com.RajDhakar.CRUD_Demo.entity.Instructor;
import com.RajDhakar.CRUD_Demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {

      return   entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        Instructor tempInstructor=entityManager.find(Instructor.class,theId);

        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theid) {

        InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class,theid);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    @Transactional
    public void deleteOnlyInstructorDetailById(int theid) {

        InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class,theid);

        // remove the associated bject reference
        //break bi-directional link

        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }
}
