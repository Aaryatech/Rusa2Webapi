package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.GetProgram;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.ProgramOutcome;
import com.ats.rusasoftapi.model.ProgramSpeceficOutcome;
import com.ats.rusasoftapi.prodetailrepo.GetPoRepo;
import com.ats.rusasoftapi.prodetailrepo.GetPsoRepo;
import com.ats.rusasoftapi.prodetailrepo.ProgramOutcomeRepo;
import com.ats.rusasoftapi.repository.GetProgramRepository;

@RestController
public class poPSOController {
	
	@Autowired
	GetProgramRepository getProgramRepo;
	
	@Autowired
	GetPoRepo getPoRepo;
	
	@Autowired
	GetPsoRepo getPsoRepo;
	
	@Autowired
	ProgramOutcomeRepo programOutcomeRepo;
	
	
	
	@RequestMapping(value = { "/getProgramByProgId" }, method = RequestMethod.POST)
	public @ResponseBody GetProgram getProgramByProgId(@RequestParam int programId) {

		GetProgram progRes = new GetProgram();

		try {

			progRes = getProgramRepo.getProgramDetail(programId);
		} catch (Exception e) {
			System.err.println("Exce in getHigherEducDetail  " + e.getMessage());
			e.printStackTrace();
		}

		return progRes;

	}
	

	@RequestMapping(value = { "/getProgramOutcomeListByProgramId" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgramOutcome> getProgramOutcomeList(@RequestParam int programId) {

		List<ProgramOutcome> almDetail = new ArrayList<>();

		try {

			almDetail = getPoRepo.getProgramOutcomes(programId);
		} catch (Exception e) {
			System.err.println("Exce in getGetTrainPlaceList  " + e.getMessage());
			e.printStackTrace();
		}

		return almDetail;

	}
	

	@RequestMapping(value = { "/getProgramOutcomeByPOId" }, method = RequestMethod.POST)
	public @ResponseBody ProgramOutcome getProgramOutcomeByPOId(@RequestParam int poId) {

		ProgramOutcome progRes = new ProgramOutcome();

		try {

			progRes = getPoRepo.getProgramOutcome(poId);
		} catch (Exception e) {
			System.err.println("Exce in getHigherEducDetail  " + e.getMessage());
			e.printStackTrace();
		}

		return progRes;

	}
	
	@RequestMapping(value = { "/getProgramSpecificOutcomeList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgramSpeceficOutcome> getProgramSpecificOutcomeList(@RequestParam int programId) {

		List<ProgramSpeceficOutcome> almDetail = new ArrayList<>();

		try {

			almDetail = getPsoRepo.getProgramSpecificOutcomes(programId);
		} catch (Exception e) {
			System.err.println("Exce in getGetTrainPlaceList  " + e.getMessage());
			e.printStackTrace();
		}

		return almDetail;

	}
	
	
	@RequestMapping(value = { "/updatePoMapping" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePoMapping(@RequestParam String psoIdList,@RequestParam int poId,@RequestParam int satValue) {

		Info info = new Info();
		int isMap=0;
		try {
			
			if(psoIdList.isEmpty()==false) {
			 isMap=1;
				
			}
			else {
				
			}
			int res = programOutcomeRepo.updatePoMapping(psoIdList,poId,isMap,satValue);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	

	

}
