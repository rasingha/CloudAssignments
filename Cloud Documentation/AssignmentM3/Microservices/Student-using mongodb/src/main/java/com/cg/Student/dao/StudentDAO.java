package com.cg.Student.dao;

import java.util.List;

import com.cg.Student.entity.Studentapp;

public interface StudentDAO {

	List<Studentapp> getAllStudents();

	Studentapp getStudentById(String studentId);

	Studentapp addNewStudent(Studentapp student);

	Studentapp deleteStudent(String studentId);

	}
