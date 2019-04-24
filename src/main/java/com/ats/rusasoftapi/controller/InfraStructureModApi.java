package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.infra.GetInstInfraAreaInfo;
import com.ats.rusasoftapi.model.infra.InfraAreaName;
import com.ats.rusasoftapi.model.infra.InfraAreaType;
import com.ats.rusasoftapi.model.infra.InstInfraAreaInfo;
import com.ats.rusasoftapi.model.instprofile.InstituteTraining;
import com.ats.rusasoftapi.repo.infra.GetInstInfraAreaInfoRepo;
import com.ats.rusasoftapi.repo.infra.InfraAreaNameRepo;
import com.ats.rusasoftapi.repo.infra.InstInfraAreaInfoRepo;
import com.ats.rusasoftapi.repo.infra.InfraAreaTypeRepo;

@RestController
public class InfraStructureModApi {
	
	@Autowired InfraAreaTypeRepo infraAreaTypeRepo;
	@Autowired InfraAreaNameRepo infraAreaNameRepo;
	@Autowired InstInfraAreaInfoRepo instInfraAreaInfoRepo;

	
	@RequestMapping(value = { "/getInfraAreaTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<InfraAreaType> getInfraAreaTypeList() {

		List<InfraAreaType> infraAreaTypeList = new ArrayList<InfraAreaType>();

		try {
			infraAreaTypeList = infraAreaTypeRepo.findByDelStatus(1);
		} catch (Exception e) {
			System.err.println("Exce in getInfraAreaTypeList " + e.getMessage());
			e.printStackTrace();
		}

		return infraAreaTypeList;
	}
	
	
	@RequestMapping(value = { "/getInfraAreaNameListByInfraAreaTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<InfraAreaName> getInfraAreaNameListByInfraAreaTypeId(
			@RequestParam int infraAreaTypeId) {

		List<InfraAreaName> infraAreaNameList = new ArrayList<InfraAreaName>();

		try {
			infraAreaNameList = infraAreaNameRepo.findByDelStatusAndIsActiveAndInfraAreaTypeId(1, 1, infraAreaTypeId);
		} catch (Exception e) {
			System.err.println("Exce in getInfraAreaNameListByInfraAreaTypeId " + e.getMessage());
			e.printStackTrace();
		}

		return infraAreaNameList;
	}
	
	
	@RequestMapping(value = { "/saveInstInfraAreaInfo" }, method = RequestMethod.POST)
	public @ResponseBody InstInfraAreaInfo saveInstInfraAreaInfo(
			@RequestBody InstInfraAreaInfo instInfrAreaInfo) {

		InstInfraAreaInfo instInfrAreaInfoRes = null;

		try {
			instInfrAreaInfoRes = instInfraAreaInfoRepo.save(instInfrAreaInfo);
		} catch (Exception e) {
			System.err.println("Exce in saving saveInstInfraAreaInfo " + e.getMessage());
			e.printStackTrace();
		}

		return instInfrAreaInfoRes;
	}
	
	
	@RequestMapping(value = { "/findByDelStatusAndIsActiveAndInstIdAndInfraAreaId" }, method = RequestMethod.POST)
	public @ResponseBody InstInfraAreaInfo saveInstInfraAreaInfo(
			@RequestParam int instId,@RequestParam int areaId) {

		InstInfraAreaInfo infrAreaInfoRes = new InstInfraAreaInfo();

		try {
			infrAreaInfoRes = instInfraAreaInfoRepo.findByDelStatusAndIsActiveAndInstIdAndInfraAreaId(1,1,instId,areaId);
		if(infrAreaInfoRes==null){
			infrAreaInfoRes = new InstInfraAreaInfo();
		}
		} catch (Exception e) {
			System.err.println("Exce in findByDelStatusAndIsActiveAndInstIdAndInfraAreaId " + e.getMessage());
			e.printStackTrace();
		}

		return infrAreaInfoRes;
	}
	
	
	@Autowired GetInstInfraAreaInfoRepo getInstInfraAreaInfoRepo;
	
	@RequestMapping(value = { "/getInstInfraAreaInfoByInstId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetInstInfraAreaInfo> getInstInfraAreaInfoByInstId(
			@RequestParam int instId) {

		 List<GetInstInfraAreaInfo> infrAreaInfoRes = new ArrayList<>();

		try {
			infrAreaInfoRes = getInstInfraAreaInfoRepo.getInstInfraAreaInfoByInstId(instId);
		} catch (Exception e) {
			System.err.println("Exce in findByDelStatusAndIsActiveAndInstIdAndInfraAreaId " + e.getMessage());
			e.printStackTrace();
		}

		return infrAreaInfoRes;
	}
}
