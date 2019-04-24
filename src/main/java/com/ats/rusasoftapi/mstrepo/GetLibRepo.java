package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetLib;

public interface GetLibRepo extends JpaRepository<GetLib, Integer> {

	@Query(value = " SELECT * from  m_librarian_reg  where institute_id =:instId and del_status=1 ORDER BY m_librarian_reg.librarian_id DESC", nativeQuery = true)

	List<GetLib> getAllLibList(@Param("instId") int instId);

}
