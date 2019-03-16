package com.ats.rusasoft.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.faculty.GetJournal;

public interface GetJournalRepo extends JpaRepository<GetJournal, Integer> {

	@Query(value = " SELECT * FROM t_faculty_journal WHERE t_faculty_journal.del_status=1 AND t_faculty_journal.faculty_id=:facultyId AND t_faculty_journal.is_active=1 ORDER BY t_faculty_journal.journal_id DESC ", nativeQuery = true)
	List<GetJournal> getJournalRepo(@Param("facultyId") int facultyId);

}
