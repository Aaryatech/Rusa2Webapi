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

import com.ats.rusasoftapi.common.DateConvertor;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.faculty.Journal;
import com.ats.rusasoftapi.model.instprofile.Disctinctveness;
import com.ats.rusasoftapi.model.instprofile.GetDisctinctveness;
import com.ats.rusasoftapi.model.instprofile.GetHumanValues;
import com.ats.rusasoftapi.model.instprofile.GetResearchCenter;
import com.ats.rusasoftapi.model.instprofile.HumanValues;
import com.ats.rusasoftapi.model.instprofile.InstituteFunctionalMOU;
import com.ats.rusasoftapi.model.instprofile.ResearchCenter;
import com.ats.rusasoftapi.model.instprofile.ValuesMaster;
import com.ats.rusasoftapi.repo.institute.DisctinctvenessRepo;
import com.ats.rusasoftapi.repo.institute.GetDisctinctvenessRepo;
import com.ats.rusasoftapi.repo.institute.GetHumanValuesRepo;
import com.ats.rusasoftapi.repo.institute.GetResearchCenterRepo;
import com.ats.rusasoftapi.repo.institute.HumanValuesRepo;
import com.ats.rusasoftapi.repo.institute.ResearchCenterRepo;
import com.ats.rusasoftapi.repo.institute.ValuesMasterRepo;

@RestController
public class InstituteDistApiController {

	@Autowired
	DisctinctvenessRepo disctinctvenessRepo;

	@Autowired
	GetDisctinctvenessRepo getDisctinctvenessRepo;

	@Autowired
	GetHumanValuesRepo getHumanValuesRepo;

	@Autowired
	HumanValuesRepo humanValuesRepo;

	@Autowired
	GetResearchCenterRepo getResearchCenterRepo;

	@Autowired
	ResearchCenterRepo researchCenterRepo;

	@Autowired
	ValuesMasterRepo valuesMasterRepo;

	// ===========Values Master============================

	@RequestMapping(value = { "/saveValuesMaster" }, method = RequestMethod.POST)
	public @ResponseBody ValuesMaster saveValuesMaster(@RequestBody ValuesMaster valuesMaster) {

		ValuesMaster saveRes = null;

		try {
			saveRes = valuesMasterRepo.saveAndFlush(valuesMaster);

		} catch (Exception e) {
			System.err.println("Exce in saving saveValuesMaster " + e.getMessage());
			e.printStackTrace();

		}
		return saveRes;
	}

	@RequestMapping(value = { "/getValuesMasterByValId" }, method = RequestMethod.POST)
	public @ResponseBody ValuesMaster getValuesMasterByValId(@RequestParam int valMstId) {

		ValuesMaster resp = new ValuesMaster();

		try {
			resp = valuesMasterRepo.findByValMastIdAndDelStatus(valMstId, 1);

		} catch (Exception e) {
			System.err.println("Exce in getValuesMasterByValId  " + e.getMessage());
			e.printStackTrace();
		}

		return resp;

	}

	@RequestMapping(value = { "/getAllValuesList" }, method = RequestMethod.GET)
	public @ResponseBody List<ValuesMaster> getAllValuesList() {

		List<ValuesMaster> resp = new ArrayList<>();

		try {
			resp = valuesMasterRepo.findByDelStatusAndIsActiveOrderByValMastIdDesc(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllValuesList  " + e.getMessage());
			e.printStackTrace();
		}

		return resp;

	}

	@RequestMapping(value = { "/deleteValuesMaster" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteValuesMaster(@RequestParam List<String> valIdList) {

		Info info = new Info();
		try {
			int res = valuesMasterRepo.deleteValuesMaster(valIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteValuesMaster   " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	// ============Research Center============================

	@RequestMapping(value = { "/saveReserachCenter" }, method = RequestMethod.POST)
	public @ResponseBody ResearchCenter saveReserachCenter(@RequestBody ResearchCenter researchCenter) {

		ResearchCenter saveRes = null;

		try {
			saveRes = researchCenterRepo.saveAndFlush(researchCenter);

		} catch (Exception e) {
			System.err.println("Exce in saving saveReserachCenter " + e.getMessage());
			e.printStackTrace();

		}
		return saveRes;
	}

	@RequestMapping(value = { "/getResearchCenterByRcId" }, method = RequestMethod.POST)
	public @ResponseBody ResearchCenter getResearchCenterByRcId(@RequestParam int rcId) {

		ResearchCenter resp = new ResearchCenter();

		try {
			resp = researchCenterRepo.findByRcIdAndDelStatus(rcId, 1);
			resp.setRcValidityFromdt(DateConvertor.convertToDMY(resp.getRcValidityFromdt()));
			resp.setRcValidityTodt(DateConvertor.convertToDMY(resp.getRcValidityTodt()));

		} catch (Exception e) {
			System.err.println("Exce in getResearchCenterByRcId  " + e.getMessage());
			e.printStackTrace();
		}

		return resp;

	}

	@RequestMapping(value = { "/getAllResearchCenterByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetResearchCenter> getAllResearchCenterByInstituteId(@RequestParam int instId,
			@RequestParam int yearId) {

		List<GetResearchCenter> resp = new ArrayList<>();

		try {
			resp = getResearchCenterRepo.getAllRecearchCenterList(instId, yearId);

		} catch (Exception e) {
			System.err.println("Exce in getAllResearchCenterByInstituteId  " + e.getMessage());
			e.printStackTrace();
		}

		return resp;

	}

	@RequestMapping(value = { "/deleteResearchCenter" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteResearchCenter(@RequestParam List<String> rcIdList) {

		Info info = new Info();
		try {
			int res = researchCenterRepo.deleteResearchCenter(rcIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in humanValuesRepo   " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	// ============Human Values============================

	@RequestMapping(value = { "/saveHumanValues" }, method = RequestMethod.POST)
	public @ResponseBody HumanValues saveHumanValues(@RequestBody HumanValues humanValues) {

		HumanValues saveRes = null;

		try {
			saveRes = humanValuesRepo.saveAndFlush(humanValues);

		} catch (Exception e) {
			System.err.println("Exce in saving saveHumanValues " + e.getMessage());
			e.printStackTrace();

		}
		return saveRes;
	}

	@RequestMapping(value = { "/getHumanValuesByValueId" }, method = RequestMethod.POST)
	public @ResponseBody HumanValues getHumanValuesByValueId(@RequestParam int valueId) {

		HumanValues resp = new HumanValues();

		try {
			resp = humanValuesRepo.findByValueIdAndDelStatus(valueId, 1);
			resp.setActivityFromdt(DateConvertor.convertToDMY(resp.getActivityFromdt()));
			resp.setActivityTodt(DateConvertor.convertToDMY(resp.getActivityTodt()));

		} catch (Exception e) {
			System.err.println("Exce in getHumanValuesByValueId  " + e.getMessage());
			e.printStackTrace();
		}

		return resp;

	}

	@RequestMapping(value = { "/getAllHumanValuesByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetHumanValues> getAllHumanValuesByInstituteId(@RequestParam int instId,
			@RequestParam int yearId) {

		List<GetHumanValues> resp = new ArrayList<>();

		try {
			resp = getHumanValuesRepo.getAllHumanValuesList(instId, yearId);

		} catch (Exception e) {
			System.err.println("Exce in getAllHumanValuesByInstituteId  " + e.getMessage());
			e.printStackTrace();
		}

		return resp;

	}

	@RequestMapping(value = { "/deleteHumanVlaues" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteHumanVlaues(@RequestParam List<String> valueIdList) {

		Info info = new Info();
		try {
			int res = humanValuesRepo.deleteHumanValues(valueIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in humanValuesRepo   " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	// ============Dist============================

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
