package com.ats.rusasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.instprofilerepo.InstituteTrainingRepo;
import com.ats.rusasoft.model.instprofile.InstituteTraining;

@RestController
public class InstiProfTrainingApi {
	
	@Autowired InstituteTrainingRepo instituteTrainingRepo;
	
	@RequestMapping(value = { "/saveInstituteTraining" }, method = RequestMethod.POST)
	public @ResponseBody InstituteTraining saveInstituteTraining(
			@RequestBody InstituteTraining instTraining) {

		InstituteTraining instTrainRes = null;

		try {
			instTrainRes = instituteTrainingRepo.save(instTraining);
		} catch (Exception e) {
			System.err.println("Exce in saving saveInstituteTraining " + e.getMessage());
			e.printStackTrace();
		}

		return instTrainRes;
	}

}
