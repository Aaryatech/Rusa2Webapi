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

import com.ats.rusasoft.model.LoginResponse;
import com.ats.rusasoft.model.OTPVerification;
import com.ats.rusasoft.model.Staff;
import com.ats.rusasoft.model.Student;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.common.Commons;
import com.ats.rusasoft.common.EmailUtility;
import com.ats.rusasoft.model.AccOfficer;
import com.ats.rusasoft.model.GetUserDetail;
import com.ats.rusasoft.model.Hod;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.Institute;
import com.ats.rusasoft.model.InstituteInfo;
import com.ats.rusasoft.model.Librarian;
import com.ats.rusasoft.model.LoginLog;
import com.ats.rusasoft.mstrepo.GetUserDataRepo;
import com.ats.rusasoft.mstrepo.LoginLogRepo;
import com.ats.rusasoft.mstrepo.LoginResponseRepo;
import com.ats.rusasoft.mstrepo.UserService;
import com.ats.rusasoft.repositories.StaffRepo;

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

	static String senderEmail = "atsinfosoft@gmail.com";
	static String senderPassword = "atsinfosoft@123";
	static String mailsubject = " RUSA Otp  Verification ";
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
	public @ResponseBody Info checkUserName(@RequestParam String inputValue) {

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

		Staff userDetail = staffRepo.findByDelStatusAndIsActiveAndEmail(1, 1, inputValue);

		if (userDetail != null) {
			OTPVerification.setUserId(userDetail.getFacultyId());

			String emailId = userDetail.getEmail();
			String conNumber = userDetail.getContactNo();

			System.err.println("User data is" + userDetail.toString());
			char[] otp = Commons.OTP(6);

			otp1 = String.valueOf(otp);
			// info.setMsg(" Matched");
			System.err.println("User otp is" + otp1);
			Info inf = EmailUtility.sendOtp(otp1, conNumber, "Rusa OTP Verification");

			System.out.println("info ires" + inf.toString());

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
	public @ResponseBody Info VerifyOTP(@RequestParam String otp) {
		Info info = new Info();
		try {

			if (otp.equals(OTPVerification.getOtp()) == true) {
				info.setError(false);
				info.setMsg("success");

				String mobile = OTPVerification.getConNumber();
				String email = OTPVerification.getEmailId();
				String pass = Commons.getAlphaNumericString(7);
				System.out.println("pass");

				Info inf = EmailUtility.sendOtp(pass, mobile, "Password From RUSA ");

				Info info1 = EmailUtility.sendEmail(senderEmail, senderPassword, email, mailsubject, email, pass);

				System.err.println("Info email sent response   " + inf.toString());

				int res = staffrepo.chagePass(pass, OTPVerification.getUserId());

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

}
