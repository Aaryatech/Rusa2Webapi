package com.ats.rusasoftapi.controller;

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

import com.ats.rusasoftapi.model.faculty.FacultyAcademic;
import com.ats.rusasoftapi.model.faculty.FacultyPersonalDetail;
import com.ats.rusasoftapi.model.faculty.FacultyPhdDetails;
import com.ats.rusasoftapi.model.faculty.GetFacAcademic;
import com.ats.rusasoftapi.model.faculty.GetFacPerDetail;
import com.ats.rusasoftapi.model.faculty.GetFacPhdGuideDetail;
import com.ats.rusasoftapi.repo.faculty.FacultyAcademicRepo;
import com.ats.rusasoftapi.repo.faculty.FacultyPersonalDetailRepo;
import com.ats.rusasoftapi.repo.faculty.FacultyPhdDetailsRepo;
import com.ats.rusasoftapi.repo.faculty.GetFacAcademicRepo;
import com.ats.rusasoftapi.repo.faculty.GetFacPerDetailRepo;
import com.ats.rusasoftapi.repo.faculty.GetFacPhdGuideDetailRepo;

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
	
	
	@RequestMapping(value = { "/getFacAcademic" }, method = RequestMethod.POST)
	public @ResponseBody FacultyAcademic getFacAcademic(
			@RequestParam int fAcaId) {

		FacultyAcademic facAcaRes = null;

		try {
			facAcaRes = facultyAcademicRepo.findByFAcaIdAndDelStatusAndIsActive(fAcaId, 1, 1);
		} catch (Exception e) {
			System.err.println("Exce in  getFacAcademic by FAcadeid" + e.getMessage());
			e.printStackTrace();
		}

		return facAcaRes;
	}
	
	@RequestMapping(value = { "/getFacAcademicByFacId" }, method = RequestMethod.POST)
	public @ResponseBody FacultyAcademic getFacAcademicByFacId(
			@RequestParam int facultyId) {
		//System.err.println("getFacAcademicByFacId  facultyId " +facultyId);
		

		FacultyAcademic facAcaRes = new FacultyAcademic();

		try {
			facAcaRes = facultyAcademicRepo.findByFacultyIdAndDelStatusAndIsActive(facultyId, 1, 1);
			//System.err.println("facAcaRes  getFacAcademicByFacId " +facAcaRes.toString());
		} catch (Exception e) {
			System.err.println("Exce in  getFacAcademicByFacId by FAcadeid" + e.getMessage());
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
	
	//GetFacPhdGuideDetailRepo
	@Autowired GetFacPhdGuideDetailRepo getFacPhdGuideDetailRepo;
	
	@RequestMapping(value = { "/getFacPhdGuideDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacPhdGuideDetail> getFacPhdGuideDetailList(
			@RequestParam int instId) {

		List<GetFacPhdGuideDetail> facPerDetList = new ArrayList<GetFacPhdGuideDetail>();

		try {
			facPerDetList = getFacPhdGuideDetailRepo.getFacPhdGuideDetail(instId);
		} catch (Exception e) {
			System.err.println("Exce in getting getFacPhdGuideDetailList " + e.getMessage());
			e.printStackTrace();
		}

		return facPerDetList;
	}
	
	
	//GetFacAcademicRepo
	@Autowired GetFacAcademicRepo getFacAcademicRepo;
	
	
	@RequestMapping(value = { "/getFacAcademicList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacAcademic> getFacAcademicList(
			@RequestParam int instId) {

		List<GetFacAcademic> facPerDetList = new ArrayList<GetFacAcademic>();

		try {
			facPerDetList = getFacAcademicRepo.getFacAcademic(instId);
		} catch (Exception e) {
			System.err.println("Exce in getting getFacAcademicList " + e.getMessage());
			e.printStackTrace();
		}

		return facPerDetList;
	}
	
}
