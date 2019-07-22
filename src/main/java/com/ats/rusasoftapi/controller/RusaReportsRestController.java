package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.graph.model.BudgetGraphDash;
import com.ats.rusasoftapi.graph.model.DashBoardCounts;
import com.ats.rusasoftapi.graph.model.GetCountsForDash;
import com.ats.rusasoftapi.graphrepo.TempDashBoardGraphRepo;
import com.ats.rusasoftapi.model.AcademicYear;
import com.ats.rusasoftapi.model.SettingKeyValue;
import com.ats.rusasoftapi.model.instprofile.InstStakeholderFeedback;
import com.ats.rusasoftapi.model.report.AvgPerPlacement;
import com.ats.rusasoftapi.model.report.AwrdRecgAgnstExtActivityReport;
import com.ats.rusasoftapi.model.report.BudgetInfraAugmntn;
import com.ats.rusasoftapi.model.report.DifferentlyAbldStudReport;
import com.ats.rusasoftapi.model.report.EContntDevFacReport;
import com.ats.rusasoftapi.model.report.ExpenditureOnPrchaseBooksJournal;
import com.ats.rusasoftapi.model.report.ExpndGreenInitveWsteMgmt;
import com.ats.rusasoftapi.model.report.ExpndturOnPhysclAcademicSupprt;
import com.ats.rusasoftapi.model.report.FacAgnstSanctnPost;
import com.ats.rusasoftapi.model.report.FacAgnstSanctnPostOthrState;
import com.ats.rusasoftapi.model.report.FildeProjectInternReport;
import com.ats.rusasoftapi.model.report.FulTimFacultyWithPhd;
import com.ats.rusasoftapi.model.report.FullTimeTechrInstResrchGuide;
import com.ats.rusasoftapi.model.report.FunctionalMou;
import com.ats.rusasoftapi.model.report.ICtEnbldFaclitiesReport;
import com.ats.rusasoftapi.model.report.InitivAddrsLoctnAdvDisadv;
import com.ats.rusasoftapi.model.report.InstStakeholderFeedbackReport;
import com.ats.rusasoftapi.model.report.IntelectulPropRightReport;
import com.ats.rusasoftapi.model.report.IntrnetConnInfo;
import com.ats.rusasoftapi.model.report.NoAwardRecogExtAct;
import com.ats.rusasoftapi.model.report.NoInitivAddrsLoctnAdvDisadv;
import com.ats.rusasoftapi.model.report.NoOfLinkages;
import com.ats.rusasoftapi.model.report.PerNewCource;
import com.ats.rusasoftapi.model.report.PerProgCbseElectiveCourse;
import com.ats.rusasoftapi.model.report.ProgSanctnIntake;
import com.ats.rusasoftapi.model.report.ProgTypStudPlacedGraph;
import com.ats.rusasoftapi.model.report.ResrchProjectGrants;
import com.ats.rusasoftapi.model.report.StudCompRatioReport;
import com.ats.rusasoftapi.model.report.StudPrfrmInFinlYr;
import com.ats.rusasoftapi.model.report.StudProgression;
import com.ats.rusasoftapi.model.report.StudTeachrRatio;
import com.ats.rusasoftapi.model.report.TeacExpFullTimFac;
import com.ats.rusasoftapi.model.report.TeacherAwardRecognitn;
import com.ats.rusasoftapi.model.report.TechrResrchPaprJournlInfo;
import com.ats.rusasoftapi.model.report.TechrResrchPaprJournlRatio;
import com.ats.rusasoftapi.mstrepo.AcademicYearRepo;
import com.ats.rusasoftapi.mstrepo.DifferentlyAbldStudReportRepo;
import com.ats.rusasoftapi.mstrepo.SettingKeyValueRepo;
import com.ats.rusasoftapi.repo.faculty.TechrResrchPaprJournlRatioRepo;
import com.ats.rusasoftapi.reportrepo.AdmsnAgnstResrvCatRepo;
import com.ats.rusasoftapi.reportrepo.AvgPerPlacementRepo;
import com.ats.rusasoftapi.reportrepo.AwrdRecgAgnstExtActivityReportRepo;
import com.ats.rusasoftapi.reportrepo.BudgetInfraAugmntnRepo;
import com.ats.rusasoftapi.reportrepo.EContntDevFacReportRepo;
import com.ats.rusasoftapi.reportrepo.ExpenditureOnPrchaseBooksJournalRepo;
import com.ats.rusasoftapi.reportrepo.ExpndGreenInitveWsteMgmtRepo;
import com.ats.rusasoftapi.reportrepo.ExpndturOnPhysclAcademicSupprtRepo;
import com.ats.rusasoftapi.reportrepo.FildeProjectInternReportRepo;
import com.ats.rusasoftapi.reportrepo.FulTimFacultyWithPhdRepo;
import com.ats.rusasoftapi.reportrepo.FullTimeTechrInstResrchGuideRepo;
import com.ats.rusasoftapi.reportrepo.FunctionalMouRepo;
import com.ats.rusasoftapi.reportrepo.ICtEnbldFaclitiesReportRepo;
import com.ats.rusasoftapi.reportrepo.InitivAddrsLoctnAdvDisadvRepo;
import com.ats.rusasoftapi.reportrepo.InstStakeholderFeedbackReportRepo;
import com.ats.rusasoftapi.reportrepo.IntelectulPropRightReportRepo;
import com.ats.rusasoftapi.reportrepo.IntrnetConnInfoRepo;
import com.ats.rusasoftapi.reportrepo.NoAwardRecogExtActRepo;
import com.ats.rusasoftapi.reportrepo.NoInitivAddrsLoctnAdvDisadvRepo;
import com.ats.rusasoftapi.reportrepo.NoOfLinkagesRepo;
import com.ats.rusasoftapi.reportrepo.PerNewCourceRepo;
import com.ats.rusasoftapi.reportrepo.PerProgCbseElectiveCourseRepo;
import com.ats.rusasoftapi.reportrepo.ProgSanctnIntakeRepo;
import com.ats.rusasoftapi.reportrepo.ProgTypStudPlacedGraphRepo;
import com.ats.rusasoftapi.reportrepo.ResrchProjectGrantsRepo;
import com.ats.rusasoftapi.reportrepo.StudCompRatioReportRepo;
import com.ats.rusasoftapi.reportrepo.StudPrfrmInFinlYrRepo;
import com.ats.rusasoftapi.reportrepo.StudProgressionRepo;
import com.ats.rusasoftapi.reportrepo.StudSupprtSchemGraphRepo;
import com.ats.rusasoftapi.reportrepo.TeacExpFullTimFacRepo;
import com.ats.rusasoftapi.reportrepo.TeacherAwardRecognitnRepo;
import com.ats.rusasoftapi.reportrepo.TechrResrchPaprJournlInfoRepo;
import com.ats.rusasoftapi.repository.FacAgnstSanctnPostOthrStateRepo;
import com.ats.rusasoftapi.repository.FacAgnstSanctnPostRepo;
import com.ats.rusasoftapi.model.report.StudSupprtSchemGraph;

@RestController
public class RusaReportsRestController {
	@Autowired SettingKeyValueRepo settingKeyValueRepo;
	
	@Autowired AcademicYearRepo academicYearRepo;
	
 	@Autowired StudTeachrRatioRepo studTeachRepo;

 	@RequestMapping(value = { "/getStudTeachrRatioList" }, method = RequestMethod.POST)
	public @ResponseBody List<StudTeachrRatio> getStudTeachrRatioList(@RequestParam int instId,
			@RequestParam int acYear) {
 		List<StudTeachrRatio> ratioList = new ArrayList<StudTeachrRatio>();
 		try {
 			ratioList = studTeachRepo.getAllStudentTeacherRatioData(instId, acYear);
 			System.err.println("List="+ratioList);
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return ratioList;
 	}
 	
 	
 	@Autowired DifferentlyAbldStudReportRepo difStudRepo;
 	@RequestMapping(value = { "/getDifferntlyAbldStudList" }, method = RequestMethod.POST)
	public @ResponseBody List<DifferentlyAbldStudReport> getDifferntlyAbldStudList(@RequestParam int instId,
			@RequestParam int acYear) {
 		List<DifferentlyAbldStudReport> studList = new ArrayList<DifferentlyAbldStudReport>();
 		SettingKeyValue setKey=new SettingKeyValue();
 		try {
 			setKey=settingKeyValueRepo.findBySettingKeyAndDelStatus("Divyanjan",1);
			System.err.println("stk ids :"+setKey.toString());
			int stkId=setKey.getIntValue();
			 			
			studList = difStudRepo.getAllDifferentlyAbledStud(instId, acYear, stkId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return studList;
 	}
	
 	@Autowired FacAgnstSanctnPostRepo facRepo;
	@RequestMapping(value = { "/getFacAgnstSanctnPostList" }, method = RequestMethod.POST)
	public @ResponseBody List<FacAgnstSanctnPost> getFacAgnstSanctnPostList(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 	
		List<FacAgnstSanctnPost> postList = new ArrayList<FacAgnstSanctnPost>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			postList = facRepo.getAllFacAgnstSanctnPost(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return postList;
 	}
	
	
	@Autowired FacAgnstSanctnPostOthrStateRepo facOthrStateRepo;
 	@RequestMapping(value = { "/getFacultyAgnstSanctionPostOthrState" }, method = RequestMethod.POST)
	public @ResponseBody List<FacAgnstSanctnPostOthrState> getFacultyAgnstSanctionPostOthrState(@RequestParam int instId,
			@RequestParam int acYear) {
 		List<FacAgnstSanctnPostOthrState> facList = new ArrayList<FacAgnstSanctnPostOthrState>(); 		
 		try {
 						 			
			facList = facOthrStateRepo.getAllFacultyAgnstSanctionPostOthrState(instId, acYear);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return facList;
 	}
	
 	@Autowired TeacExpFullTimFacRepo facEpRepo;
	@RequestMapping(value = { "/getTeachingExpOfFillTimFac" }, method = RequestMethod.POST)
	public @ResponseBody List<TeacExpFullTimFac> getTeachingExpOfFillTimFac(@RequestParam int instId) {
 		List<TeacExpFullTimFac> facExpList = new ArrayList<TeacExpFullTimFac>();
 		try {
 			facExpList = facEpRepo.getAllTeachingExpOfFillTimFac(instId);
 			System.err.println("List="+facExpList);
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return facExpList;
 	}
	
	@Autowired FulTimFacultyWithPhdRepo facultyPhdRepo; 
	@RequestMapping(value = { "/getFulTimFacAvalblePhd" }, method = RequestMethod.POST)
	public @ResponseBody List<FulTimFacultyWithPhd> getFulTimFacAvalblePhd(@RequestParam int instId) {
 		List<FulTimFacultyWithPhd> phdFacList = new ArrayList<FulTimFacultyWithPhd>();
 		
 		SettingKeyValue setKey=new SettingKeyValue();
 		
 		try {
 			
 			setKey=settingKeyValueRepo.findBySettingKeyAndDelStatus("QlifPhd",1);
			System.err.println("stk ids :"+setKey.toString());
			int stkId=setKey.getIntValue();
 			
 			phdFacList = facultyPhdRepo.getAllFulTimFacAvalblePhd(stkId, instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return phdFacList;
 	}
	
	/*
	 * @Autowired AdmsnAgnstResrvCatRepo admRepo;
	 * 
	 * @RequestMapping(value = { "/getAdmisionAgnstResrvCat" }, method =
	 * RequestMethod.POST) public @ResponseBody List<AdmsnAgnstResrvCat>
	 * getAdmisionAgnstResrvCat(@RequestParam int instId,
	 * 
	 * @RequestParam List<String> acYearList) { List<AdmsnAgnstResrvCat> admList =
	 * new ArrayList<AdmsnAgnstResrvCat>(); List<AcademicYear> acYrList = new
	 * ArrayList<>();
	 * 
	 * try { List<Integer> lastFiveYears=new ArrayList<>();
	 * 
	 * if (acYearList.contains("-5")) { System.err.println("in -5"); acYrList
	 * =academicYearRepo.getLastFiveYears(); for (int i = 0; i < acYrList.size();
	 * i++) { System.err.println("acYrList" +acYrList.get(i).toString());
	 * lastFiveYears.add(acYrList.get(i).getYearId()); }
	 * System.err.println("new id list" + acYearList.toString()); }else {
	 * System.err.println("in else ");
	 * lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
	 * 
	 * } admList = admRepo.getAllAdmisionAgnstResrvCat(instId, lastFiveYears);
	 * 
	 * }catch(Exception e) { System.err.println(e.getMessage()); } return admList; }
	 */
	
	
	@Autowired StudPrfrmInFinlYrRepo studPerformRepo;
	@RequestMapping(value = { "/getStudPerformInFinalYear" }, method = RequestMethod.POST)
	public @ResponseBody List<StudPrfrmInFinlYr> getStudPerformInFinalYear(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 		List<StudPrfrmInFinlYr> studPerfrmncList = new ArrayList<StudPrfrmInFinlYr>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			 List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			}   
 			
 			studPerfrmncList = studPerformRepo.getAllStudPerformInFinalYear(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return studPerfrmncList;
 	}
	
	
	
	@Autowired ICtEnbldFaclitiesReportRepo ictFacRepo;
	@RequestMapping(value = { "/getICTEnbldFaclties" }, method = RequestMethod.POST)
	public @ResponseBody List<ICtEnbldFaclitiesReport> getICTEnbldFaclties(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 		List<ICtEnbldFaclitiesReport> ictFacList = new ArrayList<ICtEnbldFaclitiesReport>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			 List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 
			}  else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			System.err.println("id list" + acYearList.toString());
 			ictFacList = ictFacRepo.getAllICTEnbldFaclties(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return ictFacList;
 	}
	
	
	
	@Autowired BudgetInfraAugmntnRepo budgtInfraAugRepo;
	@RequestMapping(value = { "/getBudgetInfraAugmentn" }, method = RequestMethod.POST)
	public @ResponseBody List<BudgetInfraAugmntn> getBudgetInfraAugmentn(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 		List<BudgetInfraAugmntn> budgtInfraList = new ArrayList<BudgetInfraAugmntn>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
			}  
 			System.err.println("id list" + acYearList.toString());
 			budgtInfraList = budgtInfraAugRepo.getAllBudgetInfraAugmentn(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return budgtInfraList;
 	}
	
	@Autowired ExpenditureOnPrchaseBooksJournalRepo bookExpdRepo;
	@RequestMapping(value = { "/getExpenditureOnPrchaseBooksJournal" }, method = RequestMethod.POST)
	public @ResponseBody List<ExpenditureOnPrchaseBooksJournal> getExpenditureOnPrchaseBooksJournal(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 		List<ExpenditureOnPrchaseBooksJournal> bookExpdList = new ArrayList<ExpenditureOnPrchaseBooksJournal>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			System.err.println("id list" + acYearList.toString());
 			bookExpdList = bookExpdRepo.getAllExpenditureOnPrchaseBooksJournal(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return bookExpdList;
 	}
	
	@Autowired StudCompRatioReportRepo studCompRepo;
	@RequestMapping(value = { "/getStudentCompterRatio" }, method = RequestMethod.POST)
	public @ResponseBody List<StudCompRatioReport> getStudentCompterRatio(@RequestParam int instId) {
 		List<StudCompRatioReport> compList = new ArrayList<StudCompRatioReport>();
 		 		
 		try {
 			
 			compList = studCompRepo.getAllStudentCompterRatio(instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return compList;
 	}
	
	@Autowired EContntDevFacReportRepo eContRepo;
	@RequestMapping(value = { "/getEContntDevFac" }, method = RequestMethod.POST)
	public @ResponseBody List<EContntDevFacReport> getEContntDevFac(@RequestParam int instId,@RequestParam String eContFacility) {
 		List<EContntDevFacReport> eContDevList = new ArrayList<EContntDevFacReport>();
 		 		
 		try {
 			
 			eContDevList = eContRepo.getAllEContntDevFac(instId, eContFacility);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return eContDevList;
 	}
	
	@Autowired IntrnetConnInfoRepo intrntRepo;
	@RequestMapping(value = { "/getInternetConnInfo" }, method = RequestMethod.POST)
	public @ResponseBody List<IntrnetConnInfo> getInternetConnInfo(@RequestParam int instId,@RequestParam int ac_year) {
 		List<IntrnetConnInfo> intrntConList = new ArrayList<IntrnetConnInfo>();
 		 		
 		try { 			
 			intrntConList = intrntRepo.getAllInternetConnInfo(instId, ac_year);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return intrntConList;
 	}
	
	@Autowired ExpndturOnPhysclAcademicSupprtRepo expdRepo;
	
	@RequestMapping(value = { "/getExpndPhyAcdSupprtFacilities" }, method = RequestMethod.POST)
	public @ResponseBody List<ExpndturOnPhysclAcademicSupprt> getExpndPhyAcdSupprtFacilities(@RequestParam int instId) {
 		List<ExpndturOnPhysclAcademicSupprt> expndList = new ArrayList<ExpndturOnPhysclAcademicSupprt>();
 		 		
 		try {
 			
 			expndList = expdRepo.getAllExpndPhyAcdSupprtFacilities(instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return expndList;
 	}
	
	@Autowired ExpndGreenInitveWsteMgmtRepo expndInitvRepo;
	@RequestMapping(value = { "/getExpndGreenInitveWsteMgmt" }, method = RequestMethod.POST)
	public @ResponseBody List<ExpndGreenInitveWsteMgmt> getExpndGreenInitveWsteMgmt(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 		List<ExpndGreenInitveWsteMgmt> expndGrnInitveList = new ArrayList<ExpndGreenInitveWsteMgmt>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			}  
 			System.err.println("year list" + acYearList.toString());
 			expndGrnInitveList = expndInitvRepo.getAllExpndGreenInitveWsteMgmt(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return expndGrnInitveList;
 	}
	
	@Autowired InitivAddrsLoctnAdvDisadvRepo initivRepo;
	@RequestMapping(value = { "/getInitivAddrsLoctnAdvDisadv" }, method = RequestMethod.POST)
	public @ResponseBody List<InitivAddrsLoctnAdvDisadv> getInitivAddrsLoctnAdvDisadv(@RequestParam int instId,
			@RequestParam int acYearId ) {
 		List<InitivAddrsLoctnAdvDisadv> initiaveList = new ArrayList<InitivAddrsLoctnAdvDisadv>();
 		 		
 		try {
 			
 			initiaveList = initivRepo.getAllInitivAddrsLoctnAdvDisadv(instId, acYearId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return initiaveList;
 	}
	
	@Autowired NoInitivAddrsLoctnAdvDisadvRepo noInitivRepo;
	@RequestMapping(value = { "/getNoInitivAddrsLoctnAdvDisadv" }, method = RequestMethod.POST)
	public @ResponseBody List<NoInitivAddrsLoctnAdvDisadv> getNoInitivAddrsLoctnAdvDisadv(@RequestParam int instId) {
 		List<NoInitivAddrsLoctnAdvDisadv> noInitiaveList = new ArrayList<NoInitivAddrsLoctnAdvDisadv>();
 		 		
 		try {
 			
 			noInitiaveList = noInitivRepo.getAllNoInitivAddrsLoctnAdvDisadvRepo(instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return noInitiaveList;
 	}
	
	@Autowired NoOfLinkagesRepo linkRepo;
	@RequestMapping(value = { "/getNoOfLinkages" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfLinkages> getNoOfLinkages(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 	
		List<NoOfLinkages> linkList = new ArrayList<NoOfLinkages>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			linkList = linkRepo.getAllNoOfLinkages(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return linkList;
 	}
	
	@Autowired FunctionalMouRepo mouRepo;
	@RequestMapping(value = { "/getFunctnlMou" }, method = RequestMethod.POST)
	public @ResponseBody List<FunctionalMou> getFunctnlMou(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 	
		List<FunctionalMou> mouList = new ArrayList<FunctionalMou>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			mouList = mouRepo.getAllFunctnlMou(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return mouList;
 	}
	
	@Autowired AwrdRecgAgnstExtActivityReportRepo awardRepo;
	@RequestMapping(value = { "/getAwardRecog" }, method = RequestMethod.POST)
	public @ResponseBody List<AwrdRecgAgnstExtActivityReport> getAwardRecog(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 	
		List<AwrdRecgAgnstExtActivityReport> awrdList = new ArrayList<AwrdRecgAgnstExtActivityReport>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			awrdList = awardRepo.getAllAwardRecog(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return awrdList;
 	}
	
	
	
	@Autowired NoAwardRecogExtActRepo noAwardRepo;
	@RequestMapping(value = { "/getNoAwardRecogExtAct" }, method = RequestMethod.POST)
	public @ResponseBody List<NoAwardRecogExtAct> getNoAwardRecogExtAct(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 	
		List<NoAwardRecogExtAct> awrdList = new ArrayList<NoAwardRecogExtAct>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			awrdList = noAwardRepo.getAllNoAwardRecogExtAct(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return awrdList;
 	}
	
	@Autowired IntelectulPropRightReportRepo intelPropRepo;
	@RequestMapping(value = { "/getIntelPropRght" }, method = RequestMethod.POST)
	public @ResponseBody List<IntelectulPropRightReport> getIntelPropRght(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 	
		List<IntelectulPropRightReport> awrdList = new ArrayList<IntelectulPropRightReport>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			awrdList = intelPropRepo.getAllIntelPropRght(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return awrdList;
 	}
	
	
	@Autowired AvgPerPlacementRepo studPlaceRepo;
	@RequestMapping(value = { "/getAvgPerPlacement" }, method = RequestMethod.POST)
	public @ResponseBody List<AvgPerPlacement> getAvgPerPlacement(@RequestParam int instId,
			@RequestParam List<String> acYearList,@RequestParam String prgName) {
 	
		List<AvgPerPlacement> studPlaceList = new ArrayList<AvgPerPlacement>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			studPlaceList = studPlaceRepo.getAllAvgPerPlacement(instId, lastFiveYears, prgName);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return studPlaceList;
 	}
	
	@Autowired StudProgressionRepo studProgRepo;
	@RequestMapping(value = { "/getStudProgression" }, method = RequestMethod.POST)
	public @ResponseBody List<StudProgression> getStudProgression(@RequestParam int instId, @RequestParam int acYear) {
 		List<StudProgression> studProgList = new ArrayList<StudProgression>();
 		 		
 		try {
 			
 			studProgList = studProgRepo.getAllStudProgression(instId, acYear);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return studProgList;
 	}
	
	@Autowired TeacherAwardRecognitnRepo techrAwrdRepo;
	@RequestMapping(value = { "/getTeacherAwardRecognitn" }, method = RequestMethod.POST)
	public @ResponseBody List<TeacherAwardRecognitn> getTeacherAwardRecognitn(@RequestParam int instId, @RequestParam int acYear) {
 		List<TeacherAwardRecognitn> tchrAwrdList = new ArrayList<TeacherAwardRecognitn>();
 		 		
 		try {
 			
 			tchrAwrdList = techrAwrdRepo.getAllTeacherAwardRecognitn(acYear, instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return tchrAwrdList;
 	}
	
	@Autowired TechrResrchPaprJournlInfoRepo techrResrchRepo;
	@RequestMapping(value = { "/getTechrResrchPaprJournlInfo" }, method = RequestMethod.POST)
	public @ResponseBody List<TechrResrchPaprJournlInfo> getTechrResrchPaprJournlInfo(@RequestParam int instId, @RequestParam int acYear) {
 		List<TechrResrchPaprJournlInfo> tchrAwrdList = new ArrayList<TechrResrchPaprJournlInfo>();
 		 		
 		try {
 			
 			tchrAwrdList = techrResrchRepo.getAllTechrResrchPaprJournlInfo(acYear, instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return tchrAwrdList;
 	}
	
	
	
	@Autowired TechrResrchPaprJournlRatioRepo tchrResrchRatioRepo;
	@RequestMapping(value = { "/getTechrResrchPaprJournlRatio" }, method = RequestMethod.POST)
	public @ResponseBody List<TechrResrchPaprJournlRatio> getTechrResrchPaprJournlRatio(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 	
		List<TechrResrchPaprJournlRatio> tchrResrchRatioList = new ArrayList<TechrResrchPaprJournlRatio>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			tchrResrchRatioList = tchrResrchRatioRepo.getAllTechrResrchPaprJournlRatio(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return tchrResrchRatioList;
 	}
	
	@Autowired ResrchProjectGrantsRepo resrchProJGrntRepo;
	@RequestMapping(value = { "/getResrchProjectGrants" }, method = RequestMethod.POST)
	public @ResponseBody List<ResrchProjectGrants> getResrchProjectGrants(@RequestParam int instId, @RequestParam int acYear) {
 		List<ResrchProjectGrants> projGranList = new ArrayList<ResrchProjectGrants>();
 		 		
 		try {
 			
 			projGranList = resrchProJGrntRepo.getAllResrchProjectGrants(acYear, instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return projGranList;
 	}
	
	
	@Autowired FullTimeTechrInstResrchGuideRepo resrchGuideRepo;
	@RequestMapping(value = { "/getFullTimeTechrInstResrchGuide" }, method = RequestMethod.POST)
	public @ResponseBody List<FullTimeTechrInstResrchGuide> getFullTimeTechrInstResrchGuide(@RequestParam int instId, @RequestParam int acYear) {
 		List<FullTimeTechrInstResrchGuide> guideList = new ArrayList<FullTimeTechrInstResrchGuide>();
 		 		
 		try {
 			
 			guideList = resrchGuideRepo.getAllFullTimeTechrInstResrchGuide(acYear, instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return guideList;
 	}
	
	@Autowired PerNewCourceRepo newCourseRepo;
	@RequestMapping(value = { "/getPerNewCource" }, method = RequestMethod.POST)
	public @ResponseBody List<PerNewCource> getPerNewCource(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 	
		List<PerNewCource> courseList = new ArrayList<PerNewCource>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			List<Integer> lastFiveYears=new ArrayList<>();
 	
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 			courseList = newCourseRepo.getAllPerNewCource(instId, lastFiveYears);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return courseList;
 	}
	
	
	
	@Autowired PerProgCbseElectiveCourseRepo electivCrsRepo;
	@RequestMapping(value = { "/getPerProgCbseElectiveCourse" }, method = RequestMethod.POST)
	public @ResponseBody List<PerProgCbseElectiveCourse> getPerProgCbseElectiveCourse(@RequestParam int instId) {
 		List<PerProgCbseElectiveCourse> crsList = new ArrayList<PerProgCbseElectiveCourse>();
 		 		
 		try {
 			
 			crsList = electivCrsRepo.getAllPerProgCbseElectiveCourse(instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return crsList;
 	}
	
	
	
	@Autowired FildeProjectInternReportRepo fieldProInternRepo;
	@RequestMapping(value = { "/getFildeProjectInternReport" }, method = RequestMethod.POST)
	public @ResponseBody List<FildeProjectInternReport> getFildeProjectInternReport(@RequestParam int instId,
			@RequestParam int prog_name, @RequestParam int acYear) {
 		List<FildeProjectInternReport> fileInternList = new ArrayList<FildeProjectInternReport>();
 		 		
 		try {
 			
 			fileInternList = fieldProInternRepo.getAllFildeProjectInternReport(instId, prog_name, acYear);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
 		
		return fileInternList;
 	}
	
	@Autowired InstStakeholderFeedbackReportRepo stkFedBkRepo;
	@RequestMapping(value = { "/getAllFeedBackFrmStackHldr" }, method = RequestMethod.POST)
	public @ResponseBody List<InstStakeholderFeedbackReport> getAllStakeByInstituteId(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<InstStakeholderFeedbackReport> libResp = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();
		
		try {
			List<Integer> lastFiveYears=new ArrayList<>();
			
			
			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				
				for (int i = 0; i < acYrList.size(); i++) {
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				 System.err.println("new id list" + acYearList.toString());
			}else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
			
			libResp = stkFedBkRepo.getAllStkHldrFb(instId, lastFiveYears);
			System.err.println("lib are" + libResp.toString());

		} catch (Exception e) {
			System.err.println("Exce in getAllFeedBackFrmStackHldr   " + e.getMessage());
			e.printStackTrace();
		} 

		return libResp;
	}
	
 	
	/****************************************Budget Graph**************************************/	
	
	@Autowired TempDashBoardGraphRepo tempDashRepo;
	
	
	 
}
