package com.RajDhakar.CRUD_Demo;

import com.RajDhakar.CRUD_Demo.DAO.AppDAO;
import com.RajDhakar.CRUD_Demo.entity.Course;
import com.RajDhakar.CRUD_Demo.entity.Instructor;
import com.RajDhakar.CRUD_Demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.transform.Source;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			removeInstructor(appDAO);

//			findInstructorDetail(appDAO);

//			deleteInstructorDetail(appDAO);

//			deleteOnlyInstructorDetailById(appDAO);

//			createInstructorWithCourse(appDAO);

//			findInstructorWithCourses(appDAO);

			findCourseForInstructor(appDAO);
		};
	}

	private void findCourseForInstructor(AppDAO appDAO) {

		int theId=1;

		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId=1;

		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourse(AppDAO appDAO) {

		// Create Instructor
		Instructor tempInstructor=new Instructor(
				"Raj","Dhakar","rajdhakar062003@gmail.com"
		);

		// create the instructor details
		InstructorDetail tempInstructorDetails=new InstructorDetail(
				"www.funtodo.com","CP"
		);

		// associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetails);

		// create some courses
		Course temp1=new Course("Air Guitar- the ultimate Guide");
		Course temp2=new Course("The Pinball MasterClass");

		// add courses to instruction
		tempInstructor.add(temp1);
		tempInstructor.add(temp2);

		// save the Instructor
		//
		//Note this will also save the courses
		//because of CascadeType.PERSIST

		System.out.println("Saving Instructor: "+tempInstructor);
		System.out.println("The Courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteOnlyInstructorDetailById(AppDAO appDAO) {

		int theId=6;
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);

		appDAO.deleteOnlyInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId=4;
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail
		int theId=2;
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("Instructor Details : "+tempInstructorDetail);

		//print the associated Instructor
		System.out.println("Associated Instructor : "+tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void removeInstructor(AppDAO appDAO) {

		int theid=1;

		System.out.println("Deleting instructor with the id: "+theid);

		appDAO.deleteInstructorById(theid);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId=2;
		System.out.println("Finding Instructor Id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println("TempInstructor: "+tempInstructor);
		System.out.println("Associated Instructor Details: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor=new Instructor(
				"Raj","Dhakar","rajdhakar062003@gmail.com"
		);

		InstructorDetail tempInstructorDetails=new InstructorDetail(
				"www.funtodo.com","CP"
		);

//		Instructor tempInstructor=new Instructor(
//				"Raj1","Dhakar2","rajdhakar062003@gmail.com"
//		);
//
//		InstructorDetail tempInstructorDetails=new InstructorDetail(
//				"www.funtodo2.com","CP1"
//		);

		tempInstructor.setInstructorDetail(tempInstructorDetails);

		// Now this will save both Instructor
		// and InstructorDetails
		appDAO.save(tempInstructor);
	}
}
