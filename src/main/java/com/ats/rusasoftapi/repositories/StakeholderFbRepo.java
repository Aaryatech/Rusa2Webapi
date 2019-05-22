package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

 import com.ats.rusasoftapi.model.StakeholderFb;

public interface StakeholderFbRepo extends JpaRepository<StakeholderFb, Integer>{

	List<StakeholderFb> findByDelStatusAndIsActive(int delStatus, int isActive);

}
