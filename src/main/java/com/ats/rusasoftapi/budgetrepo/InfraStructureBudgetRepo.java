package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.InfraStructureBudget;

public interface InfraStructureBudgetRepo extends JpaRepository<InfraStructureBudget, Integer>{
	
	InfraStructureBudget findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(int d,int i, int curFinYear, int instId);
	
	InfraStructureBudget findByDelStatusAndIsActiveAndInfraBudgetId(int d,int i, int infraBudgetId);
	

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_infrastructure_budget SET del_status=0 WHERE infra_budget_id IN (:infraBudgetIdList) ", nativeQuery = true)
	int deleteInfraBudget(@Param("infraBudgetIdList") List<String> infraBudgetIdList);
	
	
}
