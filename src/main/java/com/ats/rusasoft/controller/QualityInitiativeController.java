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

import com.ats.rusasoft.instprofilerepo.QualityInitiativeRepo;
import com.ats.rusasoft.model.AccOfficer;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.instprofile.QualityInitiative;
import com.ats.rusasoft.model.progdetail.GetStudAdmCatwise;

@RestController
public class QualityInitiativeController {

	@Autowired
	QualityInitiativeRepo qualityInitiativeRepo;

	@RequestMapping(value = { "/saveQualityInitiative" }, method = RequestMethod.POST)
	public @ResponseBody QualityInitiative savequalityInitiative(@RequestBody QualityInitiative qualInti) {

		QualityInitiative qualIniRes = null;

		try {

			qualIniRes = qualityInitiativeRepo.save(qualInti);

		} catch (Exception e) {
			System.err.println("exce in /saveQualityInitiative " + e.getMessage());
			e.printStackTrace();

		}
		return qualIniRes;
	}
	
	@RequestMapping(value = { "/getQualityInitiativeList" }, method = RequestMethod.GET)
	public @ResponseBody List<QualityInitiative> getQualityInitiativeList() {

		List<QualityInitiative> qualInitList = new ArrayList<>();

		try {
			qualInitList = qualityInitiativeRepo.findByDelStatusAndIsActive(1, 1);
		} catch (Exception e) {
			System.err.println("Exce in getStudAdmCatwiseList  " + e.getMessage());
			e.printStackTrace();
		}

		return qualInitList;

	}
	
	
	@RequestMapping(value = { "/getQualityInitiativeById" }, method = RequestMethod.POST)
	public @ResponseBody QualityInitiative getQualityInitiativeById(@RequestParam
			int qualityInitiativeId) {
		QualityInitiative qualIniRes = null;
		
		try {
			qualIniRes = qualityInitiativeRepo.findByQualityInitiativeId(qualityInitiativeId);
		} catch (Exception e) {
			System.err.println("exce in /getQualityInitiativeById " + e.getMessage());
			e.printStackTrace();

		}
		return qualIniRes;
	}
	
	
	@RequestMapping(value = { "/deleteQualiInitiatives" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteQualiInitiatives(@RequestParam List<String> qualityInitiativeIdList) {

		Info info = new Info();
		try {
			int res = qualityInitiativeRepo.deleteQualInititives(qualityInitiativeIdList);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteQualiInitiatives  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	
}
