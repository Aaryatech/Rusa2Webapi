package com.ats.rusasoftapi.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.AcademicYear;
import com.ats.rusasoftapi.model.SettingKeyValue;
import com.ats.rusasoftapi.model.report.AdmissionsAgainstCategory;
import com.ats.rusasoftapi.model.report.AvgEnrollmentPrcnt;
import com.ats.rusasoftapi.model.report.FacParticipationInBodies;
import com.ats.rusasoftapi.model.report.GetAvgStudYearwise;
import com.ats.rusasoftapi.model.report.GetTeachersUsingICT;
import com.ats.rusasoftapi.model.report.LibAutoLMSInfo;
import com.ats.rusasoftapi.model.report.LibSpecFacilities;
import com.ats.rusasoftapi.model.report.NoOfMentorsAssignedStudent;
import com.ats.rusasoftapi.model.report.NoOfPrograms;
import com.ats.rusasoftapi.model.report.RareBookManuscriptSpec;
import com.ats.rusasoftapi.model.report.StudentPerformanceOutcome;
import com.ats.rusasoftapi.model.report.TeacherStudUsingLib;
import com.ats.rusasoftapi.mstrepo.AcademicYearRepo;
import com.ats.rusasoftapi.mstrepo.SettingKeyValueRepo;
import com.ats.rusasoftapi.reportrepo.AdmissionsAgainstCategoryRepo;
import com.ats.rusasoftapi.reportrepo.AvgEnrollmentPrcntRepo;
import com.ats.rusasoftapi.reportrepo.FacParticipationInBodiesRepo;
import com.ats.rusasoftapi.reportrepo.GetAvgStudYearwiseRepo;
import com.ats.rusasoftapi.reportrepo.GetTeachersUsingICTRepo;
import com.ats.rusasoftapi.reportrepo.LibAutoLMSInfoRepo;
import com.ats.rusasoftapi.reportrepo.LibSpecFacilitiesRepo;
import com.ats.rusasoftapi.reportrepo.NoOfMentorsAssignedStudentRepo;
import com.ats.rusasoftapi.reportrepo.NoOfProgramsRepo;
import com.ats.rusasoftapi.reportrepo.RareBookManuscriptSpecRepo;
import com.ats.rusasoftapi.reportrepo.StudentPerformanceOutcomeRepo;
import com.ats.rusasoftapi.reportrepo.TeacherStudUsingLibRepo;

@RestController
public class ReportApiController {

	@Autowired
	SettingKeyValueRepo settingKeyValueRepo;
	
	@Autowired
	AcademicYearRepo academicYearRepo;

	@Autowired
	NoOfProgramsRepo getNoOfProgramsRepo;
	
	@Autowired
	FacParticipationInBodiesRepo getFacParticipationInBodiesRepo;
	
	
	@Autowired
	GetAvgStudYearwiseRepo getAvgStudYearwiseRepo;
	
	@Autowired
	AvgEnrollmentPrcntRepo avgEnrollmentPrcntRepo;
	
	
	

	@RequestMapping(value = { "/getNoOfProgramsList" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfPrograms> getNoOfProgramsList(@RequestParam int instId) {

		List<NoOfPrograms> progList = new ArrayList<>();
		SettingKeyValue setKey=new SettingKeyValue();
		try {
			setKey=settingKeyValueRepo.findBySettingKeyAndDelStatus("Report1",1);
			System.err.println("stk ids :"+setKey.toString());
			String stkId=setKey.getStringValue();
			progList = getNoOfProgramsRepo.getNoOfPrograms(instId,stkId);
			System.err.println("List=" + progList);

		} catch (Exception e) {

			System.err.println("Exce in getNoOfProgramsList R1 " + e.getMessage());
			e.printStackTrace();

		}

		return progList;

	}

	@RequestMapping(value = { "/getFacParticipationInBodies" }, method = RequestMethod.POST)
	public @ResponseBody List<FacParticipationInBodies> getFacParticipationInBodies(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<FacParticipationInBodies> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();
		 
	 
		try {
			List<Integer> lastFiveYears=new ArrayList<>();

			if (acYearList.contains("-5")) {
				//System.err.println("in if ");
				//System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				 
				for (int i = 0; i < acYrList.size(); i++) {
					//acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
					//acYrList.remove(acYrList.size());
					 //System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 				facPartInVarBodies = getFacParticipationInBodiesRepo.getFacParticipationInBodies(instId, lastFiveYears);
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	
	@RequestMapping(value = { "/getAvgEnrollmentPrcnt" }, method = RequestMethod.POST)
	public @ResponseBody List<AvgEnrollmentPrcnt> getAvgEnrollmentPrcnt(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<AvgEnrollmentPrcnt> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();
		 
	 
		try {

			List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				//System.err.println("in if ");
				//System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				 
				for (int i = 0; i < acYrList.size(); i++) {
					//acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
					//acYrList.remove(acYrList.size());
					 //System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
			 
 				facPartInVarBodies = avgEnrollmentPrcntRepo.getAvgEnrollmentPrcnt(instId, lastFiveYears);
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	
	@RequestMapping(value = { "/getAvgStudYearwiseLocWise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAvgStudYearwise> getAvgStudYearwiseLocWise(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<GetAvgStudYearwise> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();
		 
	 
		try {

			List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				//System.err.println("in if ");
				//System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				 
				for (int i = 0; i < acYrList.size(); i++) {
					//acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
					//acYrList.remove(acYrList.size());
					 //System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
			
			SettingKeyValue setKey=new SettingKeyValue();
			 
				setKey=settingKeyValueRepo.findBySettingKeyAndDelStatus("Report10",1);
				System.err.println("stk ids :"+setKey.toString());
				String stkId=setKey.getStringValue();
				int acId1=lastFiveYears.get(0);
				int acId2=lastFiveYears.get(1);
				int acId3=lastFiveYears.get(2);
				int acId4=lastFiveYears.get(3);
				int acId5=lastFiveYears.get(4);

  				facPartInVarBodies = getAvgStudYearwiseRepo.getAvgStudYearwiseLocWise(instId, stkId,acId1,acId2,acId3,acId4,acId5);
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	@Autowired
	GetTeachersUsingICTRepo getTeachersUsingICTRepo;
	
	@RequestMapping(value = { "/getTeachersUsingICT" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTeachersUsingICT> getTeachersUsingICT(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<GetTeachersUsingICT> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();
		 
	 
		try {

			List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				//System.err.println("in if ");
				//System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				 
				for (int i = 0; i < acYrList.size(); i++) {
					//acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
					//acYrList.remove(acYrList.size());
					 //System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 				facPartInVarBodies = getTeachersUsingICTRepo.getTeachersUsingICT(instId, lastFiveYears);
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	NoOfMentorsAssignedStudentRepo noOfMentorsAssignedStudentRepo;
	
	@RequestMapping(value = { "/getNoOfMentorsAssignedStudent" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfMentorsAssignedStudent> getNoOfMentorsAssignedStudentRepo(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
 		List<NoOfMentorsAssignedStudent> facPartInVarBodies = new ArrayList<>();
		try {
 
 				facPartInVarBodies = noOfMentorsAssignedStudentRepo.getNoOfMentorsAssignedStudent(instId );
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	StudentPerformanceOutcomeRepo studentPerformanceOutcomeRepo;
	
	@RequestMapping(value = { "/getStudPerformancePo" }, method = RequestMethod.POST)
	public @ResponseBody List<StudentPerformanceOutcome> getStudPerformancePo(@RequestParam int instId,
			@RequestParam int programId) {
 		List<StudentPerformanceOutcome> facPartInVarBodies = new ArrayList<>();
		try {
 
 				facPartInVarBodies = studentPerformanceOutcomeRepo.getStudPerformanceOutcome(instId,programId );
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	AdmissionsAgainstCategoryRepo admissionsAgainstCategoryRepo;
	
	@RequestMapping(value = { "/getAdmisssionsAgainstCat" }, method = RequestMethod.POST)
	public @ResponseBody List<AdmissionsAgainstCategory> getAdmisssionsAgainstCat(@RequestParam int instId,@RequestParam int catId
			,@RequestParam List<String> acYearList) {

		List<AdmissionsAgainstCategory> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();
		 
	 
		try {

			 List<Integer> lastFiveYears=new ArrayList<>();
	 			if (acYearList.contains("-5")) {
					//System.err.println("in if ");
					//System.err.println("in -5");
					acYrList =academicYearRepo.getLastFiveYears();
					 
					for (int i = 0; i < acYrList.size(); i++) {
						//acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
						System.err.println("acYrList" +acYrList.get(i).toString());
						lastFiveYears.add(acYrList.get(i).getYearId());
					}
					
						//acYrList.remove(acYrList.size());
						 //System.err.println("new id list" + acYearList.toString());
				} else {
					System.err.println("in else ");
					lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
					
				} 
 				facPartInVarBodies = admissionsAgainstCategoryRepo.getAdmissionsAgainstCat(instId, catId,lastFiveYears);
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	LibAutoLMSInfoRepo libAutoLMSInfoRepo;
	
	@RequestMapping(value = { "/getLibLMSInfo" }, method = RequestMethod.POST)
	public @ResponseBody List<LibAutoLMSInfo> getLibLMSInfo(@RequestParam int instId
			 ) {
 		List<LibAutoLMSInfo> facPartInVarBodies = new ArrayList<>();
		try {
 
 				facPartInVarBodies = libAutoLMSInfoRepo.getLMSInfo(instId );
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}
		

		return facPartInVarBodies;

	}
	
	
	@Autowired
	RareBookManuscriptSpecRepo rareBookManuscriptSpecRepo;
	
	@RequestMapping(value = { "/getRareBookManuscript" }, method = RequestMethod.POST)
	public @ResponseBody List<RareBookManuscriptSpec> getRareBookManuscript(@RequestParam int instId
			 ) {
 		List<RareBookManuscriptSpec> facPartInVarBodies = new ArrayList<>();
		try {
 
 				facPartInVarBodies = rareBookManuscriptSpecRepo.getRareBookInfo(instId );
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}
		

		return facPartInVarBodies;

	}
	
	@Autowired
	LibSpecFacilitiesRepo libSpecFacilitiesRepo;
	
	@RequestMapping(value = { "/getLibSpecFacilities" }, method = RequestMethod.POST)
	public @ResponseBody List<LibSpecFacilities> getLibSpecFacilities(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<LibSpecFacilities> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();
	 
		try {
			 List<Integer> lastFiveYears=new ArrayList<>();
 			if (acYearList.contains("-5")) {
				//System.err.println("in if ");
				//System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				 
				for (int i = 0; i < acYrList.size(); i++) {
					//acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
					//acYrList.remove(acYrList.size());
					 //System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			} 
 				facPartInVarBodies = libSpecFacilitiesRepo.getLibSpecialFacilities(instId,lastFiveYears);
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	TeacherStudUsingLibRepo teacherStudUsingLibRepo;
	
	@RequestMapping(value = { "/getTeachersStudUsingLib" }, method = RequestMethod.POST)
	public @ResponseBody List<TeacherStudUsingLib> getTeachersStudUsingLib(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<TeacherStudUsingLib> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();
		 
	 List<Integer> lastFiveYears=new ArrayList<>();
		try {

			if (acYearList.contains("-5")) {
				//System.err.println("in if ");
				//System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				 
				for (int i = 0; i < acYrList.size(); i++) {
					//acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" +acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}
				
					//acYrList.remove(acYrList.size());
					 //System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));
				
			}
		System.err.println("Last five " +lastFiveYears.toString());
 				facPartInVarBodies = teacherStudUsingLibRepo.getTechStudUsingLib(instId,lastFiveYears);
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
}
