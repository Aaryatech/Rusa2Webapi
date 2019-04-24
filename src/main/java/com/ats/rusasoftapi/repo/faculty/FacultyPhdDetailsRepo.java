package com.ats.rusasoftapi.repo.faculty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.faculty.FacultyPhdDetails;

public interface FacultyPhdDetailsRepo extends JpaRepository<FacultyPhdDetails, Integer>{
	
	//List<FacultyPhdDetails> 
	FacultyPhdDetails findByFacultyId(int facultyId);
	
}
