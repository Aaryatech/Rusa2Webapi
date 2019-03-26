package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.StudMentorList;

public interface StuedentMentorListRepo extends JpaRepository<StudMentorList, Integer> {
	
	@Modifying
	@Query(value="SELECT m.men_id, m.men_stu_count, a.academic_year FROM t_faculty_mentoring m, m_academic_year a WHERE m.year_id=a.year_id AND faculty_id=:facId AND m.del_status=1 AND m.year_id=:yearId ORDER BY m.men_id DESC",nativeQuery=true)
	public List<StudMentorList> getListFacultyMonitor(int facId,int yearId);

}
