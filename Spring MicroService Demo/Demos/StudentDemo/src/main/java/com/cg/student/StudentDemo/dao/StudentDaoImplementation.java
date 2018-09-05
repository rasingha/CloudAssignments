package com.cg.student.StudentDemo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.student.StudentDemo.bean.Student;


@Repository
public class StudentDaoImplementation implements IStudentdao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Student addnewstudents(Student st) {
			
		mongoTemplate.save(st);
		// Now, user object will contain the ID as well
		return st;
	}

	@Override
	public List<Student> getallstudents(){
		
		return mongoTemplate.findAll(Student.class);		
		
	}

	@Override
	public Student rollgetStudent(String rollno) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("rollno").is(rollno));
		return mongoTemplate.findOne(query, Student.class);
		
	}
	


}
