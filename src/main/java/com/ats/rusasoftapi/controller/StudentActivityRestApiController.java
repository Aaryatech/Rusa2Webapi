package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.GetProgram;
import com.ats.rusasoftapi.model.GetProgramActivity;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.Program;
import com.ats.rusasoftapi.model.ProgramActivity;
import com.ats.rusasoftapi.model.ProgramEducationObjective;
import com.ats.rusasoftapi.model.ProgramMission;
import com.ats.rusasoftapi.model.ProgramOutcome;
import com.ats.rusasoftapi.model.ProgramSpeceficOutcome;
import com.ats.rusasoftapi.model.ProgramVision;
import com.ats.rusasoftapi.model.StudPerformFinalYr;
import com.ats.rusasoftapi.model.StudPerformFinalYrList;
import com.ats.rusasoftapi.model.TExtensionActivity;
import com.ats.rusasoftapi.model.progdetail.StudQualifyingExam;
import com.ats.rusasoftapi.prodetailrepo.StudPerformFinalYrListRepo;
import com.ats.rusasoftapi.prodetailrepo.StudQualifyingExamRepo;
import com.ats.rusasoftapi.repositories.StudPerformFinalYearRepo;
import com.ats.rusasoftapi.repository.GetProgramActivityRepo;
import com.ats.rusasoftapi.repository.GetProgramRepository;
import com.ats.rusasoftapi.repository.ProgramEducationObjectiveRepository;
import com.ats.rusasoftapi.repository.ProgramMissionRepository;
import com.ats.rusasoftapi.repository.ProgramOutcomeRepository;
import com.ats.rusasoftapi.repository.ProgramRepository;
import com.ats.rusasoftapi.repository.ProgramSpeceficOutcomeRepository;
import com.ats.rusasoftapi.repository.ProgramStudentActivityRepo;
import com.ats.rusasoftapi.repository.ProgramVisionRepository;

@RestController
public class StudentActivityRestApiController {

	@Autowired
	ProgramStudentActivityRepo programStudentActivityRepo;

	@Autowired
	GetProgramActivityRepo getProgramActivityRepo;

	@Autowired
	ProgramRepository programRepository;

	@Autowired
	GetProgramRepository getProgramRepository;

	@Autowired
	ProgramVisionRepository programVisionRepository;

	@Autowired
	ProgramMissionRepository programMissionRepository;

	@Autowired
	ProgramEducationObjectiveRepository programEducationObjectiveRepository;

	@Autowired
	ProgramOutcomeRepository programOutcomeRepository;

	@Autowired
	ProgramSpeceficOutcomeRepository programSpeceficOutcomeRepository;

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
	public @ResponseBody List<GetProgramActivity> getStudentAcitivityList(@RequestParam("yearId") int yearId,
			@RequestParam("type") int type, @RequestParam("instituteId") int instituteId) {

		List<GetProgramActivity> list = new ArrayList<>();

		try {

			list = getProgramActivityRepo.getStudentAcitivityList(type, yearId, instituteId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getStudentAcitivityByActivityId" }, method = RequestMethod.POST)
	public @ResponseBody GetProgramActivity getStudentAcitivityByActivityId(@RequestParam("yearId") int yearId,
			@RequestParam("type") int type, @RequestParam("activityId") int activityId) {

		GetProgramActivity getProgramActivity = new GetProgramActivity();

		try {

			getProgramActivity = getProgramActivityRepo.getStudentAcitivityByActivityId(activityId, type, yearId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return getProgramActivity;

	}

	@RequestMapping(value = { "/deleteActivity" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteActivity(@RequestParam("activityId") int activityId) {

		Info info = new Info();
		try {

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

		return info;

	}

	@RequestMapping(value = { "/saveProgram" }, method = RequestMethod.POST)
	public @ResponseBody Program saveProgram(@RequestBody Program program) {

		Program save = new Program();

		try {

			save = programRepository.saveAndFlush(program);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}

	@RequestMapping(value = { "/getProgramList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetProgram> getProgramList(@RequestParam("instituteId") int instituteId) {

		List<GetProgram> list = new ArrayList<GetProgram>();

		try {

			list = getProgramRepository.getProgramList(instituteId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	// neha
	@RequestMapping(value = { "/getAllProgramList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetProgram> getAllProgramList(@RequestParam int instId) {

		List<GetProgram> list = new ArrayList<GetProgram>();

		try {

			list = getProgramRepository.getAllProgramList(instId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteProgram" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProgram(@RequestParam("programId") int programId) {

		Info info = new Info();

		try {

			try {
				int res = programRepository.deleteProgram(programId);
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

	@RequestMapping(value = { "/getProgramByProgramTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<Program> getProgramByProgramTypeId(@RequestParam("programTypeId") int programTypeId,@RequestParam("instituteId") int instituteId ) {

		List<Program> list = new ArrayList<Program>();

		try {

			list = programRepository.findByProgramTypeAndDelStatusAndInstituteId(programTypeId, 1, instituteId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getProgramByProgramId" }, method = RequestMethod.POST)
	public @ResponseBody GetProgram getProgramByProgramId(@RequestParam("programId") int programId) {

		GetProgram program = new GetProgram();

		try {

			program = getProgramRepository.findByProgramId(programId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return program;

	}

	@RequestMapping(value = { "/saveProgramVision" }, method = RequestMethod.POST)
	public @ResponseBody ProgramVision saveProgramVision(@RequestBody ProgramVision programVision) {

		ProgramVision save = new ProgramVision();

		try {

			save = programVisionRepository.saveAndFlush(programVision);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}

	@RequestMapping(value = { "/getProgramVisionList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgramVision> getProgramVisionList(@RequestParam("programId") int programId) {

		List<ProgramVision> list = new ArrayList<ProgramVision>();

		try {

			list = programVisionRepository.findByDelStatusAndIsActiveAndProgramIdOrderByVisionIdDesc(1, 1, programId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteProgramVision" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProgramVision(@RequestParam("visionId") int visionId) {

		Info info = new Info();

		try {

			try {
				int res = programVisionRepository.deleteProgramVision(visionId);
				if (res > 0) {
					info.setError(false);
					info.setMsg("success");

				} else {
					info.setError(true);
					info.setMsg("failed");

				}
			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getProgramVisionByVisionId" }, method = RequestMethod.POST)
	public @ResponseBody ProgramVision getProgramVisionByVisionId(@RequestParam("visionId") int visionId) {

		ProgramVision program = new ProgramVision();

		try {

			program = programVisionRepository.findByVisionId(visionId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return program;

	}

	@RequestMapping(value = { "/saveProgramMission" }, method = RequestMethod.POST)
	public @ResponseBody ProgramMission saveProgramMission(@RequestBody ProgramMission programMission) {

		ProgramMission save = new ProgramMission();

		try {

			save = programMissionRepository.saveAndFlush(programMission);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}

	@RequestMapping(value = { "/getProgramMissionList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgramMission> getProgramMissionList(@RequestParam("programId") int programId) {

		List<ProgramMission> list = new ArrayList<ProgramMission>();

		try {

			list = programMissionRepository.findByDelStatusAndIsActiveAndProgramIdOrderByMissionIdDesc(1, 1, programId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteProgramMission" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProgramMission(@RequestParam("missionId") int missionId) {

		Info info = new Info();

		try {

			try {
				int res = programMissionRepository.deleteProgramMission(missionId);

				if (res > 0) {
					info.setError(false);
					info.setMsg("success");

				} else {
					info.setError(true);
					info.setMsg("failed");

				}
			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getProgramMissionByMissionId" }, method = RequestMethod.POST)
	public @ResponseBody ProgramMission getProgramMissionByMissionId(@RequestParam("missionId") int missionId) {

		ProgramMission program = new ProgramMission();

		try {

			program = programMissionRepository.findByMissionId(missionId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return program;

	}

	@RequestMapping(value = { "/saveProgramEducationObjective" }, method = RequestMethod.POST)
	public @ResponseBody ProgramEducationObjective saveProgramEducationObjective(
			@RequestBody ProgramEducationObjective programEducationObjective) {

		ProgramEducationObjective save = new ProgramEducationObjective();

		try {

			save = programEducationObjectiveRepository.saveAndFlush(programEducationObjective);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}

	@RequestMapping(value = { "/getProgramEducationObjectiveList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgramEducationObjective> getProgramEducationObjectiveList(
			@RequestParam("programId") int programId) {

		List<ProgramEducationObjective> list = new ArrayList<ProgramEducationObjective>();

		try {

			list = programEducationObjectiveRepository.findByDelStatusAndIsActiveAndProgramIdOrderByPeoIdDesc(1, 1,
					programId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteProgramEducationObjective" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProgramEducationObjective(@RequestParam("peoId") int peoId) {

		Info info = new Info();

		try {

			try {
				int res = programEducationObjectiveRepository.deleteProgramEducationObjective(peoId);

				if (res > 0) {
					info.setError(false);
					info.setMsg("success");

				} else {
					info.setError(true);
					info.setMsg("failed");

				}
			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getProgramEducationObjectiveByPeoId" }, method = RequestMethod.POST)
	public @ResponseBody ProgramEducationObjective getProgramEducationObjectiveByPeoId(
			@RequestParam("peoId") int peoId) {

		ProgramEducationObjective program = new ProgramEducationObjective();

		try {

			program = programEducationObjectiveRepository.findByPeoId(peoId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return program;

	}

	@RequestMapping(value = { "/saveProgramOutcome" }, method = RequestMethod.POST)
	public @ResponseBody ProgramOutcome saveProgramOutcome(@RequestBody ProgramOutcome programOutcome) {

		ProgramOutcome save = new ProgramOutcome();

		try {

			save = programOutcomeRepository.saveAndFlush(programOutcome);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}

	@RequestMapping(value = { "/getProgramOutcomeList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgramOutcome> getProgramOutcomeList(@RequestParam("programId") int programId) {

		List<ProgramOutcome> list = new ArrayList<ProgramOutcome>();

		try {

			list = programOutcomeRepository.findByDelStatusAndIsActiveAndProgramIdOrderByPoIdDesc(1, 1, programId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteProgramOutcome" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProgramOutcome(@RequestParam("poId") int poId) {

		Info info = new Info();

		try {

			try {
				int res = programOutcomeRepository.deleteProgramOutcome(poId);

				if (res > 0) {
					info.setError(false);
					info.setMsg("success");

				} else {
					info.setError(true);
					info.setMsg("failed");

				}
			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getProgramOutcomeByPoId" }, method = RequestMethod.POST)
	public @ResponseBody ProgramOutcome getProgramOutcomeByPoId(@RequestParam("poId") int poId) {

		ProgramOutcome program = new ProgramOutcome();

		try {

			program = programOutcomeRepository.findByPoId(poId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return program;

	}

	@RequestMapping(value = { "/saveProgramSpeceficOutcome" }, method = RequestMethod.POST)
	public @ResponseBody ProgramSpeceficOutcome saveProgramSpeceficOutcome(
			@RequestBody ProgramSpeceficOutcome programSpeceficOutcome) {

		ProgramSpeceficOutcome save = new ProgramSpeceficOutcome();

		try {

			save = programSpeceficOutcomeRepository.saveAndFlush(programSpeceficOutcome);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}

	@RequestMapping(value = { "/getProgramSpeceficOutcomeList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgramSpeceficOutcome> getProgramSpeceficOutcomeList(
			@RequestParam("programId") int programId) {

		List<ProgramSpeceficOutcome> list = new ArrayList<ProgramSpeceficOutcome>();

		try {

			list = programSpeceficOutcomeRepository.findByDelStatusAndIsActiveAndProgramIdOrderByPsoIdDesc(1, 1,
					programId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteProgramSpeceficOutcome" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProgramSpeceficOutcome(@RequestParam("psoId") int psoId) {

		Info info = new Info();

		try {

			try {
				int res = programSpeceficOutcomeRepository.deleteProgramSpeceficOutcome(psoId);

				if (res > 0) {
					info.setError(false);
					info.setMsg("success");

				} else {
					info.setError(true);
					info.setMsg("failed");

				}
			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getProgramSpeceficOutcomeByPsoId" }, method = RequestMethod.POST)
	public @ResponseBody ProgramSpeceficOutcome getProgramSpeceficOutcomeByPsoId(@RequestParam("psoId") int psoId) {

		ProgramSpeceficOutcome program = new ProgramSpeceficOutcome();

		try {

			program = programSpeceficOutcomeRepository.findByPsoId(psoId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return program;

	}
/****************************Student Passed in Final Year******************************************/
	@Autowired StudPerformFinalYearRepo studPerfomRepo;
	@RequestMapping(value = { "/addStudPerformFinalYear" }, method = RequestMethod.POST)
	public @ResponseBody StudPerformFinalYr addStudPerformFinalYear(
			@RequestBody StudPerformFinalYr studPer) {

		StudPerformFinalYr save = new StudPerformFinalYr();

		try {

			save = studPerfomRepo.saveAndFlush(studPer);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}

	
	@RequestMapping(value = { "/getstudPassingPerByAcdYrId"}, method = RequestMethod.POST)
	public @ResponseBody StudPerformFinalYr getstudPassingPerByAcdYrId(
			@RequestParam("instituteId") int instituteId, @RequestParam("yearId") int yearId) {

		StudPerformFinalYr studPerfrmDtl = new StudPerformFinalYr();

		try {

			studPerfrmDtl = studPerfomRepo.findByInstIdAndExInt1AndDelStatus(instituteId, yearId, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return studPerfrmDtl;

	}
	
	
	@Autowired StudPerformFinalYrListRepo studPerfomlistRepo;
	@RequestMapping(value = { "/getstudPassingPer"}, method = RequestMethod.POST)
	public @ResponseBody List<StudPerformFinalYrList> getstudPassingPer(
			@RequestParam("instituteId") int instituteId, @RequestParam("yearId") int yearId) {

		List<StudPerformFinalYrList> list = new ArrayList<StudPerformFinalYrList>();

		try {

			list = studPerfomlistRepo.getStudPassingInfo(instituteId, yearId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getStudPerformanceById"}, method = RequestMethod.POST)
	public @ResponseBody StudPerformFinalYr getStudPerformanceById(@RequestParam("studperId") int studperId) {

		StudPerformFinalYr finalYearPerform = null;

		try {

			finalYearPerform = studPerfomRepo.findByStudPerformIdAndDelStatus(studperId,1);
			System.err.println("Ext="+finalYearPerform);

		} catch (Exception e) {

			System.err.println("Exce in getStudPerformanceById Stud Act " + e.getMessage());
			e.printStackTrace();

		}

		return finalYearPerform;

	}
	
	@RequestMapping(value = { "/deleteStudPerformanceById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelExtAct(@RequestParam("studperId") int studperId) {

		Info info = new Info();
		try {
			int res = studPerfomRepo.deletetStudFinalYearPerformance(studperId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}
	
	
	@RequestMapping(value = { "/deleteSelStudperformnc" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelStudperformnc(@RequestParam List<String> studInfoList) {

		Info info = new Info();
		try {
			int res = studPerfomRepo.deletetSelStudInfo(studInfoList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	
	/*************************************Students Qualifying Exam Details*************************************/
	
	@Autowired StudQualifyingExamRepo studQulifyExmRepo;
	
	@RequestMapping(value = { "/saveStudQualifyExam" }, method = RequestMethod.POST)
	public @ResponseBody StudQualifyingExam saveStudQualifyExam(
			@RequestBody StudQualifyingExam stud) {

		StudQualifyingExam saveStud = new StudQualifyingExam();

		try {

			stud = studQulifyExmRepo.saveAndFlush(stud);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return saveStud;

	}
	
	@RequestMapping(value = { "/getStudQualifiedExamList"}, method = RequestMethod.POST)
	public @ResponseBody List<StudQualifyingExam> getStudQualifiedExamList(
			@RequestParam("instituteId") int instituteId,@RequestParam("yearId") int yearId) {

		List<StudQualifyingExam> list = new ArrayList<StudQualifyingExam>();

		try {

			list = studQulifyExmRepo.findByInstIdAndAcYearIdAndDelStatusOrderByStudExmIdDesc(instituteId, yearId,1);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getStudQulifExmById"}, method = RequestMethod.POST)
	public @ResponseBody StudQualifyingExam getStudQulifExmById(@RequestParam("studExmId") int studExmId) {

		StudQualifyingExam studQualif = null;

		try {

			studQualif = studQulifyExmRepo.findByStudExmId(studExmId);
			System.err.println("Ext="+studQualif);

		} catch (Exception e) {

			System.err.println("Exce in getStudQulifExmById Stud Act " + e.getMessage());
			e.printStackTrace();

		}

		return studQualif;

	}
	
	@RequestMapping(value = { "/deleteStudQulifExmByById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteStudQulifExmByById(@RequestParam("studExmId") int studExmId) {

		Info info = new Info();
		try {
			int res = studQulifyExmRepo.deletetStudQualifiedExamDetail(studExmId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}
	
	@RequestMapping(value = { "/deleteSelStudQulifiedExm" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelStudQulifiedExm(@RequestParam List<String> studQlfExmIdList) {

		Info info = new Info();
		try {
			int res = studQulifyExmRepo.deletetSelStudQlifExmInfo(studQlfExmIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	
}
