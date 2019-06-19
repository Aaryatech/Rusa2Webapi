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

import com.ats.rusasoftapi.model.FacultyActivity;
import com.ats.rusasoftapi.model.FacultyBook;
import com.ats.rusasoftapi.model.FacultyConference;
import com.ats.rusasoftapi.model.FacultyContribution;
import com.ats.rusasoftapi.model.FacultyPhdGuide;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.OrganizedList;
import com.ats.rusasoftapi.model.StudMentorList;
import com.ats.rusasoftapi.model.StudentMentoring;
import com.ats.rusasoftapi.model.faculty.FacultiContributionList;
import com.ats.rusasoftapi.model.faculty.FacultyBookList;
import com.ats.rusasoftapi.model.faculty.FacultyConferenceList;
import com.ats.rusasoftapi.model.faculty.GetJournal;
import com.ats.rusasoftapi.model.faculty.PhdGuidList;
import com.ats.rusasoftapi.mstrepo.StuedentMentorListRepo;
import com.ats.rusasoftapi.repositories.BookPublicatioRepo;
import com.ats.rusasoftapi.repositories.FaclutyConfListRepo;
import com.ats.rusasoftapi.repositories.FacultiContriRepo;
import com.ats.rusasoftapi.repositories.FacultyActivityRepo;
import com.ats.rusasoftapi.repositories.FacultyBookListRepo;
import com.ats.rusasoftapi.repositories.FacultyConferenceRepo;
import com.ats.rusasoftapi.repositories.FacultyContributionRepo;
import com.ats.rusasoftapi.repositories.FacultyPhdGuideRepo;
import com.ats.rusasoftapi.repositories.ShowOrganizedListRepo;
import com.ats.rusasoftapi.repositories.StudentMentoringRepo;
import com.ats.rusasoftapi.repository.PhdGuidListRepo;

@RestController
public class FacultyDetailRestApi {

	@Autowired StudentMentoringRepo studmentrepo;
	
	@Autowired StuedentMentorListRepo  smRepo;
	
	@Autowired FaclutyConfListRepo fConRepo;
	
	@Autowired FacultyConferenceRepo facconRepo;
	
	@Autowired BookPublicatioRepo bookpubrepo;
	
	@Autowired FacultyActivityRepo facAcRepo;
	
	@Autowired FacultyContributionRepo facContriRepo;
	
	@Autowired FacultyPhdGuideRepo fphdrepo;
	
	@Autowired ShowOrganizedListRepo showOrgnRep;
	
	@Autowired PhdGuidListRepo phdListRepo;
	
	@Autowired FacultyBookListRepo facBookRepo;
	
	@Autowired FacultiContriRepo facContriListRepo;
	
	
	@RequestMapping(value= {"/insertStudentMentoringDetails"}, method=RequestMethod.POST)
	public @ResponseBody StudentMentoring insertStudMent(@RequestBody StudentMentoring studMent){
		
		return studmentrepo.save(studMent);
	}
	
	@RequestMapping(value= {"/getStudentMentoringDetailsById"}, method=RequestMethod.POST)
	public @ResponseBody StudentMentoring getByFacId(@RequestParam("facId") int facId){
		
		return studmentrepo.findByFacultyIdAndDelStatus(facId, 1);
	}
	
	@RequestMapping(value= {"/getStudentMentoringDetailsList"}, method=RequestMethod.POST)
	public @ResponseBody List<StudMentorList> getFacultyMonitorList(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId){
		// System.out.println("facultyId ==" + facultyId + " isPrincipal=" + isPrincipal + " sIQAC=" + isIQAC + " isHod="
		//		+ isHod + " yearId=" + yearId + " deptIdList=" + deptIdList);

		
		List<StudMentorList> studMentr = new ArrayList<>();
		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				// System.out.println("1");
				studMentr = smRepo.getStudMentrByYear(yearId, instituteId, facultyId);
			} else if (isHod == 1) {
				// System.out.println("2");
				studMentr = smRepo.getStudMentrByDept(deptIdList, yearId, instituteId);
			} 
			else { 
				studMentr = smRepo.getListStudMentor(facultyId, yearId, instituteId);
			 }
				 

		} catch (Exception e) {
			System.err.println("Exce in getStudentMentorList  " + e.getMessage());
			e.printStackTrace();

		}
		System.err.println("Mentor List" + studMentr);
		return studMentr;
	}
	@RequestMapping(value= {"/editFacultyMentoringDetailsById"}, method=RequestMethod.POST)
	public @ResponseBody StudentMentoring getFacultyMentor(@RequestParam("mId") int mId){
		
		return studmentrepo.findByMenIdAndDelStatus(mId, 1);
	}
	
	@RequestMapping(value= {"/deleteFacultyMentoringDetailsById"}, method=RequestMethod.POST)
	public @ResponseBody Info deleteFacultyMentor(@RequestParam("mId") int mId){
		
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
	
		
	@RequestMapping(value = { "/delSlectedStudMentor"}, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstLinkages(@RequestParam List<String> menIdList) {

		Info info = new Info();
		try {
			int res = studmentrepo.deleteSelStudMentor(menIdList);

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
	
	/*************************************Faculty Conference**********************************/
	
	@RequestMapping(value= {"/insertNewFacConference"}, method=RequestMethod.POST)
	public @ResponseBody FacultyConference insertFacultyConfrence(@RequestBody FacultyConference facConf){
		
		return facconRepo.save(facConf);
		
	}
	
	@RequestMapping(value= {"/getfacultyConferenceByFacId"}, method=RequestMethod.POST)
	public @ResponseBody List<FacultyConferenceList> getFacultyConfList(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId){
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
		//		+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);
		
		List<FacultyConferenceList> facConfList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				facConfList = fConRepo.getJouByYear(yearId, instituteId);
			} else if (isHod == 1) {
				facConfList = fConRepo.getJournalByDept(deptIdList, yearId, instituteId);
			} else {
				facConfList = fConRepo.getJournalRepo(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		
		
		return facConfList;
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
	
	@RequestMapping(value = { "/delPubicationDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info delPubicationDetails(@RequestParam List<String> confIdList) {

		Info info = new Info();
		try {
			int res = facconRepo.deletePubDetails(confIdList);

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
	
	
	/***************************************Book Publication************************************/
	
	@RequestMapping(value= {"/savefacultyPubBook"}, method=RequestMethod.POST)
	public @ResponseBody FacultyBook insertBookPub(@RequestBody FacultyBook facBook){
		
		return bookpubrepo.save(facBook);
		
	}
	
	@RequestMapping(value= {"/getAllPublishedBooks"}, method=RequestMethod.POST)
	public @ResponseBody List<FacultyBookList> getPublishedBooks(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId){
		
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
		//		+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);

		List<FacultyBookList> fBookList = new ArrayList<>();
		

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				fBookList = facBookRepo.getJouByYear(yearId, instituteId);
			} else if (isHod == 1) {
				fBookList = facBookRepo.getJournalByDept(deptIdList, yearId, instituteId);
			} else {
				fBookList = facBookRepo.getJournalRepo(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return  fBookList;
		
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
	
	@RequestMapping(value = { "/delFacultyPubJournals" }, method = RequestMethod.POST)
	public @ResponseBody Info delFacultyPubJournals(@RequestParam List<String> bookIdsList) {

		Info info = new Info();
		try {
			int res = bookpubrepo.delPubJournals(bookIdsList);

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
	
	
	/***************************************************Facultity Activity**************************************************/
	
	@RequestMapping(value= {"/insertFacultyActivity"}, method=RequestMethod.POST)
	public @ResponseBody FacultyActivity insertFacActivity(@RequestBody FacultyActivity facAct){
		
		return facAcRepo.save(facAct);
		
	}
	
	@RequestMapping(value= {"/getAllActivityById"}, method=RequestMethod.POST)
	public @ResponseBody List<OrganizedList> getAllActivities(@RequestParam("facId") int facId, @RequestParam("yrId") int yrId ){
		
		return showOrgnRep.getOrganizedDetailList(facId, yrId, 1);
		
	}
	
	@RequestMapping(value= {"/getFacActivityByActvId"}, method=RequestMethod.POST)
	public @ResponseBody FacultyActivity getActivitiesById(@RequestParam("facActivityId") int facActivityId){
		
		return facAcRepo.findByActivityIdAndDelStatus(facActivityId, 1);
		
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
	
	@RequestMapping(value = { "/deleteOrgActivity" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteOrgActivity(@RequestParam List<String> activityIdList) {

		Info info = new Info();
		try {
			int res = facAcRepo.delOrgActivity(activityIdList);

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
	
	/**********************************Faculty Contribution*************************************************/
	
	@RequestMapping(value= {"/saveOutReachContri"}, method=RequestMethod.POST)
	public @ResponseBody FacultyContribution insertOutReachContri(@RequestBody FacultyContribution facCon){
		
		return facContriRepo.save(facCon);
		
	}
	
	@RequestMapping(value= {"/getAllOutReachContri"}, method=RequestMethod.POST)
	public @ResponseBody List<FacultiContributionList> getAllOutReachContri(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		// System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
		//		+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);

		List<FacultiContributionList> facContriList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				facContriList = facContriListRepo.getJouByYear(yearId, instituteId);
			} else if (isHod == 1) {
				facContriList = facContriListRepo.getJournalByDept(deptIdList, yearId, instituteId);
			} else {
				facContriList = facContriListRepo.getJournalRepo(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getJournalListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return facContriList;
		
	}
	
	
	@RequestMapping(value= {"/getOutReachContriById"}, method=RequestMethod.POST)
	public @ResponseBody FacultyContribution getOutReachContriById(@RequestParam("conId") int conId){
		
		return facContriRepo.findByConId(conId);
		
	}
	
	@RequestMapping(value= {"/deleteReachContriById"}, method=RequestMethod.POST)
	public @ResponseBody Info deleteReachContriById(@RequestParam("conId") int conId){
		
		
		int isDelete=0;
		 isDelete = facContriRepo.deleteFContributionByconId(conId);
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
	
	@RequestMapping(value = { "/deleteOutReachContiList" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteOutReachContiList(@RequestParam List<String> facContIdsList) {

		Info info = new Info();
		try {
			int res = facContriRepo.deleteOutReachContributn(facContIdsList);

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
	
	/***************************************Faculty Phd Guide*******************************************/
	
	@RequestMapping(value= {"/insertPhdGuide"}, method=RequestMethod.POST)
	public @ResponseBody FacultyPhdGuide insertPhdGuide(@RequestBody FacultyPhdGuide phd){
		
		return fphdrepo.save(phd);
		
	}
	
	@RequestMapping(value= {"/getAllPhdGuid"}, method=RequestMethod.POST)
	public @ResponseBody List<PhdGuidList> getAllPhdGuid(@RequestParam("facId") int facId, @RequestParam("yrId") int yrId ){
		
		return phdListRepo.findByFacultyIdAndYearIdAndDelStatusOrderByPhdIdDesc(facId, yrId, 1);
		
	}
	

	@RequestMapping(value= {"/getPhdGuideById"}, method=RequestMethod.POST)
	public @ResponseBody FacultyPhdGuide getPhdGuideById(@RequestParam("phdId") int phdId){
		
		return fphdrepo.findByPhdId(phdId);
		
	}
	
	@RequestMapping(value= {"/deletePhdGuideById"}, method=RequestMethod.POST)
	public @ResponseBody Info deletePhdGuideById(@RequestParam("phdId") int phdId){
		
		
		int isDelete=0;
		 isDelete = fphdrepo.deletePhdGuideByPhdId(phdId);
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
	
	@RequestMapping(value = { "/deletePhdGuidList" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePhdGuidList(@RequestParam List<String> phdIdsList) {

		Info info = new Info();
		try {
			int res = fphdrepo.delPhds(phdIdsList);

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
}
