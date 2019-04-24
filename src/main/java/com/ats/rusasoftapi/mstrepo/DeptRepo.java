package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Dept;

public interface DeptRepo extends JpaRepository<Dept, Integer> {
	
	
	List<Dept> findByDelStatusAndIsActiveAndInstituteIdOrderByDeptIdDesc(int delStatus, int isActive,int instId);
	
	Dept findBydeptId(int deptId);
	
	
	List<Dept> findByDelStatusAndIsActiveAndDeptIdIn(int delSatus, int isActive,List<Integer> deptIds);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_dept SET del_status=0 WHERE dept_id IN (:deptIdList) ",nativeQuery=true)
	int deleteDepts(@Param("deptIdList") List<String> deptIdList);
	
	
	@Query(value=" SELECT m_dept.* from  m_dept WHERE m_dept.institute_id=:instId and m_dept.dept_id IN "
			+ "(SELECT m_faculty.dept_id FROM m_faculty "
			+ "WHERE m_faculty.institute_id=m_dept.institute_id AND"
			+ " m_faculty.is_hod=0 AND m_faculty.del_status=1 AND m_faculty.is_active=1 "
			+ "AND m_faculty.is_blocked=0) AND m_dept.del_status=1 AND"
			+ " m_dept.is_active=1 ",nativeQuery=true)
	List<Dept> getDeptForHodReg(@Param("instId") int  instId);
	
	
	
}
