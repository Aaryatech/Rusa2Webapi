package com.ats.rusasoft.webapi.iqac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.MIqac;
import com.ats.rusasoft.model.Staff;
import com.ats.rusasoft.repositories.IqacRepo;
import com.ats.rusasoft.repositories.StaffRepo;

@RestController
public class IqacRestController {

	@Autowired IqacRepo iqacrepo;
	
	@Autowired StaffRepo staffrepo;
	
	/********************************IQAC**************************************/
	
	@RequestMapping(value= {"/getIqacById"}, method=RequestMethod.POST)
	public @ResponseBody MIqac getIqacById(@RequestParam("id") int id){
		
		return iqacrepo.findByIqacIdAndDelStatus(id,1);
		
	}
	
	
	@RequestMapping(value= {"/insertNewIqac"}, method=RequestMethod.POST)
	public @ResponseBody MIqac insertNewIqac(@RequestBody MIqac miqac){
		
		return iqacrepo.save(miqac);
		
	}
	
	@RequestMapping(value= {"/getAllIqac"}, method=RequestMethod.GET)
	public @ResponseBody List<MIqac> getAllIqac(){
		
		List<MIqac> iqcList = null;
		try {
			
			iqcList=iqacrepo.findByIsActiveAndDelStatus(1,1);
			
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
	/*************************************IQAC***********************************************/
	
	/**************************************Staff/Faculty**************************************/
	
	@RequestMapping(value= {"/addNewStaff"}, method=RequestMethod.POST)
	public @ResponseBody Staff addNewStaff(@RequestBody Staff staff) {
		return staffrepo.save(staff);
		
		
	}
	
	@RequestMapping(value= {"/getListStaff"}, method=RequestMethod.POST)
	public @ResponseBody List<Staff> getListStaff(){
		
		List<Staff> staffList = null;
		try {
			
			staffList = staffrepo.findByIsActiveAndDelStatus(1,1);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return staffList;
		
	}
	
	
	
	/**************************************Staff/Faculty**************************************/
}
