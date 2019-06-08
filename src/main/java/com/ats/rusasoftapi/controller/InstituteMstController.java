package com.ats.rusasoftapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.Institute;
import com.ats.rusasoftapi.model.InstituteMaster;
import com.ats.rusasoftapi.mstrepo.InstituteRepo;
import com.ats.rusasoftapi.repository.InstituteMasterRepo;
//06-06-2019
@RestController
public class InstituteMstController {

	@Autowired InstituteMasterRepo instituteMasterRepo;
	@Autowired
	InstituteRepo instituteRepo;
	@RequestMapping(value = { "/checkAisheCodeDuplication" }, method = RequestMethod.POST)
	public @ResponseBody String checkAisheCodeDuplication(@RequestParam String aisheCode) {
String response=null;
		Institute insResp = new Institute();
		try {
			
			insResp=instituteRepo.findByAisheCodeAndDelStatus(aisheCode, 1);
			//System.err.println("Inst with aishe " +insResp.toString());
			if(insResp==null) {
				response= "unique";
			}else {
				response= "duplicate";
			}
		}catch (Exception e) {
			System.err.println("");
			
		}
		//System.err.println("Inst with aishe " +insResp.toString());
		
		return response;
	}
		
	@RequestMapping(value = { "/getInstituteMasterByAishe" }, method = RequestMethod.POST)
	public @ResponseBody InstituteMaster getInstituteMasterByAishe(@RequestParam String aisheCode) {

		InstituteMaster instMaster = null;

		try {
			instMaster = instituteMasterRepo.findByAisheCode(aisheCode);

		} catch (Exception e) {
			System.err.println("Exce in getting  getInstituteMasterByAishe @ InstituteMstController " + e.getMessage());
			e.printStackTrace();

		}
		return instMaster;
	}
	
	
}
