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

import com.ats.rusasoftapi.budgetrepo.FinancialYearRepo;
import com.ats.rusasoftapi.budgetrepo.GetInfraStructureBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.GetLibraryBookBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.GetLibraryBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.GetWasteMngtBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.InfraStructureBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.LibraryBookBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.LibraryBudgetRepo;
import com.ats.rusasoftapi.budgetrepo.WasteMngtBudgetRepo;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.budget.FinancialYear;
import com.ats.rusasoftapi.model.budget.GetInfraStructureBudget;
import com.ats.rusasoftapi.model.budget.GetLibraryBookBudget;
import com.ats.rusasoftapi.model.budget.GetLibraryBudget;
import com.ats.rusasoftapi.model.budget.GetWasteMngtBudget;
import com.ats.rusasoftapi.model.budget.InfraStructureBudget;
import com.ats.rusasoftapi.model.budget.LibraryBookBudget;
import com.ats.rusasoftapi.model.budget.LibraryBudget;
import com.ats.rusasoftapi.model.budget.WasteMngtBudget;

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
			@RequestParam int curFinYear,@RequestParam int instId) {

		InfraStructureBudget facAcaRes = null;

		try {
			facAcaRes = infraStructureBudgetRepo.findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(1, 1, curFinYear, instId);
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
			@RequestParam int curFinYear, @RequestParam int instId) {

		LibraryBudget facAcaRes = null;

		try {
			facAcaRes = libraryBudgetRepo.findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(1,1,curFinYear,instId);
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
	
	//deleteLibBudget
	
	@RequestMapping(value = { "/deleteLibBudget" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLibBudget(@RequestParam List<String> libBudgetIdList) {

		Info info = new Info();
		try {
			int res = libraryBudgetRepo.deleteLibBudget(libBudgetIdList);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteLibBudget  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	@Autowired WasteMngtBudgetRepo wasteMngtBudgetRepo;
	@Autowired GetWasteMngtBudgetRepo getWasteMngtBudgetRepo;
	
	//waste Budget Start A
	
		@RequestMapping(value = { "/getWasteMngtBudgetListByAcYearId" }, method = RequestMethod.POST)
		public @ResponseBody List<GetWasteMngtBudget> getWasteMngtBudgetListByAcYearId(@RequestParam int instId, 
				@RequestParam int acYearId) {

			List<GetWasteMngtBudget>  budgetList= new ArrayList<GetWasteMngtBudget>();

			try {
				
				budgetList = getWasteMngtBudgetRepo.getWasteMngtBudgetList(instId, acYearId);
				
			} catch (Exception e) {
				System.err.println("Exce in  getWasteMngtBudgetListByAcYearId" + e.getMessage());
				e.printStackTrace();
			}

			return budgetList;
		}
		
		//B
		
		 @RequestMapping(value = { "/getWasteMngtBudgetByFinYearId" }, method = RequestMethod.POST)
		public @ResponseBody WasteMngtBudget getWasteMngtBudgetByFinYearId(
				@RequestParam int curFinYear,@RequestParam int instId) {

			WasteMngtBudget budgetRes = null;

			try {
				budgetRes = wasteMngtBudgetRepo.findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(1, 1, curFinYear,instId);
			} catch (Exception e) {
				System.err.println("Exce in  getWasteMngtBudgetByFinYearId " + e.getMessage());
				e.printStackTrace();
			}

			return budgetRes;
		}
		
		//C
		@RequestMapping(value = { "/saveWasteMngtBudget" }, method = RequestMethod.POST)
		public @ResponseBody WasteMngtBudget saveWasteMngtBudget(
				@RequestBody WasteMngtBudget budget) {

			WasteMngtBudget budgetRes = null;

			try {
				budgetRes = wasteMngtBudgetRepo.save(budget);
			} catch (Exception e) {
				System.err.println("Exce in saving saveWasteMngtBudget " + e.getMessage());
				e.printStackTrace();
			}

			return budgetRes;
		}
		//D
		@RequestMapping(value = { "/getWasteMngtBudgetBywasteMngtBudgetId" }, method = RequestMethod.POST)
		public @ResponseBody WasteMngtBudget getWasteMngtBudgetBywasteMngtBudgetId(
				@RequestParam int wasteMngtBudgetId) {

			WasteMngtBudget budgetRes = null;

			try {
				budgetRes = wasteMngtBudgetRepo.findByDelStatusAndIsActiveAndWasteMngtBudgetId(1, 1, wasteMngtBudgetId);
			} catch (Exception e) {
				System.err.println("Exce in  getWasteMngtBudgetBywasteMngtBudgetId " + e.getMessage());
				e.printStackTrace();
			}

			return budgetRes;
		}
		
		//deleteLibBudget
		//E
		@RequestMapping(value = { "/deleteWasteMngtBudget" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteWasteMngtBudget(@RequestParam List<String> wasteMngtBudgetIdList) {

			Info info = new Info();
			try {
				int res = wasteMngtBudgetRepo.deleteWasteMngtBudget(wasteMngtBudgetIdList);
				if (res > 0) {
					info.setError(false);
					info.setMsg("success");
				} else {
					info.setError(true);
					info.setMsg("failed");
				}
			} catch (Exception e) {

				System.err.println("Exce in deleteWasteMngtBudget  " + e.getMessage());
				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

			return info;
		}
//waste Budget End
		
		
		
		
		//For Harsha
		//LB Budget Start A
		
		@Autowired LibraryBookBudgetRepo libraryBookBudgetRepo;
		@Autowired GetLibraryBookBudgetRepo getLibraryBookBudgetRepo;
		
			@RequestMapping(value = { "/getLibraryBookBudgetListByAcYearId" }, method = RequestMethod.POST)
			public @ResponseBody List<GetLibraryBookBudget> getLibraryBookBudgetListByAcYearId(@RequestParam int instId, 
					@RequestParam int acYearId) {

				List<GetLibraryBookBudget>  budgetList= new ArrayList<GetLibraryBookBudget>();

				try {
					
					budgetList = getLibraryBookBudgetRepo.getLibraryBookBudgetList(instId, acYearId);
					
				} catch (Exception e) {
					System.err.println("Exce in  getWasteMngtBudgetListByAcYearId" + e.getMessage());
					e.printStackTrace();
				}

				return budgetList;
			}
			
			//B
			
			 @RequestMapping(value = { "/getLibBoookBudgetByFinYearId" }, method = RequestMethod.POST)
			public @ResponseBody LibraryBookBudget getLibBoookBudgetByFinYearId(
					@RequestParam int curFinYear,@RequestParam int instId) {

				 LibraryBookBudget budgetRes = null;

				try {
					budgetRes = libraryBookBudgetRepo.findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(1, 1, curFinYear, instId);
				} catch (Exception e) {
					System.err.println("Exce in  getWasteMngtBudgetByFinYearId " + e.getMessage());
					e.printStackTrace();
				}

				return budgetRes;
			}
			
			//C
			@RequestMapping(value = { "/saveLibBookBudget" }, method = RequestMethod.POST)
			public @ResponseBody LibraryBookBudget saveLibBookBudget(
					@RequestBody LibraryBookBudget budget) {

				LibraryBookBudget budgetRes = null;

				try {
					budgetRes = libraryBookBudgetRepo.save(budget);
				} catch (Exception e) {
					System.err.println("Exce in saving saveLibBookBudget " + e.getMessage());
					e.printStackTrace();
				}

				return budgetRes;
			}
			//D
			@RequestMapping(value = { "/getLibBookBudgetByLibBookBudgetId" }, method = RequestMethod.POST)
			public @ResponseBody LibraryBookBudget getLibBookBudgetByLibBookBudgetId(
					@RequestParam int libraryBookBudgetId) {

				LibraryBookBudget budgetRes = null;

				try {
					budgetRes = libraryBookBudgetRepo.findByDelStatusAndIsActiveAndLibraryBookBudgetId(1, 1, libraryBookBudgetId);
				} catch (Exception e) {
					System.err.println("Exce in  getWasteMngtBudgetBywasteMngtBudgetId " + e.getMessage());
					e.printStackTrace();
				}

				return budgetRes;
			}
			
			//deleteLibBookBudget
			//E
			@RequestMapping(value = { "/deleteLibBookBudget" }, method = RequestMethod.POST)
			public @ResponseBody Info deleteLibBookBudget(@RequestParam List<String> libBookBudgetIdList) {
					System.err.println("libBookBudgetIdList"+libBookBudgetIdList.toString());
				Info info = new Info();
				try {
					int res = libraryBookBudgetRepo.deleteLibBookBudget(libBookBudgetIdList);
					if (res > 0) {
						info.setError(false);
						info.setMsg("success");
					} else {
						info.setError(true);
						info.setMsg("failed");
					}
				} catch (Exception e) {

					System.err.println("Exce in deleteLibBookBudget  " + e.getMessage());
					e.printStackTrace();
					info.setError(true);
					info.setMsg("excep");
				}

				return info;
			}
	//waste Budget End
}
