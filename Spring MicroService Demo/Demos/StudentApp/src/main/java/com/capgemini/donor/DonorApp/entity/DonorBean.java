package com.capgemini.donor.DonorApp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
public class DonorBean {
	
	@Id
	@GeneratedValue
	private int donorId;
	@NotNull
	@Size(min=2, message="Name should have atleast 2 characters")
	private String donorName;
	
	@NotNull
	@Size(min=10, message="Number must have 10 digits")
	@Pattern(regexp = "[1-9] {1}[0-9]{9}")
	private String phoneNumber;
	private String address;
	private double donationAmount;
	private Date donationDate;
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}
	public Date getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Donor Details \n");
		sb.append("Donor Name: " +donorName +"\n");
		sb.append("Donor Address: "+ address +"\n");
		sb.append("Phone Number: "+ phoneNumber +"\n");
		sb.append("Donation Amount: "+ donationAmount +"\n");
		sb.append("Donation Date: "+ donationDate);
		return sb.toString();
	}
	
}
