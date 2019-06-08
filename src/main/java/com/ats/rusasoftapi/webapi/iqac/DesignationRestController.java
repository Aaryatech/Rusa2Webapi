package com.ats.rusasoftapi.webapi.iqac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.Designation;
import com.ats.rusasoftapi.repositories.DesignationRepo;

@RestController
public class DesignationRestController {

	@Autowired DesignationRepo desgrepo;

	@RequestMapping(value= {"/getAllDesignations"}, method=RequestMethod.POST)
	public @ResponseBody List<Designation> getAllDesignation(@RequestParam List<Integer> desgList ){
				
		List<Designation> designationList = desgrepo.findByDelStatusAndIsActiveOrderByDesignationIdDesc(desgList);
		
		return designationList;
		
	}
	
	@RequestMapping(value= {"/getAllDesignationsForList"}, method=RequestMethod.GET)
	public @ResponseBody List<Designation> getAllDesignationsForList(){
				
		List<Designation> designationList = desgrepo.findByDelStatusAndIsActiveOrderByDesignationIdDesc(1,1);
		
		return designationList;
		
	}
}
