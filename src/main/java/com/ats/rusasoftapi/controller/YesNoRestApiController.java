package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.InstituteYesNo;
import com.ats.rusasoftapi.model.SectionList;
import com.ats.rusasoftapi.model.YesNoMaster;
import com.ats.rusasoftapi.repository.InstituteYesNoRepository;
import com.ats.rusasoftapi.repository.SectionListRepository;
import com.ats.rusasoftapi.repository.YesNoMasterRepository;

@RestController
public class YesNoRestApiController {
	
	@Autowired
	YesNoMasterRepository yesNoMasterRepository;

	@Autowired
	SectionListRepository sectionListRepository;
	
	@Autowired
	InstituteYesNoRepository instituteYesNoRepository;
	
	@RequestMapping(value = { "/getYesNoList" }, method = RequestMethod.POST)
	public @ResponseBody List<YesNoMaster> getYesNoList(@RequestParam("pageCode") String pageCode) {

		List<YesNoMaster> list = new ArrayList<>();

		try {

			list = yesNoMasterRepository.findByYesnoPagecodeAndDelStatusAndIsActive(pageCode,1,1);
			
			for(int i=0 ; i<list.size() ; i++) {
				
				if(list.get(i).getYesnoResponseType()==1) {
					
					list.get(i).setJsonArray(list.get(i).getYesnoResponseContent().split(","));
				}
				
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getSectionListByPageCode" }, method = RequestMethod.POST)
	public @ResponseBody List<SectionList> getSectionListByPageCode(@RequestParam("pageCode") String pageCode) {

		List<SectionList> list = new ArrayList<>();

		try {

			list = sectionListRepository.getSectionListByPageCode(pageCode);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/saveYesNoSingle" }, method = RequestMethod.POST)
	public @ResponseBody InstituteYesNo saveYesNoSingle(@RequestBody InstituteYesNo instituteYesNo) {

		InstituteYesNo save = new InstituteYesNo();

		try {

			save = instituteYesNoRepository.save(instituteYesNo);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}
	
	@RequestMapping(value = { "/saveYesNo" }, method = RequestMethod.POST)
	public @ResponseBody List<InstituteYesNo>  saveYesNo(@RequestBody List<InstituteYesNo> instituteYesNo) {

		List<InstituteYesNo> save = new ArrayList<InstituteYesNo>();

		try {

			save = instituteYesNoRepository.saveAll(instituteYesNo);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}
	
	@RequestMapping(value = { "/getInstituteYesNoListByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<InstituteYesNo> getInstituteYesNoListByInstituteId(@RequestParam("instituteId") int instituteId,
			@RequestParam("yearId") int yearId,@RequestParam("pageCode") String pageCode) {

		List<InstituteYesNo> list = new ArrayList<>();

		try {

			list = instituteYesNoRepository.findByInstituteIdAndDelStatusAndIsActiveAndYearIdAndYesnoPagecode(instituteId,1,1,yearId,pageCode);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getInstituteYesNoListByInstituteIdAndSectionCode" }, method = RequestMethod.POST)
	public @ResponseBody List<InstituteYesNo> getInstituteYesNoListByInstituteIdAndSectionCode(@RequestParam("instituteId") int instituteId,
			@RequestParam("yearId") int yearId,@RequestParam("secCode") String secCode) {

		List<InstituteYesNo> list = new ArrayList<>();

		try {

			list = instituteYesNoRepository.findByInstituteIdAndDelStatusAndIsActiveAndYearIdAndSectionCodeOrderByInstYesnoIdDesc(instituteId,1,1,yearId,secCode);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getInstituteYesNoById" }, method = RequestMethod.POST)
	public @ResponseBody InstituteYesNo getInstituteYesNoByInstituteIdAndSectionCode(@RequestParam("instituteId") int instituteId,
			@RequestParam("yearId") int yearId, @RequestParam("id") int id ) {

	InstituteYesNo instyn= new InstituteYesNo();

		try {

			instyn = instituteYesNoRepository.findByInstituteIdAndDelStatusAndIsActiveAndYearIdAndInstYesnoId(instituteId,1,1,yearId,id);
			// System.out.println("res="+instyn.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return instyn;

	}
	
	
	@RequestMapping(value = { "/editYesNoRecord" }, method = RequestMethod.POST)
	public @ResponseBody Info editYesNoRecord(@RequestParam("id") int id,@RequestParam String yesNoResponse ) {

		Info info = new Info();

		try {
			
			int yesNoRes = instituteYesNoRepository.editYesNoRecord(id, yesNoResponse);
			info.setError(false);
			info.setMessage("edited");
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage("editYesNoRecord failed");
		}

		return info;

	}
	
	@RequestMapping(value = { "/deleteYesNoRecord" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteYesNoRecord(@RequestParam("id") int id ) {

		Info info = new Info();

		try {
			
			int elete = instituteYesNoRepository.deleteYesNoRecord(id);
			info.setError(false);
			info.setMessage("deleted");
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage("deleted failed");
		}

		return info;

	}

}
