package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.StudentDao;
import com.example.model.Student;

@Component("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);

	}

	@Override
	public List<Student> displayAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.displayAllStudent();
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(id);
	}

	@Override
	public Student findStudentByName(String name) {
		// TODO Auto-generated method stub
		return studentDao.findStudentByName(name);
	}

	@Override
	public Student findStudentByDate(String date) {
		// TODO Auto-generated method stub
		return studentDao.findStudentByDate(date);
	}

	@Override
	public Student updateStudentById(int id, Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudentById(id, student);
	}

	@Override
	public Student updateStudentByName(String name, Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudentByName(name, student);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentDao.deleteById(id);

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		studentDao.deleteAll();
	}

}
