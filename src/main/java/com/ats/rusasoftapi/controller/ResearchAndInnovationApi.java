package com.ats.rusasoftapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.MExtActList;
import com.ats.rusasoftapi.model.MExtensionActivity;
import com.ats.rusasoftapi.model.TExtensionActivity;
import com.ats.rusasoftapi.model.TNeighbourhoodCommActivities;
import com.ats.rusasoftapi.repositories.MExtActListRepo;
import com.ats.rusasoftapi.repositories.MExtensionActivityRepo;
import com.ats.rusasoftapi.repositories.TExtensionActivityRepo;

@RestController
public class ResearchAndInnovationApi {
	@Autowired MExtensionActivityRepo mExtRepo;
	
	@Autowired TExtensionActivityRepo extAcrRepo;
	
	@Autowired MExtActListRepo extReop;
/******************Extension Activity********************/
	
	
	@RequestMapping(value = { "/getAllExtensionActivities" }, method = RequestMethod.GET)
	public @ResponseBody List<MExtensionActivity> getAllExtensionActivities() {
		System.out.println("List");
		List<MExtensionActivity> extList = null;
		
		extList = mExtRepo.findByDelStatus(1);
		System.out.println("List"+extList);
		return extList;
	
	}
	
	
	
	@RequestMapping(value = { "/saveExtActivity" }, method = RequestMethod.POST)
	public @ResponseBody TExtensionActivity saveExtActivity(@RequestBody TExtensionActivity tExtAct) {
		TExtensionActivity extAct = null;
			extAct = extAcrRepo.save(tExtAct);
		
		return extAct;
	
	}
	
	@RequestMapping(value = { "/getAllExtActivities"}, method = RequestMethod.POST)
	public @ResponseBody List<MExtActList> showNeighbourCommActivities(@RequestParam("instituteId") int instituteId) {

		List<MExtActList> extActList = null;

		try {

			extActList = extReop.getAllExtActByInstId(instituteId);
			System.err.println("List="+extActList);

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return extActList;

	}
	
	@RequestMapping(value = { "/getExtActivityById"}, method = RequestMethod.POST)
	public @ResponseBody TExtensionActivity getExtActivityById(@RequestParam("extActId") int extActId) {

		TExtensionActivity extAct = null;

		try {

			extAct = extAcrRepo.findByinstExtensionActId(extActId);
			System.err.println("Ext="+extAct);

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return extAct;

	}
	
	@RequestMapping(value = { "/deleteTExtActById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMExtActById(@RequestParam int extActId) {
		
		Info info = new Info();
		try {
			int res = extAcrRepo.deleteExtActInfoById(extActId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteMExtActById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}
	
	@RequestMapping(value = { "/deleteSelExtAct" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelExtAct(@RequestParam List<String> exActIdsList) {

		Info info = new Info();
		try {
			int res = extAcrRepo.deletetExtAct(exActIdsList);

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
