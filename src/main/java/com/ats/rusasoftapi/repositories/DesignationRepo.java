package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Designation;


public interface DesignationRepo extends JpaRepository<Designation, Integer> {

	List<Designation> findByDelStatusAndIsActiveOrderByDesignationIdDesc(@Param("i") int i, @Param("j") int j);
}
