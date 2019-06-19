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

import com.ats.rusasoftapi.model.AccOfficer;
import com.ats.rusasoftapi.model.Dept;
import com.ats.rusasoftapi.model.FacultyAward;
import com.ats.rusasoftapi.model.FacultyOutreach;
import com.ats.rusasoftapi.model.FacultyPatent;
import com.ats.rusasoftapi.model.GetFacultyActivity;
import com.ats.rusasoftapi.model.GetFacultyAward;
import com.ats.rusasoftapi.model.GetFacultyOutrea;
import com.ats.rusasoftapi.model.GetFacultyPatent;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.OutreachType;
import com.ats.rusasoftapi.model.faculty.FacultyEmpowerment;
import com.ats.rusasoftapi.model.faculty.GetFacultyEmpwrList;
import com.ats.rusasoftapi.model.faculty.GetFacultyOutreach;
import com.ats.rusasoftapi.model.faculty.GetJournal;
import com.ats.rusasoftapi.model.faculty.GetResearchProject;
import com.ats.rusasoftapi.model.progdetail.ProgramType;
import com.ats.rusasoftapi.mstrepo.FacultyOutreachRepo;
import com.ats.rusasoftapi.mstrepo.FacultyPatentRepo;
import com.ats.rusasoftapi.mstrepo.GetFacultyPatentRepo;
import com.ats.rusasoftapi.mstrepo.OutreachTypeRepo;
import com.ats.rusasoftapi.prodetailrepo.FacultyAwardRepo;
import com.ats.rusasoftapi.prodetailrepo.FacultyEmpowermentRepo;
import com.ats.rusasoftapi.prodetailrepo.GetFacultyAwardRepo;
import com.ats.rusasoftapi.prodetailrepo.GetFacultyEmpwrListRepo;
import com.ats.rusasoftapi.repo.faculty.GetFacultyOutreaRepo;
import com.ats.rusasoftapi.repo.faculty.GetFacultyOutreachRepo;
import com.ats.rusasoftapi.repositories.GetFacultyActivityRepo;

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

	@Autowired
	GetFacultyPatentRepo getFacultyPatentRepo;

	@Autowired
	GetFacultyAwardRepo getFacultyAwardRepo;

	@Autowired
	GetFacultyOutreaRepo getFacultyOutreaRepo;

	@Autowired
	GetFacultyActivityRepo getFacultyActivityRepo;

	@RequestMapping(value = { "/getFacultyActivityListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacultyActivity> getFacultyActivityListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
		//		+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);

		List<GetFacultyActivity> facOutList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				facOutList = getFacultyActivityRepo.getActivityListYear(yearId, instituteId);
			} else if (isHod == 1) {
				facOutList = getFacultyActivityRepo.getActivityListByDept(deptIdList, yearId, instituteId);
			} else {
				facOutList = getFacultyActivityRepo.getActivityList(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getFacultyActivityListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return facOutList;
	}

	@RequestMapping(value = { "/getOutReachListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacultyOutrea> getOutReachListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
		//		+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);

		List<GetFacultyOutrea> facOutList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				facOutList = getFacultyOutreaRepo.getOutReachListYear(yearId, instituteId);
			} else if (isHod == 1) {
				facOutList = getFacultyOutreaRepo.getOutReachListByDept(deptIdList, yearId, instituteId);
			} else {
				facOutList = getFacultyOutreaRepo.getOutReachList(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return facOutList;
	}
	// --------------------------------------------Faculty
	// Patent-----------------------------------------------------//

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

	@RequestMapping(value = { "/getPatentListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacultyPatent> getPatentListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
			//	+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);

		List<GetFacultyPatent> patentList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				patentList = getFacultyPatentRepo.getPatentListYear(yearId, instituteId);
			} else if (isHod == 1) {
				patentList = getFacultyPatentRepo.getPatentListByDept(deptIdList, yearId, instituteId);
			} else {
				patentList = getFacultyPatentRepo.getPatentList(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return patentList;
	}

	@RequestMapping(value = { "/getAwardListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacultyAward> getAwardListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
		//	+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);

		List<GetFacultyAward> awardList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				awardList = getFacultyAwardRepo.getAwardListYear(yearId, instituteId);
			} else if (isHod == 1) {
				awardList = getFacultyAwardRepo.getAwardListByDept(deptIdList, yearId, instituteId);
			} else {
				awardList = getFacultyAwardRepo.getAwardList(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return awardList;
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

			acOfRes = patentRepo.findByPatentIdAndDelStatus(patentId, 1);

		} catch (Exception e) {
			System.err.println("Excc in getting one patent id by patentid " + e.getMessage());
			e.printStackTrace();
		}
		return acOfRes;
	}

	@RequestMapping(value = { "/deletePetentFaculty" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePetentFaculty(@RequestParam("patentId") int patentId) {

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
	// --------------------------------------------Faculty
	// Award-----------------------------------------------------//

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

			acOfRes = facultyAwardRepo.findByAwardIdAndDelStatus(awardId, 1);

		} catch (Exception e) {
			System.err.println("Excc in getting one award id by id " + e.getMessage());
			e.printStackTrace();
		}
		return acOfRes;
	}

	@RequestMapping(value = { "/deleteAwardFaculty" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAwardFaculty(@RequestParam("awardId") int awardId) {

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

	// --------------------------------------------Faculty
	// OutReach-----------------------------------------------------//

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
		// System.out.println("date:::" + patent.getOutreachDate());
		try {
			patentRes = facultyOutreachRepo.saveAndFlush(patent);

		} catch (Exception e) {
			System.err.println("Exce in saving petent faculty  " + e.getMessage());
			e.printStackTrace();

		}
		return patentRes;
	}

	@RequestMapping(value = { "/getOutReachListByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacultyOutreach> getOutReachListByFacultyId(@RequestParam int facultyId,
			@RequestParam int instituteId) {

		List<GetFacultyOutreach> jouList = new ArrayList<>();

		try {
			jouList = getFacultyOutreachRepo.getOutreachList(facultyId, instituteId);

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

			acOfRes = facultyOutreachRepo.findByOutreachIdAndDelStatus(outreachId, 1);

		} catch (Exception e) {
			System.err.println("Excc in getting one patent id by patentid " + e.getMessage());
			e.printStackTrace();
		}
		return acOfRes;
	}

	@RequestMapping(value = { "/deleteOutreachFaculty" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteOutreachFaculty(@RequestParam("outreachId") int outreachId) {

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

	////////////////////// **************************Outreach
	////////////////////// Type********************************////////////////////////

	@Autowired
	OutreachTypeRepo outreachTypeRepo;

	@RequestMapping(value = { "/getOutReachTypeList" }, method = RequestMethod.POST)
	public @ResponseBody List<OutreachType> getOutReachTypeList(@RequestParam int instituteId) {

		List<OutreachType> jouList = new ArrayList<>();

		try {
			jouList = outreachTypeRepo.findByDelStatusOrderByTypeIdDesc(1);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return jouList;
	}
	
	/**********************************************Faculty Empowerment******************************************/
	@Autowired FacultyEmpowermentRepo facEmpRepo;
	
	@RequestMapping(value = { "/saveFacultyEmpowerment" }, method = RequestMethod.POST)
	public @ResponseBody FacultyEmpowerment saveFacultyEmpowerment(@RequestBody FacultyEmpowerment fac) {

		FacultyEmpowerment facEmp = null;
		try {
			facEmp = facEmpRepo.saveAndFlush(fac);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();

		}
		return facEmp;
	}

	
	
	/*
	 * @RequestMapping(value = { "/getFacEmpowerList" }, method =
	 * RequestMethod.POST) public @ResponseBody List<FacultyEmpowerment>
	 * getFacEmpowerList(@RequestParam int instituteId, @RequestParam int yearId) {
	 * 
	 * List<FacultyEmpowerment> facEmp = new ArrayList<>();
	 * 
	 * try { facEmp =
	 * facEmpRepo.findByInstIdAndAcYearIdAndDelStatusOrderByFacultyEmpwrmntIdDesc(
	 * instituteId, yearId, 1);
	 * 
	 * } catch (Exception e) { System.err.println("Exce in getFacEmpowerList  " +
	 * e.getMessage()); e.printStackTrace();
	 * 
	 * } return facEmp; }
	 */
	
	@Autowired GetFacultyEmpwrListRepo getFacEmpwrList;
	
	@RequestMapping(value = { "/getFacEmpowerList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacultyEmpwrList> getFacEmpowerList(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
			//	+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);

		List<GetFacultyEmpwrList> facEmpwrList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				facEmpwrList = getFacEmpwrList.getFacultyEmpwrListByYearAndInstId(yearId, instituteId);
			} else if (isHod == 1) {
				facEmpwrList = getFacEmpwrList.getFacultyEmpwrListByDept(deptIdList, yearId, instituteId);
			} else {
				facEmpwrList = getFacEmpwrList.getFacultyEmpowerList(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return facEmpwrList;
	}
	
	
	@RequestMapping(value = { "/getFacultyEmpowerById" }, method = RequestMethod.POST)
	public @ResponseBody FacultyEmpowerment getFacultyEmpowerById(@RequestParam int facEmpwrId) {

		FacultyEmpowerment facEmp = new FacultyEmpowerment();

		try {
			facEmp = facEmpRepo.findByFacultyEmpwrmntId(facEmpwrId);

		} catch (Exception e) {
			System.err.println("Exce in getFacultyEmpowerById  " + e.getMessage());
			e.printStackTrace();

		}
		return facEmp;
	}
	
	@RequestMapping(value = { "/deleteFacultyEmpowerById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteFacultyEmpowerById(@RequestParam("facEmpwrId") int facEmpwrId) {

		Info info = new Info();
		try {

			try {
				int res = facEmpRepo.deleteFacultyEmpowr(facEmpwrId);
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
}
