package com.ats.rusasoft.webapi.iqac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.common.Commons;
import com.ats.rusasoft.common.EmailUtility;
import com.ats.rusasoft.model.Dean;
import com.ats.rusasoft.model.DeansList;
import com.ats.rusasoft.model.Hod;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.Institute;
import com.ats.rusasoft.model.IqacList;
import com.ats.rusasoft.model.Librarian;
import com.ats.rusasoft.model.MIqac;
import com.ats.rusasoft.model.Staff;
import com.ats.rusasoft.model.StaffList;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.mstrepo.UserService;
import com.ats.rusasoft.repositories.DeanRepo;
import com.ats.rusasoft.repositories.DeansListRepo;
import com.ats.rusasoft.repositories.IqacListRepo;
import com.ats.rusasoft.repositories.IqacRepo;
import com.ats.rusasoft.repositories.StaffListRepo;
import com.ats.rusasoft.repositories.StaffRepo;

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
	
	static String senderEmail = "atsinfosoft@gmail.com";
	static	String senderPassword = "atsinfosoft@123";
	static String mailsubject = " RUSA Login Credentials ";
	
	
	@RequestMapping(value = { "/chkUniqueValues" }, method = RequestMethod.POST)
	public @ResponseBody Info chkUniqueFields(@RequestParam String inputValue, @RequestParam int valueType,
			@RequestParam int tableId, @RequestParam int isEditCall, @RequestParam int primaryKey) {
		
		System.out.println("Values:"+inputValue+" "+valueType+" "+primaryKey+" "+isEditCall+" "+tableId);
		
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
	
	
	@RequestMapping(value= {"/insertNewIqac"}, method=RequestMethod.POST)
	public @ResponseBody MIqac insertNewIqac(@RequestBody MIqac miqac){
		
		MIqac iqacRes = null;
		try {
			if(miqac.getIqacId()==0) {
				iqacRes = iqacrepo.save(miqac);
				
				UserLogin user = new UserLogin(); 
				
				String passWord = com.getAlphaNumericString(7);
				 
				  user.setRegPrimaryKey(iqacRes.getIqacId());
				  user.setUserName(iqacRes.getIqacName());
				  user.setPass(passWord);
				  user.setRoleId(0);
				  user.setExInt1(0);
				  user.setUserType(iqacRes.getType()); 
				  user.setExInt2(iqacRes.getInstituteId());
				  user.setExVar1("NA");
				  user.setExVar2("NA");
				  user.setIsBlock(1);
				  
				  UserLogin userRes = userrepo.save(user);
				  System.out.println("IQac LOg:"+userRes);
				 
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
	
	@RequestMapping(value= {"/getAllIqac"}, method=RequestMethod.GET)
	public @ResponseBody List<IqacList> getAllIqac(){
		
		List<IqacList> iqcList = null;
		try {
			
			iqcList=iqaclistrepo.findByIsActiveAndDelStatus();
			
		}catch(Exception e){
			e.printStackTrace();
		}
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
		
		if(staff.getFacultyId()==0) {
			
			staffRes = staffrepo.save(staff);
			
			UserLogin user = new UserLogin(); 
			
			String passWord = com.getAlphaNumericString(7);
			 
			  user.setRegPrimaryKey(staffRes.getFacultyId());
			  user.setUserName(staffRes.getFacultyName());
			  user.setPass(passWord);
			  user.setRoleId(0); 
			  user.setExInt1(0);
			  user.setUserType(staffRes.getExtraint1()); 
			  user.setExInt2(staffRes.getInstituteId());
			  user.setExVar1("NA");
			  user.setExVar2("NA");
			  user.setIsBlock(1);
			  
			  UserLogin userRes = userrepo.save(user);
			  System.out.println("IQac LOg:"+userRes);
		
			  Info info=EmailUtility.sendEmail(senderEmail, senderPassword, staffRes.getEmail(), mailsubject,
						userRes.getUserName(), userRes.getPass());
			  
			  Info info1=EmailUtility.sendMsg(userRes.getUserName(), userRes.getPass(), staffRes.getContactNo());
				System.err.println("Info email sent response   "+info.toString());
			
		}else{
			staffRes = staffrepo.save(staff);
		}
		return staffRes;
		
		
	}
	
	@RequestMapping(value= {"/getListStaff"}, method=RequestMethod.GET)
	public @ResponseBody List<StaffList> getListStaff(){
		
		List<StaffList> staffList = null;
		try {
			
			staffList = stafflistrepo.findByIsActiveAndDelStatus();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return staffList;
		
	}
	
	@RequestMapping(value= {"/getStaffById"}, method=RequestMethod.POST)
	public @ResponseBody Staff getStaffById(@RequestParam("id") int id){
		
		return staffrepo.findByFacultyIdAndDelStatus(id,1);
		
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
	
	/*******************************************DEAN********************************************/
	
	@RequestMapping(value = {"/saveNewDean"}, method=RequestMethod.POST)
	public @ResponseBody Dean saveDean(@RequestBody Dean dean) {
		
		Dean deanRes =  null;
		if(dean.getDeanId() == 0) {
			deanRes = deanrepo.save(dean);
			
			UserLogin user = new UserLogin(); 
			
			String passWord = com.getAlphaNumericString(7);
			 
			  user.setRegPrimaryKey(deanRes.getDeanId());
			  user.setUserName(deanRes.getDeanName());
			  user.setPass(passWord);
			  user.setRoleId(0); 
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
	
	
	  @RequestMapping(value= {"/getListDean"}, method=RequestMethod.GET)
	  public @ResponseBody List<DeansList> getListDean(){
	 
	  List<DeansList> deansList = null; try {
	  
	  deansList = deanlistrepo.findByIsActiveAndDelStatus();
	  
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
	 
}
