package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.WasteMngtBudget;

public interface WasteMngtBudgetRepo extends JpaRepository<WasteMngtBudget, Integer> {

	WasteMngtBudget findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(int i, int j, int curFinYear,int instId);

	WasteMngtBudget findByDelStatusAndIsActiveAndWasteMngtBudgetId(int i, int j, int wasteMngtBudgetId);

	@Transactional
	@Modifying
	@Query(value = " UPDATE t_waste_mngt_budget SET del_status=0 WHERE waste_mngt_budget_id IN (:wasteMngtBudgetIdList) ", nativeQuery = true)
	int deleteWasteMngtBudget(@Param("wasteMngtBudgetIdList") List<String> wasteMngtBudgetIdList);

}
