package com.ats.rusasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.LoginResponse;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.model.GetUserDetail;
import com.ats.rusasoft.model.Info;
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
	
	

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	
	public @ResponseBody LoginResponse loginUser(@RequestParam("username") String userName,
			@RequestParam("password") String pass,@RequestParam("isBlock") int isBlock) {

		System.err.println("inside loginUser ");
		LoginResponse loginResponse = logRes.getUser(userName, pass,isBlock);
		System.err.println("User data is"+loginResponse.toString());
		int typeId=loginResponse.getUserType();
		
		int regKey=loginResponse.getRegPrimaryKey();
		GetUserDetail userDetail=null;
		if(typeId == 1) 
		{
		   userDetail = userDataRepo.getPrinciDetails(regKey);
		  
		      System.err.println("User data is"+userDetail.toString());
		}
		else if(typeId == 2) {
			 userDetail = userDataRepo.getIqacDetails(regKey);
		      System.err.println("User data is"+userDetail.toString());
		}
		else if(typeId == 3) {
			 userDetail = userDataRepo.getHodDetails(regKey);
		      System.err.println("User data is"+userDetail.toString());
		}
		else if(typeId == 4) {
			 userDetail = userDataRepo.getFacultyDetails(regKey);
		      System.err.println("User data is"+userDetail.toString());
		}
		else if(typeId == 5) {
			 userDetail = userDataRepo.getOfficerDetails(regKey);
		      System.err.println("User data is"+userDetail.toString());
		}
		
		else if(typeId == 6) {
			 userDetail = userDataRepo.getDeanDetails(regKey);
		      System.err.println("User data is"+userDetail.toString());
		}
		else if(typeId == 7) {
		userDetail = userDataRepo.getLibrarianDetails(regKey);
		      System.err.println("User data is"+userDetail.toString());
		}
		else {
		 userDetail = userDataRepo.getStudentDetails(regKey);
		      System.err.println("User data is"+userDetail.toString());
		}
		
		System.err.println("hiiiiiiii......");
		 loginResponse.setGetData(userDetail);
		
		 
		
		System.err.println("User data is after"+loginResponse.toString());
		return loginResponse;
 
	}
	
	
	@RequestMapping(value = { "/changePass" }, method = RequestMethod.POST)
	public @ResponseBody Info changePass(@RequestParam String password,@RequestParam int userId) {
	Info info=new Info();
	try {
		int res=userServices.chagePass(password,userId);
		
		if(res>0) {
			info.setError(false);
			info.setMsg("success");
			
		}
		else {
			info.setError(true);
			info.setMsg("failed");
			
		}
	}catch (Exception e) {
		
		System.err.println("Exce in getAllInstitutes Institute " +e.getMessage());
		e.printStackTrace();
		info.setError(true);
		info.setMsg("excep");
	}
	
	return info;
	
}



}
