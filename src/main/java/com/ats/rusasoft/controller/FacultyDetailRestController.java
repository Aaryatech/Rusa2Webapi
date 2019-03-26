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

import com.ats.rusasoft.common.DateConvertor;
import com.ats.rusasoft.model.Dept;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.SubjectCo;
import com.ats.rusasoft.model.faculty.GetJournal;
import com.ats.rusasoft.model.faculty.GetResearchProject;
import com.ats.rusasoft.model.faculty.GetSubject;
import com.ats.rusasoft.model.faculty.Journal;
import com.ats.rusasoft.model.faculty.ResearchProject;
import com.ats.rusasoft.model.faculty.SWOC;
import com.ats.rusasoft.model.faculty.Subject;
import com.ats.rusasoft.repo.faculty.GetJournalRepo;
import com.ats.rusasoft.repo.faculty.GetResearchProjectRepo;
import com.ats.rusasoft.repo.faculty.GetSubjectRepo;
import com.ats.rusasoft.repo.faculty.JournalRepo;
import com.ats.rusasoft.repo.faculty.ResearchProjectRepo;
import com.ats.rusasoft.repo.faculty.SWOCRepo;
import com.ats.rusasoft.repo.faculty.SubjectRepo;
import com.ats.rusasoft.repository.SubjectCoRepo;

@RestController
public class FacultyDetailRestController {

	@Autowired
	JournalRepo journalRepo;

	@Autowired
	ResearchProjectRepo researchProjectRepo;

	@Autowired
	GetJournalRepo getJournalRepo;

	@Autowired
	GetResearchProjectRepo getResearchProjectRepo;

	@Autowired
	SubjectRepo subjectRepo;

	@Autowired
	GetSubjectRepo getSubjectRepo;

	@Autowired
	SubjectCoRepo subjectCoRepo;

	@Autowired
	SWOCRepo sWOCRepo;

	@RequestMapping(value = { "/getJournalListByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetJournal> getJournalListByFacultyId(@RequestParam int facultyId,
			@RequestParam int yearId) {

		List<GetJournal> jouList = new ArrayList<>();

		try {
			jouList = getJournalRepo.getJournalRepo(facultyId, yearId);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return jouList;
	}

	@RequestMapping(value = { "/saveReaserchProject" }, method = RequestMethod.POST)
	public @ResponseBody ResearchProject saveReaserchProject(@RequestBody ResearchProject researchProject) {

		ResearchProject projRes = null;

		try {
			projRes = researchProjectRepo.saveAndFlush(researchProject);

		} catch (Exception e) {
			System.err.println("Exce in saving saveReaserchProject " + e.getMessage());
			e.printStackTrace();

		}
		return projRes;
	}

	@RequestMapping(value = { "/getProjectListByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetResearchProject> getProjectListByFacultyId(@RequestParam int facultyId,
			@RequestParam int yearId) {

		List<GetResearchProject> projList = new ArrayList<>();

		try {
			projList = getResearchProjectRepo.getProjectList(facultyId, yearId);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return projList;
	}

	/*
	 * @RequestMapping(value = { "/getProjectListByFacultyId" }, method =
	 * RequestMethod.POST) public @ResponseBody List<ResearchProject>
	 * getProjectListByFacultyId(@RequestParam int facultyId) {
	 * 
	 * List<ResearchProject> projList = new ArrayList<>();
	 * 
	 * try { projList = researchProjectRepo.findByFacultyIdAndDelStatus(facultyId,
	 * 1);
	 * 
	 * } catch (Exception e) { System.err.println("Exce in getJournalByFacultyId  "
	 * + e.getMessage()); e.printStackTrace();
	 * 
	 * } return projList; }
	 */
	@RequestMapping(value = { "/getProjectByProjId" }, method = RequestMethod.POST)
	public @ResponseBody ResearchProject getProjectByProjId(@RequestParam int projectId) {

		ResearchProject researchProjectRes = null;

		try {
			researchProjectRes = researchProjectRepo.findByProjIdAndDelStatus(projectId, 1);
			researchProjectRes.setProjYear(DateConvertor.convertToDMY(researchProjectRes.getProjYear()));

			researchProjectRes.setProjFrdt(DateConvertor.convertToDMY(researchProjectRes.getProjFrdt()));

			researchProjectRes.setProjTodt(DateConvertor.convertToDMY(researchProjectRes.getProjTodt()));

		} catch (Exception e) {
			System.err.println("Exce in getJournalByJournalId  " + e.getMessage());
			e.printStackTrace();

		}
		return researchProjectRes;
	}

	@RequestMapping(value = { "/deleteResearchDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteResearchDetails(@RequestParam List<String> projIdList) {

		Info info = new Info();
		try {
			int res = researchProjectRepo.deleteResearchDetails(projIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteResearchDetails  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@RequestMapping(value = { "/saveJournal" }, method = RequestMethod.POST)
	public @ResponseBody Journal saveJournal(@RequestBody Journal journal) {

		Journal journalRes = null;

		try {
			journalRes = journalRepo.saveAndFlush(journal);

		} catch (Exception e) {
			System.err.println("Exce in saving saveJournal " + e.getMessage());
			e.printStackTrace();

		}
		return journalRes;
	}

	@RequestMapping(value = { "/getJournalByJournalId" }, method = RequestMethod.POST)
	public @ResponseBody Journal getJournalByJournalId(@RequestParam int journalId) {

		Journal journalRes = null;

		try {
			journalRes = journalRepo.findByJournalIdAndDelStatus(journalId, 1);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByJournalId  " + e.getMessage());
			e.printStackTrace();

		}
		return journalRes;
	}

	@RequestMapping(value = { "/getAllJournalList" }, method = RequestMethod.GET)
	public @ResponseBody List<Journal> getAllJournalList() {

		List<Journal> jouList = new ArrayList<>();

		try {
			jouList = journalRepo.findByDelStatusOrderByJournalIdDesc(1);

		} catch (Exception e) {
			System.err.println("Exce in getAllJournalList  " + e.getMessage());
			e.printStackTrace();
		}

		return jouList;

	}

	@RequestMapping(value = { "/getJournalByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<Journal> getJournalByFacultyId(@RequestParam int facultyId) {

		List<Journal> jouList = new ArrayList<>();

		try {
			jouList = journalRepo.findByFacultyIdAndDelStatusOrderByJournalIdDesc(facultyId, 1);

		} catch (Exception e) {
			System.err.println("Exce in getJournalByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return jouList;
	}

	@RequestMapping(value = { "/deleteJournals" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteJournals(@RequestParam List<String> jouIdList) {

		Info info = new Info();
		try {
			int res = journalRepo.deleteJournals(jouIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteJournals  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@RequestMapping(value = { "/saveSubject" }, method = RequestMethod.POST)
	public @ResponseBody Subject saveSubject(@RequestBody Subject subject) {

		Subject subRes = null;

		try {
			subRes = subjectRepo.saveAndFlush(subject);

		} catch (Exception e) {
			System.err.println("Exce in saving saveSubject " + e.getMessage());
			e.printStackTrace();

		}
		return subRes;
	}

	@RequestMapping(value = { "/deleteSubjects" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSubjects(@RequestParam List<String> subIdList) {

		Info info = new Info();
		try {
			int res = subjectRepo.deleteSubjects(subIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteSubjects  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@RequestMapping(value = { "/getSubjectBySubId" }, method = RequestMethod.POST)
	public @ResponseBody Subject getSubjectBySubId(@RequestParam int subId) {

		Subject subRes = null;

		try {
			subRes = subjectRepo.findBySubIdAndDelStatus(subId, 1);

		} catch (Exception e) {
			System.err.println("Exce in getSubjectBySubId  " + e.getMessage());
			e.printStackTrace();

		}
		return subRes;
	}

	@RequestMapping(value = { "/getAllSubjectList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSubject> getAllSubjectList(@RequestParam("facultyId") int facultyId,
			@RequestParam("yearId") int yearId) {

		List<GetSubject> subList = new ArrayList<>();

		try {
			subList = getSubjectRepo.getProjectList(facultyId, yearId);

		} catch (Exception e) {
			System.err.println("Exce in getAllJournalList  " + e.getMessage());
			e.printStackTrace();
		}

		return subList;

	}

	@RequestMapping(value = { "/saveSubjectCo" }, method = RequestMethod.POST)
	public @ResponseBody SubjectCo saveSubjectCo(@RequestBody SubjectCo subject) {

		SubjectCo subRes = null;

		try {
			subRes = subjectCoRepo.saveAndFlush(subject);

		} catch (Exception e) {
			System.err.println("Exce in saving saveSubject " + e.getMessage());
			e.printStackTrace();

		}
		return subRes;
	}

	@RequestMapping(value = { "/getSubjectCoBySubId" }, method = RequestMethod.POST)
	public @ResponseBody SubjectCo getSubjectCoBySubId(@RequestParam int coId) {

		SubjectCo subRes = null;

		try {

			subRes = subjectCoRepo.findByCoIdAndDelStatusAndIsActive(coId, 1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getSubjectBySubId  " + e.getMessage());
			e.printStackTrace();

		}
		return subRes;
	}

	@RequestMapping(value = { "/deleteSubjectsCo" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSubjectsCo(@RequestParam int coId) {

		Info info = new Info();
		try {
			int res = subjectCoRepo.deleteSubjects(coId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteSubjects  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	
	@RequestMapping(value = { "/updateSubjeCoName" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSubjeCoName(@RequestParam("coName") String coName,@RequestParam("coId") int coId) {

		Info info = new Info();
		try {
			int res = subjectCoRepo.updateSubjeCoName(coName,coId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteSubjects  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@RequestMapping(value = { "/getSubjectCoListBySubId" }, method = RequestMethod.POST)
	public @ResponseBody List<SubjectCo> getSubjectCoListBySubId(@RequestParam int subId, @RequestParam int facultyId) {

		List<SubjectCo> List = new ArrayList<>();

		try {

			List = subjectCoRepo.findBySubIdAndDelStatusAndIsActiveAndFacultyIdOrderByCoIdDesc(subId, 1, 1, facultyId);

		} catch (Exception e) {
			System.err.println("Exce in getSubjectBySubId  " + e.getMessage());
			e.printStackTrace();

		}
		return List;
	}

	// ----------------SWOC------------------------------
	@RequestMapping(value = { "/saveSWOCList" }, method = RequestMethod.POST)
	public @ResponseBody List<SWOC> saveSWOCList(@RequestBody List<SWOC> swocList) {

		List<SWOC> sWOCResList = new ArrayList<>();

		try {
			sWOCResList = sWOCRepo.saveAll(swocList);

		} catch (Exception e) {
			System.err.println("Exce in saving saveSWOCList " + e.getMessage());
			e.printStackTrace();

		}
		return sWOCResList;
	}

	@RequestMapping(value = { "/deleteSwoc" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSwoc(@RequestParam List<String> swocIdList) {

		Info info = new Info();
		try {
			int res = sWOCRepo.deleteSWOC(swocIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteSubjects  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@RequestMapping(value = { "/getSWOCBySwocId" }, method = RequestMethod.POST)
	public @ResponseBody SWOC getSWOCBySwocId(@RequestParam int swocId) {

		SWOC swocRes = null;

		try {

			System.out.println("swocId" + swocId);
			swocRes = sWOCRepo.findBySwocIdAndDelStatus(swocId, 1);
			System.out.println("swocRes" + swocRes.toString());

		} catch (Exception e) {
			System.err.println("Exce in getSubjectBySubId  " + e.getMessage());
			e.printStackTrace();

		}
		return swocRes;
	}

	@RequestMapping(value = { "/getSWOCByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<SWOC> getSWOCByFacultyId(@RequestParam int facultyId) {

		List<SWOC> swocList = new ArrayList<>();

		try {
			swocList = sWOCRepo.findByFacultyIdAndDelStatusOrderBySwocIdDesc(facultyId, 1);

		} catch (Exception e) {
			System.err.println("Exce in getSWOCByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return swocList;
	}

	@RequestMapping(value = { "/getSWOCByFacultyIdAndType" }, method = RequestMethod.POST)
	public @ResponseBody List<SWOC> getSWOCByFacultyIdAndType(@RequestParam int facultyId, @RequestParam int swocType) {

		List<SWOC> swocList = new ArrayList<>();

		try {
			swocList = sWOCRepo.findByFacultyIdAndDelStatusAndSwocTypeOrderBySwocIdDesc(facultyId, 1, swocType);

		} catch (Exception e) {
			System.err.println("Exce in getSWOCByFacultyId  " + e.getMessage());
			e.printStackTrace();

		}
		return swocList;
	}

	@RequestMapping(value = { "/saveSWOC" }, method = RequestMethod.POST)
	public @ResponseBody SWOC saveSWOC(@RequestBody SWOC sWOC) {

		SWOC subRes = null;

		try {
			subRes = sWOCRepo.saveAndFlush(sWOC);

		} catch (Exception e) {
			System.err.println("Exce in saving sWOCRepo " + e.getMessage());
			e.printStackTrace();

		}
		return subRes;
	}

}