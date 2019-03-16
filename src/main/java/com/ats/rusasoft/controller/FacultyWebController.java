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

import com.ats.rusasoft.model.AccOfficer;
import com.ats.rusasoft.model.Dept;
import com.ats.rusasoft.model.FacultyAward;
import com.ats.rusasoft.model.FacultyOutreach;
import com.ats.rusasoft.model.FacultyPatent;
import com.ats.rusasoft.model.progdetail.ProgramType;
import com.ats.rusasoft.mstrepo.FacultyOutreachRepo;
import com.ats.rusasoft.mstrepo.FacultyPatentRepo;
import com.ats.rusasoft.prodetailrepo.FacultyAwardRepo;


@RestController
public class FacultyWebController {

	
	@Autowired
	FacultyPatentRepo patentRepo;
	
	@Autowired
	FacultyAwardRepo facultyAwardRepo;
	
	@Autowired
	FacultyOutreachRepo facultyOutreachRepo;

	//--------------------------------------------Faculty Patent-----------------------------------------------------//

	@RequestMapping(value = { "/getAllFacultyPatent" }, method = RequestMethod.GET)
	public @ResponseBody List<FacultyPatent> getAllFacultyPatent() {

		List<FacultyPatent> patentList = new ArrayList<>();

		try {
			
			patentList = patentRepo.findByDelStatusAndIsActive(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllFacultyPatent  " + e.getMessage());
			e.printStackTrace();
		}

		return patentList;

	}
	
	@RequestMapping(value = { "/saveFacultyPatent" }, method = RequestMethod.POST)
	public @ResponseBody FacultyPatent saveFacultyPatent(@RequestBody FacultyPatent patent) {

		FacultyPatent patentRes = null;

		try {
			patentRes = patentRepo.saveAndFlush(patent);

		} catch (Exception e) {
			System.err.println("Exce in saving petent faculty  " + e.getMessage());
			e.printStackTrace();

		}
		return patentRes;
	}

	
	@RequestMapping(value = { "/getFacultyPatent" }, method = RequestMethod.POST)
	public @ResponseBody FacultyPatent getFacultyPatent(@RequestParam int patentId) {

		FacultyPatent acOfRes = null;

		try {

			acOfRes = patentRepo.findByPatentIdAndDelStatus(patentId,1);
			
		} catch (Exception e) {
			System.err.println("Excc in getting one patent id by patentid "+e.getMessage());
			e.printStackTrace();
		}
		return acOfRes;
	}
	
	//--------------------------------------------Faculty Award-----------------------------------------------------//
	
	@RequestMapping(value = { "/getAllFacultyAward" }, method = RequestMethod.GET)
	public @ResponseBody List<FacultyAward> getAllFacultyAward() {

		List<FacultyAward> patentList = new ArrayList<>();

		try {
			
			patentList = facultyAwardRepo.findByDelStatusAndIsActive(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllFacultyPatent  " + e.getMessage());
			e.printStackTrace();
		}

		return patentList;

	}
	
	@RequestMapping(value = { "/saveFacultyAward" }, method = RequestMethod.POST)
	public @ResponseBody FacultyAward saveFacultyAward(@RequestBody FacultyAward patent) {

		FacultyAward patentRes = null;

		try {
			patentRes = facultyAwardRepo.saveAndFlush(patent);

		} catch (Exception e) {
			System.err.println("Exce in saving petent faculty  " + e.getMessage());
			e.printStackTrace();

		}
		return patentRes;
	}
  
	
	@RequestMapping(value = { "/getFacultyAwardById" }, method = RequestMethod.POST)
	public @ResponseBody FacultyAward getFacultyAward(@RequestParam int awardId) {

		FacultyAward acOfRes = null;

		try {

			acOfRes = facultyAwardRepo.findByAwardIdAndDelStatus(awardId,1);
			
		} catch (Exception e) {
			System.err.println("Excc in getting one award id by id "+e.getMessage());
			e.printStackTrace();
		}
		return acOfRes;
	}
	
	//--------------------------------------------Faculty OutReach-----------------------------------------------------//

	@RequestMapping(value = { "/getAllFacultyOutReach" }, method = RequestMethod.GET)
	public @ResponseBody List<FacultyOutreach> getAllFacultyOutReach() {

		List<FacultyOutreach> patentList = new ArrayList<>();

		try {
			
			patentList = facultyOutreachRepo.findByDelStatusAndIsActive(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllFacultyPatent  " + e.getMessage());
			e.printStackTrace();
		}

		return patentList;
 
	}
	
	@RequestMapping(value = { "/saveFacultyOutReach" }, method = RequestMethod.POST)
	public @ResponseBody FacultyOutreach saveFacultyOutReach(@RequestBody FacultyOutreach patent) {

		FacultyOutreach patentRes = null;

		try {
			patentRes = facultyOutreachRepo.saveAndFlush(patent);

		} catch (Exception e) {
			System.err.println("Exce in saving petent faculty  " + e.getMessage());
			e.printStackTrace();

		}
		return patentRes;
	}

	
	@RequestMapping(value = { "/getFacultyOutReach" }, method = RequestMethod.POST)
	public @ResponseBody FacultyOutreach getFacultyOutReach(@RequestParam int outreachId) {

		FacultyOutreach acOfRes = null;

		try {

			acOfRes = facultyOutreachRepo.findByOutreachIdAndDelStatus(outreachId,1);
			
		} catch (Exception e) {
			System.err.println("Excc in getting one patent id by patentid "+e.getMessage());
			e.printStackTrace();
		}
		return acOfRes;
	}
}
