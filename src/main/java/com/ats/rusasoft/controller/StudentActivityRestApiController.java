package com.ats.rusasoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.GetProgramActivity;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.ProgramActivity;
import com.ats.rusasoft.repository.GetProgramActivityRepo;
import com.ats.rusasoft.repository.ProgramStudentActivityRepo;
 

@RestController
public class StudentActivityRestApiController {
	
	@Autowired
	ProgramStudentActivityRepo programStudentActivityRepo;
	
	@Autowired
	GetProgramActivityRepo getProgramActivityRepo;
	
	@RequestMapping(value = { "/saveStudentActivity" }, method = RequestMethod.POST)
	public @ResponseBody ProgramActivity saveLoginLog(@RequestBody ProgramActivity programActivity) {

		ProgramActivity save = new ProgramActivity();
 
		try {

			save = programStudentActivityRepo.saveAndFlush(programActivity);


		} catch (Exception e) {
		 
			e.printStackTrace();
		}

		return save;

	}
	
	@RequestMapping(value = { "/getStudentAcitivityList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetProgramActivity> getStudentAcitivityList(@RequestParam("yearId") int yearId, @RequestParam("type") int type) {

		List<GetProgramActivity> list = new ArrayList<>();
 
		try {

			list = getProgramActivityRepo.getStudentAcitivityList(type,yearId);

			
		} catch (Exception e) {
		 
			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getStudentAcitivityByActivityId" }, method = RequestMethod.POST)
	public @ResponseBody GetProgramActivity getStudentAcitivityByActivityId(@RequestParam("yearId") int yearId, @RequestParam("type") int type,
			@RequestParam("activityId") int activityId) {

		 GetProgramActivity getProgramActivity = new GetProgramActivity();
 
		try {

			getProgramActivity = getProgramActivityRepo.getStudentAcitivityByActivityId(activityId,type,yearId);

			
		} catch (Exception e) {
		 
			e.printStackTrace();
		}

		return getProgramActivity;

	}
	
	@RequestMapping(value = { "/deleteActivity" }, method = RequestMethod.POST)
	public @ResponseBody GetProgramActivity deleteActivity(@RequestParam("activityId") int activityId ) {

		 GetProgramActivity getProgramActivity = new GetProgramActivity();
 
		try {

			Info info = new Info();
			try {
				int res = programStudentActivityRepo.deleteActivity(activityId);
				if (res > 0) {
					info.setError(false);
					info.setMsg("success");

				} else {
					info.setError(true);
					info.setMsg("failed");

				}
			} catch (Exception e) {

				System.err.println("Exce in deleteHods  " + e.getMessage());
				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

			
		} catch (Exception e) {
		 
			e.printStackTrace();
		}

		return getProgramActivity;

	}

}
