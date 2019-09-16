package com.ats.rusasoftapi.controller;

import java.security.SecureRandom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.common.EmailUtility;
import com.ats.rusasoftapi.model.AccOfficer;
import com.ats.rusasoftapi.model.Dept;
import com.ats.rusasoftapi.model.EContentDevFacility;
import com.ats.rusasoftapi.model.GetAccOfficer;
import com.ats.rusasoftapi.model.GetHod;
import com.ats.rusasoftapi.model.GetInstituteList;
import com.ats.rusasoftapi.model.Hod;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.Institute;
import com.ats.rusasoftapi.model.Librarian;
import com.ats.rusasoftapi.model.Principal;
import com.ats.rusasoftapi.model.Quolification;
import com.ats.rusasoftapi.model.Staff;
import com.ats.rusasoftapi.model.Student;
import com.ats.rusasoftapi.model.TFacultyStudLinkage;
import com.ats.rusasoftapi.model.UserLogin;
import com.ats.rusasoftapi.mstrepo.AccOfficerRepo;
import com.ats.rusasoftapi.mstrepo.DeptRepo;
import com.ats.rusasoftapi.mstrepo.GetAccOfficerRepo;
import com.ats.rusasoftapi.mstrepo.GetHodRepo;
import com.ats.rusasoftapi.mstrepo.GetInstituteListRepo;
import com.ats.rusasoftapi.mstrepo.HodRepo;
import com.ats.rusasoftapi.mstrepo.InstituteRepo;
import com.ats.rusasoftapi.mstrepo.LibrarianRepo;
import com.ats.rusasoftapi.mstrepo.PrincipalRepo;
import com.ats.rusasoftapi.mstrepo.QuolificationRepo;
import com.ats.rusasoftapi.mstrepo.StudentRepo;
import com.ats.rusasoftapi.mstrepo.TInstEContentDevFacilityRepo;
import com.ats.rusasoftapi.mstrepo.UserService;
import com.ats.rusasoftapi.repositories.StaffRepo;
import com.ats.rusasoftapi.repository.TFacultyStudLinkageRepo;

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
	LibrarianRepo libRepo;

	@Autowired
	DeptRepo deptRepo;

	@Autowired
	HodRepo hodRepo;

	@Autowired
	StudentRepo studRepo;
	
	@Autowired
	StaffRepo staffRepo;
	
	

	@RequestMapping(value = { "/checkUniqueField" }, method = RequestMethod.POST)
	public @ResponseBody Info checkUniqueField(@RequestParam String inputValue, @RequestParam int valueType,
			@RequestParam int tableId, @RequestParam int isEditCall, @RequestParam int primaryKey) {

		Info info = new Info();
		// tableId 1 for Institute tableId 2 for Hod for Sachin table id 5 for acc
		// Officer

		if (tableId == 1) {
			List<Institute> instList = new ArrayList<>();
			System.err.println("******From Institute Table******");
			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					instList = instituteRepo.findByContactNoAndDelStatusAndIsActive(inputValue.trim(), 1, 1);
				} else {
					System.err.println("Its Edit Record ");
					instList = instituteRepo.findByContactNoAndDelStatusAndIsActiveAndInstituteIdNot(inputValue.trim(),
							1, 1, primaryKey);
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					instList = instituteRepo.findByEmailAndDelStatusAndIsActive(inputValue.trim(), 1, 1);
				} else {
					System.err.println("Its Edit Record ");
					instList = instituteRepo.findByEmailAndDelStatusAndIsActiveAndAndInstituteIdNot(inputValue.trim(),
							1, 1, primaryKey);
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
		
		
	if (tableId == 1) {
			List<Staff> instList = new ArrayList<>();
			System.err.println("******From Faculty Table*******");
			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					instList = staffRepo.findByContactNoAndDelStatusAndIsBlocked(inputValue.trim(), 1, 0);
				} else {
					System.err.println("Its Edit Record ");
					
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					instList = staffRepo.findByEmailAndDelStatusAndIsBlocked(inputValue.trim(), 1, 0);
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

		else if (tableId == 4) {
			System.err.println("inside lib info check");

			List<Librarian> libList = new ArrayList<>();

			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					libList = libRepo.findByContactNoAndDelStatus(inputValue.trim(), 1);
				} else {
					System.err.println("Its Edit Record ");
					libList = libRepo.findByContactNoAndDelStatusAndLibrarianIdNot(inputValue.trim(), 1, primaryKey);
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					libList = libRepo.findByEmailAndDelStatus(inputValue, 1);
				} else {
					System.err.println("Its Edit Record ");
					libList = libRepo.findByEmailAndDelStatusAndLibrarianIdNot(inputValue.trim(), 1, primaryKey);
				}

			}

			if (libList.size() > 0) {
				info.setError(true);
				info.setMsg("duplicate");
			} else {
				info.setError(false);
				info.setMsg("unique");
			}
		}

		if (tableId == 5) {
			List<AccOfficer> accOffList = new ArrayList<>();

			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					accOffList = accOfficerRepo.findByContactNoAndDelStatusAndIsActive(inputValue.trim(), 1, 1);
				} else {
					System.err.println("Its Edit Record ");
					accOffList = accOfficerRepo.findByContactNoAndDelStatusAndIsActiveAndOfficerIdNot(inputValue.trim(),
							1, 1, primaryKey);
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					accOffList = accOfficerRepo.findByEmailAndDelStatusAndIsActive(inputValue.trim(), 1, 1);
				} else {
					System.err.println("Its Edit Record ");
					accOffList = accOfficerRepo.findByEmailAndDelStatusAndIsActiveAndOfficerIdNot(inputValue.trim(), 1,
							1, primaryKey);
				}

			}

			if (accOffList.size() > 0) {
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

	@Autowired
	GetAccOfficerRepo getGetAccOfficerRepo;

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
				user.setRoleId(6);// 6 for acc officer
				user.setUserName(acOfRes.getEmail());
				user.setUserType(5);// 5 for acc Officer user Default

				UserLogin userRes = userServiceRepo.save(user);

				Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword, acOfRes.getEmail(), mailsubject,
						acOfRes.getEmail(), userRes.getPass());

				Info smsRes = EmailUtility.sendMsg(acOfRes.getEmail(), userRes.getPass(), acOfRes.getContactNo());

			} else {

				acOfRes = accOfficerRepo.save(accOff);
			}

		} catch (Exception e) {
			System.err.println("Exce in saving saveAccOff " + e.getMessage());
			e.printStackTrace();

		}
		return acOfRes;
	}

	// getAccOffList
	@RequestMapping(value = { "/getAccOffList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAccOfficer> getAccOffList(@RequestParam int instId) {

		List<GetAccOfficer> accOffListByInstId = new ArrayList<>();

		try {
			accOffListByInstId = getGetAccOfficerRepo.getGetAccOfficer(instId);

		} catch (Exception e) {
			System.err.println("Exce in getAccOffList  " + e.getMessage());
			e.printStackTrace();
		}

		return accOffListByInstId;

	}

	@RequestMapping(value = { "/getAccOfficer" }, method = RequestMethod.POST)
	public @ResponseBody AccOfficer getAccOfficer(@RequestParam int accOffId) {

		AccOfficer acOfRes = null;

		try {

			acOfRes = accOfficerRepo.findByOfficerId(accOffId);

		} catch (Exception e) {
			System.err.println("Excc in getting one acc off by id " + e.getMessage());
			e.printStackTrace();
		}
		return acOfRes;
	}

	// deleteAccOfficers
	@RequestMapping(value = { "/deleteAccOfficers" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAccOfficers(@RequestParam List<String> accOffIds) {

		Info info = new Info();
		try {
			int res = accOfficerRepo.deleteAccOfficers(accOffIds);
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

	// for demo example
	@RequestMapping(value = { "/getCount" }, method = RequestMethod.POST)
	public @ResponseBody long getCount(@RequestParam String contactNo) {

		long x = accOfficerRepo.countByContactNoAndDelStatusAndIsActive(contactNo, 1, 1);
		return x;

	}

	//static String senderEmail = "atsinfosoft@gmail.com";
	//static String senderPassword = "atsinfosoft@123";
	//static String mailsubject = " RUSA Login Credentials ";
	
	static String senderEmail ="techrusa1@gmail.com";// "atsinfosoft@gmail.com";
	static String senderPassword ="@Rusamah";// "atsinfosoft@123";
	static String mailsubject = " RUSA Software Login Credentials ";


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
				user.setRoleId(4);// 4 for HOD
				user.setUserName(hodRes.getEmail());
				user.setUserType(3);// 3 for hod user Default

				UserLogin userRes = userServiceRepo.save(user);

				Info info = EmailUtility.sendEmail(senderEmail, senderPassword, hodRes.getEmail(), mailsubject,
						hodRes.getEmail(), userRes.getPass());

				Info smsRes = EmailUtility.sendMsg(hodRes.getEmail(), userRes.getPass(), hodRes.getContactNo());

				System.err.println("Info email sent response   " + info.toString());

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

			for (int i = 0; i < hodListByInstId.size(); i++) {

				List<Integer> deptIds = Stream.of(hodListByInstId.get(i).getDeptId().split(",")).map(Integer::parseInt)
						.collect(Collectors.toList());
				List<Dept> deptList = new ArrayList<>();

				deptList = deptRepo.findByDelStatusAndIsActiveAndDeptIdIn(1, 1, deptIds);

				String deptName = "";
				for (int j = 0; j < deptList.size(); j++) {

					deptName = deptList.get(j).getDeptName() + "," + deptName;
					deptName.substring(0, deptName.length());
				}

				hodListByInstId.get(i).setDeptName(deptName);
			}

			System.err.println("hodListByInstId " + hodListByInstId.toString());

		} catch (Exception e) {

			System.err.println("Exce in getHodListByInstId  " + e.getMessage());
			e.printStackTrace();
		}

		return hodListByInstId;

	}

	// 23Apr
	@RequestMapping(value = { "/getDeptListDeptIdIn" }, method = RequestMethod.POST)
	public @ResponseBody List<Dept> getDeptListDeptIdIn(@RequestParam List<Integer> deptIds) {
		List<Dept> deptList = new ArrayList<>();
		try {
			deptList = deptRepo.findByDelStatusAndIsActiveAndDeptIdIn(1, 1, deptIds);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deptList;

	}

	@RequestMapping(value = { "/getDeptForHodReg" }, method = RequestMethod.POST)
	public @ResponseBody List<Dept> getDeptForHodReg(@RequestParam int instId) {
		List<Dept> deptList = new ArrayList<>();
		try {

			String deptIdString = deptRepo.getDeptIdString(instId);
			System.err.println("dept String " + deptIdString);
			if (deptIdString != null) {
				List<Integer> deptIds = Stream.of(deptIdString.split(",")).map(Integer::parseInt)
						.collect(Collectors.toList());

				deptList = deptRepo.getDeptForHodReg(deptIds, instId);
			} else {
				deptList = deptRepo.findByDelStatusAndIsActiveAndInstituteIdOrderByDeptIdDesc(1, 1, instId);
			}
			System.err.println("Dept List " + deptList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deptList;

	}

	@RequestMapping(value = { "/getDeptForHodRegForEdit" }, method = RequestMethod.POST)
	public @ResponseBody List<Dept> getDeptForHodRegForEdit(@RequestParam int instId,
			@RequestParam List<Integer> deptIdList) {
		List<Dept> deptList = new ArrayList<>();
		try {

			System.err.println("dept String from admin " + deptIdList.toString());
			String deptIdString = deptRepo.getDeptIdString(instId);
			System.err.println("dept String " + deptIdString);
			if (deptIdString != null) {
				List<Integer> deptIds = Stream.of(deptIdString.split(",")).map(Integer::parseInt)
						.collect(Collectors.toList());

				for (int j = 0; j < deptIdList.size(); j++) {
					for (int i = 0; i < deptIds.size(); i++) {

						if (deptIds.get(i) == deptIdList.get(j)) {

							deptIds.remove(i);
						}
					}

				}

				deptList = deptRepo.getDeptForHodReg(deptIds, instId);
			} else {
				deptList = deptRepo.findByDelStatusAndIsActiveAndInstituteIdOrderByDeptIdDesc(1, 1, instId);
			}
			System.err.println("Dept List " + deptList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deptList;

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
			quolList = getQuolificationRepo.findByTypeAndDelStatusOrderByQualificationIdDesc(type, 1);

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

	//@Autowired
	//StaffRepo staffRepo;

	@RequestMapping(value = { "/saveInstitute" }, method = RequestMethod.POST)
	public @ResponseBody Institute saveInstitute(@RequestBody Institute institute) {

		Institute insResp = null;

		try {

			if (institute.getInstituteId() == 0) {
				insResp = instituteRepo.saveAndFlush(institute);

				/*
				 * System.err.println("New Isntitute Insert  New Principal");
				 * 
				 * Principal princi = new Principal();
				 * 
				 * princi.setEmail(insResp.getEmail());
				 * princi.setInstituteId(insResp.getInstituteId());
				 * princi.setPhoneNo(insResp.getContactNo()); princi.setPrincipalId(0);
				 * princi.setPrincipalName(insResp.getPrincipalName()); princi.setIsEnroll(0);
				 * pincipalRepo.saveAndFlush(princi);
				 */
				//

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String curDateTime = dateFormat.format(cal.getTime());

				Staff staff = new Staff();

				staff.setContactNo(insResp.getContactNo());
				staff.setCurrentDesignationId(9);
				staff.setDeptId("0");
				staff.setEmail(insResp.getEmail());
				staff.setFacultyFirstName(insResp.getPrincipalName());
				staff.setFacultyId(0);
				staff.setHighestQualification(0);
				staff.setHightestQualificationYear(null);
				staff.setIsAccOff(0);
				staff.setIsDean(0);
				staff.setIsFaculty(1);
				staff.setIsHod(0);
				staff.setIsIqac(0);
				staff.setIsLibrarian(0);
				staff.setIsPrincipal(1);

				staff.setIsStudent(0);
				staff.setIsWorking(1);
				staff.setJoiningDate(null);
				staff.setLastUpdatedDatetime(curDateTime);
				staff.setMakerEnterDatetime(curDateTime);

				staff.setPassword("");
				staff.setRealivingDate(null);
				staff.setRoleIds("2");
				staff.setTeachingTo(0);

				staff.setInstituteId(insResp.getInstituteId());
				// staff.setJoiningDate(new Date());
				staff.setDelStatus(1);
				staff.setIsActive(1);
				staff.setMakerUserId(0);
				staff.setMakerEnterDatetime(curDateTime);
				staff.setCheckerUserId(0);
				staff.setCheckerDatetime(curDateTime);
				staff.setLastUpdatedDatetime(curDateTime);
				staff.setType(1);

				staff.setExtravarchar1("NA");

				staffRepo.save(staff);

				//

			} else {
				insResp = instituteRepo.saveAndFlush(institute);

				System.err.println("Old Isntitute Old   Principal  update if any");

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

	@RequestMapping(value = { "/updateHodStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateHodStatus(@RequestParam int hodId) {

		Info info = new Info();
		try {
			int res = hodRepo.updateHod(hodId);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in updateHod  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	// create user after approving institute by Rusa

	@Autowired
	UserService userServiceRepo;

	@RequestMapping(value = { "/blockPreviousHodRecord" }, method = RequestMethod.POST)
	public @ResponseBody Info blockPreviousHodRecord(@RequestParam("regPrimaryKey") int regPrimaryKey,
			@RequestParam("userType") int userType) {

		Info info = new Info();

		try {

			int blockPreous = userServiceRepo.blockPreviousHodRecord(regPrimaryKey, userType);

			if (blockPreous > 0) {
				info.setError(false);
				info.setMsg("block");
			} else {
				info.setError(true);
				info.setMsg("failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMsg("failed");
		}
		return info;

	}

	@RequestMapping(value = { "/approveInstitutes" }, method = RequestMethod.POST)
	public @ResponseBody Info approveInstitutes(@RequestParam List<Integer> instIdList, @RequestParam int aprUserId) {

		Info info = new Info();
		try {
			int res = 0;

			for (int i = 0; i < instIdList.size(); i++) {

				//UserLogin user = new UserLogin();

				String userName = getAlphaNumericString(7);
				String pass = getAlphaNumericString(7);
				System.err.println("username  " + userName + "\n  pass  " + pass);

				/*
				 * user.setExInt1(0); user.setExInt2(0); user.setExVar1("Na");
				 * user.setExVar2("Na"); user.setIsBlock(1); user.setPass(pass);
				 * 
				 * Principal princi = pincipalRepo.findByInstituteId(instIdList.get(i));
				 * 
				 * user.setRegPrimaryKey(princi.getPrincipalId());// principla primary key
				 * System.err.println("prinId----------"+princi);
				 * 
				 * user.setExInt2(instIdList.get(i)); // user.setRoleId(2);// 2 for Principal
				 * user.setUserName(princi.getEmail()); user.setUserType(1);// 2 for Principal
				 * user Default
				 * 
				 * UserLogin userRes = userServiceRepo.save(user);
				 * 
				 */				Institute insResp = null;

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String curDateTime = dateFormat.format(cal.getTime());

				Staff staff = staffRepo.findByDelStatusAndIsActiveAndIsBlockedAndInstituteId(1, 1, 0,
						instIdList.get(i));
				staff.setPassword(pass);
				staffRepo.save(staff);

				insResp = instituteRepo.findByInstituteId(instIdList.get(i));

				insResp.setCheckerUserId(aprUserId);
				insResp.setCheckerDatetime(curDateTime);
				insResp.setExInt2(1); // is approved
				instituteRepo.save(insResp);

				//Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword, princi.getEmail(), mailsubject,
						//princi.getEmail(), userRes.getPass());

				//Info smsRes = EmailUtility.sendMsg(princi.getEmail(), userRes.getPass(), princi.getPhoneNo());

				Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword, staff.getEmail(), mailsubject,
						staff.getEmail(), staff.getPassword());

				Info smsRes = EmailUtility.sendMsg(staff.getEmail(), staff.getPassword(), staff.getContactNo());

				/*
				 * final String emailSMTPserver = "smtp.gmail.com"; final String emailSMTPPort =
				 * "587"; final String mailStoreType = "imaps"; final String username =
				 * "atsinfosoft@gmail.com"; final String password = "atsinfosoft@123";
				 * 
				 * // System.out.println("username" + username); //
				 * System.out.println("password" + password);
				 * 
				 * Properties props = new Properties(); props.put("mail.smtp.host",
				 * "smtp.gmail.com"); props.put("mail.smtp.socketFactory.port", "465");
				 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.port", "587");
				 * 
				 * Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				 * protected PasswordAuthentication getPasswordAuthentication() { return new
				 * PasswordAuthentication(username, password); } });
				 * 
				 * try { Store mailStore = session.getStore(mailStoreType);
				 * mailStore.connect(emailSMTPserver, username, password);
				 * 
				 * String mes = " Hello Sir/Madam ";
				 * 
				 * String address = "atsinfosoft@gmail.com";// address of to
				 * 
				 * String subject = " Login Credentials For RUSA Login  ";
				 * 
				 * Message mimeMessage = new MimeMessage(session); mimeMessage.setFrom(new
				 * InternetAddress(username));
				 * mimeMessage.setRecipients(Message.RecipientType.TO,
				 * InternetAddress.parse(address)); mimeMessage.setSubject(subject);
				 * mimeMessage.setText(mes); mimeMessage.setText(" User Name " +
				 * staff.getEmail() + "\n Password " + staff.getPassword());
				 * 
				 * // Transport.send(mimeMessage); } catch (Exception e) { e.printStackTrace();
				 * }
				 */
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

	@RequestMapping(value = { "/showInstituteData" }, method = RequestMethod.POST)
	public @ResponseBody Institute approveInstitutes(@RequestParam("instId") int instId) {

		Institute instiData = null;
		try {

			instiData = instituteRepo.findByInstituteId(instId);

		} catch (Exception e) {

		}
		return instiData;

	}

	@RequestMapping(value = { "/deleteInstituteById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteByIqacById(@RequestParam("instId") int instId) {
		int isDelete = 0;
		isDelete = instituteRepo.delPendingInst(instId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMsg("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMsg("Fail");
		}
		return inf;
	}

	@Autowired
	TInstEContentDevFacilityRepo econtentRepo;

	@RequestMapping(value = { "/saveEcontentDevFacilities" }, method = RequestMethod.POST)
	public @ResponseBody EContentDevFacility saveEcontentDevFacilities(@RequestBody EContentDevFacility eCont) {

		EContentDevFacility contentres = null;

		try {
			contentres = econtentRepo.saveAndFlush(eCont);

		} catch (Exception e) {
			System.err.println("Exce in saveEcontentDevFacilities " + e.getMessage());
			e.printStackTrace();
		}
		return contentres;
	}

	@RequestMapping(value = { "/showEComtentDevFaclity" }, method = RequestMethod.POST)
	public @ResponseBody List<EContentDevFacility> showEComtentDevFaclity(
			@RequestParam("instituteId") int instituteId) {

		List<EContentDevFacility> eCont = new ArrayList<>();

		try {

			eCont = econtentRepo.findByDelStatusAndInstIdOrderByInstEContentDevFacilityIdDesc(1, instituteId);
			System.err.println("eCont=" + eCont);

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return eCont;

	}

	@RequestMapping(value = { "/getEContentDevFecilityById" }, method = RequestMethod.POST)
	public @ResponseBody EContentDevFacility getEContentDevFecilityById(@RequestParam("contentId") int contentId) {

		EContentDevFacility eCon = null;
		eCon = econtentRepo.findByInstEContentDevFacilityIdAndDelStatus(contentId, 1);
		return eCon;

	}

	@RequestMapping(value = { "/deleteEContentById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLibBookById(@RequestParam("contentId") int contentId) {

		Info info = new Info();
		try {
			int res = econtentRepo.deleteContentById(contentId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteRareBookById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}

	@RequestMapping(value = { "/deleteSelContent" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelContent(@RequestParam List<String> contentIdsList) {

		Info info = new Info();
		try {
			int res = econtentRepo.deleteEContents(contentIdsList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}

	/*******************************
	 * Research & Innovation
	 ******************************/
	@RequestMapping(value = { "/newstudFacLink" }, method = RequestMethod.POST)
	public @ResponseBody TFacultyStudLinkage saveEcontentDevFacilities(@RequestBody TFacultyStudLinkage linkage) {
		TFacultyStudLinkage link = null;
		link = studFacLinkRepo.save(linkage);

		return link;

	}

	@RequestMapping(value = { "/showStudFacLinks" }, method = RequestMethod.POST)
	public @ResponseBody List<TFacultyStudLinkage> showStudFacLinks(@RequestParam("instituteId") int instituteId) {

		List<TFacultyStudLinkage> links = new ArrayList<>();

		try {

			links = studFacLinkRepo.findByInstIdAndDelStatusOrderByFacultyStudLinkageIdDesc(instituteId, 1);
			System.err.println("linls=" + links);

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return links;

	}

	@RequestMapping(value = { "/getStudFacLinksById" }, method = RequestMethod.POST)
	public @ResponseBody TFacultyStudLinkage getStudFacLinksById(@RequestParam("linkId") int linkId) {

		TFacultyStudLinkage link = null;

		try {

			link = studFacLinkRepo.findByFacultyStudLinkageId(linkId);
			System.err.println("link=" + link);

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return link;
	}

	@RequestMapping(value = { "/deleteLinkById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLinkById(@RequestParam("linkId") int linkId) {

		Info info = new Info();
		try {
			int res = studFacLinkRepo.deleteFacStudLinkById(linkId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteRareBookById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}

	@Autowired
	TFacultyStudLinkageRepo studFacLinkRepo;

	@RequestMapping(value = { "/deleteSelLinks" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelLinks(@RequestParam List<String> linkageIdsList) {

		Info info = new Info();
		try {
			int res = studFacLinkRepo.deleteLinks(linkageIdsList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}

}
