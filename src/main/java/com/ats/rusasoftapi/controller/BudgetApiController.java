package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.budgetrepo.AcademicBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.GetAcademicBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.GetPhysicalFacilityBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.PhysicalFacilityBudgetRepo;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.budget.AcademicBudget;
import com.ats.rusasoftapi.model.budget.GetAcademicBudget;
import com.ats.rusasoftapi.model.budget.GetInfraStructureBudget;
import com.ats.rusasoftapi.model.budget.GetPhysicalFacilityBudget;
import com.ats.rusasoftapi.model.budget.InfraStructureBudget;
import com.ats.rusasoftapi.model.budget.PhysicalFacilityBudget;

@RestController
public class BudgetApiController {
	@Autowired
	PhysicalFacilityBudgetRepo physicalFacilityBudgetRepo;

	@Autowired
	AcademicBudgetRepo academicBudgetRepo;

	@Autowired
	GetAcademicBudgetRepo getAcademicBudgetRepo;

	@Autowired
	GetPhysicalFacilityBudgetRepo getPhysicalFacilityBudgetRepo;

	@RequestMapping(value = { "/saveAcademicBudget" }, method = RequestMethod.POST)
	public @ResponseBody AcademicBudget saveAcademicBudget(@RequestBody AcademicBudget academicBudget) {

		AcademicBudget facAcaRes = null;

		try {
			facAcaRes = academicBudgetRepo.save(academicBudget);
		} catch (Exception e) {
			System.err.println("Exce in saving savePhysicalFacilityBudget " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}

	@RequestMapping(value = { "/getAcademicBudgetByFinYearId" }, method = RequestMethod.POST)
	public @ResponseBody AcademicBudget getAcademicBudgetByFinYearId(@RequestParam int curFinYear,
			@RequestParam int instituteId) {

		AcademicBudget facAcaRes = null;

		try {
			facAcaRes = academicBudgetRepo.findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(1, 1, curFinYear,
					instituteId);
		} catch (Exception e) {
			System.err.println("Exce in  getAcademicBudgetByFinYearId " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}

	@RequestMapping(value = { "/getAcademicBudgetListByAcYearId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAcademicBudget> getAcademicBudgetListByAcYearId(@RequestParam int instId,
			@RequestParam int acYearId) {

		List<GetAcademicBudget> budgetList = new ArrayList<GetAcademicBudget>();

		try {

			budgetList = getAcademicBudgetRepo.getBudgetList(instId, acYearId);

		} catch (Exception e) {
			System.err.println("Exce in  getPhysicalBudgetListByAcYearId" + e.getMessage());
			e.printStackTrace();
		}

		return budgetList;
	}

	@RequestMapping(value = { "/getAcademicBudgetById" }, method = RequestMethod.POST)
	public @ResponseBody AcademicBudget getAcademicBudgetById(@RequestParam int academicBudgetId) {

		AcademicBudget facAcaRes = null;

		try {
			facAcaRes = academicBudgetRepo.findByDelStatusAndIsActiveAndAcademicBudgetId(1, 1, academicBudgetId);
		} catch (Exception e) {
			System.err.println("Exce in  getphysicalFacilityBudgetByFinYearId " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}

	@RequestMapping(value = { "/deleteAcademicBudget" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAcademicBudget(@RequestParam List<String> academicIdList) {

		Info info = new Info();
		try {
			int res = academicBudgetRepo.deleteAcademic(academicIdList);
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
	public @ResponseBody PhysicalFacilityBudget getphysicalFacilityBudgetByFinYearId(@RequestParam int curFinYear,
			@RequestParam int instituteId) {

		PhysicalFacilityBudget facAcaRes = null;

		try {
			facAcaRes = physicalFacilityBudgetRepo.findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(1, 1,
					curFinYear, instituteId);
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
