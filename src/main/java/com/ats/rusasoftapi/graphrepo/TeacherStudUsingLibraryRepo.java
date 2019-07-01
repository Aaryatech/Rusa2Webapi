package com.ats.rusasoftapi.graphrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.graph.model.TeacherStudUsingLibrary;

public interface TeacherStudUsingLibraryRepo extends JpaRepository<TeacherStudUsingLibrary, Integer>{

	
	
	@Query(value="SELECT\n" + 
			"    m_library_info.ac_year_id,\n" + 
			"    m_library_info.lib_info_id,\n" + 
			"    m_library_info.avg_teacher,\n" + 
			"    m_library_info.avg_student,m_academic_year.academic_year as ac_year \n" + 
			"FROM\n" + 
			"    m_library_info,m_academic_year\n" + 
			"WHERE\n" + 
			"    m_library_info.institute_id =:instId AND m_library_info.del_status = 1 AND m_library_info.ac_year_id IN(:lastFiveYears) AND m_academic_year.year_id=  m_library_info.ac_year_id",nativeQuery=true)
	List<TeacherStudUsingLibrary> getTeacherStudUsingLibraryDet(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
}
