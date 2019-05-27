package com.ats.rusasoftapi.repo.faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.FacultyPersonalDetail;

public interface FacultyPersonalDetailRepo extends JpaRepository<FacultyPersonalDetail, Integer> {
	
	FacultyPersonalDetail findByFacultyId(int facultyId);
}
