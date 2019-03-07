package com.ats.rusasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.Institute;
import com.ats.rusasoft.model.Librarian;
import com.ats.rusasoft.model.Principal;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.mstrepo.LibrarianRepo;

@RestController
public class LibraryApiController {
	@Autowired
	LibrarianRepo libRepo;
	
	@RequestMapping(value = { "/saveLibrarian" }, method = RequestMethod.POST)
	public @ResponseBody Librarian saveLibrarian(@RequestBody Librarian librarian) {

		Librarian libResp = null;

		try {

			if (librarian.getLibrarianId() == 0) {
				libResp = libRepo.saveAndFlush(librarian);

				System.err.println("New librarian Insert  New Principal");

				UserLogin ul = new UserLogin();

				/*princi.setEmail(insResp.getEmail());
				princi.setInstituteId(insResp.getInstituteId());
				princi.setPhoneNo(insResp.getContactNo());
				princi.setPrincipalId(0);
				princi.setPrincipalName(insResp.getPrincipalName());
				princi.setIsEnroll(0);
				pincipalRepo.saveAndFlush(princi);
*/
			} else {
				libResp = libRepo.saveAndFlush(librarian);

				System.err.println("Old  librarian Old   User  update if any");

				/*Principal princi = pincipalRepo.findByInstituteId(insResp.getInstituteId());

				princi.setEmail(insResp.getEmail());
				princi.setInstituteId(insResp.getInstituteId());
				princi.setPhoneNo(insResp.getContactNo());
				princi.setPrincipalName(insResp.getPrincipalName());
				pincipalRepo.saveAndFlush(princi);*/

			}

		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return librarian;

	}


}
