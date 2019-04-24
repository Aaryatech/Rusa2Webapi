package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.NewDeanList;


public interface NewDeanListRepository extends JpaRepository<NewDeanList, Integer> {

	@Query(value = "  SELECT m_faculty.faculty_id,m_faculty.faculty_first_name,m_faculty.dept_id,m_faculty.highest_qualification,m_faculty.teaching_to,\n"
			+ "m_faculty.current_designation_id,m_faculty.joining_date,m_faculty.realiving_date,m_faculty.contact_no,m_faculty.email,m_faculty.maker_user_id,\n"
			+ "m_dept.dept_name,m_qualificatoin.qualification_name,m_designation.designation_name\n"
			+ "FROM m_faculty,m_designation,m_qualificatoin,m_dept\n"
			+ "WHERE m_faculty.dept_id=m_dept.dept_id AND m_designation.designation_id=m_faculty.current_designation_id AND m_faculty.institute_id=:instituteId AND m_faculty.is_hod=1 "
			+ "AND m_faculty.del_status=1 AND m_faculty.is_active=1 AND m_faculty.is_blocked=0 \n"
			+ "AND m_qualificatoin.qualification_id=m_faculty.highest_qualification ORDER BY m_faculty.faculty_id DESC", nativeQuery = true)
	List<NewDeanList> getNewHodList(@Param("instituteId") int instituteId);

	@Query(value = "  SELECT m_faculty.faculty_id,m_faculty.faculty_first_name,m_faculty.dept_id,m_faculty.highest_qualification,m_faculty.teaching_to,\n"
			+ "m_faculty.current_designation_id,m_faculty.joining_date,m_faculty.realiving_date,m_faculty.contact_no,m_faculty.email,m_faculty.maker_user_id,\n"
			+ "m_dept.dept_name,m_qualificatoin.qualification_name,m_designation.designation_name\n"
			+ "FROM m_faculty,m_designation,m_qualificatoin,m_dept\n"
			+ "WHERE m_faculty.dept_id=m_dept.dept_id AND m_designation.designation_id=m_faculty.current_designation_id AND m_faculty.institute_id=:instituteId AND m_faculty.is_librarian=1 "
			+ "AND m_faculty.del_status=1 AND m_faculty.is_active=1 AND m_faculty.is_blocked=0  \n"
			+ "AND m_qualificatoin.qualification_id=m_faculty.highest_qualification ORDER BY m_faculty.faculty_id DESC", nativeQuery = true)
	List<NewDeanList> getNewLibraryList(@Param("instituteId") int instituteId);

	@Query(value = "  SELECT m_faculty.faculty_id,m_faculty.faculty_first_name,m_faculty.dept_id,m_faculty.highest_qualification,m_faculty.teaching_to,\n"
			+ "m_faculty.current_designation_id,m_faculty.joining_date,m_faculty.realiving_date,m_faculty.contact_no,m_faculty.email,m_faculty.maker_user_id,\n"
			+ "m_dept.dept_name,m_qualificatoin.qualification_name,m_designation.designation_name\n"
			+ "FROM m_faculty,m_designation,m_qualificatoin,m_dept\n"
			+ "WHERE m_faculty.dept_id=m_dept.dept_id AND m_designation.designation_id=m_faculty.current_designation_id AND m_faculty.institute_id=:instituteId AND m_faculty.is_acc_off=1 "
			+ "AND m_faculty.del_status=1 AND m_faculty.is_active=1 AND m_faculty.is_blocked=0 \n"
			+ "AND m_qualificatoin.qualification_id=m_faculty.highest_qualification ORDER BY m_faculty.faculty_id DESC", nativeQuery = true)
	List<NewDeanList> getNewAccOffList(@Param("instituteId") int instituteId);

}
