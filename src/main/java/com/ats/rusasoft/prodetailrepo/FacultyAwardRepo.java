package com.ats.rusasoft.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.FacultyAward;

public interface FacultyAwardRepo extends JpaRepository<FacultyAward, Integer>{

	List<FacultyAward> findByDelStatusAndIsActive(int i, int j);

	FacultyAward findByAwardIdAndDelStatus(int patentId, int i);

}
