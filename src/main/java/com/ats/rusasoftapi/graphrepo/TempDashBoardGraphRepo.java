package com.ats.rusasoftapi.graphrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.BudgetGraphDash;
import com.ats.rusasoftapi.graph.model.GetCountsForDash;

public interface TempDashBoardGraphRepo extends JpaRepository<GetCountsForDash, Integer>{

	
	@Query(value="SELECT " + 
			"	UUID() AS id, " + 
			"	SUM(t_infrastructure_budget.budget_allocated) as count," + 	//allocated_amt
			"	SUM(t_infrastructure_budget.budget_utilized) as count1," + 	//utillized_amt
			"	'Infrastructure Budget' as data1,"+	//budget_title
			"   0 as data2 " + 		
			"FROM " + 
			"	t_infrastructure_budget " + 
			"WHERE " + 
			"	t_infrastructure_budget.institute_id=:instId AND " + 
			"	t_infrastructure_budget.del_status=1 AND " + 
			"   t_infrastructure_budget.is_active=1" + 
			"	ORDER BY t_infrastructure_budget.infra_budget_id DESC LIMIT 5",nativeQuery=true)
	GetCountsForDash getBudgetInfrastructureDetail(@Param("instId") int instId);

	
	@Query(value="SELECT " + 
			"	UUID() AS id, " + 
			"	SUM(t_physical_facility_budget.budget_allocated) as count," + //allocated_amt
			"	SUM(t_physical_facility_budget.budget_utilized) as count1," + //utillized_amt
			"	'Physical Facility Budget' as data1," + //budget_title
			"   0 as data2 " + 		
			"FROM " + 
			"	t_physical_facility_budget " + 
			"WHERE " + 
			"	t_physical_facility_budget.institute_id=:instId AND " + 
			"	t_physical_facility_budget.del_status=1 AND " + 
			"    t_physical_facility_budget.is_active=1" + 
			"	ORDER BY t_physical_facility_budget.physical_facility_budget_id DESC LIMIT 5",nativeQuery=true)
	GetCountsForDash getBudgetPhysicalDetail(@Param("instId") int instId);


	@Query(value="SELECT UUID() AS id," + 
			"	SUM(t_academic_budget.budget_allocated) as count," + //allocated_amt
			"	SUM(t_academic_budget.budget_utilized) as count1," + //utillized_amt
			"	'Academic Facilities Budget' as data1, " + //budget_title
			"   0 as data2 " + 	
			"FROM " + 
			"	t_academic_budget " + 
			"WHERE " + 
			"	t_academic_budget.institute_id=2 AND " + 
			"	t_academic_budget.del_status=1 AND t_academic_budget.is_active=1" + 
			"	ORDER BY t_academic_budget.academic_budget_id DESC LIMIT 5",nativeQuery=true)
	GetCountsForDash getAcadMicSupprtFaclityBudgt(@Param("instId")int instId);


	@Query(value="SELECT UUID() AS id," + 
			"	SUM(t_library_budget.budget_allocated) as count," + 
			"	SUM(t_library_budget.budget_utilized) as count1," + 
			"	'Library Budget' as data1, " + 
			"   0 as data2 " + 	
			"FROM " + 
			"	t_library_budget " + 
			"WHERE " + 
			"	t_library_budget.institute_id=:instId AND " + 
			"	t_library_budget.del_status=1 AND " + 
			"   t_library_budget.is_active=1" + 
			"	ORDER BY t_library_budget.lib_budget_id DESC LIMIT 5",nativeQuery=true)
	GetCountsForDash getLibraryFacilityBudgt(@Param("instId") int instId);

	@Query(value="SELECT UUID() AS id," + 
			"	SUM(t_library_book_budget.ex_int2) as count," + 
			"    SUM(t_library_book_budget.expenditure_on_book_purchase) as count1," + 
			"    'Books Budget' as data1," + 
			"    0 as data2 " + 
			"FROM " + 
			"	t_library_book_budget " + 
			"WHERE " + 
			"	t_library_book_budget.institute_id=:instId AND " + 
			"	t_library_book_budget.del_status=1 AND " + 
			"    t_library_book_budget.is_active=1" + 
			"	ORDER BY t_library_book_budget.library_book_budget_id DESC LIMIT 5",nativeQuery=true)
	GetCountsForDash getBooksBudgt(@Param("instId") int instId);


	@Query(value="SELECT UUID() AS id," + 
			"	SUM(t_waste_mngt_budget.budget_allocated) as count," + 
			"	SUM(t_waste_mngt_budget.budget_utilized) as count1," + 
			"	'Green Initiatives' as data1, " + 
			"   0 as data2 " + 	
			"FROM " + 
			"	t_waste_mngt_budget " + 
			"WHERE " + 
			"	t_waste_mngt_budget.institute_id=:instId AND " + 
			"	t_waste_mngt_budget.del_status=1 AND " + 
			"    t_waste_mngt_budget.is_active=1" + 
			"	ORDER BY t_waste_mngt_budget.waste_mngt_budget_id DESC LIMIT 5",nativeQuery=true)
	GetCountsForDash getGreenInitivativAndWasteMgnt(@Param("instId") int instId);
	
	
}
