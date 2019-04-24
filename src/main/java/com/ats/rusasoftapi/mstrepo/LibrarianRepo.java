package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Librarian;


public interface LibrarianRepo extends JpaRepository<Librarian, Integer> {
	
	@Query(value=" SELECT * from  m_librarian_reg  where  	institute_id =:instId and del_status=1 ", nativeQuery=true)
		
		List<Librarian> getAllLibList(@Param("instId") int instId);

	Librarian findByLibrarianId(int libId); 

	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_librarian_reg SET del_status=0 WHERE librarian_id IN (:libIdList) ",nativeQuery=true)
	int deleteLibrarians(@Param("libIdList") List<String> libIdList);
	
	

	List<Librarian> findByContactNoAndDelStatus(String contactNo, int delStatus);

	List<Librarian> findByContactNoAndDelStatusAndLibrarianIdNot(String contactNo, int delStatus, int librarianId);

	List<Librarian> findByEmailAndDelStatus(String email, int delStatus);

	List<Librarian> findByEmailAndDelStatusAndLibrarianIdNot(String email, int delStatus, int librarianId);
}
