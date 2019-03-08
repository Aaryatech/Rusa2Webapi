package com.ats.rusasoft.controller;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.common.EmailUtility;
import com.ats.rusasoft.model.AccOfficer;
import com.ats.rusasoft.model.Dept;
import com.ats.rusasoft.model.GetHod;
import com.ats.rusasoft.model.GetInstituteList;
import com.ats.rusasoft.model.Hod;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.Institute;
import com.ats.rusasoft.model.Librarian;
import com.ats.rusasoft.model.Principal;
import com.ats.rusasoft.model.Quolification;
import com.ats.rusasoft.model.Student;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.mstrepo.AccOfficerRepo;
import com.ats.rusasoft.mstrepo.DeptRepo;
import com.ats.rusasoft.mstrepo.GetHodRepo;
import com.ats.rusasoft.mstrepo.GetInstituteListRepo;
import com.ats.rusasoft.mstrepo.HodRepo;
import com.ats.rusasoft.mstrepo.InstituteRepo;
import com.ats.rusasoft.mstrepo.PrincipalRepo;
import com.ats.rusasoft.mstrepo.QuolificationRepo;
import com.ats.rusasoft.mstrepo.StudentRepo;
import com.ats.rusasoft.mstrepo.UserService;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class MasterApiController {

	@Autowired
	InstituteRepo instituteRepo;
	@Autowired
	GetInstituteListRepo getGetInstituteListRepo;
	@Autowired
	PrincipalRepo pincipalRepo;

	@Autowired
	DeptRepo deptRepo;

	@Autowired
	HodRepo hodRepo;

	@Autowired
	StudentRepo studRepo;

	@RequestMapping(value = { "/checkUniqueField" }, method = RequestMethod.POST)
	public @ResponseBody Info checkUniqueField(@RequestParam String inputValue, @RequestParam int valueType,
			@RequestParam int tableId, @RequestParam int isEditCall, @RequestParam int primaryKey) {

		Info info = new Info();
		// tableId 1 for Institute tableId 2 for Hod for Sachin

		if (tableId == 1) {
			List<Institute> instList = new ArrayList<>();

			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					instList = instituteRepo.findByContactNo(inputValue.trim());
				} else {
					System.err.println("Its Edit Record ");
					instList = instituteRepo.findByContactNoAndInstituteIdNot(inputValue.trim(), primaryKey);
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					instList = instituteRepo.findByEmail(inputValue);
				} else {
					System.err.println("Its Edit Record ");
					instList = instituteRepo.findByEmailAndInstituteIdNot(inputValue.trim(), primaryKey);
				}

			}

			if (instList.size() > 0) {
				info.setError(true);
				info.setMsg("duplicate");
			} else {
				info.setError(false);
				info.setMsg("unique");
			}

		}

		else if (tableId == 2) {

			List<Hod> hodList = new ArrayList<>();

			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					hodList = hodRepo.findByContactNoAndDelStatusAndIsActive(inputValue.trim(), 1, 1);
				} else {
					System.err.println("Its Edit Record ");
					hodList = hodRepo.findByContactNoAndDelStatusAndIsActiveAndHodIdNot(inputValue.trim(), 1, 1,
							primaryKey);
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					hodList = hodRepo.findByEmailAndDelStatusAndIsActive(inputValue, 1, 1);
				} else {
					System.err.println("Its Edit Record ");
					hodList = hodRepo.findByEmailAndDelStatusAndIsActiveAndHodIdNot(inputValue.trim(), 1, 1,
							primaryKey);
				}

			}

			if (hodList.size() > 0) {
				info.setError(true);
				info.setMsg("duplicate");
			} else {
				info.setError(false);
				info.setMsg("unique");
			}
		}

		else if (tableId == 3) {
			System.err.println("inside stud info check");

			List<Student> studList = new ArrayList<>();

			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					studList = studRepo.findByContactNoAndDelStatus(inputValue.trim(), 1);
				} else {
					System.err.println("Its Edit Record ");
					studList = studRepo.findByContactNoAndDelStatusAndStudentIdNot(inputValue.trim(), 1, primaryKey);
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					studList = studRepo.findByEmailAndDelStatus(inputValue, 1);
				} else {
					System.err.println("Its Edit Record ");
					studList = studRepo.findByEmailAndDelStatusAndStudentIdNot(inputValue.trim(), 1, primaryKey);
				}

			}

			if (studList.size() > 0) {
				info.setError(true);
				info.setMsg("duplicate");
			} else {
				info.setError(false);
				info.setMsg("unique");
			}
		}

		return info;

	}

	@Autowired
	AccOfficerRepo accOfficerRepo;

	@RequestMapping(value = { "/saveAccOfficer" }, method = RequestMethod.POST)
	public @ResponseBody AccOfficer saveAccOfficer(@RequestBody AccOfficer accOff) {

		AccOfficer acOfRes = null;

		try {

			if (accOff.getOfficerId() == 0) {
				acOfRes = accOfficerRepo.save(accOff);

				UserLogin user = new UserLogin();

				String userName = getAlphaNumericString(7);
				String pass = getAlphaNumericString(7);
				System.err.println("username  " + userName + "\n  pass  " + pass);

				user.setExInt1(0);
				user.setExInt2(0);
				user.setExVar1("Na");
				user.setExVar2("Na");
				user.setIsBlock(1);
				user.setPass(pass);

				user.setRegPrimaryKey(acOfRes.getOfficerId());// principla primary key

				user.setExInt2(acOfRes.getInstituteId()); //
				user.setRoleId(0);
				user.setUserName(userName);
				user.setUserType(5);// 5 for acc Officer user Default

				UserLogin userRes = userServiceRepo.save(user);
			} else {

				acOfRes = accOfficerRepo.save(accOff);
			}

		} catch (Exception e) {
			System.err.println("Exce in saving saveAccOff " + e.getMessage());
			e.printStackTrace();

		}
		return acOfRes;
	}

	static String senderEmail = "atsinfosoft@gmail.com";
	static	String senderPassword = "atsinfosoft@123";
	static String mailsubject = " RUSA Login Credentials ";

	@RequestMapping(value = { "/saveHod" }, method = RequestMethod.POST)
	public @ResponseBody Hod saveInstitute(@RequestBody Hod hod) {

		Hod hodRes = null;

		try {

			if (hod.getHodId() == 0) {
				hodRes = hodRepo.save(hod);

				UserLogin user = new UserLogin();

				String userName = getAlphaNumericString(7);
				String pass = getAlphaNumericString(7);
				System.err.println("username  " + userName + "\n  pass  " + pass);

				user.setExInt1(0);
				user.setExInt2(0);
				user.setExVar1("Na");
				user.setExVar2("Na");
				user.setIsBlock(1);
				user.setPass(pass);

				user.setRegPrimaryKey(hodRes.getHodId());// principla primary key

				user.setExInt2(hodRes.getInstituteId()); //
				user.setRoleId(0);
				user.setUserName(userName);
				user.setUserType(3);// 3 for hod user Default

				UserLogin userRes = userServiceRepo.save(user);
				
				Info info=EmailUtility.sendEmail(senderEmail, senderPassword, hodRes.getEmail(), mailsubject,
						userRes.getUserName(), userRes.getPass());
				
				System.err.println("Info email sent response   "+info.toString());

			} else {

				hodRes = hodRepo.save(hod);
			}

		} catch (Exception e) {
			System.err.println("Exce in saving saveHod " + e.getMessage());
			e.printStackTrace();

		}
		return hodRes;
	}

	@RequestMapping(value = { "/getHod" }, method = RequestMethod.POST)
	public @ResponseBody Hod getHod(@RequestParam int hodId) {

		Hod deptRes = null;

		try {
			deptRes = hodRepo.findByHodId(hodId);

		} catch (Exception e) {
			System.err.println("Exce in getDept  " + e.getMessage());
			e.printStackTrace();

		}
		return deptRes;
	}

	//
	@Autowired
	GetHodRepo getHodRepo;

	@RequestMapping(value = { "/getHodListByInstId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetHod> getHodListByInstId(@RequestParam int instId) {

		List<GetHod> hodListByInstId = new ArrayList<>();

		try {
			hodListByInstId = getHodRepo.getHodListByInstId(instId);

		} catch (Exception e) {
			System.err.println("Exce in getAllDeptList  " + e.getMessage());
			e.printStackTrace();
		}

		return hodListByInstId;

	}

	@RequestMapping(value = { "/deleteHods" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteHods(@RequestParam List<String> hodIdList) {

		Info info = new Info();
		try {
			int res = hodRepo.deleteHods(hodIdList);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteHods  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	// getQuolifications
	@Autowired
	QuolificationRepo getQuolificationRepo;

	@RequestMapping(value = { "/getQuolificationList" }, method = RequestMethod.POST)
	public @ResponseBody List<Quolification> getQuolificationList(@RequestParam int type) {

		List<Quolification> quolList = new ArrayList<>();

		try {
			quolList = getQuolificationRepo.findByTypeAndDelStatus(type, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllDeptList  " + e.getMessage());
			e.printStackTrace();
		}

		return quolList;

	}

	@RequestMapping(value = { "/saveDept" }, method = RequestMethod.POST)
	public @ResponseBody Dept saveInstitute(@RequestBody Dept dept) {

		Dept deptRes = null;

		try {
			deptRes = deptRepo.saveAndFlush(dept);

		} catch (Exception e) {
			System.err.println("Exce in saving saveDept " + e.getMessage());
			e.printStackTrace();

		}
		return deptRes;
	}

	@RequestMapping(value = { "/getDept" }, method = RequestMethod.POST)
	public @ResponseBody Dept getDept(@RequestParam int deptId) {

		Dept deptRes = null;

		try {
			deptRes = deptRepo.findBydeptId(deptId);

		} catch (Exception e) {
			System.err.println("Exce in getDept  " + e.getMessage());
			e.printStackTrace();

		}
		return deptRes;
	}

	@RequestMapping(value = { "/getAllDeptList" }, method = RequestMethod.POST)
	public @ResponseBody List<Dept> getAllDeptList(@RequestParam int instId) {

		List<Dept> insResp = new ArrayList<>();

		try {
			insResp = deptRepo.findByDelStatusAndIsActiveAndInstituteIdOrderByDeptIdDesc(1, 1, instId);

		} catch (Exception e) {
			System.err.println("Exce in getAllDeptList  " + e.getMessage());
			e.printStackTrace();
		}

		return insResp;

	}

	@RequestMapping(value = { "/deleteDepts" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDepts(@RequestParam List<String> deptIdList) {

		Info info = new Info();
		try {
			int res = deptRepo.deleteDepts(deptIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteDepts  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@RequestMapping(value = { "/saveInstitute" }, method = RequestMethod.POST)
	public @ResponseBody Institute saveInstitute(@RequestBody Institute institute) {

		Institute insResp = null;

		try {

			if (institute.getInstituteId() == 0) {
				insResp = instituteRepo.saveAndFlush(institute);

				System.err.println("New Isntitute Insert  New Principal");

				Principal princi = new Principal();

				princi.setEmail(insResp.getEmail());
				princi.setInstituteId(insResp.getInstituteId());
				princi.setPhoneNo(insResp.getContactNo());
				princi.setPrincipalId(0);
				princi.setPrincipalName(insResp.getPrincipalName());
				princi.setIsEnroll(0);
				pincipalRepo.saveAndFlush(princi);

			} else {
				insResp = instituteRepo.saveAndFlush(institute);

				System.err.println("Old Isntitute Old   Principal  update if any");

				Principal princi = pincipalRepo.findByInstituteId(insResp.getInstituteId());

				princi.setEmail(insResp.getEmail());
				princi.setInstituteId(insResp.getInstituteId());
				princi.setPhoneNo(insResp.getContactNo());
				princi.setPrincipalName(insResp.getPrincipalName());
				pincipalRepo.saveAndFlush(princi);

			}

		} catch (Exception e) {
			System.err.println("Exce in saving Institute " + e.getMessage());
			e.printStackTrace();
		}

		return institute;

	}

	@RequestMapping(value = { "/getAllInstitutes" }, method = RequestMethod.GET)
	public @ResponseBody List<GetInstituteList> getAllInstitutes() {

		List<GetInstituteList> insResp = new ArrayList<>();

		try {
			insResp = getGetInstituteListRepo.getAllInstituteList();

		} catch (Exception e) {
			System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
			e.printStackTrace();
		}

		return insResp;

	}

	@RequestMapping(value = { "/deleteInstitutes" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstitutes(@RequestParam List<String> instIdList) {

		Info info = new Info();
		try {
			int res = instituteRepo.deleteInstitutes(instIdList);

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

	@RequestMapping(value = { "/getInstitute" }, method = RequestMethod.POST)
	public @ResponseBody Institute getInstitute(@RequestParam int instituteId) {

		Institute insResp = null;

		try {
			insResp = instituteRepo.findByInstituteId(instituteId);

		} catch (Exception e) {

			System.err.println("Exce in getInstitute Institute " + e.getMessage());
			e.printStackTrace();
		}

		return insResp;

	}

	@RequestMapping(value = { "/getAllPendingInstitutes" }, method = RequestMethod.GET)
	public @ResponseBody List<GetInstituteList> getAllPendingInstitutes() {

		List<GetInstituteList> insResp = new ArrayList<>();

		try {

			insResp = getGetInstituteListRepo.getAllPendingInstituteList();

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return insResp;

	}

	// create user after approving institute by Rusa

	@Autowired
	UserService userServiceRepo;

	@RequestMapping(value = { "/approveInstitutes" }, method = RequestMethod.POST)
	public @ResponseBody Info approveInstitutes(@RequestParam List<Integer> instIdList, @RequestParam int aprUserId) {

		Info info = new Info();
		try {
			int res = 0;

			for (int i = 0; i < instIdList.size(); i++) {

				UserLogin user = new UserLogin();

				String userName = getAlphaNumericString(7);
				String pass = getAlphaNumericString(7);
				System.err.println("username  " + userName + "\n  pass  " + pass);

				user.setExInt1(0);
				user.setExInt2(0);
				user.setExVar1("Na");
				user.setExVar2("Na");
				user.setIsBlock(1);
				user.setPass(pass);

				Principal princi = pincipalRepo.findByInstituteId(instIdList.get(i));

				user.setRegPrimaryKey(princi.getPrincipalId());// principla primary key

				user.setExInt2(instIdList.get(i)); //
				user.setRoleId(0);
				user.setUserName(userName);
				user.setUserType(1);// 2 for Principal user Default

				UserLogin userRes = userServiceRepo.save(user);

				Institute insResp = null;

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String curDateTime = dateFormat.format(cal.getTime());

				insResp = instituteRepo.findByInstituteId(userRes.getExInt2());

				insResp.setCheckerUserId(aprUserId);
				insResp.setCheckerDatetime(curDateTime);
				instituteRepo.save(insResp);
				
				
				Info info2=EmailUtility.sendEmail(senderEmail, senderPassword, princi.getEmail(), mailsubject,
						userRes.getUserName(), userRes.getPass());

				final String emailSMTPserver = "smtp.gmail.com";
				final String emailSMTPPort = "587";
				final String mailStoreType = "imaps";
				final String username = "atsinfosoft@gmail.com";
				final String password = "atsinfosoft@123";

				System.out.println("username" + username);
				System.out.println("password" + password);

				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

				try {
					Store mailStore = session.getStore(mailStoreType);
					mailStore.connect(emailSMTPserver, username, password);

					String mes = " Hello Sir/Madam ";

					String address = "atsinfosoft@gmail.com";// address of to

					String subject = " Login Credentials For RUSA Login  ";

					Message mimeMessage = new MimeMessage(session);
					mimeMessage.setFrom(new InternetAddress(username));
					mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
					mimeMessage.setSubject(subject);
					mimeMessage.setText(mes);
					mimeMessage.setText(" User Name " + userRes.getUserName() + "\n Password " + userRes.getPass());

					//Transport.send(mimeMessage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

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

	static String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

}
