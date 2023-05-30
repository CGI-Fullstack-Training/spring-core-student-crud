package com.example;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.SpringConfig;
import com.example.model.Student;
import com.example.service.StudentService;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		StudentService studentService = context.getBean("studentService", StudentService.class);
		int option ;
		do {
		System.out.println("Choose your choice...");
		System.out.println("1: add student");
		System.out.println("2: display all students");
		System.out.println("3: find student by id");
		System.out.println("4: find student by name");
		System.out.println("5: update student by id");
		System.out.println("6: update student by name");
		System.out.println("7: find student by date");
		System.out.println("8: delete student by id");
		System.out.println("9: delete all student");
		option=scanner.nextInt();
		
			switch (option) {
			case 1:
				add_student(studentService);
				break;
			case 2:
				studentService.displayAllStudent();
				break;
			case 3:
				findStudentbyId(studentService);
				break;
			case 4:
				findStudentByName(studentService);
				break;
			case 5:
				updateStudentById(studentService);
				break;
			case 6:
				updateStudentByName(studentService);
				break;
			case 7:
				findStudentByDate(studentService);
				break;
			case 8:
				deleteStudentById(studentService);
				break;
			case 9:
				deleteAllStudent(studentService);
				break;

			}
		} while (option != 0);

	}

	public static void add_student(StudentService studentService) {
		System.out.println("enter name");
		String name = scanner.next();
		System.out.println("enter date");
		String date = scanner.next();
		System.out.println("enter nationality");
		String nationality = scanner.next();
		System.out.println("enter code");
		String code = scanner.next();

		Student student = new Student(name, date, nationality, code);
		studentService.addStudent(student);
	}

	public static void findStudentbyId(StudentService studentService) {
		System.out.println("enter student id");
		Integer id = scanner.nextInt();
		studentService.findStudentById(id);
	}

	public static void findStudentByName(StudentService studentService) {
		System.out.println("enter name");
		String name = scanner.next();
		studentService.findStudentByName(name);
	}

	public static void updateStudentById(StudentService studentService) {
		System.out.println("enter student id");
		Integer id = scanner.nextInt();
		System.out.println("enter name");
		String name = scanner.next();
		System.out.println("enter date");
		String date = scanner.next();
		System.out.println("enter nationality");
		String nationality = scanner.next();
		System.out.println("enter code");
		String code = scanner.next();
		Student student = new Student(name, date, nationality, code);
		studentService.updateStudentById(id, student);
	}

	public static void updateStudentByName(StudentService studentService) {
		System.out.println("enter old name");
		String oldName = scanner.next();
		System.out.println("enter name");
		String name = scanner.next();
		System.out.println("enter date");
		String date = scanner.next();
		System.out.println("enter nationality");
		String nationality = scanner.next();
		System.out.println("enter code");
		String code = scanner.next();
		Student student = new Student(name, date, nationality, code);
		studentService.updateStudentByName(oldName, student);
	}

	public static void findStudentByDate(StudentService studentService) {
		System.out.println("enter date (please enter without any slash or dash and in ddmmyyyy format");
		String date = scanner.next();
		studentService.findStudentByDate(date);
	}

	public static void deleteStudentById(StudentService studentService) {
		System.out.println("enter id");
		Integer id = scanner.nextInt();
		studentService.deleteById(id);
	}

	public static void deleteAllStudent(StudentService studentService) {
		studentService.deleteAll();
	}

}
