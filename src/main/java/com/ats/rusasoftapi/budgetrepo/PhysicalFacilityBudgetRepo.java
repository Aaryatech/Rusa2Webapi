package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.PhysicalFacilityBudget;

public interface PhysicalFacilityBudgetRepo extends JpaRepository<PhysicalFacilityBudget, Integer> {

	PhysicalFacilityBudget findByDelStatusAndIsActiveAndFinYearId(int i, int j, int curFinYear);

	PhysicalFacilityBudget findByDelStatusAndIsActiveAndPhysicalFacilityBudgetId(int i, int j,
			int physicalFacilityBudgetId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_physical_facility_budget SET del_status=0 WHERE physical_facility_budget_id IN (:phyBudgetIdList) ", nativeQuery = true)
	int deletePhysicalBud(@Param("phyBudgetIdList") List<String> phyBudgetIdList);

	PhysicalFacilityBudget findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(int i, int j, int curFinYear,
			int instituteId);

}
