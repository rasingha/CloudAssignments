package com.cg.student.StudentDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.student.StudentDemo.bean.Student;
import com.cg.student.StudentDemo.dao.IStudentdao;



@Service
public class StudentServiceImpl implements Istudentservice {
	
	@Autowired
	private IStudentdao studentDao;

	public Student add_new_student(Student st){

		return studentDao.addnewstudents(st);
	
	}

	@Override
	public List<Student> getallstudents(){
		
		return studentDao.getallstudents();
		
	}
	
	public Student rollgetStudent(String rollno) {
		
		return studentDao.rollgetStudent(rollno);
		
	}
	

	
}
