package com.ats.rusasoftapi.webapi.iqac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.repositories.IqacListRepo;
import com.ats.rusasoftapi.common.Commons;
import com.ats.rusasoftapi.common.EmailUtility;
import com.ats.rusasoftapi.model.Dean;
import com.ats.rusasoftapi.model.DeansList;
import com.ats.rusasoftapi.model.Hod;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.Institute;
import com.ats.rusasoftapi.model.IqacList;
import com.ats.rusasoftapi.model.Librarian;
import com.ats.rusasoftapi.model.MIqac;
import com.ats.rusasoftapi.model.NewDeanList;
import com.ats.rusasoftapi.model.Quolification;
import com.ats.rusasoftapi.model.Staff;
import com.ats.rusasoftapi.model.StaffList;
import com.ats.rusasoftapi.model.StudentSchemeList;
import com.ats.rusasoftapi.model.StudentSupprtScheme;
import com.ats.rusasoftapi.model.UserLogin;
import com.ats.rusasoftapi.mstrepo.QuolificationRepo;
import com.ats.rusasoftapi.mstrepo.UserService;
import com.ats.rusasoftapi.repositories.DeanRepo;
import com.ats.rusasoftapi.repositories.DeansListRepo;
import com.ats.rusasoftapi.repositories.ExtActOfficerRepo;
import com.ats.rusasoftapi.repositories.IqacRepo;
import com.ats.rusasoftapi.repositories.NewDeanListRepo;
import com.ats.rusasoftapi.repositories.StaffListRepo;
import com.ats.rusasoftapi.repositories.StaffRepo;
import com.ats.rusasoftapi.repositories.StudentSchemeRepo;
import com.ats.rusasoftapi.repositories.StudentSupprtSchemeRepo;
import com.ats.rusasoftapi.repositories.TrainingPlacementOfficerRepo;

@RestController
public class IqacRestController {

	Commons com = new Commons();
	
	@Autowired IqacRepo iqacrepo;
	
	@Autowired StaffRepo staffrepo;
	
	@Autowired UserService userrepo;
	
	@Autowired IqacListRepo iqaclistrepo;
	
	@Autowired StaffListRepo stafflistrepo;
	
	@Autowired DeanRepo deanrepo;
	
	@Autowired DeansListRepo deanlistrepo;
	
	@Autowired StudentSupprtSchemeRepo studschemerepo;
	
	@Autowired StudentSchemeRepo studrepo;
	
	@Autowired NewDeanListRepo newDeanListRepo;
	
	//static String senderEmail = "atsinfosoft@gmail.com";
	//static	String senderPassword = "atsinfosoft@123";
	//static String mailsubject = " RUSA Login Credentials ";
	
	static String senderEmail ="techrusa1@gmail.com";// "atsinfosoft@gmail.com";
	static String senderPassword ="@Rusamah";// "atsinfosoft@123";
	static String mailsubject = " RUSA Software Login Credentials ";
	
	@RequestMapping(value = { "/chkUniqueValues" }, method = RequestMethod.POST)
	public @ResponseBody Info chkUniqueFields(@RequestParam String inputValue, @RequestParam int valueType,
			@RequestParam int tableId, @RequestParam int isEditCall, @RequestParam int primaryKey) {
		
		// System.out.println("Values:"+inputValue+" "+valueType+" "+primaryKey+" "+isEditCall+" "+tableId);
		
		Info info = new Info();

		if (tableId == 3) {
			List<Dean> deanlist = new ArrayList<>();

			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					deanlist = deanrepo.findByContactNo(inputValue.trim());
				} else {
					System.err.println("Its Edit Record ");
					deanlist = deanrepo.findByContactNoAndDeanIdNot(inputValue.trim(), primaryKey);
				}

			}else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					deanlist = deanrepo.findByEmail(inputValue);
				} else {
					System.err.println("Its Edit Record ");
					deanlist = deanrepo.findByEmailAndDeanIdNot(inputValue.trim(), primaryKey);
				}

			}
			if (deanlist.size() > 0) {
				info.setError(true);
				info.setMsg("duplicate");
			} else {
				info.setError(false);
				info.setMsg("unique");
			}
		}else if (tableId == 1) {

			List<MIqac> iqaclist = new ArrayList<>();

			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					iqaclist = iqacrepo.findByContactNoAndDelStatusAndIsActive(inputValue.trim(), 1, 1);
				} else {
					System.err.println("Its Edit Record ");
					iqaclist = iqacrepo.findByContactNoAndDelStatusAndIsActiveAndIqacIdNot(inputValue.trim(), 1, 1,
							primaryKey);
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					iqaclist = iqacrepo.findByEmailAndDelStatusAndIsActive(inputValue, 1, 1);
				} else {
					System.err.println("Its Edit Record ");
					iqaclist = iqacrepo.findByEmailAndDelStatusAndIsActiveAndIqacIdNot(inputValue.trim(), 1, 1,
							primaryKey);
				}

			}

			if (iqaclist.size() > 0) {
				info.setError(true);
				info.setMsg("duplicate");
			} else {
				info.setError(false);
				info.setMsg("unique");
			}
		}else if (tableId == 2) {
			System.err.println("inside lib info check");

			List<Staff> stafList = new ArrayList<>();

			if (valueType == 1) {
				System.err.println("Its Contact No check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					stafList = staffrepo.findByContactNoAndDelStatus(inputValue.trim(), 1);
				} else {
					System.err.println("Its Edit Record ");
					stafList = staffrepo.findByContactNoAndDelStatusAndFacultyIdNot(inputValue.trim(), 1, primaryKey);
				}

			} else if (valueType == 2) {
				System.err.println("Its Email check");
				if (isEditCall == 0) {
					System.err.println("Its New Record Insert ");
					stafList = staffrepo.findByEmailAndDelStatus(inputValue, 1);
				} else {
					System.err.println("Its Edit Record ");
					stafList = staffrepo.findByEmailAndDelStatusAndFacultyIdNot(inputValue.trim(), 1, primaryKey);
				}

			}

			if (stafList.size() > 0) {
				info.setError(true);
				info.setMsg("duplicate");
			} else {
				info.setError(false);
				info.setMsg("unique");
			}
		}
		
		return info;
}
	
	/********************************IQAC**************************************/
	
	@RequestMapping(value= {"/getIqacById"}, method=RequestMethod.POST)
	public @ResponseBody MIqac getIqacById(@RequestParam("id") int id){
		
		return iqacrepo.findByIqacIdAndDelStatus(id,1);
		
	}
	
	@RequestMapping(value= {"/getIqacbyInstituteId"}, method=RequestMethod.POST)
	public @ResponseBody MIqac getIqacbyInstituteId(@RequestParam("instituteId") int instituteId){
		
		return iqacrepo.findByInstituteIdAndDelStatusAndIsActive(instituteId,1,1);
		
	}
	
	
	@RequestMapping(value= {"/getUserInfoByContcAndEmail"}, method=RequestMethod.POST)
	public @ResponseBody Staff getUserInfoByConAndEmail(@RequestParam  int instId,@RequestParam int checkValue,@RequestParam String inputValue){
		
		Staff staff=new Staff();
		if(checkValue==1) {
			//Its Contact no check
			staff=staffrepo.findByDelStatusAndIsActiveAndIsBlockedAndInstituteIdAndContactNo(1, 1, 0, instId, inputValue);
		}
		else {
			
			//Its Email check
			staff=staffrepo.findByDelStatusAndIsActiveAndIsBlockedAndInstituteIdAndEmailIgnoreCase(1, 1, 0, instId, inputValue);
		}
		
		if(staff==null) {
			staff=new Staff();
			
		}
		return staff;
		
	}
	
	
	@RequestMapping(value= {"/blockPreviousIqacRecord"}, method=RequestMethod.POST)
	public @ResponseBody Info blockPreviousIqacRecord(@RequestParam("instituteId") int instituteId,
			@RequestParam("userType") int userType){
		
		Info info = new Info();
		
		try {
			
			int  blockPreous = userrepo.blockPreviousIqacRecord(instituteId,userType);
			

			if(blockPreous>0) {
				info.setError(false);
				info.setMsg("block");
			}else {
				info.setError(true);
				info.setMsg("failed");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMsg("failed");
		}
		return info;
		
	}

	
	@RequestMapping(value= {"/insertNewIqac"}, method=RequestMethod.POST)
	public @ResponseBody MIqac insertNewIqac(@RequestBody MIqac miqac){
		
		MIqac iqacRes = null;
		try {
			if(miqac.getIqacId()==0) {
				iqacRes = iqacrepo.save(miqac);
				
				UserLogin user = new UserLogin(); 
				
				String passWord = com.getAlphaNumericString(7);
				 
				  user.setRegPrimaryKey(iqacRes.getIqacId());
				  user.setUserName(iqacRes.getEmail());
				  user.setPass(passWord);
				  user.setRoleId(3);
				  user.setExInt1(0);
				  user.setUserType(iqacRes.getType()); 
				  user.setExInt2(iqacRes.getInstituteId());
				  user.setExVar1("NA");
				  user.setExVar2("NA");
				  user.setIsBlock(1);
				  
				  UserLogin userRes = userrepo.save(user);
				  // System.out.println("IQac LOg:"+userRes);
				 
					Info info=EmailUtility.sendEmail(senderEmail, senderPassword, iqacRes.getEmail(), mailsubject,
							userRes.getUserName(), userRes.getPass());
					
					Info info1=EmailUtility.sendMsg(userRes.getUserName(), userRes.getPass(), iqacRes.getContactNo());
					
					System.err.println("Info email sent response   "+info.toString());
				  
			}else {
				iqacRes = iqacrepo.save(miqac);
			}
		}catch(Exception e) {
			
		}
		
		return iqacRes;
		
	}
	
	@RequestMapping(value= {"/getAllIqac"}, method=RequestMethod.POST)
	public @ResponseBody List<IqacList> getAllIqac(@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int instituteId){

	  // System.out.println("isIQAC" + isIQAC+ " "+instituteId+" "+isPrincipal);
 
	  List<IqacList> iqcList = null; 
  try {
	  if (isIQAC == 1 || isPrincipal == 1) {
		  iqcList=iqaclistrepo.findIqacByInstId(instituteId);
		} 
			
			//iqcList=iqaclistrepo.findByIsActiveAndDelStatus();
			
		}catch(Exception e){
			e.printStackTrace();
		}
  // System.out.println("List="+iqcList);
		return iqcList;
	}
	
	
	@RequestMapping(value= {"/deleteIqacById"}, method=RequestMethod.POST)
	public @ResponseBody Info deleteByIqacById(@RequestParam("id") int id){
		int isDelete=0;
		 isDelete= iqacrepo.deleteByIqacId(id);
		 Info inf = new Info();
		 if(isDelete>0) {
			 inf.setError(false);
			 inf.setMsg("Sucessfully Deleted");
		 }
		 else{
			 inf.setError(true);
			 inf.setMsg("Fail");
		 }
		 return inf;
	}
	
	
	/**************************************Staff/Faculty**************************************/
	
	@RequestMapping(value= {"/addNewStaff"}, method=RequestMethod.POST)
	public @ResponseBody Staff addNewStaff(@RequestBody Staff staff) {
		
		Staff staffRes= null;
		System.out.println("  LOg****:"+staff.toString());
		if(staff.getFacultyId()==0) {
			String passWord = com.getAlphaNumericString(7);
			staff.setPassword(passWord);

			staffRes = staffrepo.save(staff);
			
			//UserLogin user = new UserLogin(); 
			
			 
			  /*user.setRegPrimaryKey(staffRes.getFacultyId());
			  user.setUserName(staffRes.getEmail());
			  user.setPass(passWord);
			  user.setRoleId(5); 
			  user.setExInt1(0);
			  user.setUserType(staffRes.getExtraint1()); 
			  user.setExInt2(staffRes.getInstituteId());
			  user.setExVar1("NA");
			  user.setExVar2("NA");
			  user.setIsBlock(1);
			  
			  UserLogin userRes = userrepo.save(user);
			  // System.out.println("IQac LOg:"+userRes);*/
		
			  Info info=EmailUtility.sendEmail(senderEmail, senderPassword, staffRes.getEmail(), mailsubject,
					  staffRes.getEmail(), staffRes.getPassword());
			  
			  Info info1=EmailUtility.sendMsg(staffRes.getEmail(), staffRes.getPassword(), staffRes.getContactNo());
				System.err.println("Info email sent response   "+info.toString());
			
		}else{
			staffRes = staffrepo.save(staff);
		}
		return staffRes;
		
		
	}
	
	@RequestMapping(value= {"/getListStaff"}, method=RequestMethod.POST)
	public @ResponseBody List<StaffList> getListStaff(@RequestParam int facultyId, @RequestParam int user,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
		//		+ isHod + "yearId" + yearId + "deptIdList" + deptIdList+" " +user);

		List<StaffList> staffList = null;
		try {
			
			if (isPrincipal == 1 || isIQAC == 1) {
				staffList = stafflistrepo.getFacultyListYear(instituteId);
			} else if (isHod == 1) {
				staffList = stafflistrepo.getFacultyListByDept(deptIdList, instituteId);
			} 
			else {
				staffList = stafflistrepo.getFacultyListById(facultyId, instituteId); 
			}
				 
			//staffList = stafflistrepo.findByIsActiveAndDelStatus(facId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return staffList;
		
	}
	
	@RequestMapping(value= {"/getStaffById"}, method=RequestMethod.POST)
	public @ResponseBody Staff getStaffById(@RequestParam("id") int id){
		
		return staffrepo.findByFacultyIdAndDelStatusAndIsBlocked(id,1,0);
		
	}
	
	
	@RequestMapping(value = {"/deleteStaffById"}, method=RequestMethod.POST)
	public @ResponseBody Info deleteStaffById(@RequestParam("id") int id){
		int isDelete=0;
		 isDelete= staffrepo.deleteByFacultyId(id);
		 Info inf = new Info();
		 if(isDelete>0) {
			 inf.setError(false);
			 inf.setMsg("Sucessfully Deleted");
		 }
		 else{
			 inf.setError(true);
			 inf.setMsg("Fail");
		 }
		 return inf;
	}
	 

	@RequestMapping(value = { "/deleteStaffSlected" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteStaffs(@RequestParam List<String> staffIdList) {

		Info info = new Info();
		try {
			int res = staffrepo.deleteStaffs(staffIdList);

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
	/*******************************************DEAN********************************************/
	
	@RequestMapping(value = {"/saveNewDean"}, method=RequestMethod.POST)
	public @ResponseBody Dean saveDean(@RequestBody Dean dean) {
		
		Dean deanRes =  null;
		if(dean.getDeanId() == 0) {
			deanRes = deanrepo.save(dean);
			
			UserLogin user = new UserLogin(); 
			
			String passWord = com.getAlphaNumericString(7);
			 
			  user.setRegPrimaryKey(deanRes.getDeanId());
			  user.setUserName(deanRes.getEmail());
			  user.setPass(passWord);
			  user.setRoleId(7); 
			  user.setExInt1(0);
			  user.setUserType(deanRes.getExtraint1()); 
			  user.setExInt2(deanRes.getInstituteId());
			  user.setExVar1("NA");
			  user.setExVar2("NA");
			  user.setIsBlock(1);
			  
			UserLogin userRes = userrepo.save(user); 
			Info info=EmailUtility.sendEmail(senderEmail, senderPassword, deanRes.getEmail(), mailsubject,
					userRes.getUserName(), userRes.getPass());
			
			Info info1=EmailUtility.sendMsg(userRes.getUserName(), userRes.getPass(), deanRes.getContactNo());
			System.err.println("Info email sent response   "+info.toString());
		}else {
			deanRes = deanrepo.save(dean);
		}
		
		
		return deanRes;
		
	}
	
	
	  @RequestMapping(value= {"/getListDean"}, method=RequestMethod.POST)
	  public @ResponseBody List<NewDeanList> getListDean(@RequestParam int facultyId,
				@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod,@RequestParam List<Integer> deptIdList,
				@RequestParam int instituteId ,@RequestParam int isDean){
	
		  // System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
			//		+ isHod +  "deptIdList" + deptIdList);
	 
	  List<NewDeanList> deansList = null; try {
		  if (isPrincipal == 1 || isIQAC == 1) {
			  deansList = newDeanListRepo.getDeanByInst( instituteId);
			} else if ( isDean == 1 || isHod == 1) {
				deansList = newDeanListRepo.getDeanByDept(deptIdList, instituteId);
			} else {
				deansList = newDeanListRepo.getDeanRepo(facultyId, instituteId);
			}
	  
	  //deansList = deanlistrepo.findByIsActiveAndDelStatus();
	  
	  }catch(Exception e){ e.printStackTrace(); }
	  
	  return deansList;
	  
	  }
	  
	  
	  @RequestMapping(value= {"/getDeanById"}, method=RequestMethod.POST)
		public @ResponseBody Dean getDeanById(@RequestParam("id") int id){
			
			return deanrepo.findByDeanIdAndDelStatus(id,1);
			
		}
		

		@RequestMapping(value = {"/deleteDeanById"}, method=RequestMethod.POST)
		public @ResponseBody Info deleteDeanById(@RequestParam("id") int id){
			int isDelete=0;
			 isDelete= deanrepo.deleteByDeanId(id);
			 Info inf = new Info();
			 if(isDelete>0) {
				 inf.setError(false);
				 inf.setMsg("Sucessfully Deleted");
			 }
			 else{
				 inf.setError(true);
				 inf.setMsg("Fail");
			 }
			 return inf;
		}
		
		
		/****************************************Student Support Scheme***********************************/
		
		@RequestMapping(value= {"/saveStudentSupprtScheme"}, method=RequestMethod.POST)
		public @ResponseBody StudentSupprtScheme insertStudentSupprtScheme(
				@RequestBody StudentSupprtScheme studsupprtscheme)
		{
			return studschemerepo.save(studsupprtscheme);
			
		}
		
		@RequestMapping(value = {"/getAllStudentSchemes"}, method=RequestMethod.POST)
		public @ResponseBody List<StudentSchemeList> getAllStudentSchemes(@RequestParam("yearId") int yearId,@RequestParam("instId") int instId) {
			
			List<StudentSchemeList> studSchmList = null;
			try {
				studSchmList = studrepo.getStudentSchemeList(yearId,instId);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return studSchmList;
			
		}
		
		 @RequestMapping(value= {"/getStudentSchemesById"}, method=RequestMethod.POST)
			public @ResponseBody StudentSupprtScheme getStudentSchemesById(@RequestParam("id") int id){
				
				return studschemerepo.findBySprtSchmIdAndDelStatus(id, 1);
				
			}
		 
		 @RequestMapping(value = {"/deleteStudentSchemesById"}, method=RequestMethod.POST)
			public @ResponseBody Info deleteStudentSchemesById(@RequestParam("id") int id){
				int isDelete=0;
				 isDelete= studschemerepo.deleteBySprtSchmId(id);
				 Info inf = new Info();
				 if(isDelete>0) {
					 inf.setError(false);
					 inf.setMsg("Sucessfully Deleted");
				 }
				 else{
					 inf.setError(true);
					 inf.setMsg("Fail");
				 }
				 return inf;
			}
		 
/***********************************************************************************************************/
		 @Autowired
			QuolificationRepo getQuolificationRepo;

			@RequestMapping(value = { "/getQuolificationListToTeach" }, method = RequestMethod.POST)
			public @ResponseBody List<Quolification> getQuolificationListToTeach(@RequestParam int type0) {

				List<Quolification> quolList = new ArrayList<>();

				try {
					quolList = getQuolificationRepo.findByTypeAndDelStatusOrderByQualificationIdDesc(type0, 1);
					System.err.println("teachList1 " + quolList);
				} catch (Exception e) {
					System.err.println("Exce in getAllDeptList  " + e.getMessage());
					e.printStackTrace();
				}

				return quolList;

			}
			
			
			
/*****************************************Training & Placement Officer*****************************************/
			@Autowired TrainingPlacementOfficerRepo tpoRepo;
			
			@RequestMapping(value= {"/getTraningOfficerList"}, method=RequestMethod.POST)
			  public @ResponseBody List<NewDeanList> getTraningOfficerList(@RequestParam int facultyId,
						@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod,@RequestParam List<Integer> deptIdList,
						@RequestParam int instituteId ,@RequestParam int isDean){
			
				  // System.out.println(" facultyId ==" + facultyId + " isPrincipal " + isPrincipal + " isIQAC " + isIQAC + " Institute Id="+instituteId+
				//		  "isHod "+ isHod +  " deptIdList" + deptIdList);
			 
			  List<NewDeanList> tpoList = null; try {
				  if (isPrincipal == 1 || isIQAC == 1) {
					  tpoList = tpoRepo.getTpoByInst( instituteId);
					} else if ( isDean == 1 || isHod == 1) {
						tpoList = tpoRepo.getTpoByDept(deptIdList, instituteId);
					} else {
						tpoList = tpoRepo.getTpoRepo(facultyId, instituteId);
					}
			  
			  //deansList = deanlistrepo.findByIsActiveAndDelStatus();
			  
			  }catch(Exception e){ e.printStackTrace(); }
			  
			  return tpoList;
			  
			  }
			
	/*******************************************Extension Activity Officer***************************************/
			@Autowired ExtActOfficerRepo extRepo;
			@RequestMapping(value= {"/getExtActList"}, method=RequestMethod.POST)
			  public @ResponseBody List<NewDeanList> getExtActList(@RequestParam int facultyId,
						@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod,@RequestParam List<Integer> deptIdList,
						@RequestParam int instituteId ,@RequestParam int isDean){
			
				  // System.out.println(" facultyId ==" + facultyId + " isPrincipal " + isPrincipal + " isIQAC " + isIQAC + " Institute Id="+instituteId+
					//	  "isHod "+ isHod +  " deptIdList" + deptIdList);
			 
			  List<NewDeanList> extoFFList = null; try {
				  if (isPrincipal == 1 || isIQAC == 1) {
					  extoFFList = extRepo.getextOffByInst( instituteId);
					} else if ( isDean == 1 || isHod == 1) {
						extoFFList = extRepo.getextOffByDept(deptIdList, instituteId);
					} else {
						extoFFList = extRepo.getextOffRepo(facultyId, instituteId);
					}
			  
			  //deansList = deanlistrepo.findByIsActiveAndDelStatus();
			  
			  }catch(Exception e){ e.printStackTrace(); }
			  
			  return extoFFList;
			  
			  }
}
