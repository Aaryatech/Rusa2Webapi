package com.ats.rusasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.LoginResponse;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.mstrepo.UserService;




@RestController
public class RestApiController {
	

	@Autowired
    UserService userServices;
	
	
	// UserLogin of AdminPanel
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	
	public @ResponseBody UserLogin loginUser(@RequestParam("username") String userName,
			@RequestParam("password") String pass,@RequestParam("isBlock") int isBlock) {

		
		UserLogin loginResponse = userServices.getUser(userName, pass,isBlock);
		System.err.println("User data is"+loginResponse.toString());
		
		return loginResponse;

	}
	
/*@RequestMapping(value = { "/getUserData" }, method = RequestMethod.POST)
	
	public @ResponseBody UserLogin getUserData(@RequestParam("typeId") int typeId) {

		
		UserLogin loginResponse = userServices.getUserDetail(typeId);
		System.err.println("User data is"+loginResponse.toString());
		
		return loginResponse;

	}
*/


}
