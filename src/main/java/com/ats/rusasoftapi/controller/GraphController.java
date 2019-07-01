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
import com.ats.rusasoftapi.graph.model.SancIntakeStudAdmittedGraph;
import com.ats.rusasoftapi.graph.model.TotSancIntakeProgwise;
import com.ats.rusasoftapi.graphrepo.DashBoardCountsRepo;
import com.ats.rusasoftapi.graphrepo.GetTotStudentPassedAndAppearInFinYrRepo;
import com.ats.rusasoftapi.graphrepo.SancIntakeStudAdmittedGraphRepo;
import com.ats.rusasoftapi.graphrepo.TotSancIntakeProgwiseRepo;
import com.ats.rusasoftapi.model.AcademicYear;
import com.ats.rusasoftapi.mstrepo.AcademicYearRepo;

@RestController

public class GraphController {

	@Autowired
	AcademicYearRepo academicYearRepo;

	@Autowired
	SancIntakeStudAdmittedGraphRepo sancIntakeStudAdmittedGraphRepo;

	@Autowired
	TotSancIntakeProgwiseRepo totSancIntakeProgwiseRepo;

	
	//****************************Principal & IQAC********************************
	
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

	@Autowired
	DashBoardCountsRepo dashBoardCountsRepo;

	@RequestMapping(value = { "/getPrincipalDashCounts" }, method = RequestMethod.POST)
	public @ResponseBody DashBoardCounts getPrincipalDashCounts(@RequestParam int instId,@RequestParam int facultyId,@RequestParam int deptId, @RequestParam int isPrincipal,
			@RequestParam int isIqac, @RequestParam int isHod, @RequestParam int isFaculty,
			@RequestParam int isLibrarian, @RequestParam int isAccOff, @RequestParam int isDean) {

		DashBoardCounts dash = new DashBoardCounts();

		GetCountsForDash temp = new GetCountsForDash();

		try {

		  
			if (isPrincipal == 1 || isIqac == 1) {
				temp = dashBoardCountsRepo.getNoOfFacultiesForPrinci(instId);
				dash.setTotalfaculties(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfFacultiesPHDForPrinci(instId);
				dash.setTotalfacultieswithPHD(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfStudentForPrinci(instId);
				dash.setTotalstudent(temp.getCount()+temp.getCount1());
				 
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

				float x1 =(float) ( dash.getTotalstudent() /(float)  dash.getTotalfaculties());

				dash.setRatio(x1);
			}
			
			if(isHod==1) {
				
				temp = dashBoardCountsRepo.getNoOfFacultiesForHod(instId,deptId);
				dash.setTotalfacultiesforHOD(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfStudentsForHod(instId,facultyId);
				dash.setTotalstudentForHOD(temp.getCount());

				temp = dashBoardCountsRepo.getNoOfProgramForHod(instId,facultyId);
				dash.setNoofprogramForHOD(temp.getCount());
				
			}

		} catch (Exception e) {

			System.err.println("Exce in getPrincipalDashCounts" + e.getMessage());
			e.printStackTrace();

		}

		return dash;

	}
	
	//****************************HOD********************************
	
	@Autowired
	GetTotStudentPassedAndAppearInFinYrRepo getTotStudentPassedAndAppearInFinYrRepo;
	
	@RequestMapping(value = { "/getTotStudentPassedAndAppearInFinYrGraphForHod" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTotStudentPassedAndAppearInFinYr> getTotStudentPassedAndAppearInFinYrGraphForHod(@RequestParam int instId,@RequestParam int facultyId) {

		List<GetTotStudentPassedAndAppearInFinYr> facPartInVarBodies = new ArrayList<>();

		try {

			facPartInVarBodies = getTotStudentPassedAndAppearInFinYrRepo.getGetTotStudentPassedAndAppearInFinYrDet(instId,facultyId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in getTotStudentPassedAndAppearInFinYrGraphForHod R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	

	
	
}
