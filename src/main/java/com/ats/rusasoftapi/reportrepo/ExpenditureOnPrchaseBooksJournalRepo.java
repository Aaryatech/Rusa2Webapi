package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.ExpenditureOnPrchaseBooksJournal;

public interface ExpenditureOnPrchaseBooksJournalRepo extends JpaRepository<ExpenditureOnPrchaseBooksJournal, Integer> {

	@Query(value="SELECT" + 
			" lib_book_purchase.book_purchase_id," + 
			" lib_book_purchase.cost_of_books," + 
			" lib_book_purchase.cost_of_journal," + 
			" lib_book_purchase.cost_of_ejournal," + 
			" (lib_book_purchase.cost_of_books+lib_book_purchase.cost_of_journal+lib_book_purchase.cost_of_ejournal) AS total_expenditures," + 
			" m_academic_year.academic_year," + 
			" m_institute.institute_name " + 
			"FROM lib_book_purchase, m_academic_year, m_institute " + 
			"WHERE lib_book_purchase.del_status=1 AND" + 
			" m_academic_year.year_id=lib_book_purchase.academic_yrid AND" + 
			" m_institute.institute_id=lib_book_purchase.institute_id AND" + 
			" lib_book_purchase.institute_id=:instId AND" + 
			" lib_book_purchase.academic_yrid IN (:acYearList)",nativeQuery=true)
	List<ExpenditureOnPrchaseBooksJournal> getAllExpenditureOnPrchaseBooksJournal(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);

}
