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

import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.progdetail.AlumniDetail;
import com.ats.rusasoftapi.model.progdetail.Cast;
import com.ats.rusasoftapi.model.progdetail.GetAlumni;
import com.ats.rusasoftapi.model.progdetail.GetHigherEduDetail;
import com.ats.rusasoftapi.model.progdetail.GetStudAdmCatwise;
import com.ats.rusasoftapi.model.progdetail.GetStudAdmCatwiseGrpByProg;
import com.ats.rusasoftapi.model.progdetail.GetStudAdmLocwise;
import com.ats.rusasoftapi.model.progdetail.GetStudAdmLocwiseGrpByProg;
import com.ats.rusasoftapi.model.progdetail.GetTrainPlace;
import com.ats.rusasoftapi.model.progdetail.HigherEducDetail;
import com.ats.rusasoftapi.model.progdetail.Location;
import com.ats.rusasoftapi.model.progdetail.ProgramType;
import com.ats.rusasoftapi.model.progdetail.StudAdmCatwise;
import com.ats.rusasoftapi.model.progdetail.StudAdmLocwise;
import com.ats.rusasoftapi.model.progdetail.TrainPlacement;
import com.ats.rusasoftapi.prodetailrepo.AlumniDetailRepo;
import com.ats.rusasoftapi.prodetailrepo.CastRepo;
import com.ats.rusasoftapi.prodetailrepo.GetAlumniRepo;
import com.ats.rusasoftapi.prodetailrepo.GetHigherEduDetailRepo;
import com.ats.rusasoftapi.prodetailrepo.GetStudAdmCatwiseGrpByProgRepo;
import com.ats.rusasoftapi.prodetailrepo.GetStudAdmCatwiseRepo;
import com.ats.rusasoftapi.prodetailrepo.GetStudAdmLocwiseGrpByProgRepo;
import com.ats.rusasoftapi.prodetailrepo.GetStudAdmLocwiseRepo;
import com.ats.rusasoftapi.prodetailrepo.GetTrainPlaceRepo;
import com.ats.rusasoftapi.prodetailrepo.HigherEducDetailRepo;
import com.ats.rusasoftapi.prodetailrepo.LocationRepo;
import com.ats.rusasoftapi.prodetailrepo.ProgramTypeRepo;
import com.ats.rusasoftapi.prodetailrepo.StudAdmCatwiseRepo;
import com.ats.rusasoftapi.prodetailrepo.StudAdmLocwiseRepo;
import com.ats.rusasoftapi.prodetailrepo.TrainPlacementRepo;

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
}
