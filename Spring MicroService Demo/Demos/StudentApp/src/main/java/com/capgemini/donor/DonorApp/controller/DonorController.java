
package com.capgemini.donor.DonorApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.donor.DonorApp.entity.DonorBean;
import com.capgemini.donor.DonorApp.exception.UserNotFoundException;
import com.capgemini.donor.DonorApp.service.DonorService;



@RestController
@RequestMapping("/api")
public class DonorController {

	@Autowired
	DonorService donorService;
	
	@GetMapping("/donors")
	public List<DonorBean> getAllDonors() {
		List<DonorBean> list= donorService.getAllDonors();
		if(list.isEmpty()) {
			throw new UserNotFoundException(" No Donors Records Exist!! ");
		}
		return list;
	}
	
	@GetMapping("/donors/{id}")
	public DonorBean getCustomer(@PathVariable int id) {
		
		DonorBean  user = donorService.getDonor(id);
	    if( user == null)
	    {
	    	throw new UserNotFoundException(" User Not Found ");
	    }
	    
	    return user;
	}
	
	@PostMapping("/donors")
	public void createCustomer(@Valid @RequestBody DonorBean donorBean) {
		donorService.save(donorBean);
	}
	
	@PutMapping("/donors")
	public void updateCustomer(@Valid @RequestBody DonorBean donorBean) {
		donorService.update(donorBean);
	}
	
	@DeleteMapping("/donors")
	public void deleteAllCustomer() {
		donorService.deleteAll();
	}
	
	@DeleteMapping("/donors/{id}")
	public void deleteCustomer(@PathVariable int id) {
		donorService.delete(id);
	}
}
