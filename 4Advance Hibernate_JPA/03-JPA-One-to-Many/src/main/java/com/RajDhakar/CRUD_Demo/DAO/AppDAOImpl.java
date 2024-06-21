package com.RajDhakar.CRUD_Demo.DAO;

import com.RajDhakar.CRUD_Demo.entity.Course;
import com.RajDhakar.CRUD_Demo.entity.Instructor;
import com.RajDhakar.CRUD_Demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Course> findCourseByInstructorId(int theId) {

        TypedQuery<Course> query=entityManager.createQuery(
                "form Course where instructor.id=:data", Course.class
        );

        query.setParameter("data",theId);

        List<Course> courses=query.getResultList();

        return courses;
    }
}
