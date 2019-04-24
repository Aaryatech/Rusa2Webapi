package com.ats.rusasoftapi.webapi.iqac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.model.Staff;
import com.ats.rusasoftapi.repositories.StaffRepo;

@RestController
public class FacultyApiController {

	@Autowired
	StaffRepo staffrepo;

	@RequestMapping(value = { "/getFacultyByFacultyIdAndIsPrinci" }, method = RequestMethod.POST)
	public @ResponseBody Staff getFacultyByFacultyIdAndIsPrinci(@RequestParam int facultyId) {

		Staff staff = new Staff();

		try {
			staff = staffrepo.findByFacultyIdAndDelStatusAndIsPrincipalAndIsActive(facultyId, 1, 1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getFacultyByFacultyIdAndIsPrinci  " + e.getMessage());
			e.printStackTrace();

		}
		return staff;
	}

}
