package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.Journal;

public interface JournalRepo extends JpaRepository<Journal, Integer> {

	Journal findByJournalIdAndDelStatus(int journalId, int i);

	List<Journal> findByDelStatusOrderByJournalIdDesc(int i);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_journal SET del_status=0 WHERE journal_id IN (:jouIdList) ", nativeQuery = true)
	int deleteJournals(@Param("jouIdList") List<String> jouIdList);

	List<Journal> findByFacultyIdAndDelStatusOrderByJournalIdDesc(int facultyId, int i);

}
