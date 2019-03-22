package com.ats.rusasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.InstituteActivity;
import com.ats.rusasoft.model.InstituteSupport;
import com.ats.rusasoft.repositories.InstituteActivityRepo;
import com.ats.rusasoft.repositories.InstituteSupportRepo;

@RestController
public class InstituteRestApiController {

	@Autowired InstituteSupportRepo instSuprtRepo;
	
	@Autowired InstituteActivityRepo instActvRepo;
	
	@RequestMapping(value = {"/addInstSupprt"}, method = RequestMethod.POST)
	public  @ResponseBody InstituteSupport  addInstSuprt(@RequestBody InstituteSupport instSpprt){
		return instSuprtRepo.save(instSpprt);
		
	}
	
	@RequestMapping(value = {"/getSchemesByIds"}, method = RequestMethod.POST)
	public  @ResponseBody List<InstituteSupport>  getInstSuprtList(@RequestParam("instituteId") int instituteId, @RequestParam("yId") int yId){
		return instSuprtRepo.findByInstituteIdAndYearIdAndDelStatusOrderByInstSchemeId(instituteId, yId, 1);
		
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
	
	/*****************************************Institute Activity*********************************************/
	
	@RequestMapping(value = {"/addNewInstituteActity"}, method = RequestMethod.POST)
	public  @ResponseBody InstituteActivity  addInstSuprt(@RequestBody InstituteActivity instAct){
		
		return instActvRepo.save(instAct);
		
	}
}
