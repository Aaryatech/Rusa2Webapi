package com.ats.rusasoftapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.InstituteMaster;
import com.ats.rusasoftapi.repository.InstituteMasterRepo;

@RestController
public class InstituteMstController {

	@Autowired InstituteMasterRepo instituteMasterRepo;
	
	
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
