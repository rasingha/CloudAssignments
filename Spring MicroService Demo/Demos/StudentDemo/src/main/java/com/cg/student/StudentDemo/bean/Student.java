package com.cg.student.StudentDemo.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	

	@Id
	private String rollno;
	
	@NotNull
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	@NotNull
	@Size(min=10, message="Number must have 10 digits")
	@Pattern(regexp = "^[1-9]{1}[0-9]{9}$")
	private String mobileno;
	
	private String age;
	private String registrationDate;
	private String city;
	private String pincode;
	private String State;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String date1) {
		this.registrationDate = date1;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate registrationDate= LocalDate.parse(date1, dateFormat);
		
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + ", mobileno="
				+ mobileno + ", age=" + age + ", registrationDate="
				+ registrationDate + ", city=" + city + ", pincode=" + pincode
				+ ", State=" + State + "]";
	}
	

}
