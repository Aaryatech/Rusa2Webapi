package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.Institute;
import com.ats.rusasoftapi.model.InstituteMaster;
import com.ats.rusasoftapi.model.State;
import com.ats.rusasoftapi.mstrepo.InstituteRepo;
import com.ats.rusasoftapi.mstrepo.StateRepo;
import com.ats.rusasoftapi.repository.InstituteMasterRepo;
//06-06-2019
@RestController
public class InstituteMstController {
	
	//temporaty web service to insert state master in DB
	@Autowired StateRepo stateRepo;
	@RequestMapping(value = { "/saveState" }, method = RequestMethod.GET)
	public @ResponseBody String saveState() {
	
		String stateList="Andaman and Nicobar Islands, Andhra Pradesh,Arunachal Pradesh,Assam,Bihar, Chandigarh ,Chhattisgarh,Dadra and Nagar Haveli,Daman and Diu,Delhi,Goa,Gujarat,Haryana,Himachal Pradesh,Jammu and Kashmir,Jharkhand,Karnataka,Kerala, 	Lakshadweep ,Madhya Pradesh,Maharashtra,Manipur,Meghalaya,Mizoram,Nagaland,Orissa,Puducherry,Punjab, Rajasthan,Sikkim,Tamil Nadu,Telangana,Tripura,Uttar Pradesh,Uttarakhand,West Bengal"
;
		List<String> stateList1 = Stream.of(stateList.split(","))
				.collect(Collectors.toList());
		
		System.err.println("stateList1 " +stateList1.toString());
		
		List<State> staList=new ArrayList<>();
		for(int i=0;i<stateList1.size();i++) {
			
			State state=new State();
			state.setStateName(stateList1.get(i));
			staList.add(state);
		}
		
	   stateRepo.saveAll(staList);
		return stateList1.toString();
	}
	
	
	@RequestMapping(value = { "/getStateList" }, method = RequestMethod.GET)
	public @ResponseBody List<State> getStateList() {
		
		List<State> stateList=new ArrayList<>();
		
		try {
			stateList=stateRepo.findByDelStatus(1);
		}catch (Exception e) {
			
		}
		return stateList;
		
	}

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
				response= "	";
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
	
	
	 
	@RequestMapping(value = { "/getInstituteMasterByAisheForChangePrincipal" }, method = RequestMethod.POST)
	public @ResponseBody Institute getInstituteMasterByAisheForChangePrincipal(@RequestParam String aisheCode) {

		Institute instMaster = null;

		try {
			instMaster = instituteRepo.findByAisheCodeAndDelStatusAndIsActiveAndExInt2(aisheCode,1,1,1);

		} catch (Exception e) {
			System.err.println("Exce in getting  getInstituteMasterByAisheForChangePrincipal @ InstituteMstController " + e.getMessage());
			e.printStackTrace();

		}
		return instMaster;
	}
	
	
}
