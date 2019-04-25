package com.ats.rusasoftapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.GenderEqalityPrg;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.InstituteActivity;
import com.ats.rusasoftapi.model.InstituteSupport;
import com.ats.rusasoftapi.model.IntelPrpoRight;
import com.ats.rusasoftapi.repositories.GenderEqualityPrgRepo;
import com.ats.rusasoftapi.repositories.InstituteActivityRepo;
import com.ats.rusasoftapi.repositories.InstituteSupportRepo;
import com.ats.rusasoftapi.repositories.IntelPropRightRepo;

@RestController
public class InstituteRestApiController {

	@Autowired InstituteSupportRepo instSuprtRepo;
	
	@Autowired InstituteActivityRepo instActvRepo;
	
	@Autowired IntelPropRightRepo intelRepo;
	
	@Autowired GenderEqualityPrgRepo gProgRepo;
	
	@RequestMapping(value = {"/addInstSupprt"}, method = RequestMethod.POST)
	public  @ResponseBody InstituteSupport  addInstSuprt(@RequestBody InstituteSupport instSpprt){
		return instSuprtRepo.save(instSpprt);
		
	}
	
	@RequestMapping(value = {"/getSchemesByIds"}, method = RequestMethod.POST)
	public  @ResponseBody List<InstituteSupport>  getInstSuprtList(@RequestParam("instituteId") int instituteId, @RequestParam("yId") int yId){
		
		return instSuprtRepo.findByInstituteIdAndYearIdAndDelStatusOrderByInstSchemeIdDesc(instituteId, yId, 1);
		
	}

	@RequestMapping(value = {"/getSuprtSchemeBySchmId"}, method = RequestMethod.POST)
	public  @ResponseBody InstituteSupport  getSuprSchmByID(@RequestParam("schmId") int schmId){
		return instSuprtRepo.findByInstSchemeId(schmId);
		
	}
	

	@RequestMapping(value = {"/deleteSuprtSchemeBySchmId"}, method = RequestMethod.POST)
	public  @ResponseBody Info  deleteSuprSchmByID(@RequestParam("schmId") int schmId){
		
		
		int isDelete=0;
		 isDelete= instSuprtRepo.deleteByInstSuprtSchmId(schmId);
		 Info inf = new Info();
		 if(isDelete>0) {
			 inf.setError(false);
			 inf.setMsg("Sucessfully Deleted");
		 }
		 else{
			 inf.setError(true);
			 inf.setMsg("Fail");
		 }
		 return inf;
		
	}
	
	@RequestMapping(value = { "/deletinstSupport"}, method = RequestMethod.POST)
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
	
	
	/*****************************************Institute Activity*********************************************/
	
	@RequestMapping(value = {"/addNewInstituteActity"}, method = RequestMethod.POST)
	public  @ResponseBody InstituteActivity  addInstSuprt(@RequestBody InstituteActivity instAct){
		
		return instActvRepo.save(instAct);
		
	}
	
	@RequestMapping(value = {"/getAllInstituteActities"}, method = RequestMethod.POST)
	public  @ResponseBody List<InstituteActivity>  getAllInstituteActities(@RequestParam("instituteId") int instituteId, @RequestParam("yId") int yId){
		return instActvRepo.findByInstituteIdAndYearIdAndDelStatusOrderByInstActivityIdDesc(instituteId, yId, 1);
		
	}
	
	@RequestMapping(value = {"/getInstActivityById"}, method = RequestMethod.POST)
	public  @ResponseBody InstituteActivity  getInstActivityById(@RequestParam("instActvId") int instActvId){
		return instActvRepo.findByInstActivityId(instActvId);
		
	}
	
	@RequestMapping(value = {"/deleteActivId"}, method = RequestMethod.POST)
	public  @ResponseBody Info deleteActivtById(@RequestParam("instActvId") int instActvId){
		
		
		int isDelete=0;
		 isDelete= instActvRepo.deleteByInstActivityId(instActvId);
		 Info inf = new Info();
		 if(isDelete>0) {
			 inf.setError(false);
			 inf.setMsg("Sucessfully Deleted");
		 }
		 else{
			 inf.setError(true);
			 inf.setMsg("Fail");
		 }
		 return inf;
		
	}
	
	@RequestMapping(value = { "/deleteOrgActivities"}, method = RequestMethod.POST)
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
	
	/**********************************Intelectual Property Right********************************/
	@RequestMapping(value = {"/andNewIntelPropRight"}, method = RequestMethod.POST)
	public  @ResponseBody IntelPrpoRight  andNewIntelPropRight(@RequestBody IntelPrpoRight intelProp){
		
		return intelRepo.save(intelProp);
		
	}
	
	@RequestMapping(value = {"/getAllIntelPropRights"}, method = RequestMethod.POST)
	public  @ResponseBody List<IntelPrpoRight>  getintelRightsList(@RequestParam("instituteId") int instituteId, @RequestParam("yId") int yId){
		
		return intelRepo.findByInstituteIdAndYearIdAndDelStatusOrderByConIdDesc(instituteId, yId, 1);
	}
	
	@RequestMapping(value = {"/getIntelPropRigntById"}, method = RequestMethod.POST)
	public  @ResponseBody IntelPrpoRight  getIntelPropRigntById(@RequestParam("conId") int conId){
		return intelRepo.findByConId(conId);
		
	}
	
	@RequestMapping(value = {"/deleteRightById"}, method = RequestMethod.POST)
	public  @ResponseBody Info deleteRightById(@RequestParam("conId") int conId){
		
		
		int isDelete=0;
		 isDelete= intelRepo.deleteIntelRightById(conId);
		 Info inf = new Info();
		 if(isDelete>0) {
			 inf.setError(false);
			 inf.setMsg("Sucessfully Deleted");
		 }
		 else{
			 inf.setError(true);
			 inf.setMsg("Fail");
		 }
		 return inf;
		
	}
	
	@RequestMapping(value = { "/deleteIntelRights"}, method = RequestMethod.POST)
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
	
	/******************************************Gender Equality Programe*********************************************/
	
	@RequestMapping(value = {"/addGendrEqtyPrg"}, method = RequestMethod.POST)
	public  @ResponseBody GenderEqalityPrg  addGendrEqtyPrg(@RequestBody GenderEqalityPrg gendrEqualityt){
		return gProgRepo.save(gendrEqualityt);
		
	}
	
	
	@RequestMapping(value = {"/getAllGenderEqltyData"}, method = RequestMethod.POST)
	public  @ResponseBody List<GenderEqalityPrg>  getAllGenderEqltyList(@RequestParam("instituteId") int instituteId, @RequestParam("yId") int yId){
		
		return gProgRepo.findByInstituteIdAndYearIdAndDelStatusOrderByGprogIdDesc(instituteId, yId, 1);
				
	}
	
	@RequestMapping(value = {"/editGenderEqualityById"}, method = RequestMethod.POST)
	public  @ResponseBody GenderEqalityPrg  editGenderEqualityById(@RequestParam("gndrDataId") int gndrDataId){
		return gProgRepo.findBygprogId(gndrDataId);
		
	}
	
	
	@RequestMapping(value = {"/deleteGenderEqualityById"}, method = RequestMethod.POST)
	public  @ResponseBody Info deleteGndrEqltyById(@RequestParam("gndrDataId") int gndrDataId){
		
		
		int isDelete=0;
		 isDelete= gProgRepo.deleteGendrEqltyById(gndrDataId);
		 Info inf = new Info();
		 if(isDelete>0) {
			 inf.setError(false);
			 inf.setMsg("Sucessfully Deleted");
		 }
		 else{
			 inf.setError(true);
			 inf.setMsg("Fail");
		 }
		 return inf;
		
	}

	@RequestMapping(value = { "/deleteGenderEquity"}, method = RequestMethod.POST)
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

}