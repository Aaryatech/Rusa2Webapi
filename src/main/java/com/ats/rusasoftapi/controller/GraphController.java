package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.graph.model.SancIntakeStudAdmittedGraph;
import com.ats.rusasoftapi.graphrepo.SancIntakeStudAdmittedGraphRepo;
import com.ats.rusasoftapi.model.AcademicYear;
 import com.ats.rusasoftapi.mstrepo.AcademicYearRepo;
 
@RestController

public class GraphController {

	@Autowired
	AcademicYearRepo academicYearRepo;

	@Autowired
	SancIntakeStudAdmittedGraphRepo sancIntakeStudAdmittedGraphRepo;

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
}
