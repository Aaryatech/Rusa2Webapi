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
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.OutreachType;
import com.ats.rusasoft.model.faculty.GetFacultyOutreach;
import com.ats.rusasoft.model.faculty.GetJournal;
import com.ats.rusasoft.model.progdetail.ProgramType;
import com.ats.rusasoft.mstrepo.FacultyOutreachRepo;
import com.ats.rusasoft.mstrepo.FacultyPatentRepo;
import com.ats.rusasoft.mstrepo.OutreachTypeRepo;
import com.ats.rusasoft.prodetailrepo.FacultyAwardRepo;
import com.ats.rusasoft.repo.faculty.GetFacultyOutreachRepo;


@RestController
public class FacultyWebController {

	
	@Autowired
	FacultyPatentRepo patentRepo;
	
	@Autowired
	FacultyAwardRepo facultyAwardRepo;
	
	@Autowired
	FacultyOutreachRepo facultyOutreachRepo;

	@Autowired
	GetFacultyOutreachRepo getFacultyOutreachRepo;
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
	
	@RequestMapping(value = { "/getPatentListByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<FacultyPatent> getPatentListByFacultyId(@RequestParam int facultyId) {

		List<FacultyPatent> jouList = new ArrayList<>();

		try {
			jouList = patentRepo.getPetentRepo(facultyId);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return jouList;
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
	
	@RequestMapping(value = { "/deletePetentFaculty" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePetentFaculty(@RequestParam("patentId") int patentId ) {

		 
		 Info info = new Info();
		try {

			
			try {
				int res = patentRepo.deletePetent(patentId);
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

		return info;

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
	

	@RequestMapping(value = { "/getAwardListByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<FacultyAward> getAwardListByFacultyId(@RequestParam int facultyId) {

		List<FacultyAward> jouList = new ArrayList<>();

		try {
			jouList = facultyAwardRepo.getAwardRepo(facultyId);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return jouList;
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
	@RequestMapping(value = { "/deleteAwardFaculty" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAwardFaculty(@RequestParam("awardId") int awardId ) {

		 
		 Info info = new Info();
		try {

			
			try {
				int res = facultyAwardRepo.deleteAward(awardId);
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

		return info;

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
		System.out.println("date:::"+patent.getOutreachDate());
		try {
			patentRes = facultyOutreachRepo.saveAndFlush(patent);
			

		} catch (Exception e) {
			System.err.println("Exce in saving petent faculty  " + e.getMessage());
			e.printStackTrace();

		}
		return patentRes;
	}

	@RequestMapping(value = { "/getOutReachListByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacultyOutreach> getOutReachListByFacultyId(@RequestParam int facultyId,@RequestParam int instituteId) {

		List<GetFacultyOutreach> jouList = new ArrayList<>();

		try {
			jouList = getFacultyOutreachRepo.getOutreachList(facultyId,instituteId);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return jouList;
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
	@RequestMapping(value = { "/deleteOutreachFaculty" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteOutreachFaculty(@RequestParam("outreachId") int outreachId ) {

		 
		 Info info = new Info();
		try {

			
			try {
				int res = facultyOutreachRepo.deleteOutReach(outreachId);
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

		return info;

	}
	
	
	
	//////////////////////**************************Outreach Type********************************////////////////////////
	

	@Autowired
	OutreachTypeRepo outreachTypeRepo;
	
	
	@RequestMapping(value = { "/getOutReachTypeList" }, method = RequestMethod.POST)
	public @ResponseBody List<OutreachType> getOutReachTypeList(@RequestParam int instituteId) {

		List<OutreachType> jouList = new ArrayList<>();

		try {
			jouList = outreachTypeRepo.findByDelStatusAndInstituteIdOrderByTypeIdDesc(1,instituteId);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return jouList;
	}
	
	
	
	
}
