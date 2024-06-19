package com.RajDhakar.CRUD_Demo;

import com.RajDhakar.CRUD_Demo.DAO.AppDAO;
import com.RajDhakar.CRUD_Demo.entity.Instructor;
import com.RajDhakar.CRUD_Demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			createInstructor(appDAO);
//			findInstructor(appDAO);
//			removeInstructor(appDAO);
		};
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
