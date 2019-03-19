package com.ats.rusasoft.repo.faculty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.faculty.FacultyPhdDetails;

public interface FacultyPhdDetailsRepo extends JpaRepository<FacultyPhdDetails, Integer>{
	
	//List<FacultyPhdDetails> 
	FacultyPhdDetails findByFacultyId(int facultyId);
	
}
