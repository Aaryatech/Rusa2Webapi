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

import com.ats.rusasoftapi.model.GovtScholarships;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.NewCourseInfo;
import com.ats.rusasoftapi.model.NewCourseInfoList;
import com.ats.rusasoftapi.model.Program;
import com.ats.rusasoftapi.model.progdetail.AlumniAssocAct;
import com.ats.rusasoftapi.model.progdetail.AlumniDetail;
import com.ats.rusasoftapi.model.progdetail.Cast;
import com.ats.rusasoftapi.model.progdetail.DifrentlyAbledStud;
import com.ats.rusasoftapi.model.progdetail.DifrentlyAbledStudList;
import com.ats.rusasoftapi.model.progdetail.FieldProjectsIntern;
import com.ats.rusasoftapi.model.progdetail.FieldProjectsInternList;
import com.ats.rusasoftapi.model.progdetail.GetAlumni;
import com.ats.rusasoftapi.model.progdetail.GetHigherEduDetail;
import com.ats.rusasoftapi.model.progdetail.GetStudAdmCatwise;
import com.ats.rusasoftapi.model.progdetail.GetStudAdmCatwiseGrpByProg;
import com.ats.rusasoftapi.model.progdetail.GetStudAdmLocwise;
import com.ats.rusasoftapi.model.progdetail.GetStudAdmLocwiseGrpByProg;
import com.ats.rusasoftapi.model.progdetail.GetTrainPlace;
import com.ats.rusasoftapi.model.progdetail.HigherEducDetail;
import com.ats.rusasoftapi.model.progdetail.Location;
import com.ats.rusasoftapi.model.progdetail.ProgSancIntake;
import com.ats.rusasoftapi.model.progdetail.ProgramType;
import com.ats.rusasoftapi.model.progdetail.RedressedStudGrievance;
import com.ats.rusasoftapi.model.progdetail.StudAdmCatwise;
import com.ats.rusasoftapi.model.progdetail.StudAdmLocwise;
import com.ats.rusasoftapi.model.progdetail.TrainPlacement;
import com.ats.rusasoftapi.model.progdetail.ValueAddedCourses;
import com.ats.rusasoftapi.prodetailrepo.AlumniDetailRepo;
import com.ats.rusasoftapi.prodetailrepo.CastRepo;
import com.ats.rusasoftapi.prodetailrepo.DifrentlyAbledStudListRepo;
import com.ats.rusasoftapi.prodetailrepo.DifrentlyAbledStudRepo;
import com.ats.rusasoftapi.prodetailrepo.FieldProjectsInternListRepo;
import com.ats.rusasoftapi.prodetailrepo.FieldProjectsInternRepo;
import com.ats.rusasoftapi.prodetailrepo.GetAlumniRepo;
import com.ats.rusasoftapi.prodetailrepo.GetHigherEduDetailRepo;
import com.ats.rusasoftapi.prodetailrepo.GetStudAdmCatwiseGrpByProgRepo;
import com.ats.rusasoftapi.prodetailrepo.GetStudAdmCatwiseRepo;
import com.ats.rusasoftapi.prodetailrepo.GetStudAdmLocwiseGrpByProgRepo;
import com.ats.rusasoftapi.prodetailrepo.GetStudAdmLocwiseRepo;
import com.ats.rusasoftapi.prodetailrepo.GetTrainPlaceRepo;
import com.ats.rusasoftapi.prodetailrepo.HigherEducDetailRepo;
import com.ats.rusasoftapi.prodetailrepo.LocationRepo;
import com.ats.rusasoftapi.prodetailrepo.NewCourseInfoListRepo;
import com.ats.rusasoftapi.prodetailrepo.NewCourseInfoRepo;
import com.ats.rusasoftapi.prodetailrepo.ProgSancIntakeRepo;
import com.ats.rusasoftapi.prodetailrepo.ProgramTypeRepo;
import com.ats.rusasoftapi.prodetailrepo.RedressedStudGrievanceRepo;
import com.ats.rusasoftapi.prodetailrepo.StudAdmCatwiseRepo;
import com.ats.rusasoftapi.prodetailrepo.StudAdmLocwiseRepo;
import com.ats.rusasoftapi.prodetailrepo.TrainPlacementRepo;
import com.ats.rusasoftapi.prodetailrepo.ValueAddedCoursesRepo;
import com.ats.rusasoftapi.repository.AlumniAssocActRepo;
import com.ats.rusasoftapi.repository.ProgramRepository;

@RestController
public class ProgDetailControllerSac {

	@Autowired
	ProgramTypeRepo programTypeRepo;

	@RequestMapping(value = { "/getAllProgramType" }, method = RequestMethod.GET)
	public @ResponseBody List<ProgramType> getAllProgramType() {

		List<ProgramType> progTypeList = new ArrayList<>();

		try {
		progTypeList = programTypeRepo.findByDelStatusAndIsActiveAndSequenceNotIn(1	, 1, "0");	

		} catch (Exception e) {
			System.err.println("Exce in getAllProgramType  " + e.getMessage());
			e.printStackTrace();
		}

		return progTypeList;

	}

	// getHigherProg

	@RequestMapping(value = { "/getHigherProgList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgramType> getHigherProgList(@RequestParam int progTypeId) {

		List<ProgramType> progTypeList = new ArrayList<>();

		try {

			progTypeList = programTypeRepo.getHigherProg(progTypeId);

		} catch (Exception e) {
			System.err.println("Exce in getHigherProgList  " + e.getMessage());
			e.printStackTrace();
		}

		return progTypeList;

	}

	@Autowired
	CastRepo castRepo;

	@RequestMapping(value = { "/getAllCastCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<Cast> getAllCastCategory() {

		List<Cast> castList = new ArrayList<>();

		try {
			castList = castRepo.findByDelStatusAndIsActiveOrderByCastIdDesc(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllCastCategory  " + e.getMessage());
			e.printStackTrace();
		}

		return castList;

	}
	
	
	@RequestMapping(value = { "/getCastCategoryById" }, method = RequestMethod.GET)
	public @ResponseBody Cast getCastCategoryById(@RequestParam int castId) {

		Cast cast = new Cast();

		try {
			cast = castRepo.findByDelStatusAndIsActiveAndCastId(1 , 1, castId);
		} catch (Exception e) {
			System.err.println("Exce in getCastCategoryById  " + e.getMessage());
			e.printStackTrace();
		}

		return cast;

	}

	@Autowired
	LocationRepo locRepo;

	@RequestMapping(value = { "/getAllLocation" }, method = RequestMethod.GET)
	public @ResponseBody List<Location> getAllLocation() {

		List<Location> locList = new ArrayList<>();

		try {
			locList = locRepo.findByDelStatusAndIsActive(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllLocation  " + e.getMessage());
			e.printStackTrace();
		}

		return locList;

	}

	@Autowired
	StudAdmCatwiseRepo studAdmCatwiseRepo;

	@RequestMapping(value = { "/saveStudentAdmCatwise" }, method = RequestMethod.POST)
	public @ResponseBody List<StudAdmCatwise> saveStudentAdmCatwise(@RequestBody List<StudAdmCatwise> studAdmCatList) {

		List<StudAdmCatwise> resList = new ArrayList<>();

		try {
			resList = studAdmCatwiseRepo.saveAll(studAdmCatList);

		} catch (Exception e) {
			System.err.println("Exce in saveStudentAdmCatwise  " + e.getMessage());
			e.printStackTrace();
		}
		return resList;
	}

	@Autowired
	GetStudAdmCatwiseRepo getStudAdmCatwiseRepo;

	@RequestMapping(value = { "/getStudAdmCatwiseList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStudAdmCatwise> getStudAdmCatwiseList(@RequestParam int instId,
			@RequestParam int yearId) {

		List<GetStudAdmCatwise> studAdmCatList = new ArrayList<>();

		try {

			studAdmCatList = getStudAdmCatwiseRepo.getStudAdmCatwise(instId, yearId);
		} catch (Exception e) {
			System.err.println("Exce in getStudAdmCatwiseList  " + e.getMessage());
			e.printStackTrace();
		}

		return studAdmCatList;

	}
	//For ajax.onload of selected prog type 18 Apr.
	@RequestMapping(value = { "/getStudAdmCatwiseByProgType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStudAdmCatwise> getStudAdmCatwiseByProgType(@RequestParam int instId,
			@RequestParam int yearId,@RequestParam int progType) {

		List<GetStudAdmCatwise> studAdmCatList = new ArrayList<>();

		try {

			studAdmCatList = getStudAdmCatwiseRepo.getStudAdmCatwiseByProgType(instId, yearId, progType);
		} catch (Exception e) {
			System.err.println("Exce in getStudAdmCatwiseList  " + e.getMessage());
			e.printStackTrace();
		}

		return studAdmCatList;

	}
	
	
	
	
	//For ajax.onload of selected prog type 19 Apr.
		@RequestMapping(value = { "/getStudAdmLocwiseByProgType" }, method = RequestMethod.POST)
		public @ResponseBody List<GetStudAdmLocwise> getStudAdmLocwiseByProgType(@RequestParam int instId,
				@RequestParam int yearId,@RequestParam int progType) {

			List<GetStudAdmLocwise> studAdmCatList = new ArrayList<>();

			try {

				studAdmCatList = getStudAdmLocwiseRepo.getStudAdmLocwiseByProgType(instId, yearId, progType);
				
			} catch (Exception e) {
				System.err.println("Exce in getStudAdmLocwiseByProgType  " + e.getMessage());
				e.printStackTrace();
			}

			return studAdmCatList;

		}
		
	
	//18/Apr  For List page..
	@Autowired GetStudAdmCatwiseGrpByProgRepo getStudAdmCatwiseGrpByProgRepo;
	@RequestMapping(value = { "/getStudAdmCatwiseGrpByProgType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStudAdmCatwiseGrpByProg> getStudAdmCatwiseGrpByProgType(@RequestParam int instId,
			@RequestParam int yearId) {

		List<GetStudAdmCatwiseGrpByProg> studAdmCatList = new ArrayList<>();

		try {

			studAdmCatList = getStudAdmCatwiseGrpByProgRepo.getStudAdmCatwiseGrpByProg(instId, yearId);
		} catch (Exception e) {
			System.err.println("Exce in getStudAdmCatwiseList  " + e.getMessage());
			e.printStackTrace();
		}

		return studAdmCatList;

	}
	
	//19 Apr For List Page
	@Autowired GetStudAdmLocwiseGrpByProgRepo getStudAdmLocwiseGrpByProgRepo;
	@RequestMapping(value = { "/getStudAdmLocwiseGrpByProgType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStudAdmLocwiseGrpByProg> getStudAdmLocwiseGrpByProgType(@RequestParam int instId,
			@RequestParam int yearId) {

		List<GetStudAdmLocwiseGrpByProg> studAdmCatList = new ArrayList<>();

		try {

			studAdmCatList = getStudAdmLocwiseGrpByProgRepo.getStudAdmLocwiseGrpByProg(instId, yearId);
		} catch (Exception e) {
			System.err.println("Exce in getStudAdmCatwiseList  " + e.getMessage());
			e.printStackTrace();
		}

		return studAdmCatList;

	}
	

	@Autowired
	StudAdmLocwiseRepo studAdmLocwiseRepo;

	@RequestMapping(value = { "/saveStudentAdmLocwise" }, method = RequestMethod.POST)
	public @ResponseBody List<StudAdmLocwise> saveStudentAdmLocwise(@RequestBody List<StudAdmLocwise> studAdmLocList) {

		List<StudAdmLocwise> resList = new ArrayList<>();

		try {
			resList = studAdmLocwiseRepo.saveAll(studAdmLocList);

		} catch (Exception e) {
			System.err.println("Exce in saveStudentAdmLocwise  " + e.getMessage());
			e.printStackTrace();
		}

		return resList;

	}

	@Autowired
	GetStudAdmLocwiseRepo getStudAdmLocwiseRepo;

	@RequestMapping(value = { "/getStudAdmLocwiseList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStudAdmLocwise> getStudAdmLocwiseList(@RequestParam int instId,
			@RequestParam int yearId) {

		List<GetStudAdmLocwise> studAdmLocList = new ArrayList<>();

		try {

			studAdmLocList = getStudAdmLocwiseRepo.getStudAdmLocwise(instId, yearId);
		} catch (Exception e) {
			System.err.println("Exce in getStudAdmLocwiseList  " + e.getMessage());
			e.printStackTrace();
		}

		return studAdmLocList;

	}

	@Autowired
	AlumniDetailRepo alumniDetailRepo;

	@RequestMapping(value = { "/saveAlumni" }, method = RequestMethod.POST)
	public @ResponseBody AlumniDetail saveAlumni(@RequestBody AlumniDetail alDetail) {

		AlumniDetail almDetail = new AlumniDetail();

		try {

			almDetail = alumniDetailRepo.save(alDetail);

		} catch (Exception e) {
			System.err.println("Exce in saveAlumni  " + e.getMessage());
			e.printStackTrace();
		}

		return almDetail;

	}

	@Autowired
	GetAlumniRepo getAlumniRepo;

	@RequestMapping(value = { "/getAlumniList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAlumni> getAlumniList(@RequestParam int instId, @RequestParam int yearId) {

		List<GetAlumni> almDetail = new ArrayList<>();

		try {

			almDetail = getAlumniRepo.getGetAlumniByInstAndYearId(instId, yearId);
		} catch (Exception e) {
			System.err.println("Exce in saveAlumni  " + e.getMessage());
			e.printStackTrace();
		}

		return almDetail;

	}

	@RequestMapping(value = { "/getAlumni" }, method = RequestMethod.POST)
	public @ResponseBody AlumniDetail getAlumni(@RequestParam int alumniId) {

		AlumniDetail almDetail = new AlumniDetail();

		try {

			almDetail = alumniDetailRepo.findByAlumniDetailIdAndDelStatusAndIsActive(alumniId, 1, 1);
		} catch (Exception e) {
			System.err.println("Exce in getAlumni  " + e.getMessage());
			e.printStackTrace();
		}

		return almDetail;

	}

	// deleteAccOfficers
	@RequestMapping(value = { "/deleteAlumni" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAlumni(@RequestParam List<String> alumniIds) {

		Info info = new Info();
		try {
			int res = alumniDetailRepo.deleteAlumniIds(alumniIds);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteAlumni  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	// Trainint And Placement

	@Autowired
	TrainPlacementRepo trainPlacementRepo;

	@RequestMapping(value = { "/saveTrainPlacement" }, method = RequestMethod.POST)
	public @ResponseBody TrainPlacement saveTrainPlacement(@RequestBody TrainPlacement tranPlace) {

		TrainPlacement placementRes = new TrainPlacement();

		try {

			placementRes = trainPlacementRepo.save(tranPlace);

		} catch (Exception e) {
			System.err.println("Exce in saveTrainPlacement  " + e.getMessage());
			e.printStackTrace();
		}

		return placementRes;

	}

	@RequestMapping(value = { "/getTrainPlacement" }, method = RequestMethod.POST)
	public @ResponseBody TrainPlacement getTrainPlacement(@RequestParam int placementId) {

		TrainPlacement trainPlace = new TrainPlacement();

		try {

			trainPlace = trainPlacementRepo.findByPlacementIdAndDelStatusAndIsActive(placementId, 1, 1);
		} catch (Exception e) {
			System.err.println("Exce in getTrainPlacement  " + e.getMessage());
			e.printStackTrace();
		}

		return trainPlace;

	}

	@RequestMapping(value = { "/deleteTrainPlacement" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteTrainPlacement(@RequestParam List<String> placementIds) {

		Info info = new Info();
		try {
			int res = trainPlacementRepo.deleteTrainPlace(placementIds);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteTrainPlacement " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	@Autowired
	GetTrainPlaceRepo getTrainPlaceRepo;

	@RequestMapping(value = { "/getGetTrainPlaceList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTrainPlace> getGetTrainPlaceList(@RequestParam int instId, @RequestParam int yearId) {

		List<GetTrainPlace> almDetail = new ArrayList<>();

		try {

			almDetail = getTrainPlaceRepo.getGetTrainPlace(instId, yearId);
		} catch (Exception e) {
			System.err.println("Exce in getGetTrainPlaceList  " + e.getMessage());
			e.printStackTrace();
		}

		return almDetail;

	}

	// HigherEducDetail Proceed

	@Autowired
	HigherEducDetailRepo higherEducDetailRepo;

	@RequestMapping(value = { "/saveHigherEducDetail" }, method = RequestMethod.POST)
	public @ResponseBody HigherEducDetail saveHigherEducDetail(@RequestBody HigherEducDetail higherEdu) {

		HigherEducDetail highEduDet = new HigherEducDetail();

		try {

			highEduDet = higherEducDetailRepo.save(higherEdu);

		} catch (Exception e) {
			System.err.println("Exce in saveHigherEducDetail  " + e.getMessage());
			e.printStackTrace();
		}

		return highEduDet;

	}

	@RequestMapping(value = { "/getHigherEduDetailByAcdYr" }, method = RequestMethod.POST)
	public @ResponseBody HigherEducDetail getHigherEduDetailByAcdYr(@RequestParam int instId,
			@RequestParam int yearId) {

		HigherEducDetail highEd = new HigherEducDetail();

		try {

			highEd = higherEducDetailRepo.findByInstituteIdAndYearIdAndDelStatus(instId, yearId, 1);
			
		} catch (Exception e) {
			System.err.println("Exce in getHigherEduDetailByAcdYr  " + e.getMessage());
			e.printStackTrace();
		}

		return highEd;

	}
	@RequestMapping(value = { "/getHigherEducDetail" }, method = RequestMethod.POST)
	public @ResponseBody HigherEducDetail getHigherEducDetail(@RequestParam int eduDetailId) {

		HigherEducDetail highEduRes = new HigherEducDetail();

		try {

			highEduRes = higherEducDetailRepo.findByEducationDetailId(eduDetailId);
		} catch (Exception e) {
			System.err.println("Exce in getHigherEducDetail  " + e.getMessage());
			e.printStackTrace();
		}

		return highEduRes;

	}

	@RequestMapping(value = { "/deleteHigherEducDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteHigherEducDetail(@RequestParam List<String> educationDetailIds) {

		Info info = new Info();
		try {
			int res = higherEducDetailRepo.deleteAlumniIds(educationDetailIds);
			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteHigherEducDetail " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}

	// GetHigherEduDetailRepo

	@Autowired
	GetHigherEduDetailRepo getHigherEduDetailRepo;

	@RequestMapping(value = { "/getHigherEduDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetHigherEduDetail> getHigherEduDetailList(@RequestParam int instId,
			@RequestParam int yearId) {

		List<GetHigherEduDetail> highEdList = new ArrayList<>();

		try {

			highEdList = getHigherEduDetailRepo.getHigherEduDetail(instId, yearId);
		} catch (Exception e) {
			System.err.println("Exce in getHigherEduDetailList  " + e.getMessage());
			e.printStackTrace();
		}

		return highEdList;

	}
	

	/***************************************Alumni Association Activity**********************************/
	
	@Autowired AlumniAssocActRepo almActRepo;
	
	@RequestMapping(value = { "/saveAlumniAssoAct" }, method = RequestMethod.POST)
	public @ResponseBody AlumniAssocAct saveIctEnabledFacility(@RequestBody AlumniAssocAct alumni) {
		AlumniAssocAct alm = null;
		try {

			alm = almActRepo.save(alumni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alm;
	}
	
	@RequestMapping(value = { "/getAlumniAssocActivitiesList" }, method = RequestMethod.POST)
	public @ResponseBody List<AlumniAssocAct> getAlumniAssocActivitiesList(@RequestParam("instituteId") int instituteId,@RequestParam("yId") int yId) {
		List<AlumniAssocAct> alm = new ArrayList<AlumniAssocAct>();
		try {
			alm=almActRepo.findByInstIdAndAcYearIdAndDelStatusOrderByAlmAssocActIdDesc(instituteId, yId, 1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alm;

	}
	

	@RequestMapping(value = { "/getAlumniAssocActByIds" }, method = RequestMethod.POST)
	public @ResponseBody AlumniAssocAct getAlumniAssocActByIds(@RequestParam("instituteId") int instituteId,@RequestParam("yId") int yId) {
		AlumniAssocAct alumni = new AlumniAssocAct();
		try {
			alumni=almActRepo.findLastRecordByInstIdAndAcYearId(instituteId, yId);
			if(alumni!=null) {
			alumni.setAlmAssocActId(0);
			alumni.setAlumniMeetngAgnda(null);
			alumni.setDateOfMeeting(null);
			alumni.setNoAlumniReg(0);
			alumni.setNoMemberAttended(0);
			alumni.setTtlNoAlumniEnrolled(0);
			}else {
				 alumni = new AlumniAssocAct();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alumni;

	}
	
	@RequestMapping(value = { "/editAlumniAssocActivityById" }, method = RequestMethod.POST)
	public @ResponseBody AlumniAssocAct editAlumniAssocActivityById(@RequestParam("almniActivityId") int almniActivityId) {
		AlumniAssocAct alm = new AlumniAssocAct();
		try {
			alm=almActRepo.findByAlmAssocActId(almniActivityId);
			
			// System.out.println(alm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alm;
		
	}
	
	@RequestMapping(value = { "/delAlumniAssocActivityById" }, method = RequestMethod.POST)
	public @ResponseBody Info delGovtScholrSchmById(@RequestParam("almniActivityId") int almniActivityId) {

		int isDelete = 0;
		isDelete = almActRepo.deleteAlmniActivity(almniActivityId);
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
	
	@RequestMapping(value = { "/deleteSelAlumni" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelAlumni(@RequestParam List<String> alumniList) {

		Info info = new Info();
		try {
			int res = almActRepo.deleteSelAlumniAssoActivitys(alumniList);

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
	
	/***********************************New Course Information*********************************/
	@Autowired NewCourseInfoRepo courseRepo;
	
	@RequestMapping(value = { "/saveNewCourseInfo" }, method = RequestMethod.POST)
	public @ResponseBody NewCourseInfo saveNewCourseInfo(@RequestBody NewCourseInfo course) {
		NewCourseInfo crs = null;
		try {

			crs = courseRepo.save(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crs;
	}
	
	@RequestMapping(value = { "/getByCourseId" }, method = RequestMethod.POST)
	public @ResponseBody NewCourseInfo getByCourseId(@RequestParam("courseId") int courseId) {
		NewCourseInfo course = new NewCourseInfo();
		try {
			course=courseRepo.findByCourseId(courseId);
			
			// System.out.println(course);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return course;
		
	}
	
	
	@RequestMapping(value = { "/delCourseById" }, method = RequestMethod.POST)
	public @ResponseBody Info delCourseById(@RequestParam("courseId") int courseId) {

		int isDelete = 0;
		isDelete = courseRepo.deleteCourseInfo(courseId);
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
	
	@Autowired NewCourseInfoListRepo courseListRepo;
	@RequestMapping(value = { "/getAllNewCourseList" }, method = RequestMethod.POST)
	public @ResponseBody List<NewCourseInfoList> getAllNewCourseList(@RequestParam("instId") int instId,@RequestParam("yearId") int yearId) {
		List<NewCourseInfoList> crs = new ArrayList<NewCourseInfoList>();
		try {
			crs=courseListRepo.getAllByInstituteAndAcadmicYear(instId, yearId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return crs;

	}
	/***********************************Value Added Courses********************************/
	
@Autowired ValueAddedCoursesRepo valAddCourseRepo;
	
	@RequestMapping(value = { "/saveValueAddedCourse" }, method = RequestMethod.POST)
	public @ResponseBody ValueAddedCourses saveValAddCourse(@RequestBody ValueAddedCourses course) {
		ValueAddedCourses val = null;
		try {

			val = valAddCourseRepo.save(course);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
	
	@RequestMapping(value = { "/getValueAddedCurseList" }, method = RequestMethod.POST)
	public @ResponseBody List<ValueAddedCourses> getValueAddedCurseList(@RequestParam("instId") int instId,@RequestParam("yearId") int yearId) {
		List<ValueAddedCourses> val = new ArrayList<ValueAddedCourses>();
		try {
			val = valAddCourseRepo.findByInstIdAndAcademicYearIdAndDelStatusOrderByValueAddedCourseIdDesc(instId, yearId,1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return val;

	}
	
	@RequestMapping(value = { "/getValueAddedCourseById" }, method = RequestMethod.POST)
	public @ResponseBody ValueAddedCourses getValueAddedCourseById(@RequestParam("courseId") int courseId) {
		ValueAddedCourses val = new ValueAddedCourses();
		try {
			val = valAddCourseRepo.findByValueAddedCourseId(courseId);
			
			// System.out.println(val);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return val;
		
	}
	
	@RequestMapping(value = { "/deleteValueAddedCourse" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCourse(@RequestParam("courseId") int courseId) {

		int isDelete = 0;
		isDelete = valAddCourseRepo.deleteValueAddedCourse(courseId);
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
	
	/*******************************************************************/
	
	@Autowired FieldProjectsInternRepo fieldRepo;
	
	@RequestMapping(value = { "/saveFieldProjectsIntern" }, method = RequestMethod.POST)
	public @ResponseBody FieldProjectsIntern saveValAddCourse(@RequestBody FieldProjectsIntern field) {
		FieldProjectsIntern val = null;
		try {

			val = fieldRepo.save(field);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
	
	@RequestMapping(value = { "/getFieldProjectInternById" }, method = RequestMethod.POST)
	public @ResponseBody FieldProjectsIntern getFieldProjectInternById(@RequestParam("fieldId") int fieldId) {
		FieldProjectsIntern fld = new FieldProjectsIntern();
		try {
			fld = fieldRepo.findByFieldProjectInternId(fieldId);
			
			// System.out.println(fld);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fld;
		
	}
	
	@RequestMapping(value = { "/deleteFieldProjectById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteFieldProjectById(@RequestParam("fieldId") int fieldId) {

		int isDelete = 0;
		isDelete = fieldRepo.deleteInternProjectField(fieldId);
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
	
	@Autowired FieldProjectsInternListRepo fieldRepoList;
	@RequestMapping(value = { "/getProjectInternFieldList" }, method = RequestMethod.POST)
	public @ResponseBody List<FieldProjectsInternList> getProjectInternFieldList(@RequestParam("instId") int instId,@RequestParam("yearId") int yearId) {
		List<FieldProjectsInternList> fieldList = new ArrayList<FieldProjectsInternList>();
		try {
			fieldList = fieldRepoList.getAllByIntituteIdYrIdAndDelStatus(instId, yearId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fieldList;

	}
	
	/***************************Differently Abled_Student****************************/
	@Autowired DifrentlyAbledStudRepo difDisStudRepo;
	
	@RequestMapping(value = { "/saveDifferentlyDisabledStudent" }, method = RequestMethod.POST)
	public @ResponseBody DifrentlyAbledStud saveDifferentlyDisabledStudent(@RequestBody DifrentlyAbledStud stud) {
		DifrentlyAbledStud difstud = null;
		try {

			difstud = difDisStudRepo.save(stud);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return difstud;
	}
	
	@RequestMapping(value = { "/getDifferntDisabelStudentById" }, method = RequestMethod.POST)
	public @ResponseBody DifrentlyAbledStud getDifferntDisabelStudentById(@RequestParam("studId") int studId) {
		DifrentlyAbledStud stud = new DifrentlyAbledStud();
		try {
			stud = difDisStudRepo.findByDifAbleStudId(studId);
			
			// System.out.println(stud);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stud;
		
	}
	
	@RequestMapping(value = { "/deleteDifDisStudById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDifDisStudById(@RequestParam("studId") int studId) {

		int isDelete = 0;
		isDelete = difDisStudRepo.deleteDiferentlyDisabledStudent(studId);
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
	
	@Autowired DifrentlyAbledStudListRepo disStudList;
	@RequestMapping(value = { "/getAllDifferentlyDisableStudentsList" }, method = RequestMethod.POST)
	public @ResponseBody List<DifrentlyAbledStudList> getAllDifferentlyDisableStudentsList(@RequestParam("instId") int instId,@RequestParam("yearId") int yearId) {
		List<DifrentlyAbledStudList> disStud = new ArrayList<DifrentlyAbledStudList>();
		try {
			disStud = disStudList.getAllByIntituteIdYrIdAndDelStatus(instId, yearId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return disStud;

	}
	
	/*********************************************Redressed Student Grievance********************************************/
	@Autowired RedressedStudGrievanceRepo redressedRepo;
	
	@RequestMapping(value = { "/saveStudGrievance" }, method = RequestMethod.POST)
	public @ResponseBody RedressedStudGrievance saveStudGrievance(@RequestBody RedressedStudGrievance redInfo) {
		RedressedStudGrievance redress = null;
		try {

			redress = redressedRepo.save(redInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redress;
	}
	
	
	@RequestMapping(value = { "/getAllStudGrievByInstituteIdAndAcademicYear" }, method = RequestMethod.POST)
	public @ResponseBody List<RedressedStudGrievance> getAllStudGrievByInstituteId(@RequestParam("instId") int instId,@RequestParam("yearId") int yearId) {
		List<RedressedStudGrievance> stud = new ArrayList<RedressedStudGrievance>();
		try {
			stud = redressedRepo.findByInstIdAndAcadYearIdAndDelStatusOrderByRedrsStudGrvncIdDesc(instId, yearId,1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stud;

	}
	
	@RequestMapping(value = { "/getStudGrievanceById" }, method = RequestMethod.POST)
	public @ResponseBody RedressedStudGrievance getStudGrievanceById(@RequestParam("studGrievancId") int studGrievancId) {
		RedressedStudGrievance stud = new RedressedStudGrievance();
		try {
			stud = redressedRepo.findByRedrsStudGrvncId(studGrievancId);
			
			// System.out.println(stud);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stud;
		
	}
	
	@RequestMapping(value = { "/deleteStudGrievanceById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteStudGrievanceById(@RequestParam("studGrievancId") int studGrievancId) {

		int isDelete = 0;
		isDelete = redressedRepo.deleteStudGrivance(studGrievancId);
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
	
	@RequestMapping(value = { "/deleteStudentGrievance" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstBestPractices(@RequestParam List<String> grievanceIdList) {

		Info info = new Info();
		try {
			int res = redressedRepo.deleteSelStudGriev(grievanceIdList);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteStudentGrievance Prog " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;

	}
	
	
	
	@Autowired
	ProgramRepository programRepo;

	@RequestMapping(value = { "/getAllProgramTypeForSanctnIntake" }, method = RequestMethod.POST)
	public @ResponseBody List<Program> getAllProgramTypeForSanctnIntake(@RequestParam("instId") int instId) {

		List<Program> progList = new ArrayList<>();

		try {
			progList = programRepo.getAllProgTypeAndProgram(instId);	
			//System.err.println("Prog List-----------"+progList);
		} catch (Exception e) {
			System.err.println("Exce in getAllProgramTypeForSanctnIntake" + e.getMessage());
			e.printStackTrace();
		}

		return progList;
	}
	
	
	@Autowired
	ProgSancIntakeRepo prgSancIntkRepo;

	@RequestMapping(value = { "/savePrgIntkList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgSancIntake> savePrgIntkList(@RequestBody List<ProgSancIntake> prgIntkInsertList) {

		List<ProgSancIntake> resList = new ArrayList<>();

		try {
			resList = prgSancIntkRepo.saveAll(prgIntkInsertList);
			
		} catch (Exception e) {
			//System.err.println("Exce in savePrgIntkList  " + e.getMessage());
			e.printStackTrace();
		}

		return resList;

	}
	
	
	@RequestMapping(value = { "/getAllSanctnIntakeList" }, method = RequestMethod.POST)
	public @ResponseBody List<ProgSancIntake> getAllSanctnIntakeList(@RequestParam int instId,
			@RequestParam int yearId) {

		List<ProgSancIntake> intkList = new ArrayList<>();

		try {

			intkList = prgSancIntkRepo.findByInstIdAndAcYearIdAndDelStatus(instId, yearId);
			//System.err.println("intkList-----------"+intkList);
		} catch (Exception e) {
			//System.err.println("Exce in getAllSanctnIntakeList  " + e.getMessage());
			e.printStackTrace();
		}

		return intkList;
	}
}
