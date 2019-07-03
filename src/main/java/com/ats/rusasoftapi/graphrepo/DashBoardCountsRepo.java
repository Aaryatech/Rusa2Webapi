package com.ats.rusasoftapi.graphrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.GetCountsForDash;

public interface DashBoardCountsRepo extends JpaRepository<GetCountsForDash, Integer> {

	//*************************************Harsha*********************************************
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
	@Query(value = "SELECT\n" + 
			"    UUID() AS id, SUM(\n" + 
			"        t_program_student_location.female_student\n" + 
			"    ) AS count,\n" + 
			"    SUM(\n" + 
			"        t_program_student_location.male_student\n" + 
			"    ) AS count1,\n" + 
			"    SUM(\n" + 
			"        t_program_student_location.trans_student\n" + 
			"    ) AS data1,\n" + 
			"    0 AS data2\n" + 
			"FROM\n" + 
			"    t_program_student_location\n" + 
			"WHERE\n" + 
			"    t_program_student_location.institute_id =:instId AND t_program_student_location.del_status = 1 AND t_program_student_location.is_active = 1 AND t_program_student_location.year_id =(\n" + 
			"    SELECT\n" + 
			"        m_academic_year.year_id\n" + 
			"    FROM\n" + 
			"        m_academic_year\n" + 
			"    WHERE\n" + 
			"        m_academic_year.is_current = 1\n" + 
			") ", nativeQuery = true)
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
		
	//Dean Counts 
		
		//1
		@Query(value = "SELECT\n" + 
				"    UUID() AS id, COUNT(t_faculty_project.proj_id) AS count,\n" + 
				"    0 AS count1,\n" + 
				"    0 AS data1,\n" + 
				"    0 AS data2\n" + 
				"FROM\n" + 
				"    t_faculty_project,\n" + 
				"    m_faculty\n" + 
				"WHERE\n" + 
				"    t_faculty_project.del_status = 1 AND t_faculty_project.is_active = 1 AND t_faculty_project.year_id =(\n" + 
				"    SELECT\n" + 
				"        m_academic_year.year_id\n" + 
				"    FROM\n" + 
				"        m_academic_year\n" + 
				"    WHERE\n" + 
				"        m_academic_year.is_current = 1\n" + 
				") AND t_faculty_project.faculty_id = m_faculty.faculty_id AND m_faculty.institute_id =:instId ", nativeQuery = true)
		GetCountsForDash getResearchProjForDean(@Param("instId") int instId);
		
		//2
		@Query(value = "SELECT\n" + 
				"    UUID() AS id, COUNT(t_inst_research_dev_mous.inst_reasearch_dev_mou_id) AS count,\n" + 
				"    0 AS count1,\n" + 
				"    0 AS data1,\n" + 
				"    0 AS data2\n" + 
				"FROM\n" + 
				"    t_inst_research_dev_mous\n" + 
				"     \n" + 
				"WHERE\n" + 
				"    t_inst_research_dev_mous.del_status = 1 AND t_inst_research_dev_mous.is_active = 1 AND t_inst_research_dev_mous.ac_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_academic_year.year_id\n" + 
				"    FROM\n" + 
				"        m_academic_year\n" + 
				"    WHERE\n" + 
				"        m_academic_year.is_current = 1\n" + 
				") AND t_inst_research_dev_mous.inst_id =:instId", nativeQuery = true)
		GetCountsForDash getTotalMouForDean(@Param("instId") int instId);
		
		//3
		@Query(value = "SELECT\n" + 
				"     UUID() AS id,COUNT(\n" + 
				"        t_faculty_stud_linkage.faculty_stud_linkage_id\n" + 
				"    ) AS count,\n" + 
				"    0 AS count1,\n" + 
				"    0 AS data1,\n" + 
				"    0 AS data2\n" + 
				"FROM\n" + 
				"    t_faculty_stud_linkage\n" + 
				"WHERE\n" + 
				"    t_faculty_stud_linkage.del_status = 1 AND t_faculty_stud_linkage.is_active = 1 AND t_faculty_stud_linkage.ac_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_academic_year.year_id\n" + 
				"    FROM\n" + 
				"        m_academic_year\n" + 
				"    WHERE\n" + 
				"        m_academic_year.is_current = 1\n" + 
				") AND t_faculty_stud_linkage.inst_id =:instId", nativeQuery = true)
		GetCountsForDash getInstColLinkageForDean(@Param("instId") int instId);
		
		@Query(value = "SELECT\n" + 
				"    UUID() AS id, COUNT(\n" + 
				"        t_institute_linkage.link_id\n" + 
				"    ) AS count,\n" + 
				"    0 AS count1,\n" + 
				"    0 AS data1,\n" + 
				"    0 AS data2\n" + 
				"FROM\n" + 
				"    t_institute_linkage\n" + 
				"WHERE\n" + 
				"    t_institute_linkage.del_status = 1 AND t_institute_linkage.is_active = 1 AND t_institute_linkage.year_id =(\n" + 
				"    SELECT\n" + 
				"        m_academic_year.year_id\n" + 
				"    FROM\n" + 
				"        m_academic_year\n" + 
				"    WHERE\n" + 
				"        m_academic_year.is_current = 1\n" + 
				") AND t_institute_linkage.institute_id=:instId ", nativeQuery = true)
		GetCountsForDash getInstColLinkageStudForDean(@Param("instId") int instId);
		
		
		//4
		
		@Query(value = "SELECT\n" + 
				"    UUID() AS id, SUM(\n" + 
				"        govt_scholarships.ex_int1\n" + 
				"    ) AS count,\n" + 
				"    0 AS count1,\n" + 
				"    0 AS data1,\n" + 
				"    0 AS data2\n" + 
				"FROM\n" + 
				"    govt_scholarships\n" + 
				"WHERE\n" + 
				"    govt_scholarships.del_status = 1 AND govt_scholarships.is_active = 1 AND govt_scholarships.ac_year_id=(\n" + 
				"    SELECT\n" + 
				"        m_academic_year.year_id\n" + 
				"    FROM\n" + 
				"        m_academic_year\n" + 
				"    WHERE\n" + 
				"        m_academic_year.is_current = 1\n" + 
				") AND govt_scholarships.inst_id=:instId ", nativeQuery = true)
		GetCountsForDash getFundinGovtForDean(@Param("instId") int instId);
		
		
		@Query(value = "SELECT\n" + 
				"    UUID() AS id, SUM(\n" + 
				"        t_institute_schemes.ex_int1\n" + 
				"    ) AS count,\n" + 
				"    0 AS count1,\n" + 
				"    0 AS data1,\n" + 
				"    0 AS data2\n" + 
				"FROM\n" + 
				"    t_institute_schemes\n" + 
				"WHERE\n" + 
				"    t_institute_schemes.del_status = 1 AND t_institute_schemes.is_active = 1 AND t_institute_schemes.year_id =(\n" + 
				"    SELECT\n" + 
				"        m_academic_year.year_id\n" + 
				"    FROM\n" + 
				"        m_academic_year\n" + 
				"    WHERE\n" + 
				"        m_academic_year.is_current = 1\n" + 
				") AND t_institute_schemes.institute_id=:instId ", nativeQuery = true)
		GetCountsForDash getFundinNonGovtForDean(@Param("instId") int instId);
		
		//New
		
		@Query(value="SELECT\n" + 
				"    UUID() AS id, \n" + 
				"        t_infrastructure_budget.budget_allocated\n" + 
				"     AS count,\n" + 
				"     \n" + 
				"        t_infrastructure_budget.budget_utilized\n" + 
				"     AS count1,\n" + 
				"    'Infrastructure Budget' AS data1,\n" + 
				"    0 AS data2\n" + 
				"FROM\n" + 
				"    t_infrastructure_budget\n" + 
				"WHERE\n" + 
				"    t_infrastructure_budget.institute_id =:instId AND t_infrastructure_budget.del_status = 1 AND t_infrastructure_budget.is_active = 1 AND t_infrastructure_budget.fin_year_id = (SELECT m_financial_year.fin_year_id FROM m_financial_year WHERE m_financial_year.is_current_fy=1)",nativeQuery=true)
		GetCountsForDash getBudgetInfrastructureDetailCurr(@Param("instId") int instId);

		
		@Query(value="SELECT\n" + 
				"    UUID() AS id, t_physical_facility_budget.budget_allocated AS count, t_physical_facility_budget.budget_utilized AS count1, 'Physical Facility Budget' AS data1, 0 AS data2\n" + 
				"FROM\n" + 
				"    t_physical_facility_budget\n" + 
				"WHERE\n" + 
				"    t_physical_facility_budget.institute_id =:instId AND t_physical_facility_budget.del_status = 1 AND t_physical_facility_budget.is_active = 1 AND t_physical_facility_budget.fin_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_financial_year.fin_year_id\n" + 
				"    FROM\n" + 
				"        m_financial_year\n" + 
				"    WHERE\n" + 
				"        m_financial_year.is_current_fy = 1\n" + 
				")",nativeQuery=true)
		GetCountsForDash getBudgetPhysicalDetailCurr(@Param("instId") int instId);


		@Query(value="SELECT\n" + 
				"    UUID() AS id, t_academic_budget.budget_allocated AS count, \n" + 
				"        t_academic_budget.budget_utilized\n" + 
				"     AS count1,\n" + 
				"    'Academic Facilities Budget' AS data1,\n" + 
				"    0 AS data2\n" + 
				"FROM\n" + 
				"    t_academic_budget\n" + 
				"WHERE\n" + 
				"    t_academic_budget.institute_id =:instId AND t_academic_budget.del_status = 1 AND t_academic_budget.is_active = 1 AND t_academic_budget.fin_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_financial_year.fin_year_id\n" + 
				"    FROM\n" + 
				"        m_financial_year\n" + 
				"    WHERE\n" + 
				"        m_financial_year.is_current_fy = 1\n" + 
				")",nativeQuery=true)
		GetCountsForDash getAcadMicSupprtFaclityBudgtCurr(@Param("instId")int instId);


		@Query(value="SELECT\n" + 
				"    UUID() AS id, t_library_budget.budget_allocated AS count, t_library_budget.budget_utilized AS count1, 'Library Budget' AS data1, 0 AS data2\n" + 
				"FROM\n" + 
				"    t_library_budget\n" + 
				"WHERE\n" + 
				"    t_library_budget.institute_id =:instId AND t_library_budget.del_status = 1 AND t_library_budget.is_active = 1 AND t_library_budget.fin_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_financial_year.fin_year_id\n" + 
				"    FROM\n" + 
				"        m_financial_year\n" + 
				"    WHERE\n" + 
				"        m_financial_year.is_current_fy = 1\n" + 
				")",nativeQuery=true)
		GetCountsForDash getLibraryFacilityBudgtCurr(@Param("instId") int instId);

		@Query(value="SELECT\n" + 
				"    UUID() AS id, t_library_book_budget.ex_int2 AS count, t_library_book_budget.expenditure_on_book_purchase AS count1, 'Books Budget' AS data1, 0 AS data2\n" + 
				"FROM\n" + 
				"    t_library_book_budget\n" + 
				"WHERE\n" + 
				"    t_library_book_budget.institute_id =:instId AND t_library_book_budget.del_status = 1 AND t_library_book_budget.is_active = 1 AND t_library_book_budget.fin_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_financial_year.fin_year_id\n" + 
				"    FROM\n" + 
				"        m_financial_year\n" + 
				"    WHERE\n" + 
				"        m_financial_year.is_current_fy = 1\n" + 
				")",nativeQuery=true)
		GetCountsForDash getBooksBudgtCurr(@Param("instId") int instId);


		@Query(value="SELECT\n" + 
				"    UUID() AS id, t_waste_mngt_budget.budget_allocated AS COUNT, t_waste_mngt_budget.budget_utilized AS count1, 'Green Initiatives' AS data1, 0 AS data2\n" + 
				"FROM\n" + 
				"    t_waste_mngt_budget\n" + 
				"WHERE\n" + 
				"    t_waste_mngt_budget.institute_id =:instId AND t_waste_mngt_budget.del_status = 1 AND t_waste_mngt_budget.is_active = 1 AND t_waste_mngt_budget.fin_year_id =(\n" + 
				"    SELECT\n" + 
				"        m_financial_year.fin_year_id\n" + 
				"    FROM\n" + 
				"        m_financial_year\n" + 
				"    WHERE\n" + 
				"        m_financial_year.is_current_fy = 1\n" + 
				")",nativeQuery=true)
		GetCountsForDash getGreenInitivativAndWasteMgntCurr(@Param("instId") int instId);
		
		
		
	
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
		
	
		

		@Query(value="SELECT " + 
				"	UUID() AS id, " + 
				"	SUM(t_infrastructure_budget.budget_allocated) as count," + 	//allocated_amt
				"	SUM(t_infrastructure_budget.budget_utilized) as count1," + 	//utillized_amt
				"	'Infrastructure Budget' as data1,"+	//budget_title
				"   0 as data2 " + 		
				"FROM " + 
				"	t_infrastructure_budget " + 
				"WHERE " + 
				"	t_infrastructure_budget.institute_id=:instId AND " + 
				"	t_infrastructure_budget.del_status=1 AND " + 
				"   t_infrastructure_budget.is_active=1" + 
				"	ORDER BY t_infrastructure_budget.infra_budget_id DESC LIMIT 5",nativeQuery=true)
		GetCountsForDash getBudgetInfrastructureDetail(@Param("instId") int instId);

		
		@Query(value="SELECT " + 
				"	UUID() AS id, " + 
				"	SUM(t_physical_facility_budget.budget_allocated) as count," + //allocated_amt
				"	SUM(t_physical_facility_budget.budget_utilized) as count1," + //utillized_amt
				"	'Physical Facility Budget' as data1," + //budget_title
				"   0 as data2 " + 		
				"FROM " + 
				"	t_physical_facility_budget " + 
				"WHERE " + 
				"	t_physical_facility_budget.institute_id=:instId AND " + 
				"	t_physical_facility_budget.del_status=1 AND " + 
				"    t_physical_facility_budget.is_active=1" + 
				"	ORDER BY t_physical_facility_budget.physical_facility_budget_id DESC LIMIT 5",nativeQuery=true)
		GetCountsForDash getBudgetPhysicalDetail(@Param("instId") int instId);


		@Query(value="SELECT UUID() AS id," + 
				"	SUM(t_academic_budget.budget_allocated) as count," + //allocated_amt
				"	SUM(t_academic_budget.budget_utilized) as count1," + //utillized_amt
				"	'Academic Facilities Budget' as data1, " + //budget_title
				"   0 as data2 " + 	
				"FROM " + 
				"	t_academic_budget " + 
				"WHERE " + 
				"	t_academic_budget.institute_id=2 AND " + 
				"	t_academic_budget.del_status=1 AND t_academic_budget.is_active=1" + 
				"	ORDER BY t_academic_budget.academic_budget_id DESC LIMIT 5",nativeQuery=true)
		GetCountsForDash getAcadMicSupprtFaclityBudgt(@Param("instId")int instId);


		@Query(value="SELECT UUID() AS id," + 
				"	SUM(t_library_budget.budget_allocated) as count," + 
				"	SUM(t_library_budget.budget_utilized) as count1," + 
				"	'Library Budget' as data1, " + 
				"   0 as data2 " + 	
				"FROM " + 
				"	t_library_budget " + 
				"WHERE " + 
				"	t_library_budget.institute_id=:instId AND " + 
				"	t_library_budget.del_status=1 AND " + 
				"   t_library_budget.is_active=1" + 
				"	ORDER BY t_library_budget.lib_budget_id DESC LIMIT 5",nativeQuery=true)
		GetCountsForDash getLibraryFacilityBudgt(@Param("instId") int instId);

		@Query(value="SELECT UUID() AS id," + 
				"	SUM(t_library_book_budget.ex_int2) as count," + 
				"    SUM(t_library_book_budget.expenditure_on_book_purchase) as count1," + 
				"    'Books Budget' as data1," + 
				"    0 as data2 " + 
				"FROM " + 
				"	t_library_book_budget " + 
				"WHERE " + 
				"	t_library_book_budget.institute_id=:instId AND " + 
				"	t_library_book_budget.del_status=1 AND " + 
				"    t_library_book_budget.is_active=1" + 
				"	ORDER BY t_library_book_budget.library_book_budget_id DESC LIMIT 5",nativeQuery=true)
		GetCountsForDash getBooksBudgt(@Param("instId") int instId);


		@Query(value="SELECT UUID() AS id," + 
				"	SUM(t_waste_mngt_budget.budget_allocated) as count," + 
				"	SUM(t_waste_mngt_budget.budget_utilized) as count1," + 
				"	'Green Initiatives' as data1, " + 
				"   0 as data2 " + 	
				"FROM " + 
				"	t_waste_mngt_budget " + 
				"WHERE " + 
				"	t_waste_mngt_budget.institute_id=:instId AND " + 
				"	t_waste_mngt_budget.del_status=1 AND " + 
				"    t_waste_mngt_budget.is_active=1" + 
				"	ORDER BY t_waste_mngt_budget.waste_mngt_budget_id DESC LIMIT 5",nativeQuery=true)
		GetCountsForDash getGreenInitivativAndWasteMgnt(@Param("instId") int instId);
}
