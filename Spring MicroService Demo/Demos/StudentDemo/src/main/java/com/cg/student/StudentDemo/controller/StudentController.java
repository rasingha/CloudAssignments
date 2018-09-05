package com.cg.student.StudentDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.student.StudentDemo.bean.Student;
import com.cg.student.StudentDemo.exception.UserNotFoundException;
import com.cg.student.StudentDemo.service.Istudentservice;




@RestController
@RequestMapping(value = "/api")
public class StudentController {


	@Autowired
	private  Istudentservice studentService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Student add_new_student(@Valid @RequestBody Student student) {
		return studentService.add_new_student(student);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Student> getallstudents() {
		/*LOG.info("Getting all users.");*/
		return studentService.getallstudents();
	}

	@RequestMapping(value = "/{rollno}", method = RequestMethod.GET)
	public Student getUser(@PathVariable String rollno) {
		/*LOG.info("Getting user with ID: {}.", userId);*/
	    Student  stu = studentService.rollgetStudent(rollno);
	    if( stu == null)
	    {
	    	throw new UserNotFoundException(" Student Not Found ");
	    }
	    
	    return stu;
	}

	

	
}