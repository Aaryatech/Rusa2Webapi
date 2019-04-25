package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.ResearchDevMou;

public interface ResearchDevMouRepo extends JpaRepository<ResearchDevMou, Integer> {
List<ResearchDevMou> findBydelStatus(int del);


	
}
