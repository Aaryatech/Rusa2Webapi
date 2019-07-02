package com.ats.rusasoftapi.graphrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.GetCountsForDash;

public interface DashBoardCountsRepo extends JpaRepository<GetCountsForDash, Integer> {

	// For princi Dash

	// 1
	@Query(value = "SELECT  UUID() AS id, \n"
			+ "    COUNT(m_faculty.faculty_id) as count,0 as count1 ,0 as data1,0 as data2 \n" + "FROM\n"
			+ "    m_faculty\n" + "WHERE\n"
			+ "    m_faculty.institute_id =:instId AND m_faculty.del_status = 1 AND m_faculty.is_active = 1 AND m_faculty.is_blocked=0 AND m_faculty.is_faculty=1 ", nativeQuery = true)
	GetCountsForDash getNoOfFacultiesForPrinci(@Param("instId") int instId);

	// 2
	@Query(value = "SELECT  UUID() AS id, \n"
			+ "    COUNT(m_faculty.faculty_id) as count,0 as count1, 0 as data1,0 as data2 \n" + "FROM\n"
			+ "    m_faculty\n" + "WHERE\n"
			+ "    m_faculty.institute_id =:instId AND m_faculty.del_status = 1 AND m_faculty.is_active = 1 AND m_faculty.is_blocked=0 AND m_faculty.is_faculty=1 AND m_faculty.highest_qualification=1 ", nativeQuery = true)
	GetCountsForDash getNoOfFacultiesPHDForPrinci(@Param("instId") int instId);

	// 3
	@Query(value = "SELECT  UUID() AS id, \n"
			+ "    COUNT(t_program_student_location.female_student) as count,COUNT(t_program_student_location.male_student) as count1,0 as data1,0 as data2 \n"
			+ "FROM\n" + "    t_program_student_location\n" + "WHERE\n"
			+ "    t_program_student_location.institute_id =:instId AND t_program_student_location.del_status = 1 AND t_program_student_location.is_active = 1 AND t_program_student_location.year_id=(SELECT m_academic_year.year_id FROM m_academic_year WHERE m_academic_year.is_current=1) ", nativeQuery = true)
	GetCountsForDash getNoOfStudentForPrinci(@Param("instId") int instId);

	// 4
	@Query(value = "SELECT  UUID() AS id, \n"
			+ "  COUNT( t_program.program_id) as count,0 as count1,0 as data1,0 as data2 \n" + "FROM\n"
			+ "    t_program\n" + "WHERE\n"
			+ "    t_program.institute_id =:instId AND t_program.del_status = 1 AND t_program.is_active = 1\n"
			+ " ", nativeQuery = true)
	GetCountsForDash getNoOfProgramForPrinci(@Param("instId") int instId);

	// 5
	@Query(value = "SELECT\n" + "    UUID() AS id,(\n" + "        t_academic_budget.budget_allocated\n"
			+ "    ) AS count,\n" + "    0 AS count1, 0 as data1,0 as data2 \n" + "FROM\n" + "    t_academic_budget\n"
			+ "WHERE\n"
			+ "    t_academic_budget.institute_id =:instId AND t_academic_budget.del_status = 1 AND t_academic_budget.is_active = 1 AND t_academic_budget.fin_year_id =(\n"
			+ "    SELECT\n" + "        m_financial_year.fin_year_id\n" + "    FROM\n" + "        m_financial_year\n"
			+ "    WHERE\n" + "        m_financial_year.is_current_fy = 1)\n" + "\n" + " ", nativeQuery = true)
	GetCountsForDash getNoOfBudgetForPrinci(@Param("instId") int instId);
	// 6

	@Query(value = "SELECT\n" + "    UUID() AS id, COUNT(t_faculty_book.book_id) AS count,\n"
			+ "    0 AS count1,0 as data1,0 as data2 \n" + "FROM\n" + "    t_faculty_book,\n" + "    m_faculty\n"
			+ "WHERE\n"
			+ "    t_faculty_book.faculty_id = m_faculty.faculty_id AND t_faculty_book.del_status = 1 AND t_faculty_book.is_active = 1 AND m_faculty.institute_id =:instId AND t_faculty_book.year_id =(\n"
			+ "    SELECT\n" + "        m_academic_year.year_id\n" + "    FROM\n" + "        m_academic_year\n"
			+ "    WHERE\n" + "        m_academic_year.is_current = 1\n" + ") ", nativeQuery = true)
	GetCountsForDash getNoOfBookPubForPrinci(@Param("instId") int instId);

	// 7

	@Query(value = "SELECT\n" + "    UUID() AS id, COUNT(t_faculty_conference.conf_id) AS count,\n"
			+ "    0 AS count1,0 as data1,0 as data2 \n" + "FROM\n" + "    t_faculty_conference,\n" + "    m_faculty\n"
			+ "WHERE\n"
			+ "    t_faculty_conference.faculty_id = m_faculty.faculty_id AND t_faculty_conference.del_status = 1 AND t_faculty_conference.is_active = 1 AND m_faculty.institute_id =:instId AND t_faculty_conference.year_id =(\n"
			+ "    SELECT\n" + "        m_academic_year.year_id\n" + "    FROM\n" + "        m_academic_year\n"
			+ "    WHERE\n" + "        m_academic_year.is_current = 1\n" + ")", nativeQuery = true)
	GetCountsForDash getNoOfResearchPubForPrinci(@Param("instId") int instId);

	// for hod
	// 1
	@Query(value = "SELECT\n" + "  UUID() AS id,   COUNT(m_faculty.faculty_id) AS count,\n" + "    0 AS count1,\n"
			+ "    0 AS data1,\n" + "    0 AS data2\n" + "FROM\n" + "    m_faculty\n" + "WHERE\n"
			+ "    m_faculty.del_status = 1 AND m_faculty.is_active = 1 AND m_faculty.is_faculty = 1 AND m_faculty.is_blocked = 0 AND m_faculty.institute_id =:instId AND m_faculty.dept_id =:deptId ", nativeQuery = true)
	GetCountsForDash getNoOfFacultiesForHod(@Param("instId") int instId, @Param("deptId") int deptId);

	// 2

	@Query(value = "SELECT UUID() AS id,\n" + 
			"    SUM(\n" + 
			"        t_program_student_location.loc_tot_student\n" + 
			"    ) AS count,0 as count1,0 as data1,0 as data2\n" + 
			"FROM\n" + 
			"    t_program_student_location,\n" + 
			"    t_program,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    t_program_student_location.program_id = t_program.program_id AND t_program.maker_user_id =:facultyId AND t_program_student_location.year_id = m_academic_year.year_id AND t_program.institute_id = m_institute.institute_id AND m_academic_year.is_current = 1 AND m_institute.institute_id =:instId AND t_program_student_location.del_status = 1 AND t_program_student_location.is_active = 1 AND t_program.del_status = 1 AND t_program.is_active = 1\n" + 
			"GROUP BY\n" + 
			"    t_program.maker_user_id", nativeQuery = true)
	GetCountsForDash getNoOfStudentsForHod(@Param("instId") int instId, @Param("facultyId") int facultyId);

	// 3

	@Query(value = "SELECT\n" + "  UUID() AS id,   COUNT(t_program.program_id) AS count,\n" + "    0 AS count1,\n"
			+ "    0 AS data1,\n" + "    0 AS data2\n" + "FROM\n" + "    t_program\n" + "WHERE\n"
			+ "    t_program.del_status = 1 AND t_program.is_active = 1 AND t_program.maker_user_id =:facultyId AND t_program.institute_id =:instId\n"
			+ "", nativeQuery = true)
	GetCountsForDash getNoOfProgramForHod(@Param("instId") int instId, @Param("facultyId") int facultyId);

	
	//for Librarian
	
	// 1
		@Query(value = "SELECT\n" + 
				"    UUID() AS id, m_library_info.soft_name AS data1, m_library_info.users_of_lms AS data2, m_library_info.avg_teacher AS count, m_library_info.avg_student AS count1\n" + 
				"FROM\n" + 
				"    m_library_info\n" + 
				"WHERE\n" + 
				"    m_library_info.institute_id =:instId AND m_library_info.del_status = 1 AND m_library_info.ac_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_academic_year.year_id\n" + 
				"    FROM\n" + 
				"        m_academic_year\n" + 
				"    WHERE\n" + 
				"        m_academic_year.is_current = 1\n" + 
				") ORDER BY m_library_info.lib_info_id  DESC LIMIT 1", nativeQuery = true)
		GetCountsForDash getCountsForLibrarian(@Param("instId") int instId);

		// 2
		@Query(value = "SELECT\n" + 
				"    UUID() AS id, 0 AS data1, 0 AS data2, m_library_info.ex_int1 AS count,0 AS count1\n" + 
				"FROM\n" + 
				"    m_library_info\n" + 
				"WHERE\n" + 
				"    m_library_info.institute_id =:instId AND m_library_info.del_status = 1 AND m_library_info.ac_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_academic_year.year_id\n" + 
				"    FROM\n" + 
				"        m_academic_year\n" + 
				"    WHERE\n" + 
				"        m_academic_year.is_current = 1\n" + 
				") ORDER BY m_library_info.lib_info_id  DESC LIMIT 1\n" + 
				" ", nativeQuery = true)
		GetCountsForDash getCountsForLibrarian1(@Param("instId") int instId);
		
		
		
		
		
		
	
	//****************************Mahendra************************************************
		//For Total Student Passed And Student Appeared for Subject Taughted By Facilty
		
		//Research Project Title
		@Query(value="SELECT UUID() AS id," + 
				"	0 as count," + 
				"   0 as count1," + 
				"	t_faculty_project.proj_name as data1," + 
				"	0 as data2 " + 
				"FROM " + 
				"	t_faculty_project, m_academic_year, m_faculty " + 
				"WHERE" + 
				"	t_faculty_project.faculty_id=m_faculty.faculty_id AND " + 
				"	t_faculty_project.year_id=m_academic_year.year_id AND" + 
				"   t_faculty_project.del_status=1 AND" + 
				"   m_academic_year.is_current=1 AND" + 
				"   m_faculty.institute_id=:instId" + 
				"	ORDER BY t_faculty_project.proj_id LIMIT 1", nativeQuery=true)
		GetCountsForDash getCurrentResrchProjrectTitle(@Param("instId") int instId);

		
		//No. of Research Publication
		@Query(value="SELECT UUID() AS id, COUNT(t_faculty_conference.conf_id) as count," + 
				"	 0 as count1 ," + 
				"    0 as data1," + 
				"    0 as data2 " + 
				"FROM" + 
				"	 t_faculty_conference," + 
				"    m_academic_year," + 
				"    m_faculty " + 
				"WHERE"+
				"	  t_faculty_conference.faculty_id=m_faculty.faculty_id AND" + 
				"	  t_faculty_conference.year_id=m_academic_year.year_id AND" + 
				"     t_faculty_conference.del_status=1 AND" + 
				"     m_academic_year.is_current=1 AND" + 
				"     m_faculty.institute_id=:instId " + 
				"     ORDER BY t_faculty_conference.conf_id LIMIT 1",nativeQuery=true)
		GetCountsForDash getNoResrchPubDetail(@Param("instId") int instId);


		//No. of Research Publication
		
		@Query(value="SELECT UUID() AS id, " + 
				"		COUNT(t_faculty_book.book_id) as count," + 
				"        0 as count1 ," + 
				"        0 as data1," + 
				"        0 as data2 " + 
				"FROM " + 
				"		t_faculty_book, " + 
				"		m_academic_year," + 
				"		m_faculty " + 
				"WHERE " + 
				"		t_faculty_book.faculty_id=m_faculty.faculty_id AND" + 
				"        t_faculty_book.year_id=m_academic_year.year_id AND" + 
				"        t_faculty_book.del_status=1 AND" + 
				"        m_academic_year.is_current=1 AND" + 
				"        m_faculty.institute_id=:instId" + 
				"        ORDER BY t_faculty_book.book_id LIMIT 1", nativeQuery=true)
		GetCountsForDash getNoBookPublished(@Param("instId") int instId);

	// No. of Patent Filed
		@Query(value="SELECT UUID() AS id, " + 
				"	COUNT(t_faculty_patent.patent_id) as count," + 
				"   0 as count1 ," + 
				"   0 as data1," + 
				"   0 as data2 " + 
				"FROM " + 
				"	t_faculty_patent, " + 
				"	m_academic_year," + 
				"	m_faculty " + 
				"WHERE " + 
				"	t_faculty_patent.faculty_id=m_faculty.faculty_id AND" + 
				"    t_faculty_patent.year_id=m_academic_year.year_id AND" + 
				"    t_faculty_patent.del_status=1 AND" + 
				"    m_academic_year.is_current=1 AND" + 
				"    m_faculty.institute_id=:instId" + 
				"    ORDER BY t_faculty_patent.patent_id LIMIT 1",nativeQuery=true)
		GetCountsForDash getNoPatentFiled(@Param("instId") int instId);	
		
	
}
