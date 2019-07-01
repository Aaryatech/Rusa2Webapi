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
			+ "    t_program_student_location.female_student as count,t_program_student_location.male_student as count1,0 as data1,0 as data2 \n"
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
			+ "    ) AS COUNT,\n" + "    0 AS count1, 0 as data1,0 as data2 \n" + "FROM\n" + "    t_academic_budget\n"
			+ "WHERE\n"
			+ "    t_academic_budget.institute_id =:instId AND t_academic_budget.del_status = 1 AND t_academic_budget.is_active = 1 AND t_academic_budget.fin_year_id =(\n"
			+ "    SELECT\n" + "        m_financial_year.fin_year_id\n" + "    FROM\n" + "        m_financial_year\n"
			+ "    WHERE\n" + "        m_financial_year.is_current_fy = 1)\n" + "\n" + " ", nativeQuery = true)
	GetCountsForDash getNoOfBudgetForPrinci(@Param("instId") int instId);
	// 6

	@Query(value = "SELECT\n" + "    UUID() AS id, COUNT(t_faculty_book.book_id) AS COUNT,\n"
			+ "    0 AS count1,0 as data1,0 as data2 \n" + "FROM\n" + "    t_faculty_book,\n" + "    m_faculty\n"
			+ "WHERE\n"
			+ "    t_faculty_book.faculty_id = m_faculty.faculty_id AND t_faculty_book.del_status = 1 AND t_faculty_book.is_active = 1 AND m_faculty.institute_id =:instId AND t_faculty_book.year_id =(\n"
			+ "    SELECT\n" + "        m_academic_year.year_id\n" + "    FROM\n" + "        m_academic_year\n"
			+ "    WHERE\n" + "        m_academic_year.is_current = 1\n" + ") ", nativeQuery = true)
	GetCountsForDash getNoOfBookPubForPrinci(@Param("instId") int instId);

	// 7

	@Query(value = "SELECT\n" + "    UUID() AS id, COUNT(t_faculty_conference.conf_id) AS COUNT,\n"
			+ "    0 AS count1,0 as data1,0 as data2 \n" + "FROM\n" + "    t_faculty_conference,\n" + "    m_faculty\n"
			+ "WHERE\n"
			+ "    t_faculty_conference.faculty_id = m_faculty.faculty_id AND t_faculty_conference.del_status = 1 AND t_faculty_conference.is_active = 1 AND m_faculty.institute_id =:instId AND t_faculty_conference.year_id =(\n"
			+ "    SELECT\n" + "        m_academic_year.year_id\n" + "    FROM\n" + "        m_academic_year\n"
			+ "    WHERE\n" + "        m_academic_year.is_current = 1\n" + ")", nativeQuery = true)
	GetCountsForDash getNoOfResearchPubForPrinci(@Param("instId") int instId);

}
