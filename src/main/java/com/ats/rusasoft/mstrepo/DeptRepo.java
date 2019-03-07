package com.ats.rusasoft.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.Dept;

public interface DeptRepo extends JpaRepository<Dept, Integer> {
	
	
	List<Dept> findByDelStatusAndIsActiveAndInstituteIdOrderByDeptIdDesc(int delStatus, int isActive,int instId);
	
	Dept findBydeptId(int deptId);
	
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_dept SET del_status=0 WHERE dept_id IN (:deptIdList) ",nativeQuery=true)
	int deleteDepts(@Param("deptIdList") List<String> deptIdList);
	
}
