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

import com.ats.rusasoftapi.model.ActCndctPrmtngUnivrslVal;
import com.ats.rusasoftapi.model.GenderEqalityPrg;
import com.ats.rusasoftapi.model.GovtScholarships;
import com.ats.rusasoftapi.model.IctEnabledFacilities;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.InstituteActivity;
import com.ats.rusasoftapi.model.InstituteSupport;
import com.ats.rusasoftapi.model.IntelPrpoRight;
import com.ats.rusasoftapi.model.SpecificLocalAdvntgDisadvntg;
import com.ats.rusasoftapi.mstrepo.GovtScholarshipsRepo;
import com.ats.rusasoftapi.repo.institute.ActCndctPrmtngUnivrslValRepo;
import com.ats.rusasoftapi.repo.institute.SpecificLocalAdvntgDisadvntgRepo;
import com.ats.rusasoftapi.repositories.GenderEqualityPrgRepo;
import com.ats.rusasoftapi.repositories.IctEnabledFacilitiesRepo;
import com.ats.rusasoftapi.repositories.InstituteActivityRepo;
import com.ats.rusasoftapi.repositories.InstituteSupportRepo;
import com.ats.rusasoftapi.repositories.IntelPropRightRepo;

@RestController
public class InstituteRestApiController {

	@Autowired
	InstituteSupportRepo instSuprtRepo;

	@Autowired
	InstituteActivityRepo instActvRepo;

	@Autowired
	IntelPropRightRepo intelRepo;

	@Autowired
	GenderEqualityPrgRepo gProgRepo;

	@RequestMapping(value = { "/addInstSupprt" }, method = RequestMethod.POST)
	public @ResponseBody InstituteSupport addInstSuprt(@RequestBody InstituteSupport instSpprt) {
		return instSuprtRepo.save(instSpprt);

	}

	@RequestMapping(value = { "/getSchemesByIds" }, method = RequestMethod.POST)
	public @ResponseBody List<InstituteSupport> getInstSuprtList(@RequestParam("instituteId") int instituteId,
			@RequestParam("yId") int yId) {

		return instSuprtRepo.findByInstituteIdAndYearIdAndDelStatusOrderByInstSchemeIdDesc(instituteId, yId, 1);

	}

	@RequestMapping(value = { "/getSuprtSchemeBySchmId" }, method = RequestMethod.POST)
	public @ResponseBody InstituteSupport getSuprSchmByID(@RequestParam("schmId") int schmId) {
		return instSuprtRepo.findByInstSchemeId(schmId);

	}

	@RequestMapping(value = { "/deleteSuprtSchemeBySchmId" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSuprSchmByID(@RequestParam("schmId") int schmId) {

		int isDelete = 0;
		isDelete = instSuprtRepo.deleteByInstSuprtSchmId(schmId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;

	}

	@RequestMapping(value = { "/deletinstSupport" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstLinkages(@RequestParam List<String> instIdList) {

		Info info = new Info();
		try {
			int res = instSuprtRepo.deleteSelInstSupport(instIdList);

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

	/*****************************************
	 * Institute Activity
	 *********************************************/

	@RequestMapping(value = { "/addNewInstituteActity" }, method = RequestMethod.POST)
	public @ResponseBody InstituteActivity addInstSuprt(@RequestBody InstituteActivity instAct) {

		return instActvRepo.save(instAct);

	}

	@RequestMapping(value = { "/getAllInstituteActities" }, method = RequestMethod.POST)
	public @ResponseBody List<InstituteActivity> getAllInstituteActities(@RequestParam("instituteId") int instituteId,
			@RequestParam("yId") int yId) {
		return instActvRepo.findByInstituteIdAndYearIdAndDelStatusOrderByInstActivityIdDesc(instituteId, yId, 1);

	}

	@RequestMapping(value = { "/getInstActivityById" }, method = RequestMethod.POST)
	public @ResponseBody InstituteActivity getInstActivityById(@RequestParam("instActvId") int instActvId) {
		return instActvRepo.findByInstActivityId(instActvId);

	}

	@RequestMapping(value = { "/deleteActivId" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteActivtById(@RequestParam("instActvId") int instActvId) {

		int isDelete = 0;
		isDelete = instActvRepo.deleteByInstActivityId(instActvId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;

	}

	@RequestMapping(value = { "/deleteOrgActivities" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteOrgActivities(@RequestParam List<String> activityIdList) {

		Info info = new Info();
		try {
			int res = instActvRepo.deleteSelOrgActivity(activityIdList);

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

	/**********************************
	 * Intelectual Property Right
	 ********************************/
	@RequestMapping(value = { "/addNewIntelPropRight" }, method = RequestMethod.POST)
	public @ResponseBody IntelPrpoRight addNewIntelPropRight(@RequestBody IntelPrpoRight intelProp) {

		return intelRepo.save(intelProp);

	}

	@RequestMapping(value = { "/getAllIntelPropRights" }, method = RequestMethod.POST)
	public @ResponseBody List<IntelPrpoRight> getintelRightsList(@RequestParam("instituteId") int instituteId,
			@RequestParam("yId") int yId) {

		return intelRepo.findByInstituteIdAndYearIdAndDelStatusOrderByConIdDesc(instituteId, yId, 1);
	}

	@RequestMapping(value = { "/getIntelPropRigntById" }, method = RequestMethod.POST)
	public @ResponseBody IntelPrpoRight getIntelPropRigntById(@RequestParam("conId") int conId) {
		return intelRepo.findByConId(conId);

	}

	@RequestMapping(value = { "/deleteRightById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRightById(@RequestParam("conId") int conId) {

		int isDelete = 0;
		isDelete = intelRepo.deleteIntelRightById(conId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;

	}

	@RequestMapping(value = { "/deleteIntelRights" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteIntelRights(@RequestParam List<String> rightIdList) {

		Info info = new Info();
		try {
			int res = intelRepo.deleteSelIntellRight(rightIdList);

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

	/******************************************
	 * Gender Equality Programe
	 *********************************************/

	@RequestMapping(value = { "/addGendrEqtyPrg" }, method = RequestMethod.POST)
	public @ResponseBody GenderEqalityPrg addGendrEqtyPrg(@RequestBody GenderEqalityPrg gendrEqualityt) {
		return gProgRepo.save(gendrEqualityt);

	}

	@RequestMapping(value = { "/getAllGenderEqltyData" }, method = RequestMethod.POST)
	public @ResponseBody List<GenderEqalityPrg> getAllGenderEqltyList(@RequestParam("instituteId") int instituteId,
			@RequestParam("yId") int yId) {

		return gProgRepo.findByInstituteIdAndYearIdAndDelStatusOrderByGprogIdDesc(instituteId, yId, 1);

	}

	@RequestMapping(value = { "/editGenderEqualityById" }, method = RequestMethod.POST)
	public @ResponseBody GenderEqalityPrg editGenderEqualityById(@RequestParam("gndrDataId") int gndrDataId) {
		return gProgRepo.findBygprogId(gndrDataId);

	}

	@RequestMapping(value = { "/deleteGenderEqualityById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteGndrEqltyById(@RequestParam("gndrDataId") int gndrDataId) {

		int isDelete = 0;
		isDelete = gProgRepo.deleteGendrEqltyById(gndrDataId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;

	}

	@RequestMapping(value = { "/deleteGenderEquity" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteGenderEquity(@RequestParam List<String> gndreqtyIdList) {

		Info info = new Info();
		try {
			int res = gProgRepo.deleteSelGenderEquitys(gndreqtyIdList);

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

	/******************************************
	 * ICT Enabled Facilities
	 *********************************************/
	@Autowired
	IctEnabledFacilitiesRepo ictRepo;

	@RequestMapping(value = { "/saveIctEnabledFacility" }, method = RequestMethod.POST)
	public @ResponseBody IctEnabledFacilities saveIctEnabledFacility(@RequestBody IctEnabledFacilities ictEnbFac) {
		IctEnabledFacilities ict = null;
		try {

			ict = ictRepo.save(ictEnbFac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ict;
	}

	@RequestMapping(value = { "/getAllIctEnabledFacilities" }, method = RequestMethod.POST)
	public @ResponseBody List<IctEnabledFacilities> getAllIctEnabledFacilities(@RequestParam("instituteId") int instituteId) {
		List<IctEnabledFacilities> ictList = new ArrayList<IctEnabledFacilities>();
		try {
			ictList=ictRepo.findByInstIdAndDelStatusOrderByIctEnbFacIdDesc(instituteId,1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ictList;

	}
	
	@RequestMapping(value = { "/editIctEnabledFaclityById" }, method = RequestMethod.POST)
	public @ResponseBody IctEnabledFacilities editIctEnabledFaclityById(@RequestParam("ictId") int ictId) {
		IctEnabledFacilities ict = new IctEnabledFacilities();
		try {
			ict=ictRepo.findByIctEnbFacId(ictId);
			// System.out.println(ict);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ict;
		
	}
	
	@RequestMapping(value = { "/deleteIctEnabledFaclityById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteIctEnabledFaclityById(@RequestParam("ictId") int ictId) {

		int isDelete = 0;
		isDelete = ictRepo.deleteIctEnbFacById(ictId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;

	}
	
	@RequestMapping(value = { "/deleteIctFacility" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteIctFacility(@RequestParam List<String> ictIdList) {

		Info info = new Info();
		try {
			int res = ictRepo.deleteSelIctFac(ictIdList);

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
	
	/******************************************
		Government Scholarship
	 *********************************************/
	@Autowired
	GovtScholarshipsRepo govtSchmRepo;

	@RequestMapping(value = { "/saveGovtScheme" }, method = RequestMethod.POST)
	public @ResponseBody GovtScholarships saveIctEnabledFacility(@RequestBody GovtScholarships govt) {
		GovtScholarships govtSchm = null;
		try {

			govtSchm = govtSchmRepo.save(govt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return govtSchm;
	}
	
	@RequestMapping(value = { "/getAllGovtScholrSch" }, method = RequestMethod.POST)
	public @ResponseBody List<GovtScholarships> getAllGovtScholrSch(@RequestParam("instituteId") int instituteId,@RequestParam("yId") int yId) {
		List<GovtScholarships> sch = new ArrayList<GovtScholarships>();
		try {
			sch=govtSchmRepo.findByInstIdAndAcYearIdAndDelStatusOrderByGovtScholarIdDesc(instituteId, yId, 1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sch;

	}
	
	
	@RequestMapping(value = { "/editGovtScholrScghmById" }, method = RequestMethod.POST)
	public @ResponseBody GovtScholarships editGovtScholrScghmById(@RequestParam("schmId") int schmId) {
		GovtScholarships sch = new GovtScholarships();
		try {
			sch=govtSchmRepo.findByGovtScholarId(schmId);
			// System.out.println(sch);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sch;
		
	}
	
	@RequestMapping(value = { "/delGovtScholrSchmById" }, method = RequestMethod.POST)
	public @ResponseBody Info delGovtScholrSchmById(@RequestParam("schmId") int schmId) {

		int isDelete = 0;
		isDelete = govtSchmRepo.deleteGovtSchem(schmId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;

	}
	
	@RequestMapping(value = { "/deleteSelGovtSchm" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelGovtSchm(@RequestParam List<String> schmIdList) {

		Info info = new Info();
		try {
			int res = govtSchmRepo.deleteGovtSchm(schmIdList);

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
	

	/******************************************
		 * Activities Conducted for Promoting Universal Values
	 *********************************************/
	@Autowired
	ActCndctPrmtngUnivrslValRepo actCondctRepo;

	@RequestMapping(value = { "/saveActivityConductPromtUniVal" }, method = RequestMethod.POST)
	public @ResponseBody ActCndctPrmtngUnivrslVal saveActivityConductPromtUniVal(@RequestBody ActCndctPrmtngUnivrslVal actCndct) {
		ActCndctPrmtngUnivrslVal act = null;
		try {

			act = actCondctRepo.save(actCndct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return act;
	}
		
	@RequestMapping(value = { "/getAllActivitiesCondctPromtUnivrsalValue" }, method = RequestMethod.POST)
	public @ResponseBody List<ActCndctPrmtngUnivrslVal> getAllActivitiesCondctPromtUnivrsalValue(@RequestParam("instituteId") int instituteId,@RequestParam("yId") int yId) {
		List<ActCndctPrmtngUnivrslVal> act = new ArrayList<ActCndctPrmtngUnivrslVal>();
		try {
			act=actCondctRepo.findByInstIdAndAcYearIdAndDelStatusOrderByActCndctIdDesc(instituteId, yId, 1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return act;

	}
	
	@RequestMapping(value = { "/editActivityCndtPrmtUnivrslValById" }, method = RequestMethod.POST)
	public @ResponseBody ActCndctPrmtngUnivrslVal editActivityCndtPrmtUnivrslValById(@RequestParam("actId") int actId) {
		ActCndctPrmtngUnivrslVal act = new ActCndctPrmtngUnivrslVal();
		
		try {
			act=actCondctRepo.findByActCndctId(actId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return act;
	}
	
	@RequestMapping(value = { "/delActCndctPrmtUniValById" }, method = RequestMethod.POST)
	public @ResponseBody Info delActCndctPrmtUniValById(@RequestParam("actId") int actId) {

		int isDelete = 0;
		isDelete = actCondctRepo.deleteActCndct(actId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;

	}
	
	@RequestMapping(value = { "/deleteSelActivity" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelActivity(@RequestParam List<String> activityIdlist) {

		Info info = new Info();
		try {
			int res = actCondctRepo.deleteActCndct(activityIdlist);

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
	
	/************************Specific Initiatives for Local Advantages & Disadvantages*********************/
	
	@Autowired SpecificLocalAdvntgDisadvntgRepo inItRepo;
	
	@RequestMapping(value = { "/saveInitiativeAdvDisadv" }, method = RequestMethod.POST)
	public @ResponseBody SpecificLocalAdvntgDisadvntg saveInitiativeAdvDisadv(@RequestBody SpecificLocalAdvntgDisadvntg specify) {
		SpecificLocalAdvntgDisadvntg inIt = null;
		try {

			inIt = inItRepo.save(specify);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inIt;
	}
	
	@RequestMapping(value = { "/getAllInitiativeAdvntgDisadvntg" }, method = RequestMethod.POST)
	public @ResponseBody List<SpecificLocalAdvntgDisadvntg> getAllInitiativeAdvntgDisadvntg(@RequestParam("instituteId") int instituteId,@RequestParam("yId") int yId) {
		List<SpecificLocalAdvntgDisadvntg> init = new ArrayList<SpecificLocalAdvntgDisadvntg>();
		try {
			init=inItRepo.findByInstIdAndAcYearIdAndDelStatusOrderBySpciAdvIdDesc(instituteId, yId, 1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return init;

	}
	
	@RequestMapping(value = { "/editInitiativeById" }, method = RequestMethod.POST)
	public @ResponseBody SpecificLocalAdvntgDisadvntg editInitiativeById(@RequestParam("inItId") int inItId) {
		SpecificLocalAdvntgDisadvntg init = new SpecificLocalAdvntgDisadvntg();
		
		try {
			init=inItRepo.findBySpciAdvId(inItId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return init;
	}
	
	
	@RequestMapping(value = { "/delInitiativeAdvDisadvById" }, method = RequestMethod.POST)
	public @ResponseBody Info delInitiativeAdvDisadvById(@RequestParam("inItId") int inItId) {

		int isDelete = 0;
		isDelete = inItRepo.deleteInitiative(inItId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;

	}
	
	@RequestMapping(value = { "/deleteSelInitives" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelInitives(@RequestParam List<String> initAdvIdList) {

		Info info = new Info();
		try {
			int res = inItRepo.deleteInitives(initAdvIdList);

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
