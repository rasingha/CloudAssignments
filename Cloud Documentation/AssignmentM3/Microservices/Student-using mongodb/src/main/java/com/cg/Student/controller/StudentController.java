package com.cg.Student.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Student.entity.Studentapp;
import com.cg.Student.exception.StudentnotfoundException;
import com.cg.Student.service.StudentService;

@RestController
@RequestMapping(value = "/")
public class StudentController {
	
private final Logger LOG = LoggerFactory.getLogger(getClass());

	
	@Autowired
	private  StudentService studentService;

	

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Studentapp addNewStudent(@Valid @RequestBody Studentapp student) {
		LOG.info("Saving the Student Details .");
		return studentService.addNewStudent(student);
	}
	
	@RequestMapping(value = "/{studentId}", method = RequestMethod.DELETE)
	public Studentapp deleteStudent(@PathVariable String studentId) {
		LOG.info("Deleting selected student.");
		return studentService.deleteStudent(studentId);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Studentapp> getAllStudents() {
		LOG.info("Getting all the students.");
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public Studentapp getStudentById(@PathVariable String studentId) {
		LOG.info("Getting Student with ID: {}.", studentId);
		Studentapp  student = studentService.getStudentById(studentId);
	    if( student == null)
	    {
	    	throw new StudentnotfoundException(" Student not Found ");
	    }
	    
	    return student;
	}
	




}
