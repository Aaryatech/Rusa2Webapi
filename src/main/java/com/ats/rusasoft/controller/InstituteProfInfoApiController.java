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

import com.ats.rusasoft.model.GetProgram;
import com.ats.rusasoft.model.IqacBasicInfo;
import com.ats.rusasoft.model.progdetail.Cast;
import com.ats.rusasoft.mstrepo.IqacBasicInfoRepo;

@RestController
public class InstituteProfInfoApiController {

	
	@Autowired
	IqacBasicInfoRepo iqacBasicInfoRepo;
	
	@RequestMapping(value = { "/saveInstituteBasicInfo" }, method = RequestMethod.POST)
	public @ResponseBody IqacBasicInfo saveInstituteBasicInfo(@RequestBody IqacBasicInfo instInfo) {

		IqacBasicInfo instResp = null;
 
		try {

				instResp = iqacBasicInfoRepo.saveAndFlush(instInfo);


		} catch (Exception e) {
			System.err.println("Exce in saving InstituteInfo " + e.getMessage());
			e.printStackTrace();
		}

		return instInfo; 

	}
	
	
	@RequestMapping(value = { "/getIqacInfoByInstId" }, method = RequestMethod.POST)
	public @ResponseBody IqacBasicInfo getProgramByProgId(@RequestParam int instituteId) {

		IqacBasicInfo progRes = new IqacBasicInfo();

		try {

			progRes = iqacBasicInfoRepo.getIqacInfo(instituteId);
		} catch (Exception e) {
			System.err.println("Exce in getHigherEducDetail  " + e.getMessage());
			e.printStackTrace();
		}

		return progRes;

	}
	
	@RequestMapping(value = { "/getIqacInfoByIqacInfoId" }, method = RequestMethod.POST)
	
	public @ResponseBody IqacBasicInfo getIqacInfoByIqacInfoId(@RequestParam int iqacInfoId) {

		IqacBasicInfo progRes = new IqacBasicInfo();

		try {
			progRes = iqacBasicInfoRepo.findByDelStatusAndIsActiveAndIqacInfoId(1, 1,iqacInfoId);

		} catch (Exception e) {
			System.err.println("Exce in getAllCastCategory  " + e.getMessage());
			e.printStackTrace();
		}

		return progRes;

	}

	
	
	
	

}
