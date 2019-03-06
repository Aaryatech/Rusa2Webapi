package com.ats.rusasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.LoginResponse;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.model.GetUserDetail;
import com.ats.rusasoft.mstrepo.GetUserDataRepo;
import com.ats.rusasoft.mstrepo.LoginResponseRepo;
import com.ats.rusasoft.mstrepo.UserService;




@RestController
public class RestApiController {
	

	@Autowired
    UserService userServices;
	
	@Autowired
    LoginResponseRepo logRes;
	
	@Autowired
    GetUserDataRepo userDataRepo;
	
	
	// UserLogin of AdminPanel
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	
	public @ResponseBody LoginResponse loginUser(@RequestParam("username") String userName,
			@RequestParam("password") String pass,@RequestParam("isBlock") int isBlock) {

		System.err.println("inside loginUser ");
		LoginResponse loginResponse = logRes.getUser(userName, pass,isBlock);
		System.err.println("User data is"+loginResponse.toString());
		
		return loginResponse;

	}
	
/*@RequestMapping(value = { "/getUserDetailByTypeId" }, method = RequestMethod.POST)
	
	public @ResponseBody getUserData getUserDetailByTypeId(@RequestParam("typeId") int typeId) {

		
	getUserData loginResponse = userDataRepo.getUserDetails(typeId);
		System.err.println("User data is"+loginResponse.toString());
		
		return loginResponse;

	}*/



}
