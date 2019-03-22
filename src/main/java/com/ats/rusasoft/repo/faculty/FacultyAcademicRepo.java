package com.ats.rusasoft.repo.faculty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.faculty.FacultyAcademic;

public interface FacultyAcademicRepo extends JpaRepository<FacultyAcademic, Integer> {
	
	FacultyAcademic findByFAcaIdAndDelStatusAndIsActive( int fAcaId, int delStatus, int isActive);
	
	FacultyAcademic findByFacultyIdAndDelStatusAndIsActive(int facultyId, int delStatus, int isActive);
	
}
