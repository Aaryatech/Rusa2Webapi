package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.FacultyOutreach;

public interface FacultyOutreachRepo extends JpaRepository<FacultyOutreach, Integer> {

	List<FacultyOutreach> findByDelStatusAndIsActive(int i, int j);

	FacultyOutreach findByOutreachIdAndDelStatus(int outreachId, int i);

}
