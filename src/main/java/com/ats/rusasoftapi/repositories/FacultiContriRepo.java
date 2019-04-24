package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.FacultiContributionList;

public interface FacultiContriRepo extends JpaRepository<FacultiContributionList, Integer> {

	@Query(value="SELECT c.con_id, c.faculty_id, c.year_id, c.con_level, c.con_name, c.con_university, c.con_from,c.con_to,c.con_exam_setting, c.con_as_evaluation, c.con_as_moderation, c.del_status, c.is_active, c.maker_user_id, c.maker_enter_datetime, c.maker_enter_datetime, f.faculty_first_name, d.dept_name FROM t_faculty_contribution c, m_faculty f, m_dept d WHERE c.del_status=1 AND c.is_active=1 AND c.faculty_id=f.faculty_id AND f.dept_id=d.dept_id AND c.year_id=:yearId AND f.institute_id=:instituteId ORDER BY c.con_id DESC",nativeQuery=true)
	List<FacultiContributionList> getJouByYear(@Param("yearId") int yearId, @Param("instituteId") int instituteId);

	@Query(value="SELECT c.con_id, c.faculty_id, c.year_id, c.con_level, c.con_name, c.con_university, c.con_from,c.con_to,c.con_exam_setting, c.con_as_evaluation, c.con_as_moderation, c.del_status, c.is_active, c.maker_user_id, c.maker_enter_datetime, c.maker_enter_datetime, f.faculty_first_name, d.dept_name FROM t_faculty_contribution c, m_faculty f, m_dept d WHERE c.del_status=1 AND c.is_active=1 AND c.faculty_id=f.faculty_id AND f.dept_id=d.dept_id AND c.year_id=:yearId AND f.institute_id=:instituteId AND d.dept_id IN(:deptIdList) ORDER BY c.con_id DESC ",nativeQuery=true)
	List<FacultiContributionList> getJournalByDept(@Param("deptIdList") List<Integer> deptIdList, @Param("yearId") int yearId, @Param("instituteId") int instituteId);

	@Query(value="SELECT c.con_id, c.faculty_id, c.year_id, c.con_level, c.con_name, c.con_university, c.con_from,c.con_to,c.con_exam_setting, c.con_as_evaluation, c.con_as_moderation, c.del_status, c.is_active, c.maker_user_id, c.maker_enter_datetime, c.maker_enter_datetime, f.faculty_first_name, d.dept_name FROM t_faculty_contribution c, m_faculty f, m_dept d WHERE c.del_status=1 AND c.is_active=1 AND c.faculty_id=f.faculty_id AND f.dept_id=d.dept_id AND c.year_id=:yearId AND f.institute_id=:instituteId AND c.faculty_id=:facultyId  ORDER BY c.con_id DESC",nativeQuery=true)
	List<FacultiContributionList> getJournalRepo(@Param("facultyId") int facultyId, @Param("yearId") int yearId, @Param("instituteId") int instituteId);

}
