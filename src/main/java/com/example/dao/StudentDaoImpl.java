package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(Student student) {

		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Student> displayAllStudent() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		List<Student> student = query.getResultList();
		for (Student s : student) {
			System.out.println(s);
		}
		session.getTransaction().commit();
		return student;
	}

	public Student findStudentById(int id) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = session.find(Student.class, id);
		if (student != null) {
			System.out.println(student);

		} else {
			System.out.println("no such id found!!!");
		}
		session.getTransaction().commit();
		return student;
	}

	@Override
	public Student findStudentByName(String name) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		Student student_obj = null;
		List<Student> student = query.getResultList();
		for (Student s : student) {
			if (s.getName().equals(name)) {
				student_obj = s;
				System.out.println(s);
			} else {
				student_obj = null;
				System.out.println("No such student found");
			}
		}
		session.getTransaction().commit();
		return student_obj;
	}

	@Override
	public Student updateStudentById(int id, Student newStudent) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = findStudentById(id);
		student.setName(newStudent.getName());
		student.setNationality(newStudent.getNationality());
		student.setCode(newStudent.getCode());
		student.setDate(newStudent.getDate());
		session.merge(student);
		System.out.println(student);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Student updateStudentByName(String name, Student newStudent) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = findStudentByName(name);
		student.setName(newStudent.getName());
		student.setNationality(newStudent.getNationality());
		student.setCode(newStudent.getCode());
		student.setDate(newStudent.getDate());
		session.merge(student);
		System.out.println(student);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Student findStudentByDate(String date) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		Student student_obj = null;
		List<Student> student = query.getResultList();
		for (Student s : student) {
			if (s.getDate().equals(date)) {
				student_obj = s;
				System.out.println(s);
			} else {
				student_obj = null;
				System.out.println("No such student found");
			}
		}
		session.getTransaction().commit();
		return student_obj;
	}

	@Override
	public void deleteById(int id) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		List<Student> student = query.getResultList();
		for (Student s : student) {
			System.out.println(id);
			if (s.getId() == id) {
				session.delete(s);
				System.out.println("Record deleted!!!");
				break;
			} else {
				System.out.println("id not found");
			}
		}
		session.getTransaction().commit();

	}

	@Override
	public void deleteAll() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		List<Student> student = query.getResultList();
		for (Student s : student) {

			session.delete(s);
			System.out.println("All Record deleted!!!");
			break;

		}
		session.getTransaction().commit();
	}
}
