package com.ats.rusasoft.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.faculty.FacultyAcademic;
import com.ats.rusasoft.model.faculty.FacultyPersonalDetail;
import com.ats.rusasoft.model.faculty.FacultyPhdDetails;
import com.ats.rusasoft.model.faculty.GetFacPerDetail;
import com.ats.rusasoft.repo.faculty.FacultyAcademicRepo;
import com.ats.rusasoft.repo.faculty.FacultyPersonalDetailRepo;
import com.ats.rusasoft.repo.faculty.FacultyPhdDetailsRepo;
import com.ats.rusasoft.repo.faculty.GetFacPerDetailRepo;

@RestController
public class FacPerDetailController {
	
	@Autowired FacultyAcademicRepo facultyAcademicRepo;
	
	@RequestMapping(value = { "/saveFacultyAcademic" }, method = RequestMethod.POST)
	public @ResponseBody FacultyAcademic saveFacultyAcademic(
			@RequestBody FacultyAcademic facAcademic) {

		FacultyAcademic facAcaRes = null;

		try {
			facAcaRes = facultyAcademicRepo.save(facAcademic);
		} catch (Exception e) {
			System.err.println("Exce in saving saveFacultyAcademic " + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}

	@Autowired
	FacultyPersonalDetailRepo facultyPersonalDetailRepo;

	@RequestMapping(value = { "/saveFacultyPersonalDetail" }, method = RequestMethod.POST)
	public @ResponseBody FacultyPersonalDetail saveFacultyPersonalDetail(
			@RequestBody FacultyPersonalDetail facPersonalDetail) {

		FacultyPersonalDetail facPersonalDetailRes = null;

		try {

			facPersonalDetailRes = facultyPersonalDetailRepo.save(facPersonalDetail);

		} catch (Exception e) {

			System.err.println("Exce in saving saveFacultyPersonalDetail " + e.getMessage());
			e.printStackTrace();

		}

		return facPersonalDetailRes;
	}
	
	
	@RequestMapping(value = { "/getFacultyPersonalDetail" }, method = RequestMethod.POST)
	public @ResponseBody FacultyPersonalDetail getFacultyPersonalDetail(
			@RequestParam int facultyId) {

		FacultyPersonalDetail facPersonalDetailRes = null;

		try {
			facPersonalDetailRes = facultyPersonalDetailRepo.findByFacultyId(facultyId);
		} catch (Exception e) {
			System.err.println("Exce in saving getFacultyPersonalDetail " + e.getMessage());
			e.printStackTrace();
		}

		return facPersonalDetailRes;
	}
	
	@Autowired GetFacPerDetailRepo getFacPerDetailRepo;
	
	@RequestMapping(value = { "/getFacPerDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacPerDetail> getFacPerDetailList(
			@RequestParam int instId) {

		List<GetFacPerDetail> facPerDetList = new ArrayList<GetFacPerDetail>();

		try {
			facPerDetList = getFacPerDetailRepo.getGetFacPerDetail(instId, new Date());
		} catch (Exception e) {
			System.err.println("Exce in saving getFacultyPersonalDetail " + e.getMessage());
			e.printStackTrace();
		}

		return facPerDetList;
	}
	
	
	//FacultyPhdDetailsRepo
	@Autowired FacultyPhdDetailsRepo facultyPhdDetailsRepo;
	
	@RequestMapping(value = { "/saveFacultyPhdDetails" }, method = RequestMethod.POST)
	public @ResponseBody FacultyPhdDetails saveFacultyPhdDetails(
			@RequestBody FacultyPhdDetails facPhdDetail) {

		FacultyPhdDetails facPhdDetailRes = null;

		try {

			facPhdDetailRes = facultyPhdDetailsRepo.save(facPhdDetail);

		} catch (Exception e) {

			System.err.println("Exce in saving saveFacultyPhdDetails " + e.getMessage());
			e.printStackTrace();

		}

		return facPhdDetailRes;
	}
	
	@RequestMapping(value = { "/getFacultyPhdDetail" }, method = RequestMethod.POST)
	public @ResponseBody FacultyPhdDetails getFacultyPhdDetail(
			@RequestParam int facultyId) {

		FacultyPhdDetails facPhdDetailRes = null;

		try {
			facPhdDetailRes = facultyPhdDetailsRepo.findByFacultyId(facultyId);
		} catch (Exception e) {
			System.err.println("Exce in getFacultyPhdDetail " + e.getMessage());
			e.printStackTrace();
		}

		return facPhdDetailRes;
	}
	
}
