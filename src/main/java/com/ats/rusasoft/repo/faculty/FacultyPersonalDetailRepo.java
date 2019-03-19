package com.ats.rusasoft.repo.faculty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.faculty.FacultyPersonalDetail;

public interface FacultyPersonalDetailRepo extends JpaRepository<FacultyPersonalDetail, Integer> {
	
	FacultyPersonalDetail findByFacultyId(int facultyId);
}
