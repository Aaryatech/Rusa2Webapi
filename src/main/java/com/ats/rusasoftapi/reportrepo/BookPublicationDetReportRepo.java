package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.BookPublicationDetReport;

public interface BookPublicationDetReportRepo extends JpaRepository<BookPublicationDetReport, Integer>{

 	@Query(value="SELECT\n" + 
			"    t_faculty_book.book_id,\n" + 
			"    t_faculty_book.faculty_id,\n" + 
			"    t_faculty_book.book_title,\n" + 
			"    t_faculty_book.book_publisher,\n" + 
			"    t_faculty_book.book_isbn,\n" + 
			"    t_faculty_book.book_pub_year,\n" + 
			"    m_faculty.faculty_first_name,\n" + 
			"    m_faculty.faculty_last_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    t_faculty_book,\n" + 
			"    m_faculty,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    t_faculty_book.faculty_id = m_faculty.faculty_id AND m_institute.institute_id = m_faculty.institute_id AND t_faculty_book.year_id = m_academic_year.year_id AND t_faculty_book.del_status = 1 AND t_faculty_book.is_active = 1\n" + 
			"    AND t_faculty_book.year_id IN(:acYearList) AND  m_faculty.institute_id=:instId ",nativeQuery=true)

	List<BookPublicationDetReport> getBookPublicationDetReport(@Param("instId")   int instId,@Param("acYearList")   List<Integer> acYearList);
}
