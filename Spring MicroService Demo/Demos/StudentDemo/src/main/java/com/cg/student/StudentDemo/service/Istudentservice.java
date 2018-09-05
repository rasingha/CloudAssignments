package com.cg.student.StudentDemo.service;

import java.util.List;

import com.cg.student.StudentDemo.bean.Student;




public interface Istudentservice {
	
	
	public Student add_new_student(Student student);
	
	public List<Student> getallstudents();
	
	public Student rollgetStudent(String rollno) ;

	
}
