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

import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.InstitueMission;
import com.ats.rusasoftapi.model.InstitueVision;
import com.ats.rusasoftapi.model.ProgramVision;
import com.ats.rusasoftapi.repository.InstituteMissionRepository;
import com.ats.rusasoftapi.repository.IntituteisionRepository;
import com.ats.rusasoftapi.repository.ProgramMissionRepository;
import com.ats.rusasoftapi.repository.ProgramVisionRepository;

@RestController
public class InstituteVissionMissionRestController {
	
	@Autowired
	IntituteisionRepository intituteisionRepository;

	@Autowired
	InstituteMissionRepository instituteMissionRepository;
	
	@RequestMapping(value = { "/saveInstituteVision" }, method = RequestMethod.POST)
	public @ResponseBody InstitueVision saveInstituteVision(@RequestBody InstitueVision institueVision) {

		InstitueVision save = new InstitueVision();

		try {

			save = intituteisionRepository.saveAndFlush(institueVision);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}
	
	@RequestMapping(value = { "/getInsituteVisionList" }, method = RequestMethod.POST)
	public @ResponseBody List<InstitueVision> getInsituteVisionList(@RequestParam("instituteId") int instituteId) {

		List<InstitueVision> list = new ArrayList<InstitueVision>();

		try {

			list = intituteisionRepository.findByDelStatusAndIsActiveAndInstituteIdOrderByInstVisionIdDesc(1, 1, instituteId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteInstiuteVision" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstiuteVision(@RequestParam("instVisionId") int instVisionId) {

		Info info = new Info();

		try {

			try {
				int res = intituteisionRepository.deleteInstiuteVision(instVisionId);
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

	@RequestMapping(value = { "/getInstituteVisionByVisionId" }, method = RequestMethod.POST)
	public @ResponseBody InstitueVision getInstituteVisionByVisionId(@RequestParam("instVisionId") int instVisionId) {

		InstitueVision institueVision = new InstitueVision();

		try {

			institueVision = intituteisionRepository.findByInstVisionId(instVisionId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return institueVision;

	}
	
	@RequestMapping(value = { "/saveInstituteMission" }, method = RequestMethod.POST)
	public @ResponseBody InstitueMission saveInstituteMission(@RequestBody InstitueMission institueMission) {

		InstitueMission save = new InstitueMission();

		try {

			save = instituteMissionRepository.saveAndFlush(institueMission);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}
	
	@RequestMapping(value = { "/getInsituteMissionList" }, method = RequestMethod.POST)
	public @ResponseBody List<InstitueMission> getInsituteMissionList(@RequestParam("instituteId") int instituteId) {

		List<InstitueMission> list = new ArrayList<InstitueMission>();

		try {

			list = instituteMissionRepository.findByDelStatusAndIsActiveAndInstituteIdOrderByInstMissionIdDesc(1, 1, instituteId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteInstiuteMission" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstiuteMission(@RequestParam("instMissionId") int instMissionId) {

		Info info = new Info();

		try {

			try {
				int res = instituteMissionRepository.deleteInstiuteMission(instMissionId);
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

	@RequestMapping(value = { "/getInstituteMissionByMissionId" }, method = RequestMethod.POST)
	public @ResponseBody InstitueMission getInstituteMissionByMissionId(@RequestParam("instMissionId") int instMissionId) {

		InstitueMission institueMission = new InstitueMission();

		try {

			institueMission = instituteMissionRepository.findByInstMissionId(instMissionId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return institueMission;

	}

}
