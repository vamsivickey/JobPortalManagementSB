package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.entity.JobPost;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Integer>{

	
	
	
}
