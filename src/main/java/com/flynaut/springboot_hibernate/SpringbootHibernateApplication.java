package com.flynaut.springboot_hibernate;

import com.flynaut.springboot_hibernate.Dao.StudentDao;
import com.flynaut.springboot_hibernate.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {

		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDao);

			// readStudent(studentDAO);

			//	queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			//TASK: write logic to deleteAll students

		};
	}

	private void deleteStudent(StudentDao studentDao) {

		int studentId = 5;
		System.out.println("Deleting student id: " + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Parth"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Pramod");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("yadav");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDAO) {

		// create  a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Gopal", "jain", "gopal@gmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDao studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Prasad", "Jain", "prasadj@gmail.com");
		Student tempStudent2 = new Student("Krishna", "Yadav", "krishnay@gmail.com");
		Student tempStudent3 = new Student("Govind", "Ahire", "govinda@gmail.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDao studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Ramesh", "Modi", "ramesh@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
