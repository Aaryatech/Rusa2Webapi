package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.State;

public interface StateRepo extends JpaRepository<State, Integer> {
	
	State save(State state);

	List<State> findByDelStatus(int delStatus);

}
