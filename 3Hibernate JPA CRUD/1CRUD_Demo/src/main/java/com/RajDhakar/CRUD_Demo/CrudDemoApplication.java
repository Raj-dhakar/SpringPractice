package com.RajDhakar.CRUD_Demo;

import com.RajDhakar.CRUD_Demo.DAO.StudentDAO;
import com.RajDhakar.CRUD_Demo.DAO.StudentDaoImp;
import com.RajDhakar.CRUD_Demo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
//			createStudent(studentDAO);

//			createMultipeStudent(studentDAO);

//			readStudent(studentDAO);

//			queryForStudent(studentDAO);

//			queryForStudentByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

			deleteAllStudent(studentDAO);
		};
	}



	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating be new Student Object");
		Student tempStudent=new Student("Raj","Dhakar","rajdhakar062003@gmail.com");

		//save the student object
		System.out.println("Saving the Object");
		studentDAO.save(tempStudent);

		//display id of the saved object
		System.out.println("Saved Student . Generated id "+tempStudent.getId());
	}

	public void createMultipeStudent(StudentDAO studentDAO){

		// create the student object
		System.out.println("Creating be new Student Object");
		Student tempStudent1=new Student("Raj1","Dhakar","raj1dhakar062003@gmail.com");

		Student tempStudent2=new Student("Raj2","Dhakar","raj2dhakar062003@gmail.com");
		Student tempStudent3=new Student("Raj3","Dhakar","raj3dhakar062003@gmail.com");

		//save the student object
		System.out.println("Saving the Object");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating the object");
		Student tempStudent=new Student("Raj4","Dhakar","rajdhakar@gmail.com");

		//save the object
		studentDAO.save(tempStudent);
		System.out.println("Saved Object");

		//display id of the saved object
		System.out.println("Generated id of the Saved object : "+tempStudent.getId());

		//retrieve student on the based of the id : primary key
		Student get=studentDAO.findById(tempStudent.getId());
		System.out.println(get.toString());
	}

	private void queryForStudent(StudentDAO studentDAO) {

		//get a list of student
		List<Student> theStudent=studentDAO.findAll();

		// display the list of student
		for(Student student:theStudent) System.out.println(student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		List<Student> theStudent=studentDAO.lastName("Mehta");

		for(Student student:theStudent) System.out.println(student);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id
		int StudentId=1;
		Student tempStudent=studentDAO.findById(StudentId);

		//chanage first name to Scooby
		tempStudent.setFirst_name("Scooby");

		//update the student
		studentDAO.update(tempStudent);

		//display the updated student
		System.out.println(tempStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=1;

		studentDAO.delete(studentId);
	}

	public void deleteAllStudent(StudentDAO studentDAO){

		int numberOfStudentDeleted=studentDAO.deleteAll();

		System.out.println(numberOfStudentDeleted);
	}


}
