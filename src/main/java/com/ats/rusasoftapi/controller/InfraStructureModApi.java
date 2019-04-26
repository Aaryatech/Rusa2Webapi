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

import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.infra.GetInstInfraAreaInfo;
import com.ats.rusasoftapi.model.infra.InfraAreaName;
import com.ats.rusasoftapi.model.infra.InfraAreaType;
import com.ats.rusasoftapi.model.infra.InstInfraAreaInfo;
import com.ats.rusasoftapi.model.infra.ItInfrastructure;
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
	
	@Autowired ItInfrastructureRepo infraRepo;

	
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
	
	@RequestMapping(value = { "/saveItInfrastructureInfo" }, method = RequestMethod.POST)
	public @ResponseBody ItInfrastructure saveItInfrastructureInfo(@RequestBody ItInfrastructure infrastur) {
		ItInfrastructure itInfra = null;
		try {
		 itInfra = infraRepo.save(infrastur);
	}catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
		
		
		return itInfra;
		
	}
	
	
	@RequestMapping(value = { "/showAllItInfrastructure" }, method = RequestMethod.POST)
	public @ResponseBody List<ItInfrastructure> showAllItInfrastructure(
			@RequestParam int instituteId) {

		List<ItInfrastructure> itInfraList = new ArrayList<ItInfrastructure>();

		try {
			itInfraList = infraRepo.findByInstIdAndDelStatusOrderByInstItInfraInfoIdDesc(instituteId, 1);
		} catch (Exception e) {
			System.err.println("Exce in showAllItInfrastructure " + e.getMessage());
			e.printStackTrace();
		}

		return itInfraList;
	}
	
	@RequestMapping(value = { "/getItInfraStructureById" }, method = RequestMethod.POST)
	public @ResponseBody ItInfrastructure getItInfraStructureById(
			@RequestParam int infraId) {

		ItInfrastructure itInfraList = null;

		try {
			itInfraList = infraRepo.findByInstItInfraInfoId(infraId);
		} catch (Exception e) {
			System.err.println("Exce in getItInfraStructureById " + e.getMessage());
			e.printStackTrace();
		}

		return itInfraList;
	}
	
	
	@RequestMapping(value = { "/deletetInfraById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteItInfraById(@RequestParam int infraId) {
		Info info = new Info();
		try {
			int res = infraRepo.delItInfraStructrById(infraId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteItInfraById " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
				
	}
	
	@RequestMapping(value = { "/delSelItInfraId" }, method = RequestMethod.POST)
	public @ResponseBody Info delPubicationDetails(@RequestParam List<String> infraIdList) {

		Info info = new Info();
		try {
			int res = infraRepo.deleteItInfraInfo(infraIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	
}
