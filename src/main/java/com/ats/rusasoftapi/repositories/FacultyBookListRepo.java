package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.FacultyBookList;

public interface FacultyBookListRepo extends JpaRepository<FacultyBookList, Integer> {

	
	@Query(value="SELECT b.book_id, b.faculty_id, b.year_id, b.book_title,b.book_edition,b.book_author, b.book_coauther1, b.book_coauther2,b.book_coauther3, b.book_publisher, b.book_isbn, b.book_pub_year, b.del_status, b.is_active, b.maker_user_id, b.maker_enter_datetime, b.maker_enter_datetime,f.faculty_first_name, d.dept_name FROM t_faculty_book b, m_faculty f, m_dept d WHERE b.del_status=1 AND b.is_active=1 AND b.year_id=:yearId AND f.institute_id=:instituteId AND f.dept_id=d.dept_id AND b.faculty_id=f.faculty_id ORDER BY b.book_id DESC ",nativeQuery=true)
	List<FacultyBookList> getJouByYear(@Param("yearId") int yearId, @Param("instituteId") int instituteId);
	
	
	@Query(value="SELECT b.book_id, b.faculty_id, b.year_id, b.book_title,b.book_edition,b.book_author, b.book_coauther1, b.book_coauther2,b.book_coauther3, b.book_publisher, b.book_isbn, b.book_pub_year, b.del_status, b.is_active, b.maker_user_id, b.maker_enter_datetime, b.maker_enter_datetime,f.faculty_first_name, d.dept_name FROM t_faculty_book b, m_faculty f, m_dept d WHERE b.del_status=1 AND b.is_active=1 AND b.year_id=:yearId AND d.dept_id IN(:deptIdList) AND f.institute_id=:instituteId AND f.dept_id=d.dept_id AND b.faculty_id=f.faculty_id ORDER BY b.book_id DESC ",nativeQuery=true)
	List<FacultyBookList> getJournalByDept(@Param("deptIdList")List<Integer> deptIdList, @Param("yearId") int yearId, @Param("instituteId") int instituteId);
	
	
	@Query(value="SELECT b.book_id, b.faculty_id, b.year_id, b.book_title,b.book_edition,b.book_author, b.book_coauther1, b.book_coauther2,b.book_coauther3, b.book_publisher, b.book_isbn, b.book_pub_year, b.del_status, b.is_active, b.maker_user_id, b.maker_enter_datetime, b.maker_enter_datetime,f.faculty_first_name, d.dept_name FROM t_faculty_book b, m_faculty f, m_dept d WHERE b.del_status=1 AND b.is_active=1 AND b.year_id=:yearId AND  b.faculty_id=:facultyId AND f.institute_id=:instituteId AND f.dept_id=d.dept_id AND b.faculty_id=f.faculty_id ORDER BY b.book_id DESC ",nativeQuery=true)
	List<FacultyBookList> getJournalRepo(@Param("facultyId") int facultyId, @Param("yearId") int yearId, @Param("instituteId") int instituteId);

}
