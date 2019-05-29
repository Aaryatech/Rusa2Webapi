package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.BudgetInfraAugmntn;

public interface BudgetInfraAugmntnRepo extends JpaRepository<BudgetInfraAugmntn, Integer> {

	@Query(value="SELECT t_infrastructure_budget.infra_budget_id,t_infrastructure_budget.budget_allocated,t_infrastructure_budget.budget_utilized,t_infrastructure_budget.ex_int1,t_infrastructure_budget.fin_year_id,t_infrastructure_budget.ac_year_id,m_institute.institute_name,m_financial_year.fin_year,m_academic_year.academic_year\n" + 
			"FROM t_infrastructure_budget,m_institute,m_financial_year,m_academic_year\n" + 
			"WHERE t_infrastructure_budget.institute_id=m_institute.institute_id AND t_infrastructure_budget.ac_year_id=m_academic_year.year_id  \n" + 
			"AND t_infrastructure_budget.fin_year_id=m_financial_year.fin_year_id AND m_institute.institute_id=:instId AND t_infrastructure_budget.ac_year_id IN (:acYearList)",nativeQuery=true)
	List<BudgetInfraAugmntn> getAllBudgetInfraAugmentn(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);

}
