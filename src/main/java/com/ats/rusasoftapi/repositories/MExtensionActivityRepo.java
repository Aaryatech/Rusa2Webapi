package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.MExtensionActivity;

public interface MExtensionActivityRepo extends JpaRepository<MExtensionActivity, Integer> {

	List<MExtensionActivity> findByDelStatusOrderBySequenceAsc(int i);
	
	
}
