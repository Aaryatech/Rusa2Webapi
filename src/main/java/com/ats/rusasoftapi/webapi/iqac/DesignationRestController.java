package com.ats.rusasoftapi.webapi.iqac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.Designation;
import com.ats.rusasoftapi.repositories.DesignationRepo;

@RestController
public class DesignationRestController {

	@Autowired DesignationRepo desgrepo;

	@RequestMapping(value= {"/getAllDesignations"}, method=RequestMethod.GET)
	public @ResponseBody List<Designation> getAllDesignation(){
		
		List<Designation> designationList = desgrepo.findByDelStatusAndIsActiveOrderByDesignationIdDesc(1,1);
		
		return designationList;
		
	}
}
