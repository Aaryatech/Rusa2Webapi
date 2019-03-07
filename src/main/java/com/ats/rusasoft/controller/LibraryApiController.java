package com.ats.rusasoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.common.Commons;
import com.ats.rusasoft.model.GetInstituteList;
import com.ats.rusasoft.model.Hod;
import com.ats.rusasoft.model.Info;
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
				String userName = Commons.getAlphaNumericString(7);
				UserLogin ul = new UserLogin();
				String pass = Commons.getAlphaNumericString(7);
				System.err.println("pass is "+pass);
				ul.setUserType(7);
				ul.setPass(pass);
				ul.setUserName(userName);
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

				/*
				 * System.err.println("Old  librarian Old   User  update if any"); UserLogin ul
				 * =userRepo.findByRegPrimaryKey(libResp.getLibrarianId());
				 * 
				 * ul.setUserType(7);
				 * 
				 * ul.setUserName(libResp.getLibrarianName()); ul.setIsBlock(1);
				 * //ul.setRegPrimaryKey(7); ul.setRoleId(1); ul.setExInt1(1); ul.setExInt2(1);
				 * ul.setExVar1("NA"); ul.setExVar2("NA");
				 * 
				 * 
				 * userRepo.saveAndFlush(ul);
				 */
				
			}

		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return librarian;

	}
	
	@RequestMapping(value = { "/getLibrarianByLibId" }, method = RequestMethod.POST)
	public @ResponseBody Librarian getLibrarianByLibId(@RequestParam int libId) {

		Librarian libResp = null;

		try {
			libResp = libRepo.findByLibrarianId(libId);

		} catch (Exception e) {
			System.err.println("Exce in getDept  " + e.getMessage());
			e.printStackTrace();

		}
		return libResp;
	}

	
	  @RequestMapping(value = { "/getAllLibrarianByInstituteId" }, method = RequestMethod.POST)
	  public @ResponseBody List<Librarian> getAllLibrarian(@RequestParam int instId) {
	  
	  List<Librarian> libResp = new ArrayList<>();
	  
	  try { 
		  libResp = libRepo.getAllLibList(instId);
		  System.err.println("lib are" + libResp.toString());
	  
	  } catch (Exception e) {
	  System.err.println("Exce in getAllLibrarian Librarian " + e.getMessage());
	  e.printStackTrace(); }
	  
	  return libResp;
	  
	  }
	  
		@RequestMapping(value = { "/deleteLibrarians" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteInstitutes(@RequestParam List<String> libIdList) {

			Info info = new Info();
			try {
				int res = libRepo.deleteLibrarians(libIdList);

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
