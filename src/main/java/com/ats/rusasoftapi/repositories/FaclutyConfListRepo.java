package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.FacultyConferenceList;

public interface FaclutyConfListRepo extends JpaRepository<FacultyConferenceList, Integer> {
	@Query(value="SELECT c.conf_id, c.conf_name, c.year_id, c.faculty_id, c.conf_name, c.conf_type, c.conf_date, c.conf_venue, c.conf_fund_from, c.conf_fund_amt, c.del_status, c.is_active, c.maker_user_id, c.maker_enter_datetime, c.ex_int1, c.ex_var1 ,f.faculty_first_name, d.dept_name FROM t_faculty_conference c, m_faculty f, m_dept d WHERE c.del_status=1 AND c.year_id=:yearId AND f.dept_id=d.dept_id AND c.faculty_id=f.faculty_id AND f.institute_id=:instituteId Order By conf_id Desc",nativeQuery=true)
	List<FacultyConferenceList> getJouByYear(@Param("yearId") int yearId, @Param("instituteId") int instituteId);

	@Query(value="SELECT c.conf_id, c.conf_name, c.year_id, c.faculty_id, c.conf_name, c.conf_type, c.conf_date, c.conf_venue, c.conf_fund_from, c.conf_fund_amt, c.del_status, c.is_active, c.maker_user_id, c.maker_enter_datetime, c.ex_int1, c.ex_var1 ,f.faculty_first_name, d.dept_name FROM t_faculty_conference c, m_faculty f, m_dept d WHERE c.del_status=1 AND d.dept_id IN(:deptIdList) AND f.dept_id=d.dept_id AND  c.faculty_id=f.faculty_id AND c.year_id=:yearId AND f.institute_id=:instituteId Order By conf_id Desc",nativeQuery=true)
	public List<FacultyConferenceList> getJournalByDept(@Param("deptIdList") List<Integer> deptIdList, @Param("yearId") int yearId, @Param("instituteId") int instituteId);

	@Query(value="SELECT c.conf_id, c.conf_name, c.year_id, c.faculty_id, c.conf_name, c.conf_type, c.conf_date, c.conf_venue, c.conf_fund_from, c.conf_fund_amt, c.del_status, c.is_active, c.maker_user_id, c.maker_enter_datetime, c.ex_int1, c.ex_var1 ,f.faculty_first_name, d.dept_name FROM t_faculty_conference c, m_faculty f, m_dept d WHERE c.del_status=1 AND c.year_id=:yearId AND f.dept_id=d.dept_id AND c.faculty_id=:facultyId AND c.faculty_id=f.faculty_id AND f.institute_id=:instituteId  Order By conf_id Desc",nativeQuery=true)
	public List<FacultyConferenceList> getJournalRepo(@Param("facultyId")int facultyId, @Param("yearId") int yearId, @Param("instituteId") int instituteId);	

}
