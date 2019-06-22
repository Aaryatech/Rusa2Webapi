package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.GetPhysicalFacilityBudget;

public interface GetPhysicalFacilityBudgetRepo extends JpaRepository<GetPhysicalFacilityBudget, Integer> {

	@Query(value = " SELECT t_physical_facility_budget.physical_facility_budget_id,t_physical_facility_budget.ex_int1,t_physical_facility_budget.ex_var1, t_physical_facility_budget.ex_var2,t_physical_facility_budget.fin_year_id,t_physical_facility_budget.institute_id,t_physical_facility_budget.ac_year_id,\n"
			+ " t_physical_facility_budget.physical_facility_budget_title, t_physical_facility_budget.budget_allocated,t_physical_facility_budget.budget_utilized,\n"
			+ "		m_academic_year.academic_year,m_financial_year.fin_year FROM t_physical_facility_budget \n"
			+ "			LEFT JOIN m_financial_year  ON t_physical_facility_budget.fin_year_id=m_financial_year.fin_year_id \n"
			+ "LEFT JOIN m_academic_year   ON t_physical_facility_budget.ac_year_id=m_academic_year.year_id \n"
			+ " WHERE t_physical_facility_budget.del_status=1 AND t_physical_facility_budget.is_active=1 AND t_physical_facility_budget.institute_id=:instId  AND \n"
			+ " t_physical_facility_budget.ac_year_id=:acYearId ", nativeQuery = true)

	List<GetPhysicalFacilityBudget> getBudgetList(@Param("instId") int instId, @Param("acYearId") int acYearId);

}
