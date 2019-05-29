package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.ExpndturOnPhysclAcademicSupprt;

public interface ExpndturOnPhysclAcademicSupprtRepo extends JpaRepository<ExpndturOnPhysclAcademicSupprt, Integer>{

	@Query(value="SELECT UUID() AS unq_id, (t_physical_facility_budget.budget_utilized + t_academic_budget.budget_utilized) AS expd_on_phy_acad, " + 
			"		(t_physical_facility_budget.ex_int1 + t_academic_budget.ex_int1) AS ttl_expd," + 
			"	m_financial_year.fin_year, " + 
			"        m_institute.institute_name " + 
			"FROM t_physical_facility_budget," + 
			"	 t_academic_budget," + 
			"    m_financial_year," + 
			"    m_institute " + 
			"WHERE t_academic_budget.institute_id=m_institute.institute_id AND" + 
			"	t_physical_facility_budget.institute_id=m_institute.institute_id AND" + 
			"   t_academic_budget.fin_year_id=m_financial_year.fin_year_id AND" + 
			"   t_physical_facility_budget.fin_year_id=m_financial_year.fin_year_id AND" + 
			"   t_physical_facility_budget.del_status=1 AND" + 
			"   t_academic_budget.del_status=1 AND" + 
			"   m_institute.institute_id=:instId",nativeQuery=true)
	List<ExpndturOnPhysclAcademicSupprt> getAllExpndPhyAcdSupprtFacilities(@Param("instId")int instId);

	
}
