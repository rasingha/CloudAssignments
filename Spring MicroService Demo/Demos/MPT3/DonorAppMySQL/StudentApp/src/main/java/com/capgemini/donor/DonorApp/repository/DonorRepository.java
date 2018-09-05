package com.capgemini.donor.DonorApp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.donor.DonorApp.entity.DonorBean;



public interface DonorRepository extends JpaRepository<DonorBean, Integer> {

}
