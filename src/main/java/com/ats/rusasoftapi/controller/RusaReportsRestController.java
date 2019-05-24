package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.SettingKeyValue;
import com.ats.rusasoftapi.model.report.DifferentlyAbldStudReport;
import com.ats.rusasoftapi.model.report.StudTeachrRatio;
import com.ats.rusasoftapi.mstrepo.DifferentlyAbldStudReportRepo;
import com.ats.rusasoftapi.mstrepo.SettingKeyValueRepo;

@RestController
public class RusaReportsRestController {
	@Autowired SettingKeyValueRepo settingKeyValueRepo;
 	@Autowired StudTeachrRatioRepo studTeachRepo;

 	@RequestMapping(value = { "/getStudTeachrRatioList" }, method = RequestMethod.POST)
	public @ResponseBody List<StudTeachrRatio> getStudTeachrRatioList(@RequestParam int instId,
			@RequestParam int acYear) {
 		List<StudTeachrRatio> ratioList = new ArrayList<StudTeachrRatio>();
 		try {
 			ratioList = studTeachRepo.getAllStudentTeacherRatioData(instId, acYear);
 			System.err.println("List="+ratioList);
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return ratioList;
 	}
 	
 	
 	@Autowired DifferentlyAbldStudReportRepo difStudRepo;
 	@RequestMapping(value = { "/getDifferntlyAbldStudList" }, method = RequestMethod.POST)
	public @ResponseBody List<DifferentlyAbldStudReport> getDifferntlyAbldStudList(@RequestParam int instId,
			@RequestParam int acYear) {
 		List<DifferentlyAbldStudReport> studList = new ArrayList<DifferentlyAbldStudReport>();
 		SettingKeyValue setKey=new SettingKeyValue();
 		try {
 			setKey=settingKeyValueRepo.findBySettingKeyAndDelStatus("Divyanjan",1);
			System.err.println("stk ids :"+setKey.toString());
			int stkId=setKey.getIntValue();
			 			
			studList = difStudRepo.getAllDifferentlyAbledStud(instId, acYear, stkId);
 			
 		}catch(Exception e) {
 			System.err.println(e.getMessage());
 		}
		return studList;
 	}
}
