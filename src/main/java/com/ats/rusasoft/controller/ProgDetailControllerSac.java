package com.ats.rusasoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.progdetail.AlumniDetail;
import com.ats.rusasoft.model.progdetail.Cast;
import com.ats.rusasoft.model.progdetail.GetAlumni;
import com.ats.rusasoft.model.progdetail.GetHigherEduDetail;
import com.ats.rusasoft.model.progdetail.GetTrainPlace;
import com.ats.rusasoft.model.progdetail.HigherEducDetail;
import com.ats.rusasoft.model.progdetail.Location;
import com.ats.rusasoft.model.progdetail.ProgramType;
import com.ats.rusasoft.model.progdetail.StudAdmCatwise;
import com.ats.rusasoft.model.progdetail.StudAdmLocwise;
import com.ats.rusasoft.model.progdetail.TrainPlacement;
import com.ats.rusasoft.prodetailrepo.AlumniDetailRepo;
import com.ats.rusasoft.prodetailrepo.CastRepo;
import com.ats.rusasoft.prodetailrepo.GetAlumniRepo;
import com.ats.rusasoft.prodetailrepo.GetHigherEduDetailRepo;
import com.ats.rusasoft.prodetailrepo.GetTrainPlaceRepo;
import com.ats.rusasoft.prodetailrepo.HigherEducDetailRepo;
import com.ats.rusasoft.prodetailrepo.LocationRepo;
import com.ats.rusasoft.prodetailrepo.ProgramTypeRepo;
import com.ats.rusasoft.prodetailrepo.StudAdmCatwiseRepo;
import com.ats.rusasoft.prodetailrepo.StudAdmLocwiseRepo;
import com.ats.rusasoft.prodetailrepo.TrainPlacementRepo;

@RestController
public class ProgDetailControllerSac {
	
	@Autowired ProgramTypeRepo programTypeRepo;
	@RequestMapping(value = { "/getAllProgramType" }, method = RequestMethod.GET)
	public @ResponseBody List<ProgramType> getAllProgramType() {

		List<ProgramType> progTypeList = new ArrayList<>();

		try {
			
			progTypeList = programTypeRepo.findByDelStatusAndIsActive(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllProgramType  " + e.getMessage());
			e.printStackTrace();
		}

		return progTypeList;

	}
	
	//getHigherProg
	
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
			castList = castRepo.findByDelStatusAndIsActive(1, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllCastCategory  " + e.getMessage());
			e.printStackTrace();
		}

		return castList;

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
	
	@Autowired AlumniDetailRepo alumniDetailRepo;
	
	@RequestMapping(value = { "/saveAlumni" }, method = RequestMethod.POST)
	public @ResponseBody AlumniDetail saveAlumni(@RequestBody AlumniDetail alDetail) {

		AlumniDetail almDetail=new  AlumniDetail();

		try {
			
			almDetail = alumniDetailRepo.save(alDetail);

		} catch (Exception e) {
			System.err.println("Exce in saveAlumni  " + e.getMessage());
			e.printStackTrace();
		}

		return almDetail;

	}
	
	@Autowired GetAlumniRepo getAlumniRepo;
	
	@RequestMapping(value = { "/getAlumniList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAlumni> getAlumniList(@RequestParam int instId, @RequestParam int yearId) {

		List<GetAlumni> almDetail=new ArrayList<>();

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

		AlumniDetail almDetail=new  AlumniDetail();

		try {
			
			almDetail = alumniDetailRepo.findByAlumniDetailIdAndDelStatusAndIsActive(alumniId,1,1);
		} catch (Exception e) {
			System.err.println("Exce in getAlumni  " + e.getMessage());
			e.printStackTrace();
		}

		return almDetail;

	}
	
	
	
	//deleteAccOfficers
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
		
		
		//Trainint And Placement
		
		@Autowired TrainPlacementRepo trainPlacementRepo;
		
		@RequestMapping(value = { "/saveTrainPlacement" }, method = RequestMethod.POST)
		public @ResponseBody TrainPlacement saveTrainPlacement(@RequestBody TrainPlacement tranPlace) {

			TrainPlacement placementRes=new  TrainPlacement();

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

			TrainPlacement trainPlace=new  TrainPlacement();

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
		
		@Autowired GetTrainPlaceRepo getTrainPlaceRepo;

		@RequestMapping(value = { "/getGetTrainPlaceList" }, method = RequestMethod.POST)
		public @ResponseBody List<GetTrainPlace> getGetTrainPlaceList(@RequestParam int instId, @RequestParam int yearId) {

			List<GetTrainPlace> almDetail=new ArrayList<>();

			try {
				
				almDetail = getTrainPlaceRepo.getGetTrainPlace(instId, yearId);
			} catch (Exception e) {
				System.err.println("Exce in getGetTrainPlaceList  " + e.getMessage());
				e.printStackTrace();
			}

			return almDetail;

		}
		
		//HigherEducDetail Proceed
		
		@Autowired HigherEducDetailRepo higherEducDetailRepo;
		
		@RequestMapping(value = { "/saveHigherEducDetail" }, method = RequestMethod.POST)
		public @ResponseBody HigherEducDetail saveHigherEducDetail(@RequestBody HigherEducDetail higherEdu) {

			HigherEducDetail highEduDet=new  HigherEducDetail();

			try {
				
				highEduDet = higherEducDetailRepo.save(higherEdu);

			} catch (Exception e) {
				System.err.println("Exce in saveHigherEducDetail  " + e.getMessage());
				e.printStackTrace();
			}

			return highEduDet;

		}
		
		@RequestMapping(value = { "/getHigherEducDetail" }, method = RequestMethod.POST)
		public @ResponseBody HigherEducDetail getHigherEducDetail(@RequestParam int eduDetailId) {

			HigherEducDetail highEduRes=new  HigherEducDetail();

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
		
		//GetHigherEduDetailRepo
		
		@Autowired GetHigherEduDetailRepo getHigherEduDetailRepo;
		
		@RequestMapping(value = { "/getHigherEduDetailList" }, method = RequestMethod.POST)
		public @ResponseBody List<GetHigherEduDetail> getHigherEduDetailList(@RequestParam int instId, @RequestParam int yearId) {

			List<GetHigherEduDetail> highEdList=new ArrayList<>();

			try {
				
				highEdList = getHigherEduDetailRepo.getHigherEduDetail(instId, yearId);
			} catch (Exception e) {
				System.err.println("Exce in getHigherEduDetailList  " + e.getMessage());
				e.printStackTrace();
			}

			return highEdList;

		}
}
