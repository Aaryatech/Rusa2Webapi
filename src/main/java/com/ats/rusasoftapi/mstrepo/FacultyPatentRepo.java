package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.FacultyPatent;

public interface FacultyPatentRepo extends JpaRepository<FacultyPatent, Integer>{

	FacultyPatent findByPatentId(int patentId);
	
	
	FacultyPatent findByPatentIdAndDelStatus(int patentId,int i);


	List<FacultyPatent> findByDelStatusAndIsActive(int i, int j);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_patent SET del_status=0 WHERE patent_id IN (:patentId) ", nativeQuery = true)
	int deletePetent(@Param("patentId") int patentId);

	@Query(value = " SELECT * FROM t_faculty_patent p WHERE p.del_status=1 AND p.faculty_id=:facultyId AND p.is_active=1 ORDER BY p.patent_id DESC ", nativeQuery = true)
	List<FacultyPatent> getPetentRepo(@Param("facultyId") int facultyId);
}
