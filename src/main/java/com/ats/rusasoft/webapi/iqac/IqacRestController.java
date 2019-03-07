package com.ats.rusasoft.webapi.iqac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.common.Commons;
import com.ats.rusasoft.model.Hod;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.IqacList;
import com.ats.rusasoft.model.MIqac;
import com.ats.rusasoft.model.Staff;
import com.ats.rusasoft.model.StaffList;
import com.ats.rusasoft.model.UserLogin;
import com.ats.rusasoft.mstrepo.UserService;
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
				  user.setRoleId(0); user.setExInt1(0);
				  user.setUserType(2); 
				  user.setExInt2(iqacRes.getInstituteId());
				  user.setExVar1("NA");
				  user.setExVar2("NA");
				  user.setIsBlock(0);
				  
				  UserLogin userRes = userrepo.save(user);
				  System.out.println("IQac LOg:"+userRes);
				  
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
			  user.setUserType(2); 
			  user.setExInt2(staffRes.getInstituteId());
			  user.setExVar1("NA");
			  user.setExVar2("NA");
			  user.setIsBlock(0);
			  
			  UserLogin userRes = userrepo.save(user);
			  System.out.println("IQac LOg:"+userRes);
			
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
	
	
	@RequestMapping(value= {"/deleteStaffById"}, method=RequestMethod.POST)
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
	
	
}
