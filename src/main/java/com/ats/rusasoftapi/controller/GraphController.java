package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.graph.model.DashBoardCounts;
import com.ats.rusasoftapi.graph.model.GetCountsForDash;
import com.ats.rusasoftapi.graph.model.GetTotStudentPassedAndAppearInFinYr;
import com.ats.rusasoftapi.graph.model.NoOfResearchPubGraphDean;
import com.ats.rusasoftapi.graph.model.SancIntakeStudAdmittedGraph;
import com.ats.rusasoftapi.graph.model.StudpassApperaedTaughByFac;
import com.ats.rusasoftapi.graph.model.TeacherStudUsingLibrary;
import com.ats.rusasoftapi.graph.model.TotSancIntakeProgwise;
import com.ats.rusasoftapi.graphrepo.DashBoardCountsRepo;
import com.ats.rusasoftapi.graphrepo.GetTotStudentPassedAndAppearInFinYrRepo;
import com.ats.rusasoftapi.graphrepo.NoOfResearchPubGraphDeanRepo;
import com.ats.rusasoftapi.graphrepo.SancIntakeStudAdmittedGraphRepo;
import com.ats.rusasoftapi.graphrepo.StudpassApperaedTaughByFacRepo;
import com.ats.rusasoftapi.graphrepo.TeacherStudUsingLibraryRepo;
import com.ats.rusasoftapi.graphrepo.TotSancIntakeProgwiseRepo;
import com.ats.rusasoftapi.model.AcademicYear;
import com.ats.rusasoftapi.model.report.ProgSanctnIntake;
import com.ats.rusasoftapi.model.report.ProgTypStudPlacedGraph;
import com.ats.rusasoftapi.model.report.StudSupprtSchemGraph;
import com.ats.rusasoftapi.mstrepo.AcademicYearRepo;
import com.ats.rusasoftapi.reportrepo.ProgSanctnIntakeRepo;
import com.ats.rusasoftapi.reportrepo.ProgTypStudPlacedGraphRepo;
import com.ats.rusasoftapi.reportrepo.StudSupprtSchemGraphRepo;

@RestController

public class GraphController {

	@Autowired
	AcademicYearRepo academicYearRepo;

	@Autowired
	SancIntakeStudAdmittedGraphRepo sancIntakeStudAdmittedGraphRepo;

	@Autowired
	TotSancIntakeProgwiseRepo totSancIntakeProgwiseRepo;

	// ****************************Principal & IQAC********************************

	// Principal Graph1 Harsha
	@RequestMapping(value = { "/getGraph1" }, method = RequestMethod.POST)
	public @ResponseBody List<SancIntakeStudAdmittedGraph> getGraph1(@RequestParam int instId) {

		List<SancIntakeStudAdmittedGraph> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();

			acYrList = academicYearRepo.getLastFiveYears();

			for (int i = 0; i < acYrList.size(); i++) {
				System.err.println("acYrList" + acYrList.get(i).toString());
				lastFiveYears.add(acYrList.get(i).getYearId());
			}

			facPartInVarBodies = sancIntakeStudAdmittedGraphRepo.getGraph1Data(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	// Principal Graph2 harsha
	@RequestMapping(value = { "/getTotSancIntakeProgramwiseGraph" }, method = RequestMethod.POST)
	public @ResponseBody List<TotSancIntakeProgwise> getTotSancIntakeProgramwiseGraph(@RequestParam int instId) {

		List<TotSancIntakeProgwise> facPartInVarBodies = new ArrayList<>();

		try {

			facPartInVarBodies = totSancIntakeProgwiseRepo.getGraph2Data(instId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	// Iqac Graph 3 Mahendra
	@Autowired
	StudSupprtSchemGraphRepo studSchmRepo;

	@RequestMapping(value = { "/getAllStudSupprtSchemGraph" }, method = RequestMethod.POST)
	public @ResponseBody List<StudSupprtSchemGraph> StudSupprtSchemGraph(@RequestParam int instId) {

		List<StudSupprtSchemGraph> studSchmList = new ArrayList<StudSupprtSchemGraph>();

		try {
			studSchmList = studSchmRepo.getAllStudSupprtSchemGraphByInstId(instId);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return studSchmList;

	}

	// ****************************HOD********************************

	// HOD Graph2 Harsha

	@Autowired
	GetTotStudentPassedAndAppearInFinYrRepo getTotStudentPassedAndAppearInFinYrRepo;

	@RequestMapping(value = { "/getTotStudentPassedAndAppearInFinYrGraphForHod" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTotStudentPassedAndAppearInFinYr> getTotStudentPassedAndAppearInFinYrGraphForHod(
			@RequestParam int instId, @RequestParam int facultyId) {

		List<GetTotStudentPassedAndAppearInFinYr> facPartInVarBodies = new ArrayList<>();

		try {

			facPartInVarBodies = getTotStudentPassedAndAppearInFinYrRepo
					.getGetTotStudentPassedAndAppearInFinYrDet(instId, facultyId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in getTotStudentPassedAndAppearInFinYrGraphForHod R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	// Hod Graph 1 Mahendra
	@Autowired
	ProgSanctnIntakeRepo prgSanctnIntkRepo;

	@RequestMapping(value = { "/getAllProgSanctnIntakeGraph" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgSanctnIntake> getAllProgSanctnIntakeGraph(@RequestParam int makerUserId) {

		List<ProgSanctnIntake> prgSanctnIntkList = new ArrayList<ProgSanctnIntake>();

		try {
			prgSanctnIntkList = prgSanctnIntkRepo.getAllProgSanctnIntake(makerUserId);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return prgSanctnIntkList;

	}

	// Hod Graph 3 Mahendra
	@Autowired
	ProgTypStudPlacedGraphRepo progStudGraphRepo;

	@RequestMapping(value = { "/getAllProgTypStudPlacedGraph" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgTypStudPlacedGraph> getAllProgTypStudPlacedGraph(@RequestParam int makerUserId) {

		List<ProgTypStudPlacedGraph> list = new ArrayList<ProgTypStudPlacedGraph>();

		try {
			list = progStudGraphRepo.getAllProgTypStudPlacedGraph(makerUserId);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return list;

	}

	// ******************************Librarian*******************************************

	// LIb graph1 harsha

	@Autowired
	TeacherStudUsingLibraryRepo teacherStudUsingLibraryRepo;

	@RequestMapping(value = { "/getGraphForNoofTeacherStudUsingLib" }, method = RequestMethod.POST)
	public @ResponseBody List<TeacherStudUsingLibrary> getGraphForNoofTeacherStudUsingLib(@RequestParam int instId) {

		List<TeacherStudUsingLibrary> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();

			acYrList = academicYearRepo.getLastFiveYears();

			for (int i = 0; i < acYrList.size(); i++) {
				System.err.println("acYrList" + acYrList.get(i).toString());
				lastFiveYears.add(acYrList.get(i).getYearId());
			}

			facPartInVarBodies = teacherStudUsingLibraryRepo.getTeacherStudUsingLibraryDet(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	// ***********************************Faculty************************************

	// Faculty graph1 harsha

	@Autowired
	StudpassApperaedTaughByFacRepo studpassApperaedTaughByFacRepo;

	@RequestMapping(value = { "/getStudpassAppearedTaughByFacGraph" }, method = RequestMethod.POST)
	public @ResponseBody List<StudpassApperaedTaughByFac> getStudpassApperaedTaughByFacGraph(@RequestParam int instId,
			@RequestParam int facultyId) {

		List<StudpassApperaedTaughByFac> facPartInVarBodies = new ArrayList<>();

		try {

			facPartInVarBodies = studpassApperaedTaughByFacRepo.getStudpassApperaedTaughByFacDet(instId, facultyId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	// ******************************Dean*******************************************

		// Dean graph1 harsha

		@Autowired
		NoOfResearchPubGraphDeanRepo noOfResearchPubGraphDeanRepo;

		@RequestMapping(value = { "/getNoOfResearchPubGraphDean" }, method = RequestMethod.POST)
		public @ResponseBody List<NoOfResearchPubGraphDean> getNoOfResearchPubGraphDean(@RequestParam int instId) {

			List<NoOfResearchPubGraphDean> facPartInVarBodies = new ArrayList<>();
			List<AcademicYear> acYrList = new ArrayList<>();

			try {

				List<Integer> lastFiveYears = new ArrayList<>();

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				facPartInVarBodies = noOfResearchPubGraphDeanRepo.getNoOfResearchPubGraphDeanDet(instId, lastFiveYears);
				System.err.println("List=" + facPartInVarBodies);

			} catch (Exception e) {

				System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
				e.printStackTrace();

			}

			return facPartInVarBodies;

		}


	// **********************************All dashboard
	// Counts**********************************
	@Autowired
	DashBoardCountsRepo dashBoardCountsRepo;

	@RequestMapping(value = { "/getPrincipalDashCounts" }, method = RequestMethod.POST)
	public @ResponseBody DashBoardCounts getPrincipalDashCounts(@RequestParam int instId, @RequestParam int facultyId,
			@RequestParam int deptId, @RequestParam int isPrincipal, @RequestParam int isIqac, @RequestParam int isHod,
			@RequestParam int isFaculty, @RequestParam int isLibrarian, @RequestParam int isAccOff,
			@RequestParam int isDean) {

		DashBoardCounts dash = new DashBoardCounts();

		GetCountsForDash temp = new GetCountsForDash();

		try {

			if (isPrincipal == 1 || isIqac == 1) {
				// harsha

				temp = dashBoardCountsRepo.getNoOfFacultiesForPrinci(instId);
				dash.setTotalfaculties(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfFacultiesPHDForPrinci(instId);
				dash.setTotalfacultieswithPHD(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfStudentForPrinci(instId);
				dash.setTotalstudent(temp.getCount() + temp.getCount1());

				temp = dashBoardCountsRepo.getNoOfStudentForPrinci(instId);
				dash.setMalestudent(temp.getCount1());

				temp = dashBoardCountsRepo.getNoOfStudentForPrinci(instId);
				dash.setFemalestudent(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfProgramForPrinci(instId);
				dash.setNoofprogram(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfBudgetForPrinci(instId);
				dash.setCurrfinyearbudget(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfBookPubForPrinci(instId);
				dash.setNoofbookpub(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfResearchPubForPrinci(instId);
				dash.setNoOfreserchpub(temp.getCount());

				float x1 = (float) (dash.getTotalstudent() / (float) dash.getTotalfaculties());

				dash.setRatio(x1);
			}

			if (isHod == 1) {
				// harsha

				temp = dashBoardCountsRepo.getNoOfFacultiesForHod(instId, deptId);
				dash.setTotalfacultiesforHOD(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfStudentsForHod(instId, facultyId);
				dash.setTotalstudentForHOD(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfProgramForHod(instId, facultyId);
				dash.setNoofprogramForHOD(temp.getCount());

			}

			if (isLibrarian == 1) {
				// harsha

				temp = dashBoardCountsRepo.getCountsForLibrarian(instId);
				dash.setLibraryusageperdayfaculty((String.valueOf(temp.getCount())));
				dash.setLibraryusageperdaystudents(String.valueOf(temp.getCount1()));
				dash.setLMSsoftwarename(temp.getData1());
				dash.setNoofLMSsoftwareusers(temp.getData2());

				temp = dashBoardCountsRepo.getCountsForLibrarian1(instId);
				dash.setNoofbooksinlibrary(temp.getCount());

			}

			if (isFaculty == 1) {
				// mahendra
				temp = dashBoardCountsRepo.getCurrentResrchProjrectTitle(instId); // Research Project Title
				dash.setResearchprojecttitle(temp.getData1());

				temp = dashBoardCountsRepo.getNoResrchPubDetail(instId); // No. of Research Publication
				dash.setNoOfreserchpubforFaculty(temp.getCount());

				temp = dashBoardCountsRepo.getNoBookPublished(instId); // No. of Research Publication
				dash.setNoofbookpubForFaculty(temp.getCount());

				temp = dashBoardCountsRepo.getNoPatentFiled(instId); // No. of Patent Filed
				dash.setNoofpatentsfilled(temp.getCount());
			}

			
			if (isDean == 1) {
				// harsha
				
				temp = dashBoardCountsRepo.getResearchProjForDean(instId); 
				dash.setTotalresearchprojects(temp.getCount());

				temp = dashBoardCountsRepo.getTotalMouForDean(instId);  
				dash.setTotalnoofMOUs(temp.getCount());

				temp = dashBoardCountsRepo.getInstColLinkageForDean(instId);  
				int a=temp.getCount();
				temp = dashBoardCountsRepo.getInstColLinkageStudForDean(instId);  
				int b=temp.getCount();
 				dash.setTotallinkages(a+b);
				
				
 				temp = dashBoardCountsRepo.getFundinGovtForDean(instId);  
				int c=temp.getCount();
				temp = dashBoardCountsRepo.getFundinNonGovtForDean(instId);  
				int d=temp.getCount();
 				dash.setFundingfrom(String.valueOf(c+d));
 				
			}

		} catch (Exception e) {

			System.err.println("Exce in getPrincipalDashCounts" + e.getMessage());
			e.printStackTrace();

		}

		return dash;

	}

}
