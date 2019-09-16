package com.ats.rusasoftapi.controller;

import java.util.ArrayList;
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
import com.ats.rusasoftapi.model.AcademicYear;
import com.ats.rusasoftapi.model.GetInstituteInfo;
import com.ats.rusasoftapi.model.GetLib;
import com.ats.rusasoftapi.model.GetStudentDetail;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.InstituteInfo;
import com.ats.rusasoftapi.model.LibBookPurchase;
import com.ats.rusasoftapi.model.Librarian;
import com.ats.rusasoftapi.model.LibraryInfo;

import com.ats.rusasoftapi.model.RareBook;
import com.ats.rusasoftapi.model.Student;
import com.ats.rusasoftapi.model.UserLogin;
import com.ats.rusasoftapi.mstrepo.AcademicYearRepo;
import com.ats.rusasoftapi.mstrepo.GetInstituteInfoRepo;
import com.ats.rusasoftapi.mstrepo.GetLibRepo;
import com.ats.rusasoftapi.mstrepo.GetStudentDetailRepo;
import com.ats.rusasoftapi.mstrepo.InstituteInfoRepo;
import com.ats.rusasoftapi.mstrepo.LibrarianRepo;
import com.ats.rusasoftapi.mstrepo.StudentRepo;
import com.ats.rusasoftapi.mstrepo.UserService;
import com.ats.rusasoftapi.prodetailrepo.StudentSuppSchemeRepo;
import com.ats.rusasoftapi.repositories.LibBookPurchaseRepo;
import com.ats.rusasoftapi.repository.LibraryInfoRepo;

import com.ats.rusasoftapi.repository.RareBookRepo;

@RestController
public class LibraryApiController {
	@Autowired
	LibrarianRepo libRepo;

	@Autowired
	GetLibRepo getLibRepo;

	@Autowired
	UserService userRepo;

	@Autowired
	StudentRepo studRepo;

	@Autowired
	InstituteInfoRepo instInfoRepo;

	@Autowired
	GetInstituteInfoRepo getInstInfoRepo;
	
	@Autowired
	LibraryInfoRepo libInfoRepo;
	
	@Autowired
	RareBookRepo rarebookrepo;

	static String senderEmail ="techrusa1@gmail.com";// "atsinfosoft@gmail.com";
	static String senderPassword ="@Rusamah";// "atsinfosoft@123";
	static String mailsubject = " RUSA Software Login Credentials ";

	
	
	@RequestMapping(value = { "/saveLibrarian" }, method = RequestMethod.POST)
	public @ResponseBody Librarian saveLibrarian(@RequestBody Librarian librarian) {

		Librarian libResp = null;

		try {

			if (librarian.getLibrarianId() == 0) {
				libResp = libRepo.saveAndFlush(librarian);

				System.err.println("New librarian Insert  New Principal");
				String userName = Commons.getAlphaNumericString(7);
				UserLogin ul = new UserLogin();
				String pass = Commons.getAlphaNumericString(7);
				System.err.println("pass is " + pass);
				ul.setUserType(7);
				ul.setPass(pass);
				ul.setUserName(librarian.getEmail());
				ul.setIsBlock(1);
				ul.setRegPrimaryKey(libResp.getLibrarianId());
				ul.setRoleId(8);
				ul.setExInt1(1);
				ul.setExInt2(1);
				ul.setExVar1("NA");
				ul.setExVar2("NA");

				userRepo.saveAndFlush(ul);
				Info info = EmailUtility.sendEmail(senderEmail, senderPassword, libResp.getEmail(), mailsubject,
						libResp.getEmail(), ul.getPass());

				System.err.println("Info email sent response   " + info.toString());

				Info info1 = EmailUtility.sendMsg(ul.getUserName(), ul.getPass(), libResp.getContactNo());

				System.err.println("Info msg sent response   " + info1.toString());

			} else {
				libResp = libRepo.saveAndFlush(librarian);

			}

		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return librarian;

	}

	@RequestMapping(value = { "/getLibrarianByLibId" }, method = RequestMethod.POST)
	public @ResponseBody Librarian getLibrarianByLibId(@RequestParam int libId) {

		Librarian libResp = null;

		try {
			libResp = libRepo.findByLibrarianId(libId);

		} catch (Exception e) {
			System.err.println("Exce in getDept  " + e.getMessage());
			e.printStackTrace();

		}
		return libResp;
	}

	@RequestMapping(value = { "/getAllLibrarianByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<Librarian> getAllLibrarian(@RequestParam int instId) {

		List<Librarian> libResp = new ArrayList<>();

		try {
			libResp = libRepo.getAllLibList(instId);
			System.err.println("lib are" + libResp.toString());

		} catch (Exception e) {
			System.err.println("Exce in getAllLibrarian Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return libResp;

	}

	@RequestMapping(value = { "/getAllLibByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLib> getAllLibByInstituteId(@RequestParam int instId) {

		List<GetLib> libResp = new ArrayList<>();

		try {
			libResp = getLibRepo.getAllLibList(instId);
			System.err.println("lib are" + libResp.toString());

		} catch (Exception e) {
			System.err.println("Exce in getAllLibrarian Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return libResp;

	}

	@RequestMapping(value = { "/deleteLibrarians" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstitutes(@RequestParam List<String> libIdList) {

		Info info = new Info();
		try {
			int res = libRepo.deleteLibrarians(libIdList);

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

	//////////////////////////// ******Academic
	//////////////////////////// Year****************//////////////////////////////////

	@Autowired
	AcademicYearRepo yearRepo;

	@RequestMapping(value = { "/getAcademicYearListByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<AcademicYear> getQuolificationList(@RequestParam int type) {

		List<AcademicYear> yearList = new ArrayList<>();

		try {
			yearList = yearRepo.findByTypeAndDelStatusOrderByYearIdDesc(type, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllYearList  " + e.getMessage());
			e.printStackTrace();
		}

		return yearList;

	}
	

	@RequestMapping(value = { "/getAcademicYearByIsCurrent" }, method = RequestMethod.POST)
	public @ResponseBody AcademicYear getAcademicYearByIsClosed(@RequestParam int isCurrent) {

		AcademicYear yearList = new AcademicYear();

		try {
			yearList = yearRepo.findByIsCurrentAndDelStatus(isCurrent, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAcademicYearByYearId is current " + e.getMessage());
			e.printStackTrace();
		}

		return yearList;

	}

	
	
	
	@RequestMapping(value = { "/getAcademicYearByYearId" }, method = RequestMethod.POST)
	public @ResponseBody AcademicYear getAcademicYearByYearId(@RequestParam int yearId) {

		AcademicYear yearList = new AcademicYear();

		try {
			yearList = yearRepo.findByYearIdAndDelStatus(yearId, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAcademicYearByYearId  " + e.getMessage());
			e.printStackTrace();
		}

		return yearList;

	}

	/////////////////////////////////////// **********student**********************//////////////////////////////////

	@RequestMapping(value = { "/saveStudent" }, method = RequestMethod.POST)
	public @ResponseBody Student saveStudent(@RequestBody Student student) {

		Student studResp = null;

		try {

			if (student.getStudentId() == 0) {
				studResp = studRepo.saveAndFlush(student);

				System.err.println("New Student Insert  New User");
				/*String userName = Commons.getAlphaNumericString(7);
				UserLogin ul = new UserLogin();
				String pass = Commons.getAlphaNumericString(7);
				System.err.println("pass is " + pass);
				ul.setUserType(8);
				ul.setPass(pass);
				ul.setUserName(student.getEmail());
				ul.setIsBlock(1);
				ul.setRegPrimaryKey(studResp.getStudentId());
				ul.setRoleId(9);
				ul.setExInt1(1);
				ul.setExInt2(1);
				ul.setExVar1("NA");
				ul.setExVar2("NA");

				userRepo.saveAndFlush(ul);*/

				//Info info = EmailUtility.sendEmail(senderEmail, senderPassword, studResp.getEmail(), mailsubject,
						//studResp.getEmail(), ul.getPass());

				//System.err.println("Info email sent response   " + info.toString());

				// Info info1=EmailUtility.sendMsg(ul.getUserName(), ul.getPass(),
				// libResp.getContactNo());

				//Info info1 = EmailUtility.sendMsg(studResp.getEmail(), ul.getPass(), studResp.getContactNo());

				//.err.println("Info email sent response   " + info1.toString());

			} else {
				studResp = studRepo.saveAndFlush(student);

			}

		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return student;

	}

	@RequestMapping(value = { "/getStudentByStudentId" }, method = RequestMethod.POST)
	public @ResponseBody Student getStudentByStudentId(@RequestParam int studId) {

		Student libResp = null;

		try {
			libResp = studRepo.findByStudentId(studId);

		} catch (Exception e) {
			System.err.println("Exce in getDept  " + e.getMessage());
			e.printStackTrace();

		}
		return libResp;
	}

	@Autowired
	GetStudentDetailRepo studDetailRepo;

	@RequestMapping(value = { "/getAllStudentByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStudentDetail> getAllStudentByInstituteId(@RequestParam int instituteId) {
		System.err.println("Student list is" + instituteId);
		List<GetStudentDetail> libResp = new ArrayList<>();

		try {
			libResp = studDetailRepo.getAllStudentList1(instituteId);
			System.err.println("Student list in api  are" + libResp.toString());

		} catch (Exception e) {
			System.err.println("Exce in getAllLibrarian Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return libResp;

	}

	@RequestMapping(value = { "/deleteStudents" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteStudents(@RequestParam List<String> studIdList) {

		Info info = new Info();
		try {
			int res = studRepo.deleteStudents(studIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in getAllStudents Students " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	/////////////////////////////////////// **********Institute
	/////////////////////////////////////// Info**********************////////////////////////////////

	@RequestMapping(value = { "/saveInstituteInfo" }, method = RequestMethod.POST)
	public @ResponseBody InstituteInfo saveInstituteInfo(@RequestBody InstituteInfo instInfo) {

		InstituteInfo instResp = null;

		try {

			instResp = instInfoRepo.saveAndFlush(instInfo);

		} catch (Exception e) {
			System.err.println("Exce in saving InstituteInfo " + e.getMessage());
			e.printStackTrace();
		}

		return instInfo;

	}

	@RequestMapping(value = { "/getInstituteInfoByInfoDetailId" }, method = RequestMethod.POST)
	public @ResponseBody InstituteInfo getInfoByByInfoDetailId(@RequestParam int infoDetailId) {

		InstituteInfo libResp = null;

		try {
			libResp = instInfoRepo.findByInfoDetailId(infoDetailId);

		} catch (Exception e) {
			System.err.println("Exce in getInfoByByInfoDetailId  " + e.getMessage());
			e.printStackTrace();

		}
		return libResp;
	}

	@RequestMapping(value = { "/getAllInstituteInfoByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetInstituteInfo> getAllInstituteInfoByInstituteId(@RequestParam int instituteId, @RequestParam int acadmicYear) {
		System.err.println("Inst list is" + instituteId);
		List<GetInstituteInfo> libResp = new ArrayList<>();

		try {
			libResp = getInstInfoRepo.getAllInstituteList(instituteId, acadmicYear);
			System.err.println("lib are" + libResp.toString());

		} catch (Exception e) {
			System.err.println("Exce in getAllInstituteList1 Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return libResp;

	}

	@RequestMapping(value = { "/deleteInstituteInfo" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstituteInfo(@RequestParam List<String> instIdList) {

		Info info = new Info();
		try {
			int res = instInfoRepo.deleteInstitutes(instIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteInstituteInfo  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@Autowired
	StudentSuppSchemeRepo studentSuppSchemeRepo;

	@RequestMapping(value = { "/deleteStudentSchemesRecordById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteStudentSchemesRecordById(@RequestParam List<String> id) {

		Info info = new Info();
		try {
			int res = studentSuppSchemeRepo.deleteSchemes(id);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteStudentSchemesRecordById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	
	/**************************************************************************************************/
	@RequestMapping(value = { "/insertlibBasicInfo" }, method = RequestMethod.POST)
	public @ResponseBody LibraryInfo saveLibBasicInfo(@RequestBody LibraryInfo libInfo) {
		LibraryInfo lib = null;
		try {
			lib =  libInfoRepo.save(libInfo);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return lib;
	}
	
	@RequestMapping(value = { "/libBasicInfoList" }, method = RequestMethod.POST)
	public @ResponseBody List<LibraryInfo> showLibBasicInfo(@RequestParam int instituteId) {
		
		List<LibraryInfo> libList = null;
		try {
			libList = libInfoRepo.findByInstituteIdAndDelStatusOrderByLibInfoIdDesc(instituteId, 1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return libList;
	}
	
	@RequestMapping(value = { "/getlibBasicInfo" }, method = RequestMethod.POST)
	public @ResponseBody LibraryInfo getlibBasicInfo(@RequestParam int instituteId, @RequestParam int acadYear) {
		
		LibraryInfo lib = null;
	
		try {
			
			lib = libInfoRepo.findByInstituteIdAndAcYearIdAndDelStatus(instituteId, acadYear, 1);
			
		    if(lib==null){ 
				    
				    	 //System.err.println("null found");				    		 		    	
				    	
				    	  lib = libInfoRepo.getLastYerRecord(instituteId);
				    		
				    		lib.setLibInfoId(0);
				    		lib.setUsersOfLms(0);
				    		lib.setAvgStudent(0);
				    		lib.setAvgTeacher(0);
				    		lib.setNoCompLan(0);
				    		lib.setExInt1(0);
				    		lib.setExVar1(null);		
				     }
		   
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lib;
	}
	
	
	
	@RequestMapping(value = { "/editlibBasicInfoById" }, method = RequestMethod.POST)
	public @ResponseBody LibraryInfo editlibBasicInfoById(@RequestParam int libInfoId) {
		
		LibraryInfo editLib = null;
		try {
			
		     editLib = libInfoRepo.findByLibInfoId(libInfoId);
		     
		}catch(Exception e) {
			e.printStackTrace();
		}
		return editLib;
	}
	
	@RequestMapping(value = { "/deletelibBasicInfoById" }, method = RequestMethod.POST)
	public @ResponseBody Info deletelibBasicInfoById(@RequestParam int libInfoId) {
		
		Info info = new Info();
		try {
			int res = libInfoRepo. deleteLibraryBasicInfoById(libInfoId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deletelibBasicInfoById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	
		
	}
	
	@RequestMapping(value = { "/deleteSelLib" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelLib(@RequestParam List<String> libIdList) {

		Info info = new Info();
		try {
			int res = libInfoRepo.deleteLibInfo(libIdList);

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
	
	/**************************************************************************************************/
	
	@RequestMapping(value = { "/saveRareBook" }, method = RequestMethod.POST)
	public @ResponseBody RareBook saveRareBook(@RequestBody RareBook rareBook) {
		RareBook rarBook = null;
		
		
		try {
			
			rarBook = rarebookrepo.save(rareBook);
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return rarBook;
	}
	
	@RequestMapping(value = { "/showRareBooksInfo" }, method = RequestMethod.POST)
	public @ResponseBody List<RareBook> showRareBooksInfo(@RequestParam int instituteId) {
		
		List<RareBook> bookList = null;
		try {
			bookList = rarebookrepo.findByInstituteIdAndDelStatusOrderByRareBookInfoIdDesc(instituteId, 1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookList;
	}
	
	@RequestMapping(value = { "/getRareBookById" }, method = RequestMethod.POST)
	public @ResponseBody RareBook getRareBookById(@RequestParam int bookId) {
		
		RareBook editBook = null;
		try {
			
			editBook = rarebookrepo.findByRareBookInfoId(bookId);
		     
		}catch(Exception e) {
			e.printStackTrace();
		}
		return editBook;
	}
	
	@RequestMapping(value = { "/deleteRareBookById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRareBookById(@RequestParam int bookId) {
		
		Info info = new Info();
		try {
			int res = rarebookrepo.deleteRareBookInfoById(bookId);

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
	
	@RequestMapping(value = { "/deleteSelRareBooks" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelRareBooks(@RequestParam List<String> rareBookIdList) {

		Info info = new Info();
		try {
			int res = rarebookrepo.deleteRareBooks(rareBookIdList);

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
	
	@RequestMapping(value = { "/newLibBookPurchase" }, method = RequestMethod.POST)
	public @ResponseBody LibBookPurchase newLibBookPurchase(@RequestBody LibBookPurchase lib) {
		LibBookPurchase libBook = null;
		
		System.err.println(lib.toString());
		try {
			
			libBook = libBookRepo.save(lib);
		
		
		  }catch(Exception e) { 
		  System.err.println("ex "+e.getMessage());
		  e.printStackTrace();
		  }
		
		return libBook;
	}
	
	
	@RequestMapping(value = { "/showPurchsaeBooksList" }, method = RequestMethod.POST)
	public @ResponseBody List<LibBookPurchase> showLibBooks(@RequestParam int instituteId, @RequestParam int acadYear) {
		
		List<LibBookPurchase> bookList = null;
		try {
			bookList = libBookRepo.findByDelStatusAndInstituteIdAndAcademicYridOrderByBookPurchaseIdDesc(1,instituteId,acadYear);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookList;
	}
	
	
	@RequestMapping(value = { "/getLibBookById" }, method = RequestMethod.POST)
	public @ResponseBody LibBookPurchase editLibBooks(@RequestParam int bookId) {
		
		LibBookPurchase bookInfo = null;
		try {
			bookInfo = libBookRepo.findByBookPurchaseIdAndDelStatus(bookId, 1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookInfo;
	}
	
	
	@RequestMapping(value = { "/deleteLibBookById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLibBookById(@RequestParam int bookId) {
		
		Info info = new Info();
		try {
			int res = libBookRepo.deletePurchasedBookInfoById(bookId);

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
	LibBookPurchaseRepo libBookRepo;


	@RequestMapping(value = { "/deleteSelPurchasedBooks" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelPurchasedBooks(@RequestParam List<String> libBookIdList) {

		Info info = new Info();
		try {
			int res = libBookRepo.deleteLibInfo(libBookIdList);

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
