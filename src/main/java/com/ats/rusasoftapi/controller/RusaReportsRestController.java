package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.AcademicYear;
import com.ats.rusasoftapi.model.SettingKeyValue;
import com.ats.rusasoftapi.model.report.AdmsnAgnstResrvCat;
import com.ats.rusasoftapi.model.report.BudgetInfraAugmntn;
import com.ats.rusasoftapi.model.report.DifferentlyAbldStudReport;
import com.ats.rusasoftapi.model.report.EContntDevFacReport;
import com.ats.rusasoftapi.model.report.ExpenditureOnPrchaseBooksJournal;
import com.ats.rusasoftapi.model.report.FacAgnstSanctnPost;
import com.ats.rusasoftapi.model.report.FacAgnstSanctnPostOthrState;
import com.ats.rusasoftapi.model.report.FulTimFacultyWithPhd;
import com.ats.rusasoftapi.model.report.ICtEnbldFaclitiesReport;
import com.ats.rusasoftapi.model.report.IntrnetConnInfo;
import com.ats.rusasoftapi.model.report.StudCompRatioReport;
import com.ats.rusasoftapi.model.report.StudPrfrmInFinlYr;
import com.ats.rusasoftapi.model.report.StudTeachrRatio;
import com.ats.rusasoftapi.model.report.TeacExpFullTimFac;
import com.ats.rusasoftapi.mstrepo.AcademicYearRepo;
import com.ats.rusasoftapi.mstrepo.DifferentlyAbldStudReportRepo;
import com.ats.rusasoftapi.mstrepo.SettingKeyValueRepo;
import com.ats.rusasoftapi.reportrepo.AdmsnAgnstResrvCatRepo;
import com.ats.rusasoftapi.reportrepo.BudgetInfraAugmntnRepo;
import com.ats.rusasoftapi.reportrepo.EContntDevFacReportRepo;
import com.ats.rusasoftapi.reportrepo.ExpenditureOnPrchaseBooksJournalRepo;
import com.ats.rusasoftapi.reportrepo.FulTimFacultyWithPhdRepo;
import com.ats.rusasoftapi.reportrepo.ICtEnbldFaclitiesReportRepo;
import com.ats.rusasoftapi.reportrepo.IntrnetConnInfoRepo;
import com.ats.rusasoftapi.reportrepo.StudCompRatioReportRepo;
import com.ats.rusasoftapi.reportrepo.StudPrfrmInFinlYrRepo;
import com.ats.rusasoftapi.reportrepo.TeacExpFullTimFacRepo;
import com.ats.rusasoftapi.repository.FacAgnstSanctnPostOthrStateRepo;
import com.ats.rusasoftapi.repository.FacAgnstSanctnPostRepo;

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
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 			postList = facRepo.getAllFacAgnstSanctnPost(instId, acYearList);
 			
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
 		SettingKeyValue setKey=new SettingKeyValue();
 		try {
 			setKey=settingKeyValueRepo.findBySettingKeyAndDelStatus("PHD",1);
			System.err.println("stk ids :"+setKey.toString());
			int stkId=setKey.getIntValue();
			 			
			facList = facOthrStateRepo.getAllFacultyAgnstSanctionPostOthrState(instId, acYear, stkId);
 			
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
	@RequestMapping(value = { "/getFulTimFacAvalblePhd" }, method = RequestMethod.GET)
	public @ResponseBody List<FulTimFacultyWithPhd> getFulTimFacAvalblePhd() {
 		List<FulTimFacultyWithPhd> phdFacList = new ArrayList<FulTimFacultyWithPhd>();
 		
 		SettingKeyValue setKey=new SettingKeyValue();
 		try {
 			
 			setKey=settingKeyValueRepo.findBySettingKeyAndDelStatus("QlifPhd",1);
			System.err.println("stk ids :"+setKey.toString());
			int stkId=setKey.getIntValue();
 			
 			phdFacList = facultyPhdRepo.getAllFulTimFacAvalblePhd(stkId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return phdFacList;
 	}
	
	@Autowired AdmsnAgnstResrvCatRepo admRepo;
	@RequestMapping(value = { "/getAdmisionAgnstResrvCat" }, method = RequestMethod.POST)
	public @ResponseBody List<AdmsnAgnstResrvCat> getAdmisionAgnstResrvCat(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 		List<AdmsnAgnstResrvCat> admList = new ArrayList<AdmsnAgnstResrvCat>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 			admList = admRepo.getAllAdmisionAgnstResrvCat(instId, acYearList);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return admList;
 	}
	
	
	@Autowired StudPrfrmInFinlYrRepo studPerformRepo;
	@RequestMapping(value = { "/getStudPerformInFinalYear" }, method = RequestMethod.POST)
	public @ResponseBody List<StudPrfrmInFinlYr> getStudPerformInFinalYear(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 		List<StudPrfrmInFinlYr> studPerfrmncList = new ArrayList<StudPrfrmInFinlYr>();
 		List<AcademicYear> acYrList = new ArrayList<>();
 		
 		try {
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 			studPerfrmncList = studPerformRepo.getAllStudPerformInFinalYear(instId, acYearList);
 			
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
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 			System.err.println("id list" + acYearList.toString());
 			ictFacList = ictFacRepo.getAllICTEnbldFaclties(instId, acYearList);
 			
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
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 			System.err.println("id list" + acYearList.toString());
 			budgtInfraList = budgtInfraAugRepo.getAllBudgetInfraAugmentn(instId, acYearList);
 			
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
 			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 			System.err.println("id list" + acYearList.toString());
 			bookExpdList = bookExpdRepo.getAllExpenditureOnPrchaseBooksJournal(instId, acYearList);
 			
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
	public @ResponseBody List<IntrnetConnInfo> getInternetConnInfo(@RequestParam int instId) {
 		List<IntrnetConnInfo> intrntConList = new ArrayList<IntrnetConnInfo>();
 		 		
 		try {
 			
 			intrntConList = intrntRepo.getAllInternetConnInfo(instId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return intrntConList;
 	}
	
}
