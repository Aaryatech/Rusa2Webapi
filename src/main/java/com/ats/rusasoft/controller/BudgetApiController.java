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

import com.ats.rusasoft.budgetrepo.GetPhysicalFacilityBudgetRepo;
import com.ats.rusasoft.budgetrepo.PhysicalFacilityBudgetRepo;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.budget.GetInfraStructureBudget;
import com.ats.rusasoft.model.budget.GetPhysicalFacilityBudget;
import com.ats.rusasoft.model.budget.InfraStructureBudget;
import com.ats.rusasoft.model.budget.PhysicalFacilityBudget;

@RestController
public class BudgetApiController {
	@Autowired
	PhysicalFacilityBudgetRepo physicalFacilityBudgetRepo;

	@Autowired
	GetPhysicalFacilityBudgetRepo getPhysicalFacilityBudgetRepo;

	@RequestMapping(value = { "/savePhysicalFacilityBudget" }, method = RequestMethod.POST)
	public @ResponseBody PhysicalFacilityBudget savePhysicalFacilityBudget(
			@RequestBody PhysicalFacilityBudget physicalFacilityBudget) {

		PhysicalFacilityBudget facAcaRes = null;

		try {
			facAcaRes = physicalFacilityBudgetRepo.save(physicalFacilityBudget);
		} catch (Exception e) {
			System.err.println("Exce in saving savePhysicalFacilityBudget " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}

	@RequestMapping(value = { "/getphysicalFacilityBudgetByFinYearId" }, method = RequestMethod.POST)
	public @ResponseBody PhysicalFacilityBudget getphysicalFacilityBudgetByFinYearId(@RequestParam int curFinYear) {

		PhysicalFacilityBudget facAcaRes = null;

		try {
			facAcaRes = physicalFacilityBudgetRepo.findByDelStatusAndIsActiveAndFinYearId(1, 1, curFinYear);
		} catch (Exception e) {
			System.err.println("Exce in  getphysicalFacilityBudgetByFinYearId " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}

	@RequestMapping(value = { "/getphysicalFacilityBudgetById" }, method = RequestMethod.POST)
	public @ResponseBody PhysicalFacilityBudget getphysicalFacilityBudgetById(
			@RequestParam int physicalFacilityBudgetId) {

		PhysicalFacilityBudget facAcaRes = null;

		try {
			facAcaRes = physicalFacilityBudgetRepo.findByDelStatusAndIsActiveAndPhysicalFacilityBudgetId(1, 1,
					physicalFacilityBudgetId);
		} catch (Exception e) {
			System.err.println("Exce in  getphysicalFacilityBudgetByFinYearId " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}

	@RequestMapping(value = { "/getPhysicalBudgetListByAcYearId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPhysicalFacilityBudget> getPhysicalBudgetListByAcYearId(@RequestParam int instId,
			@RequestParam int acYearId) {

		List<GetPhysicalFacilityBudget> budgetList = new ArrayList<GetPhysicalFacilityBudget>();

		try {

			budgetList = getPhysicalFacilityBudgetRepo.getBudgetList(instId, acYearId);

		} catch (Exception e) {
			System.err.println("Exce in  getPhysicalBudgetListByAcYearId" + e.getMessage());
			e.printStackTrace();
		}

		return budgetList;
	}

	@RequestMapping(value = { "/deletePhysicalFacilityBudget" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePhysicalFacilityBudget(@RequestParam List<String> phyBudgetIdList) {

		Info info = new Info();
		try {
			int res = physicalFacilityBudgetRepo.deletePhysicalBud(phyBudgetIdList);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in physicalFacilityBudgetRepo  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

}
