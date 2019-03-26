package com.ats.rusasoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.budgetrepo.FinancialYearRepo;
import com.ats.rusasoft.budgetrepo.GetInfraStructureBudgetRepo;
import com.ats.rusasoft.budgetrepo.GetLibraryBudgetRepo;
import com.ats.rusasoft.budgetrepo.InfraStructureBudgetRepo;
import com.ats.rusasoft.budgetrepo.LibraryBudgetRepo;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.budget.FinancialYear;
import com.ats.rusasoft.model.budget.GetInfraStructureBudget;
import com.ats.rusasoft.model.budget.GetLibraryBudget;
import com.ats.rusasoft.model.budget.InfraStructureBudget;
import com.ats.rusasoft.model.budget.LibraryBudget;

@RestController
public class BudgetControllerSac {
	
	@Autowired GetInfraStructureBudgetRepo getInfraStructureBudgetRepo;
	@Autowired GetLibraryBudgetRepo getLibraryBudgetRepo;
	@Autowired InfraStructureBudgetRepo infraStructureBudgetRepo;
	@Autowired LibraryBudgetRepo libraryBudgetRepo;
	
	
	@Autowired FinancialYearRepo financialYearRepo;
	
	@RequestMapping(value = { "/getCurrentFinancialYear" }, method = RequestMethod.GET)
	public @ResponseBody FinancialYear getCurrentFinancialYear() {

		FinancialYear curFinYear = null;

		try {
			curFinYear = financialYearRepo.findByDelStatusAndIsActiveAndIsCurrentFy(1, 1, 1);
			
		} catch (Exception e) {
			System.err.println("Exce in  getCurrentFinancialYear" + e.getMessage());
			e.printStackTrace();
		}

		return curFinYear;
	}
	
	
	@RequestMapping(value = { "/getFinancialYearList" }, method = RequestMethod.GET)
	public @ResponseBody List<FinancialYear> getFinancialYearList() {

		List<FinancialYear>  finYearList= new ArrayList<FinancialYear>();

		try {
			
			finYearList = financialYearRepo.findByDelStatusAndIsActive(1, 1);
			
		} catch (Exception e) {
			
			System.err.println("Exce in  getFinancialYearList" + e.getMessage());
			e.printStackTrace();
		}

		return finYearList;
	}
	
	
	@RequestMapping(value = { "/saveInfraStructureBudget" }, method = RequestMethod.POST)
	public @ResponseBody InfraStructureBudget saveInfraStructureBudget(
			@RequestBody InfraStructureBudget facAcademic) {

		InfraStructureBudget facAcaRes = null;

		try {
			facAcaRes = infraStructureBudgetRepo.save(facAcademic);
		} catch (Exception e) {
			System.err.println("Exce in saving saveInfraStructureBudget " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}
	
	
	@RequestMapping(value = { "/getInfraStructureBudgetByFinYearId" }, method = RequestMethod.POST)
	public @ResponseBody InfraStructureBudget getInfraStructureBudgetByFinYearId(
			@RequestParam int curFinYear) {

		InfraStructureBudget facAcaRes = null;

		try {
			facAcaRes = infraStructureBudgetRepo.findByDelStatusAndIsActiveAndFinYearId(1, 1, curFinYear);
		} catch (Exception e) {
			System.err.println("Exce in  getInfraStructureBudgetByFinYearId " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}
	
	
	
	
	
	@RequestMapping(value = { "/getInfraStructureBudgetByInfraBudgetId" }, method = RequestMethod.POST)
	public @ResponseBody InfraStructureBudget getInfraStructureBudgetByInfraBudgetId(
			@RequestParam int infraBudgetId) {

		InfraStructureBudget facAcaRes = null;

		try {
			facAcaRes = infraStructureBudgetRepo.findByDelStatusAndIsActiveAndInfraBudgetId(1, 1, infraBudgetId);
		} catch (Exception e) {
			System.err.println("Exce in  getInfraStructureBudgetByInfraBudgetId " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}
	
	
	@RequestMapping(value = { "/getInfraStructureBudgetListByAcYearId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetInfraStructureBudget> getInfraStructureBudgetList(@RequestParam int instId, 
			@RequestParam int acYearId) {

		List<GetInfraStructureBudget>  budgetList= new ArrayList<GetInfraStructureBudget>();

		try {
			
			budgetList = getInfraStructureBudgetRepo.getInfraStructureBudgetList(instId, acYearId);
			
		} catch (Exception e) {
			System.err.println("Exce in  getInfraStructureBudgetListByAcYearId" + e.getMessage());
			e.printStackTrace();
		}

		return budgetList;
	}
	//deleteInfraBudget
	
	@RequestMapping(value = { "/deleteInfraBudget" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInfraBudget(@RequestParam List<String> infraBudgetIdList) {

		Info info = new Info();
		try {
			int res = infraStructureBudgetRepo.deleteInfraBudget(infraBudgetIdList);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteInstQualities  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	
	
	
	//Library Budget Start
	
	@RequestMapping(value = { "/getLibraryBudgetListByAcYearId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLibraryBudget> getLibraryBudgetListByAcYearId(@RequestParam int instId, 
			@RequestParam int acYearId) {

		List<GetLibraryBudget>  budgetList= new ArrayList<GetLibraryBudget>();

		try {
			
			budgetList = getLibraryBudgetRepo.getInfraStructureBudgetList(instId, acYearId);
			
		} catch (Exception e) {
			System.err.println("Exce in  getLibraryBudgetListByAcYearId" + e.getMessage());
			e.printStackTrace();
		}

		return budgetList;
	}
	
	
	
	@RequestMapping(value = { "/getLibBudgetByFinYearId" }, method = RequestMethod.POST)
	public @ResponseBody LibraryBudget getLibBudgetByFinYearId(
			@RequestParam int curFinYear) {

		LibraryBudget facAcaRes = null;

		try {
			facAcaRes = libraryBudgetRepo.findByDelStatusAndIsActiveAndFinYearId(1, 1, curFinYear);
		} catch (Exception e) {
			System.err.println("Exce in  getLibBudgetByFinYearId " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}
	
	
	@RequestMapping(value = { "/saveLibraryBudget" }, method = RequestMethod.POST)
	public @ResponseBody LibraryBudget saveLibraryBudget(
			@RequestBody LibraryBudget libBudget) {

		LibraryBudget libRes = null;

		try {
			libRes = libraryBudgetRepo.save(libBudget);
		} catch (Exception e) {
			System.err.println("Exce in saving saveLibraryBudget " + e.getMessage());
			e.printStackTrace();
		}

		return libRes;
	}
	
	@RequestMapping(value = { "/getLibBudgetByLibBudgetId" }, method = RequestMethod.POST)
	public @ResponseBody LibraryBudget getLibBudgetByLibBudgetId(
			@RequestParam int libBudgetId) {

		LibraryBudget facAcaRes = null;

		try {
			facAcaRes = libraryBudgetRepo.findByDelStatusAndIsActiveAndLibBudgetId(1, 1, libBudgetId);
		} catch (Exception e) {
			System.err.println("Exce in  getLibBudgetByLibBudgetId " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}

}
