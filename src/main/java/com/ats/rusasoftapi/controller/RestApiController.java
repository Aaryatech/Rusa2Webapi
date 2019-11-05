package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.common.Commons;
import com.ats.rusasoftapi.common.EmailUtility;
import com.ats.rusasoftapi.model.AccOfficer;
import com.ats.rusasoftapi.model.GetUserDetail;
import com.ats.rusasoftapi.model.Hod;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.Institute;
import com.ats.rusasoftapi.model.InstituteInfo;
import com.ats.rusasoftapi.model.Librarian;
import com.ats.rusasoftapi.model.LoginLog;
import com.ats.rusasoftapi.model.LoginResponse;
import com.ats.rusasoftapi.model.OTPVerification;
import com.ats.rusasoftapi.model.Staff;
import com.ats.rusasoftapi.model.Student;
import com.ats.rusasoftapi.model.UserLogin;
import com.ats.rusasoftapi.mstrepo.GetUserDataRepo;
import com.ats.rusasoftapi.mstrepo.LoginLogRepo;
import com.ats.rusasoftapi.mstrepo.LoginResponseRepo;
import com.ats.rusasoftapi.mstrepo.UserService;
import com.ats.rusasoftapi.repositories.StaffRepo;

@RestController
public class RestApiController {

	@Autowired

	UserService userServices;

	@Autowired
	LoginResponseRepo logRes;

	@Autowired
	GetUserDataRepo userDataRepo;
	@Autowired
	LoginLogRepo logRepo;

	static String senderEmail ="techrusa1@gmail.com";// "atsinfosoft@gmail.com";
	static String senderPassword ="@Rusamah";// "atsinfosoft@123";
	static String mailsubject = " RUSA OTP  Verification ";
	static String otp1 = null;
	
	//blockUser
	
	// blockUser
		@RequestMapping(value = { "/blockUser" }, method = RequestMethod.POST)
		public @ResponseBody Info blockUser(@RequestParam int userId) {

			Info info = new Info();
			try {
				int res = staffrepo.blockUser(userId);
				if (res > 0) {
					info.setError(false);
					info.setMsg("success");

				} else {
					info.setError(true);
					info.setMsg("failed");

				}
			} catch (Exception e) {

				System.err.println("Exce in blockUser  " + e.getMessage());
				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

			return info;

		}
	

	@RequestMapping(value = { "/checkUserName" }, method = RequestMethod.POST)
	public @ResponseBody Info checkUserName(@RequestParam String inputValue,@RequestParam int  flag) {

		OTPVerification.setConNumber(null);
		OTPVerification.setEmailId(null);
		OTPVerification.setOtp(null);
		OTPVerification.setPass(null);

		System.err.println("Its userName " + inputValue);
		Info info = new Info();
		// tableId 1 for Institute tableId 2 for Hod for Sachin table id 5 for acc
		// Officer

		/*
		 * UserLogin instList = new UserLogin();
		 * System.err.println("Its New Record Insert "); instList =
		 * userServices.findByUserNameAndIsBlock(inputValue.trim(), 1);
		 * 
		 * if (instList!=null) {
		 * 
		 * System.err.println("In if " +instList.toString());
		 * 
		 * info.setError(false); info.setMsg(inputValue);
		 * 
		 * System.err.println("Matched "); // int userId= instList.getUserId(); int
		 * typeId=instList.getUserType(); int regKey=instList.getRegPrimaryKey();
		 */

		/*
		 * GetUserDetail userDetail=null; if(typeId == 1) { userDetail =
		 * userDataRepo.getPrinciDetails(regKey);
		 * 
		 * 
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 2) { userDetail = userDataRepo.getIqacDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 3) { userDetail = userDataRepo.getHodDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 4) { userDetail = userDataRepo.getFacultyDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 5) { userDetail = userDataRepo.getOfficerDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); }
		 * 
		 * else if(typeId == 6) { userDetail = userDataRepo.getDeanDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 7) { userDetail = userDataRepo.getLibrarianDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else { userDetail
		 * = userDataRepo.getStudentDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); }
		 */

		Staff userDetail = staffRepo.findByDelStatusAndIsActiveAndEmailAndIsBlocked(1, 1, inputValue,0);

		if (userDetail != null) {
			OTPVerification.setUserId(userDetail.getFacultyId());

			String emailId = userDetail.getEmail();
			String conNumber = userDetail.getContactNo();

			System.err.println("User data is" + userDetail.toString());
			char[] otp = Commons.OTP(6);

			otp1 = String.valueOf(otp);
			// info.setMsg(" Matched");
			System.err.println("User otp is" + otp1);
			if(flag==1) {
				Info inf = EmailUtility.sendOtp(otp1, conNumber, "RUSA OTP Verification ");

			}
			else if(flag==2){
				Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword,emailId, mailsubject,
						emailId, otp1);
			}

			// System.out.println("info ires" + inf.toString());

			OTPVerification.setConNumber(conNumber);
			OTPVerification.setEmailId(emailId);
			OTPVerification.setOtp(otp1);
			OTPVerification.setPass(userDetail.getPassword());

		} else {
			System.err.println("In Else ");

			info.setError(true);
			info.setMsg("not Matched");
			System.err.println(" not Matched ");
		}

		return info;

	}
	
	/***********************************Update Contact No*******************************/
	
	@RequestMapping(value = { "/changeContctNo" }, method = RequestMethod.POST)
	public @ResponseBody Info changeContctNo(@RequestParam String contact,@RequestParam int facultyId) {

		OTPVerification.setConNumber(null);
		OTPVerification.setEmailId(null);
		OTPVerification.setOtp(null);
		OTPVerification.setPass(null);

		System.err.println("Its Cont No " + contact);
		Info info = new Info();
		

		Staff userDetail = staffRepo.findByDelStatusAndIsActiveAndContactNoAndFacultyId(1, 1, contact,facultyId);

		if (userDetail != null) {
			OTPVerification.setUserId(userDetail.getFacultyId());

			String emailId = userDetail.getEmail();
			String conNumber = userDetail.getContactNo();

			System.err.println("User data is" + userDetail.toString());
			char[] otp = Commons.OTP(6);

			otp1 = String.valueOf(otp);
			// info.setMsg(" Matched");
			System.err.println("User otp is" + otp1);
			Info inf = EmailUtility.sendOtp(otp1, conNumber, "RUSA OTP Verification ");

			//Info inf = EmailUtility.sendOtp(otp1, conNumber, "RUSA OTP Verification \t");

			// System.out.println("info ires" + inf.toString());

			OTPVerification.setConNumber(conNumber);
			OTPVerification.setEmailId(emailId);
			OTPVerification.setOtp(otp1);
			OTPVerification.setPass(userDetail.getPassword());

		} else {
			System.err.println("In Else ");

			info.setError(true);
			info.setMsg("not Matched");
			System.err.println(" not Matched ");
		}

		return info;

	}

	


	@RequestMapping(value = { "/VerifyOTP" }, method = RequestMethod.POST)
	public @ResponseBody Staff VerifyOTP(@RequestParam String otp) {
		Info info = new Info();
		
		Object object=new Object();
		HashMap<Integer, Staff>  hashMap=new HashMap<>();
		
		Staff staff=new Staff();
		
		try {

			if (otp.equals(OTPVerification.getOtp()) == true) {
				info.setError(false);
				info.setMsg("success");

				String mobile = OTPVerification.getConNumber();
				String email = OTPVerification.getEmailId();
				String pass = Commons.getAlphaNumericString(7);
				// System.out.println("pass");
				//int res = staffrepo.chagePass(pass, OTPVerification.getUserId());
				
				staff=staffrepo.findByFacultyIdAndDelStatusAndIsBlocked(OTPVerification.getUserId(),1,0);
				hashMap.put(1, staff);
				
				//Info inf = EmailUtility.sendOtp(pass, mobile, "Password From RUSA ");

				//Info info1 = EmailUtility.sendEmail(senderEmail, senderPassword, email, mailsubject, email, pass);

				//System.err.println("Info email sent response   " + inf.toString());

				//
				

			} else {
				info.setError(true);
				info.setMsg("failed");
				//hashMap.put(0, new Staff());
			}
			//hashMap.put(0, info);
		} catch (Exception e) {

			System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return staff;

	}

	@Autowired
	StaffRepo staffRepo;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)

	public @ResponseBody LoginResponse loginUser(@RequestParam("username") String userName,
			@RequestParam("password") String pass, @RequestParam("isBlock") int isBlock) {

		System.err.println("inside loginUser ");

		Staff staff = staffRepo.findByDelStatusAndIsActiveAndEmailAndPasswordContainingAndIsBlocked(1, 1, userName, pass,0);
		LoginResponse loginResponse = new LoginResponse();
if(staff!=null)
		if(staff.getPassword().equals(pass)) {
System.err.println("Matched " +pass);
		loginResponse.setUserId(staff.getFacultyId());
		loginResponse.setRoleId(staff.getRoleIds());

		loginResponse.setStaff(staff);

		GetUserDetail userDetail = new GetUserDetail();
		userDetail.setUserInstituteId(staff.getInstituteId());

		userDetail.setUserDetailId(staff.getFacultyId());
		loginResponse.setGetData(userDetail);
		loginResponse.setExInt2(staff.getInstituteId());
		}else {
			System.err.println("not Matched " +pass);

		}
		/*
		 * logRes.getUser(userName, pass,isBlock);
		 * System.err.println("User data is"+loginResponse.toString()); int
		 * typeId=loginResponse.getUserType();
		 * 
		 * int regKey=loginResponse.getRegPrimaryKey(); GetUserDetail userDetail=null;
		 * if(typeId == 1) { userDetail = userDataRepo.getPrinciDetails(regKey);
		 * 
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 2) { userDetail = userDataRepo.getIqacDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 3) { userDetail = userDataRepo.getHodDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 4) { userDetail = userDataRepo.getFacultyDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 5) { userDetail = userDataRepo.getOfficerDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); }
		 * 
		 * else if(typeId == 6) { userDetail = userDataRepo.getDeanDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else if(typeId ==
		 * 7) { userDetail = userDataRepo.getLibrarianDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); } else { userDetail
		 * = userDataRepo.getStudentDetails(regKey);
		 * System.err.println("User data is"+userDetail.toString()); }
		 * 
		 * System.err.println("hiiiiiiii......"); loginResponse.setGetData(userDetail);
		 * 
		 * 
		 * 
		 * System.err.println("User data is after"+loginResponse.toString());
		 */
		return loginResponse;

	}

	@Autowired
	StaffRepo staffrepo;

	@RequestMapping(value = { "/changePass" }, method = RequestMethod.POST)
	public @ResponseBody Info changePass(@RequestParam String password, @RequestParam int userId) {
		Info info = new Info();
		try {
			int res = staffrepo.chagePass(password, userId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in changePass Institute " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@RequestMapping(value = { "/saveLoginLog" }, method = RequestMethod.POST)
	public @ResponseBody LoginLog saveLoginLog(@RequestBody LoginLog instInfo) {

		LoginLog instResp = null;

		try {

			instResp = logRepo.saveAndFlush(instInfo);

		} catch (Exception e) {
			System.err.println("Exce in saving saveLoginLog " + e.getMessage());
			e.printStackTrace();
		}

		return instInfo;

	}
	
	@RequestMapping(value= {"/updateMyNo"}, method=RequestMethod.POST)
	public @ResponseBody Info updateMyNo(@RequestParam("id") int id, @RequestParam("no") String no){
		
		
		int isDelete=0;
		 isDelete= staffRepo.updateNewNo(id, no);
		 Info inf = new Info();
		 if(isDelete>0) {
			 inf.setError(false);
			 inf.setMsg("No. Updated Sucessfully");
		 }
		 else{
			 inf.setError(true);
			 inf.setMsg("Fail");
		 }
		 return inf;
	}
	
	

	@RequestMapping(value = { "/sndOTPOnNewNo" }, method = RequestMethod.POST)
	public @ResponseBody Info sndOTPOnNewNo(@RequestParam String no) {

		OTPVerification.setConNumber(null);
		OTPVerification.setEmailId(null);
		OTPVerification.setOtp(null);
		OTPVerification.setPass(null);

		System.err.println("Its Cont No " + no);
		Info info = new Info();
		

	

		if (no != null) {
			

		
			String conNumber = no;

			
			char[] otp = Commons.OTP(6);

			otp1 = String.valueOf(otp);
			// info.setMsg(" Matched");
			System.err.println("User otp is" + otp1);
			Info inf = EmailUtility.sendOtp(otp1, conNumber, "Rusa OTP Verification");

 
			OTPVerification.setConNumber(conNumber);
			
			OTPVerification.setOtp(otp1);
		

		} else {
			System.err.println("In Else ");

			info.setError(true);
			info.setMsg("not Matched");
			System.err.println(" not Matched ");
		}

		return info;

	}

	/***********************************Update Contact No*******************************/


	@RequestMapping(value = { "/changeEmailId" }, method = RequestMethod.POST)
	public @ResponseBody Info changeEmailId(@RequestParam String emailID) {

		OTPVerification.setConNumber(null);
		OTPVerification.setEmailId(null);
		OTPVerification.setOtp(null);
		OTPVerification.setPass(null);

		System.err.println("Its changeEmailId emailID " + emailID);
		Info info = new Info();
		

		Staff userDetail = staffRepo.findByDelStatusAndIsActiveAndEmail(1, 1, emailID);

		if (userDetail != null) {
			OTPVerification.setUserId(userDetail.getFacultyId());

			String emailId = userDetail.getEmail();
			String conNumber = userDetail.getContactNo();

			System.err.println("User data is" + userDetail.toString());
			char[] otp = Commons.OTP(6);

			otp1 = String.valueOf(otp);
		 
			System.err.println("User otp is" + otp1);
			  
			Info emailRes = EmailUtility.sendEmailOTP(senderEmail, senderPassword,emailID, mailsubject,
					emailID, otp1);
			System.err.println("User emailRes" + emailRes.getMsg());

			OTPVerification.setConNumber(conNumber);
			OTPVerification.setEmailId(emailId);
			OTPVerification.setOtp(otp1);
			OTPVerification.setPass(userDetail.getPassword());

		} else {
			System.err.println("In Else ");

			info.setError(true);
			info.setMsg("not Matched");
			System.err.println(" not Matched ");
		}

		return info;

	}
	
	@RequestMapping(value= {"/updateMyEmail"}, method=RequestMethod.POST)
	public @ResponseBody Info updateMyEmail(@RequestParam("id") int id, @RequestParam("email") String email){
		
		
		int isDelete=0;
		 isDelete= staffRepo.updateNewEmail(id, email);
		 Info inf = new Info();
		 if(isDelete>0) {
			 inf.setError(false);
			 inf.setMsg("email Updated Sucessfully");
		 }
		 else{
			 inf.setError(true);
			 inf.setMsg("Fail");
		 }
		 return inf;
	}
	
	

	
	@RequestMapping(value = { "/sndOTPOnNewEmailId" }, method = RequestMethod.POST)
	public @ResponseBody Info sndOTPOnNewEmailId(@RequestParam String emailId) {

		OTPVerification.setConNumber(null);
		OTPVerification.setEmailId(null);
		OTPVerification.setOtp(null);
		OTPVerification.setPass(null);

		System.err.println("Its emailId " + emailId);
		Info info = new Info();
		 
		if (emailId != null) {
			

		
			String emailId1 = emailId;

			
			char[] otp = Commons.OTP(6);

			otp1 = String.valueOf(otp);
			// info.setMsg(" Matched");
			System.err.println("User otp is" + otp1);
			Info emailRes = EmailUtility.sendEmailOTP(senderEmail, senderPassword,emailId1, mailsubject,
					emailId1, otp1);
			System.err.println("User emailRes" + emailRes.getMsg());

 
			OTPVerification.setEmailId(emailId1); 
			
			OTPVerification.setOtp(otp1);
		

		} else {
			System.err.println("In Else ");

			info.setError(true);
			info.setMsg("not Matched");
			System.err.println(" not Matched ");
		}

		return info;

	}

}
