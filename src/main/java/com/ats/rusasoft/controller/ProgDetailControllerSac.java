package com.ats.rusasoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.progdetail.Cast;
import com.ats.rusasoft.model.progdetail.Location;
import com.ats.rusasoft.prodetailrepo.CastRepo;
import com.ats.rusasoft.prodetailrepo.LocationRepo;

@RestController
public class ProgDetailControllerSac {
	
	@Autowired  CastRepo castRepo;
	
	@Autowired LocationRepo locRepo;
	
	@RequestMapping(value = { "/getAllCastCategory" }, method = RequestMethod.POST)
	public @ResponseBody List<Cast> getAllCastCategory(@RequestParam int instId) {

		List<Cast> castList = new ArrayList<>();

		try {
			castList = castRepo.findByDelStatusAndIsActive(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllCastCategory  " + e.getMessage());
			e.printStackTrace();
		}

		return castList;

	}

	@RequestMapping(value = { "/getAllLocation" }, method = RequestMethod.POST)
	public @ResponseBody List<Location> getAllLocation(@RequestParam int instId) {

		List<Location> locList = new ArrayList<>();

		try {
			locList = locRepo.findByDelStatusAndIsActive(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllLocation  " + e.getMessage());
			e.printStackTrace();
		}

		return locList;

	}

}
