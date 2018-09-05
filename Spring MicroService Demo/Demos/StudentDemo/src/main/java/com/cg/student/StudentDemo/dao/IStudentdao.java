package com.cg.student.StudentDemo.dao;

import java.util.List;

import com.cg.student.StudentDemo.bean.Student;


public interface IStudentdao {
	public Student addnewstudents(Student st);
	public List<Student> getallstudents();
	public Student rollgetStudent(String rollno);
}
