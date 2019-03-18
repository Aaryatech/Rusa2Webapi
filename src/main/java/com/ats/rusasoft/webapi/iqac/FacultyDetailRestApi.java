package com.ats.rusasoft.webapi.iqac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.FacultyActivity;
import com.ats.rusasoft.model.FacultyBook;
import com.ats.rusasoft.model.FacultyConference;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.StudMentorList;
import com.ats.rusasoft.model.StudentMentoring;
import com.ats.rusasoft.mstrepo.StuedentMentorListRepo;
import com.ats.rusasoft.repositories.BookPublicatioRepo;
import com.ats.rusasoft.repositories.FacultyActivityRepo;
import com.ats.rusasoft.repositories.FacultyConferenceRepo;
import com.ats.rusasoft.repositories.StudentMentoringRepo;

@RestController
public class FacultyDetailRestApi {

	@Autowired StudentMentoringRepo studmentrepo;
	
	@Autowired StuedentMentorListRepo  smRepo;
	
	@Autowired FacultyConferenceRepo facconRepo;
	
	@Autowired BookPublicatioRepo bookpubrepo;
	
	@Autowired FacultyActivityRepo facAcRepo;
	
	@RequestMapping(value= {"/insertStudentMentoringDetails"}, method=RequestMethod.POST)
	public @ResponseBody StudentMentoring insertStudMent(@RequestBody StudentMentoring studMent){
		
		return studmentrepo.save(studMent);
		
	}
	@RequestMapping(value= {"/getStudentMentoringDetailsById"}, method=RequestMethod.POST)
	public @ResponseBody StudentMentoring getByFacId(@RequestParam("facId") int facId){
		
		return studmentrepo.findByFacultyIdAndDelStatus(facId, 1);
	}
	
	@RequestMapping(value= {"/getStudentMentoringDetailsList"}, method=RequestMethod.POST)
	public @ResponseBody List<StudMentorList> getFacultyMonitorList(@RequestParam("facId") int facId){
		
		return smRepo.getListFacultyMonitor(facId);
	}
	@RequestMapping(value= {"/editFacultyMentoringDetailsById"}, method=RequestMethod.POST)
	public @ResponseBody StudentMentoring getFacultyMentor(@RequestParam("mId") int mId){
		
		return studmentrepo.findByMenIdAndDelStatus(mId, 1);
	}
	
	@RequestMapping(value= {"/deleteFacultyMentoringDetailsById"}, method=RequestMethod.POST)
	public @ResponseBody Info deleteFacultyMentor(@RequestParam("mId") int mId){
		
		//return studmentrepo.findByMenIdAndDelStatus(mId, 1);
		int isDelete=0;
		 isDelete= studmentrepo.deleteByMenId(mId);
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
	
	/*************************************Faculty Conference**********************************/
	
	@RequestMapping(value= {"/insertNewFacConference"}, method=RequestMethod.POST)
	public @ResponseBody FacultyConference insertFacultyConfrence(@RequestBody FacultyConference facConf){
		
		return facconRepo.save(facConf);
		
	}
	
	@RequestMapping(value= {"/getfacultyConferenceByFacId"}, method=RequestMethod.POST)
	public @ResponseBody List<FacultyConference> getFacultyConfList(@RequestParam("facId") int facId){
		System.err.println("FId:"+facId);
		return facconRepo.getListFacultyConference(facId);
	}
	
	@RequestMapping(value= {"/getFacConfByFacId"}, method=RequestMethod.POST)
	public @ResponseBody FacultyConference getFacultyConfByFacId(@RequestParam("facId") int facId){
		System.err.println("FId:"+facId);
		return facconRepo.findByConfIdAndDelStatus(facId, 1);
	}
	
	@RequestMapping(value= "/deleteFacultyConfrncById", method=RequestMethod.POST)
	public @ResponseBody Info deleteFacultyConf(@RequestParam("facId") int facId){
		
		
		int isDelete=0;
		 isDelete= facconRepo.deleteByFacId(facId);
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
	
	/***************************************Book Publication************************************/
	
	
	@RequestMapping(value= {"/savefacultyPubBook"}, method=RequestMethod.POST)
	public @ResponseBody FacultyBook insertBookPub(@RequestBody FacultyBook facBook){
		
		return bookpubrepo.save(facBook);
		
	}
	
	@RequestMapping(value= {"/getAllPublishedBooks"}, method=RequestMethod.POST)
	public @ResponseBody List<FacultyBook> getPublishedBooks(@RequestParam("facId") int facId){
		
		return bookpubrepo.findByFacultyIdAndDelStatusOrderByBookIdDesc(facId, 1);
		
	}
	
	@RequestMapping(value= {"/getPubBookById"}, method=RequestMethod.POST)
	public @ResponseBody FacultyBook getPublishedBookById(@RequestParam("bookId") int bookId){
		
		return bookpubrepo.findByBookIdAndDelStatus(bookId, 1);
		
	}
	
	
	@RequestMapping(value= {"/deletePubBookById"}, method=RequestMethod.POST)
	public @ResponseBody Info deletePublishrdBook(@RequestParam("bookId") int bookId){
		
		
		int isDelete=0;
		 isDelete= bookpubrepo.deleteByBookId(bookId);
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
	
	/***************************************************Facultity Activity**************************************************/
	
	@RequestMapping(value= {"/insertFacultyActivity"}, method=RequestMethod.POST)
	public @ResponseBody FacultyActivity insertFacActivity(@RequestBody FacultyActivity facAct){
		
		return facAcRepo.save(facAct);
		
	}
	
	@RequestMapping(value= {"/getAllActivityById"}, method=RequestMethod.POST)
	public @ResponseBody List<FacultyActivity> getAllActivities(@RequestParam("facId") int facId, @RequestParam("yrId") int yrId ){
		
		return facAcRepo.findByFacultyIdAndYearIdAndDelStatusOrderByActivityId(facId, yrId, 1);
		
	}
	
	@RequestMapping(value= {"/getFacActivityByActvId"}, method=RequestMethod.POST)
	public @ResponseBody FacultyActivity getActivitiesById(@RequestParam("activityId") int activityId){
		
		return facAcRepo.findByActivityIdAndDelStatus(activityId, 1);
		
	}
	
	@RequestMapping(value= {"/deleteActivityById"}, method=RequestMethod.POST)
	public @ResponseBody Info deleteFacActivity(@RequestParam("activityId") int activityId){
		
		
		int isDelete=0;
		 isDelete = facAcRepo.deleteByActivityId(activityId);
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