package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.IqacList;

public interface IqacListRepo extends JpaRepository<IqacList, Integer> {

	//@Modifying
	//@Query(value="SELECT i.faculty_id, i.faculty_first_name, i.joining_date, i.contact_no, i.email, d.designation_name FROM m_faculty i, m_designation d WHERE i.del_status=1 AND i.current_designation_id=d.designation_id AND i.institute_id=:instituteId AND i.is_iqac=1 ORDER BY i.faculty_id DESC ",nativeQuery=true)
	//List<IqacList> findByIsActiveAndDelStatus(int instituteId);

	@Query(value="SELECT i.faculty_id, i.faculty_first_name, i.joining_date, i.contact_no, i.email, d.designation_name FROM m_faculty i, m_designation d WHERE i.del_status=1 AND i.current_designation_id=d.designation_id AND i.institute_id=:instituteId AND i.is_iqac=1 AND i.is_blocked=0 ORDER BY i.faculty_id DESC ",nativeQuery=true)
	List<IqacList> findIqacByInstId(@Param("instituteId")int instituteId);
}
