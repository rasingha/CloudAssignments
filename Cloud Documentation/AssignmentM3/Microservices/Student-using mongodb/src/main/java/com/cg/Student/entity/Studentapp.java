package com.cg.Student.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Studentapp {
	
	@Id
	private String studentId;
	
	@NotNull
	@Size(min=3, message="Name should have atleast 2 characters")
	private String name;
	
	@NotNull
	@Size(min=1, message="age should be atleast 10")
	private String age;
	@NotNull
	private String city;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
