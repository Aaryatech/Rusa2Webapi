package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.faculty.GetFacultyEmpwrList;

public interface GetFacultyEmpwrListRepo extends JpaRepository<GetFacultyEmpwrList, Integer> {

	@Query(value="SELECT fempwr.faculty_empwrmnt_id," + 
			" fempwr.name_of_acitvity," + 
			" fempwr.title," + 
			" fempwr.amt_recvd_from," + 
			" fempwr.from_date," + 
			" fempwr.to_date," + 
			" fempwr.ex_var1 as amount," + 
			" m_faculty.faculty_first_name as faculty_name," + 
			" m_dept.dept_name as department" + 
			" FROM faculty_empowerment fempwr, m_faculty ,m_dept " + 
			" WHERE fempwr.del_status=1 AND" + 
			" fempwr.ac_year_id=:yearId AND" + 
			" fempwr.inst_id=:instituteId AND" + 
			" fempwr.ex_int1=m_faculty.faculty_id AND" + 
			" m_faculty.dept_id=m_dept.dept_id" + 
			" ORDER BY fempwr.faculty_empwrmnt_id DESC",nativeQuery=true)
	List<GetFacultyEmpwrList> getFacultyEmpwrListByYearAndInstId(int yearId, int instituteId);

	
	@Query(value="SELECT fempwr.faculty_empwrmnt_id," + 
			" fempwr.name_of_acitvity," + 
			" fempwr.title," + 
			" fempwr.amt_recvd_from," + 
			" fempwr.from_date," + 
			" fempwr.to_date," + 
			" fempwr.ex_var1 as amount," + 
			" m_faculty.faculty_first_name as faculty_name," + 
			" m_dept.dept_name as department" + 
			" FROM faculty_empowerment fempwr, m_faculty ,m_dept " + 
			" WHERE fempwr.del_status=1 AND" + 
			" fempwr.ac_year_id=:yearId AND" + 
			" fempwr.inst_id=:instituteId AND" + 
			" fempwr.ex_int1=m_faculty.faculty_id AND" + 
			" d.dept_id IN(:deptIdList) AND" + 
			" m_faculty.dept_id=m_dept.dept_id" + 
			" ORDER BY fempwr.faculty_empwrmnt_id DESC",nativeQuery=true)
	List<GetFacultyEmpwrList> getFacultyEmpwrListByDept(List<Integer> deptIdList, int yearId, int instituteId);


	@Query(value="SELECT fempwr.faculty_empwrmnt_id," + 
			" fempwr.name_of_acitvity," + 
			" fempwr.title," + 
			" fempwr.amt_recvd_from," + 
			" fempwr.from_date," + 
			" fempwr.to_date," + 
			" fempwr.ex_var1 as amount," + 
			" m_faculty.faculty_first_name as faculty_name," + 
			" m_dept.dept_name as department" + 
			" FROM faculty_empowerment fempwr, m_faculty ,m_dept " + 
			" WHERE fempwr.del_status=1 AND" + 
			" fempwr.ac_year_id=:yearId AND" + 
			" fempwr.inst_id=:instituteId AND" + 
			" fempwr.ex_int1=m_faculty.faculty_id AND" + 
			" m_faculty.faculty_id IN(:facultyId) AND" + 
			" m_faculty.dept_id=m_dept.dept_id" + 
			" ORDER BY fempwr.faculty_empwrmnt_id DESC",nativeQuery=true)
	List<GetFacultyEmpwrList> getFacultyEmpowerList(int facultyId, int yearId, int instituteId);

}
