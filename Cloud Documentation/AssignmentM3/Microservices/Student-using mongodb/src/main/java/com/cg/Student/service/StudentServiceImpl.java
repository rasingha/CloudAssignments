package com.cg.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Student.dao.StudentDAO;
import com.cg.Student.entity.Studentapp;

@Service
public class StudentServiceImpl implements StudentService{
	

	@Autowired
	private StudentDAO StudentDao;

	public List<Studentapp> getAllStudents() {
		return StudentDao.getAllStudents();
	}
	
	@Override
	public Studentapp getStudentById(String studentId) {

		return StudentDao.getStudentById(studentId);
	}

	@Override
	public Studentapp addNewStudent(Studentapp student) {

		return StudentDao.addNewStudent(student);
	}
	
	@Override
	public Studentapp deleteStudent(String studentId) {

		return StudentDao.deleteStudent(studentId);
	}

}
