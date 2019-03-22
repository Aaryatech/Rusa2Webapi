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
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.faculty.Journal;
import com.ats.rusasoft.model.instprofile.Disctinctveness;
import com.ats.rusasoft.model.instprofile.GetDisctinctveness;
import com.ats.rusasoft.model.instprofile.InstituteFunctionalMOU;
import com.ats.rusasoft.repo.institute.DisctinctvenessRepo;
import com.ats.rusasoft.repo.institute.GetDisctinctvenessRepo;

@RestController
public class InstituteDistApiController {

	@Autowired
	DisctinctvenessRepo disctinctvenessRepo;

	@Autowired
	GetDisctinctvenessRepo getDisctinctvenessRepo;

	@RequestMapping(value = { "/saveDist" }, method = RequestMethod.POST)
	public @ResponseBody Disctinctveness saveDist(@RequestBody Disctinctveness disctinctveness) {

		Disctinctveness saveRes = null;

		try {
			saveRes = disctinctvenessRepo.saveAndFlush(disctinctveness);

		} catch (Exception e) {
			System.err.println("Exce in saving saveDist " + e.getMessage());
			e.printStackTrace();

		}
		return saveRes;
	}

	@RequestMapping(value = { "/getDistByDistId" }, method = RequestMethod.POST)
	public @ResponseBody Disctinctveness getDistByDistId(@RequestParam int distId) {

		Disctinctveness resp = new Disctinctveness();

		try {
			resp = disctinctvenessRepo.findByDistIdAndDelStatus(distId, 1);
			resp.setDistApplicableFrom(DateConvertor.convertToDMY(resp.getDistApplicableFrom()));

		} catch (Exception e) {
			System.err.println("Exce in getAllDistByInstituteId  " + e.getMessage());
			e.printStackTrace();
		}

		return resp;

	}

	@RequestMapping(value = { "/getAllDistByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDisctinctveness> getAllDistByInstituteId(@RequestParam int instId,
			@RequestParam int yearId) {

		List<GetDisctinctveness> resp = new ArrayList<>();

		try {
			resp = getDisctinctvenessRepo.getAllDistList(instId, yearId);

		} catch (Exception e) {
			System.err.println("Exce in getAllDistByInstituteId  " + e.getMessage());
			e.printStackTrace();
		}

		return resp;

	}

	@RequestMapping(value = { "/deleteDists" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDists(@RequestParam List<String> distIdList) {

		Info info = new Info();
		try {
			int res = disctinctvenessRepo.deleteDists(distIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteDists   " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

}
