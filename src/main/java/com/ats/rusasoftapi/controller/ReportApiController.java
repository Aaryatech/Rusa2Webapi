package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.MExtActList;
import com.ats.rusasoftapi.model.report.FacParticipationInBodies;
import com.ats.rusasoftapi.model.report.NoOfPrograms;
import com.ats.rusasoftapi.reportrepo.FacParticipationInBodiesRepo;
import com.ats.rusasoftapi.reportrepo.NoOfProgramsRepo;

@RestController
public class ReportApiController {
	
	@Autowired NoOfProgramsRepo getNoOfProgramsRepo;
	@Autowired FacParticipationInBodiesRepo getFacParticipationInBodiesRepo;
	
	@RequestMapping(value = { "/getNoOfProgramsList"}, method = RequestMethod.POST)
	public @ResponseBody List<NoOfPrograms> getNoOfProgramsList(@RequestParam  int instId) {

		List<NoOfPrograms> progList = new ArrayList<>();

		try {
			progList = getNoOfProgramsRepo.getNoOfPrograms(instId);
			System.err.println("List="+progList);

		} catch (Exception e) {

			System.err.println("Exce in getNoOfProgramsList R1 " + e.getMessage());
			e.printStackTrace();

		}

		return progList;

	}
	
	@RequestMapping(value = { "/getFacParticipationInBodies"}, method = RequestMethod.POST)
	public @ResponseBody List<FacParticipationInBodies> getFacParticipationInBodies(@RequestParam  int instId,
			@RequestParam List<String> acYearList) {

		List<FacParticipationInBodies> facPartInVarBodies = new ArrayList<>();

		try {
			facPartInVarBodies = getFacParticipationInBodiesRepo.getFacParticipationInBodies(instId, acYearList);
			System.err.println("List="+facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
}
