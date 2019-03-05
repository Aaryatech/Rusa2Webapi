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

import com.ats.rusasoft.model.GetInstituteList;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.Institute;
import com.ats.rusasoft.mstrepo.GetInstituteListRepo;
import com.ats.rusasoft.mstrepo.InstituteRepo;

@RestController
public class MasterApiController {
	
	@Autowired
	InstituteRepo instituteRepo;
	@Autowired GetInstituteListRepo getGetInstituteListRepo;
	
	@RequestMapping(value = { "/saveInstitute" }, method = RequestMethod.POST)
	public @ResponseBody Institute saveInstitute(@RequestBody Institute institute) {
		
		Institute insResp=null;
		
		try {
			insResp=instituteRepo.saveAndFlush(institute);
			
		}catch (Exception e) {
			System.err.println("Exce in saving Institute " +e.getMessage());
			e.printStackTrace();
		}
		
		return institute;
		
	}
	
	
	@RequestMapping(value = { "/getAllInstitutes" }, method = RequestMethod.GET)
	public @ResponseBody List<GetInstituteList> getAllInstitutes() {
		
		List<GetInstituteList> insResp=new ArrayList<>();
		
		try {
			insResp=getGetInstituteListRepo.getAllInstituteList();
			
		}catch (Exception e) {
			System.err.println("Exce in getAllInstitutes Institute " +e.getMessage());
			e.printStackTrace();
		}
		
		return insResp;
		
	}
	
	@RequestMapping(value = { "/deleteInstitutes" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstitutes(@RequestParam List<String> instIdList) {
		
		Info info=new Info();
		try {
			int res=instituteRepo.deleteInstitutes(instIdList);
			
			if(res>0) {
				info.setError(false);
				info.setMsg("success");
				
			}
			else {
				info.setError(true);
				info.setMsg("failed");
				
			}
		}catch (Exception e) {
			
			System.err.println("Exce in getAllInstitutes Institute " +e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}
		
		return info;
		
	}
	
	@RequestMapping(value = { "/getInstitute" }, method = RequestMethod.POST)
	public @ResponseBody Institute getInstitute(@RequestParam int instituteId) {
		
		Institute insResp=null;
		
		try {
			insResp=instituteRepo.findByInstituteId(instituteId);
			
		}catch (Exception e) {
			
			System.err.println("Exce in getInstitute Institute " +e.getMessage());
			e.printStackTrace();
		}
		
		return insResp;
		
	}
		
}
