package com.cg.Student.service;

import java.util.List;

import com.cg.Student.entity.Studentapp;

public interface StudentService {

	List<Studentapp> getAllStudents();

	Studentapp getStudentById(String studentId);

	Studentapp addNewStudent(Studentapp student);

	Studentapp deleteStudent(String studentId);

}
