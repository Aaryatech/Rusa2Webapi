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
import com.ats.rusasoftapi.model.report.AvgEnrollmentPrcnt;
import com.ats.rusasoftapi.model.report.FacParticipationInBodies;
import com.ats.rusasoftapi.model.report.GetAvgStudYearwise;
import com.ats.rusasoftapi.model.report.GetTeachersUsingICT;
import com.ats.rusasoftapi.model.report.NoOfMentorsAssignedStudent;
import com.ats.rusasoftapi.model.report.NoOfPrograms;
import com.ats.rusasoftapi.mstrepo.AcademicYearRepo;
import com.ats.rusasoftapi.mstrepo.SettingKeyValueRepo;
import com.ats.rusasoftapi.reportrepo.AvgEnrollmentPrcntRepo;
import com.ats.rusasoftapi.reportrepo.FacParticipationInBodiesRepo;
import com.ats.rusasoftapi.reportrepo.GetAvgStudYearwiseRepo;
import com.ats.rusasoftapi.reportrepo.GetTeachersUsingICTRepo;
import com.ats.rusasoftapi.reportrepo.NoOfMentorsAssignedStudentRepo;
import com.ats.rusasoftapi.reportrepo.NoOfProgramsRepo;

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

			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 				facPartInVarBodies = getFacParticipationInBodiesRepo.getFacParticipationInBodies(instId, acYearList);
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

			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 				facPartInVarBodies = avgEnrollmentPrcntRepo.getAvgEnrollmentPrcnt(instId, acYearList);
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

			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
			
			SettingKeyValue setKey=new SettingKeyValue();
			 
				setKey=settingKeyValueRepo.findBySettingKeyAndDelStatus("Report10",1);
				System.err.println("stk ids :"+setKey.toString());
				String stkId=setKey.getStringValue();
				String acId1=acYearList.get(0);
				String acId2=acYearList.get(0);
				String acId3=acYearList.get(0);
				String acId4=acYearList.get(0);
 				String acId5=acYearList.get(0);

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

			if (acYearList.contains("-5")) {
				System.err.println("in -5");
				acYrList =academicYearRepo.getLastFiveYears();
				for (int i = 0; i < acYrList.size(); i++) {
					acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
				}
				 System.err.println("new id list" + acYearList.toString());
			}  
 				facPartInVarBodies = getTeachersUsingICTRepo.getTeachersUsingICT(instId, acYearList);
				System.err.println("List=" + facPartInVarBodies);
 
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	NoOfMentorsAssignedStudentRepo noOfMentorsAssignedStudentRepo;
	
	@RequestMapping(value = { "/getNoOfMentorsAssignedStudentRepo" }, method = RequestMethod.POST)
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
	
	
	
}
