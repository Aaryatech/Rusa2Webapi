package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.common.DateConvertor;
import com.ats.rusasoftapi.model.Dept;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.NewDeanList;
import com.ats.rusasoftapi.model.SubjectCo;
import com.ats.rusasoftapi.model.faculty.GetJournal;
import com.ats.rusasoftapi.model.faculty.GetResearchProject;
import com.ats.rusasoftapi.model.faculty.GetSWOC;
import com.ats.rusasoftapi.model.faculty.GetSubject;
import com.ats.rusasoftapi.model.faculty.Journal;
import com.ats.rusasoftapi.model.faculty.ResearchProject;
import com.ats.rusasoftapi.model.faculty.SWOC;
import com.ats.rusasoftapi.model.faculty.Subject;
import com.ats.rusasoftapi.mstrepo.DeptRepo;
import com.ats.rusasoftapi.repo.faculty.GetJournalRepo;
import com.ats.rusasoftapi.repo.faculty.GetResearchProjectRepo;
import com.ats.rusasoftapi.repo.faculty.GetSWOCRepo;
import com.ats.rusasoftapi.repo.faculty.GetSubjectRepo;
import com.ats.rusasoftapi.repo.faculty.JournalRepo;
import com.ats.rusasoftapi.repo.faculty.NewDeanListRepository;
import com.ats.rusasoftapi.repo.faculty.ResearchProjectRepo;
import com.ats.rusasoftapi.repo.faculty.SWOCRepo;
import com.ats.rusasoftapi.repo.faculty.SubjectRepo;
import com.ats.rusasoftapi.repository.SubjectCoRepo;

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

	@Autowired
	GetSWOCRepo getSWOCRepo;

	@Autowired
	NewDeanListRepository newDeanListRepository;

	@Autowired
	DeptRepo deptRepo;

	@RequestMapping(value = { "/getNewHodList" }, method = RequestMethod.POST)
	public @ResponseBody List<NewDeanList> getNewHodList(@RequestParam int instituteId) {

		List<NewDeanList> facultyList = new ArrayList<>();

		try {

			facultyList = newDeanListRepository.getNewHodList(instituteId);

			for (int i = 0; i < facultyList.size(); i++) {

				List<Integer> deptIds = Stream.of(facultyList.get(i).getDeptId().split(",")).map(Integer::parseInt)
						.collect(Collectors.toList());
				List<Dept> deptList = new ArrayList<>();

				deptList = deptRepo.findByDelStatusAndIsActiveAndDeptIdIn(1, 1, deptIds);

				String deptName = "";
				int x=0;
				for (int j = 0; j < deptList.size(); j++) {

					deptName = deptList.get(j).getDeptName() + "," + deptName;
					if(deptList.size()>1)
						x=1;

				}
if(x==1)
				facultyList.get(i).setDeptName(deptName.substring(0, deptName.length() - 1));
			}

		} catch (Exception e) {
			System.err.println("Exce in getNewHodList  " + e.getMessage());
			e.printStackTrace();

		}
		return facultyList;
	}

	@RequestMapping(value = { "/getNewLibraryList" }, method = RequestMethod.POST)
	public @ResponseBody List<NewDeanList> getNewLibraryList(@RequestParam int instituteId) {

		List<NewDeanList> facultyList = new ArrayList<>();

		try {
			facultyList = newDeanListRepository.getNewLibraryList(instituteId);

		} catch (Exception e) {
			System.err.println("Exce in getNewLibraryList  " + e.getMessage());
			e.printStackTrace();

		}
		return facultyList;
	}

	@RequestMapping(value = { "/getNewAccOffList" }, method = RequestMethod.POST)
	public @ResponseBody List<NewDeanList> getNewAccOffList(@RequestParam int instituteId) {

		List<NewDeanList> facultyList = new ArrayList<>();

		try {
			facultyList = newDeanListRepository.getNewAccOffList(instituteId);

		} catch (Exception e) {
			System.err.println("Exce in getNewAccOffList  " + e.getMessage());
			e.printStackTrace();

		}
		return facultyList;
	}

	@RequestMapping(value = { "/getSwocListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSWOC> getSwocListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId, @RequestParam int type) {

		List<GetSWOC> swocList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				swocList = getSWOCRepo.getSwocListYear(yearId, instituteId, type);
			} else if (isHod == 1) {
				swocList = getSWOCRepo.getSwocListByDept(deptIdList, yearId, instituteId, type);
			} else {
				swocList = getSWOCRepo.getSwocList(facultyId, yearId, instituteId, type);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return swocList;
	}

	@RequestMapping(value = { "/getJournalListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetJournal> getJournalListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {

		List<GetJournal> jouList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				jouList = getJournalRepo.getJouByYear(yearId, instituteId);
			} else if (isHod == 1) {
				jouList = getJournalRepo.getJournalByDept(deptIdList, yearId, instituteId);
			} else {
				jouList = getJournalRepo.getJournalRepo(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return jouList;
	}

	@RequestMapping(value = { "/getSubjectListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSubject> getSubjectListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {

		List<GetSubject> subList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				subList = getSubjectRepo.getSubListYear(yearId, instituteId);
			} else if (isHod == 1) {
				subList = getSubjectRepo.getSubListByDept(deptIdList, yearId, instituteId);
			} else {
				subList = getSubjectRepo.getSubList(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return subList;
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

	@RequestMapping(value = { "/getProjectListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetResearchProject> getProjectListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		/*
		 * // System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal +
		 * "isIQAC" + isIQAC + "isHod" + isHod + "yearId" + yearId + "deptIdList" +
		 * deptIdList);
		 */

		List<GetResearchProject> projList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				projList = getResearchProjectRepo.getProjectListYear(yearId, instituteId);
			} else if (isHod == 1) {
				projList = getResearchProjectRepo.getProjectListByDept(deptIdList, yearId, instituteId);
			} else {
				projList = getResearchProjectRepo.getProjectList(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return projList;
	}

	@RequestMapping(value = { "/getProjectByProjId" }, method = RequestMethod.POST)
	public @ResponseBody ResearchProject getProjectByProjId(@RequestParam int projectId) {

		ResearchProject researchProjectRes = null;

		try {
			researchProjectRes = researchProjectRepo.findByProjIdAndDelStatus(projectId, 1);
			//researchProjectRes.setProjYear(DateConvertor.convertToDMY(researchProjectRes.getProjYear()));

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
	public @ResponseBody Info updateSubjeCoName(@RequestParam("coName") String coName, @RequestParam("coId") int coId) {

		Info info = new Info();
		try {
			int res = subjectCoRepo.updateSubjeCoName(coName, coId);

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

			// System.out.println("swocId" + swocId);
			swocRes = sWOCRepo.findBySwocIdAndDelStatus(swocId, 1);
			// System.out.println("swocRes" + swocRes.toString());

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