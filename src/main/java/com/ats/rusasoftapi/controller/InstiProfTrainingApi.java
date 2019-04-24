package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.instprofilerepo.GetInstTrainTeachDetailRepo;
import com.ats.rusasoftapi.instprofilerepo.InstituteTrainingRepo;
import com.ats.rusasoftapi.model.GetAccOfficer;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.instprofile.GetInstTrainTeachDetail;
import com.ats.rusasoftapi.model.instprofile.InstituteTraining;

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
	
	//GetInstTrainTeachDetailRepo
	
	@Autowired GetInstTrainTeachDetailRepo getInstTrainTeachDetailRepo;
	
	@RequestMapping(value = { "/getInstTrainTeachDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetInstTrainTeachDetail> getInstTrainTeachDetailList(@RequestParam int instId,
			@RequestParam int yearId,@RequestParam int trainningType) {

		List<GetInstTrainTeachDetail> instTrainTeachList = new ArrayList<GetInstTrainTeachDetail>();

		try {
			
			instTrainTeachList = getInstTrainTeachDetailRepo.getInstTrainTeachDetail(instId, yearId, trainningType);

		} catch (Exception e) {
			
			System.err.println("Exce in getInstTrainTeachDetailList  " + e.getMessage());
			e.printStackTrace();
		}
		
		return instTrainTeachList;
	}

	//get this For Edit show selected values..
	@RequestMapping(value = { "/getInstTrainTeachDetailById" }, method = RequestMethod.POST)
	public @ResponseBody GetInstTrainTeachDetail getInstTrainTeachDetailById(@RequestParam int trainingId) {

		GetInstTrainTeachDetail instTrainTeachList = new GetInstTrainTeachDetail();

		try {
			
			instTrainTeachList = getInstTrainTeachDetailRepo.getInstTrainTeachDetailById(trainingId);

		} catch (Exception e) {
			
			System.err.println("Exce in getInstTrainTeachDetailById  " + e.getMessage());
			e.printStackTrace();
		}
		
		return instTrainTeachList;
	}
	
	
	
	@RequestMapping(value = { "/deleteInstTraining" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstTraining(@RequestParam List<String> trainingIdList) {

		Info info = new Info();
		try {
			int res = instituteTrainingRepo.deleteInstTraining(trainingIdList);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteInstTraining  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
}
