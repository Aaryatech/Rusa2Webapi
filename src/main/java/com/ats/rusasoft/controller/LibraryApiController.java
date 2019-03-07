package com.ats.rusasoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.GetInstituteList;
import com.ats.rusasoft.model.Institute;
import com.ats.rusasoft.model.Librarian;
import com.ats.rusasoft.model.Principal;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.mstrepo.LibrarianRepo;
import com.ats.rusasoft.mstrepo.UserService;

@RestController
public class LibraryApiController {
	@Autowired
	LibrarianRepo libRepo;
	
	@Autowired
	UserService  userRepo;
	
	
	@RequestMapping(value = { "/saveLibrarian" }, method = RequestMethod.POST)
	public @ResponseBody Librarian saveLibrarian(@RequestBody Librarian librarian) {

		Librarian libResp = null;
 
		try {

			if (librarian.getLibrarianId() == 0) {
				libResp = libRepo.saveAndFlush(librarian);

				System.err.println("New librarian Insert  New Principal");

				UserLogin ul = new UserLogin();
				
				ul.setUserType(7);
				ul.setPass("123");
				ul.setUserName(libResp.getLibrarianName());
				ul.setIsBlock(1);
				ul.setRegPrimaryKey(libResp.getLibrarianId());
				ul.setRoleId(1);
				ul.setExInt1(1);
				ul.setExInt2(1);
				ul.setExVar1("NA");
				ul.setExVar2("NA");
				
				userRepo.saveAndFlush(ul);

			} else {
				libResp = libRepo.saveAndFlush(librarian);

				System.err.println("Old  librarian Old   User  update if any");
				/*
				 * Principal princi = pincipalRepo.findByInstituteId(insResp.getInstituteId());
				 * 
				 * princi.setEmail(insResp.getEmail());
				 * princi.setInstituteId(insResp.getInstituteId());
				 * princi.setPhoneNo(insResp.getContactNo());
				 * princi.setPrincipalName(insResp.getPrincipalName());
				 * pincipalRepo.saveAndFlush(princi);
				 */

			}

		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return librarian;

	}
	/*
	 * @RequestMapping(value = { "/getAllLibrarian" }, method = RequestMethod.GET)
	 * public @ResponseBody List<Librarian> getAllInstitutes() {
	 * 
	 * List<Librarian> insResp = new ArrayList<>();
	 * 
	 * try { insResp = libRepo.getAllLibList();
	 * 
	 * } catch (Exception e) {
	 * System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
	 * e.printStackTrace(); }
	 * 
	 * return insResp;
	 * 
	 * }
	 * 
	 */
}
