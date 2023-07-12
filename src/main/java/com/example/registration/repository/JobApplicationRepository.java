package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.entity.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer>{

}
