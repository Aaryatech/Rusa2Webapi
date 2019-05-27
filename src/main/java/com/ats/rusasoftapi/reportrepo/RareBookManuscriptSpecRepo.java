package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.RareBookManuscriptSpec;

public interface RareBookManuscriptSpecRepo extends JpaRepository<RareBookManuscriptSpec, Integer>{
 
	@Query(value="SELECT\n" + 
			"    t_rare_book_info.rare_book_info_id,\n" + 
			"    t_rare_book_info.rare_bookname,\n" + 
			"    t_rare_book_info.publisher,\n" + 
			"    t_rare_book_info.ex_var1 AS author,\n" + 
			"    t_rare_book_info.book_copies,\n" + 
			"    t_rare_book_info.publication_year,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    t_rare_book_info,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    t_rare_book_info.institute_id = m_institute.institute_id AND t_rare_book_info.del_status = 1  AND   t_rare_book_info.institute_id=:instId \n" + 
			"ORDER BY `t_rare_book_info`.`rare_book_info_id` ASC",nativeQuery=true)

	List<RareBookManuscriptSpec> getRareBookInfo(@Param("instId")   int instId);
}
