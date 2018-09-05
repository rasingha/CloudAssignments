package com.capgemini.donor.DonorApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.donor.DonorApp.entity.DonorBean;
import com.capgemini.donor.DonorApp.repository.DonorRepository;



@Service
public class DonorService {

	@Autowired
	DonorRepository donorRepository;

	@Transactional
	public void save(DonorBean donorBean) {

		donorRepository.save(donorBean);
	}

	@Transactional
	public void delete(int id) {
		donorRepository.deleteById(id);
	}
	
	@Transactional
	public void deleteAll() {
		donorRepository.deleteAll();
	}
	
	@Transactional
	public void update(DonorBean donorBean) {
		donorRepository.save(donorBean);
	}
	
	public List<DonorBean> getAllDonors() {
		List<DonorBean> donorBean = new ArrayList<>();
		for (DonorBean donor : donorRepository.findAll()) {
			donorBean.add(donor);
		}
		return donorBean;
	}

	public DonorBean  getDonor(int id) {
		return donorRepository.findById(id).get();
	}
	
}
