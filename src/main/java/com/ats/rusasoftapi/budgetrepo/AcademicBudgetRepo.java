package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.AcademicBudget;

public interface AcademicBudgetRepo extends JpaRepository<AcademicBudget, Integer> {

	AcademicBudget findByDelStatusAndIsActiveAndAcademicBudgetId(int i, int j, int academicBudgetId);

	List<AcademicBudget> findByInstituteIdAndAcYearIdAndDelStatusAndIsActive(int instId, int acYearId, int i, int j);

	AcademicBudget findByDelStatusAndIsActiveAndFinYearId(int i, int j, int curFinYear);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_academic_budget SET del_status=0 WHERE academic_budget_id IN (:academicIdList) ", nativeQuery = true)
	int deleteAcademic(@Param("academicIdList") List<String> academicIdList);

	AcademicBudget findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(int i, int j, int curFinYear, int instituteId);

}
