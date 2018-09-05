package com.cg.Student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.Student.entity.Studentapp;



@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Studentapp> getAllStudents() {
		return mongoTemplate.findAll(Studentapp.class);
	}
	
	public Studentapp getStudentById(String studentId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("studentId").is(studentId));
		return mongoTemplate.findOne(query, Studentapp.class);
	}

	public Studentapp addNewStudent(Studentapp student) {
		mongoTemplate.save(student);
		// Now, user object will contain the ID as well
		return student;
	}
	
	@Override
	public Studentapp deleteStudent(String studentId) {
		Studentapp studentapp= getStudentById(studentId);
		if(studentapp != null)
		{
			mongoTemplate.remove(studentapp);
		}
		return studentapp;
	}

}
