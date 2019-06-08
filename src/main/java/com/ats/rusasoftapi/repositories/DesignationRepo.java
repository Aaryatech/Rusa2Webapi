package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Designation;


public interface DesignationRepo extends JpaRepository<Designation, Integer> {

	List<Designation> findByDelStatusAndIsActiveOrderByDesignationIdDesc(@Param("i") int i, @Param("j") int j);

	@Query(value="SELECT * FROM m_designation WHERE del_status = 1 AND is_active = 1 And desg_no IN(:desgList)",nativeQuery=true)
	List<Designation> findByDelStatusAndIsActiveOrderByDesignationIdDesc(@Param("desgList") List<Integer> desgList);
}
