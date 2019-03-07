package com.ats.rusasoft.webapi.iqac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.mstrepo.UserService;

@RestController
public class UserLoginRestController {

	@Autowired UserService userrepo;
	
	@RequestMapping(value= {"/insertNewUser"}, method=RequestMethod.POST)
	public @ResponseBody UserLogin insertNewIqac(@RequestBody UserLogin user){
		
		return userrepo.save(user);
		
	}
	
}
