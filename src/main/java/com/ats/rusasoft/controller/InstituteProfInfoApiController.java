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

import com.ats.rusasoft.instprofilerepo.InstituteFunctionalMOURepo;
import com.ats.rusasoft.instprofilerepo.InstituteLinkageRepo;
import com.ats.rusasoft.model.GetProgram;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.IqacBasicInfo;
import com.ats.rusasoft.model.Librarian;
import com.ats.rusasoft.model.LinkageMaster;
import com.ats.rusasoft.model.instprofile.InstituteFunctionalMOU;
import com.ats.rusasoft.model.instprofile.InstituteLinkage;
import com.ats.rusasoft.model.progdetail.Cast;
import com.ats.rusasoft.mstrepo.IqacBasicInfoRepo;
import com.ats.rusasoft.mstrepo.LinkageMasterRepo;

@RestController
public class InstituteProfInfoApiController {

	@Autowired
	IqacBasicInfoRepo iqacBasicInfoRepo;

	@Autowired
	InstituteFunctionalMOURepo instituteFunctionalMOURepo;

	@Autowired
	InstituteLinkageRepo instituteLinkageRepo;

	@Autowired
	LinkageMasterRepo linkageMasterRepo;
	// -------------------Linkage Master------------

	@RequestMapping(value = { "/saveLinkageMaster" }, method = RequestMethod.POST)
	public @ResponseBody LinkageMaster saveLinkageMaster(@RequestBody LinkageMaster linkageMaster) {

		LinkageMaster instResp = null;

		try {

			instResp = linkageMasterRepo.save(linkageMaster);

		} catch (Exception e) {
			System.err.println("Exce in saving saveLinkageMaster " + e.getMessage());
			e.printStackTrace();
		}

		return instResp;

	}

	@RequestMapping(value = { "/saveInstituteBasicInfo" }, method = RequestMethod.POST)
	public @ResponseBody IqacBasicInfo saveInstituteBasicInfo(@RequestBody IqacBasicInfo instInfo) {

		IqacBasicInfo instResp = null;

		try {

			instResp = iqacBasicInfoRepo.saveAndFlush(instInfo);

		} catch (Exception e) {
			System.err.println("Exce in saving InstituteInfo " + e.getMessage());
			e.printStackTrace();
		}

		return instInfo;

	}

	@RequestMapping(value = { "/getIqacInfoByInstId" }, method = RequestMethod.POST)
	public @ResponseBody IqacBasicInfo getProgramByProgId(@RequestParam int instituteId) {

		IqacBasicInfo progRes = new IqacBasicInfo();

		try {

			progRes = iqacBasicInfoRepo.getIqacInfo(instituteId);
		} catch (Exception e) {
			System.err.println("Exce in getHigherEducDetail  " + e.getMessage());
			e.printStackTrace();
		}

		return progRes;

	}

	@RequestMapping(value = { "/getIqacInfoByIqacInfoId" }, method = RequestMethod.POST)

	public @ResponseBody IqacBasicInfo getIqacInfoByIqacInfoId(@RequestParam int iqacInfoId) {

		IqacBasicInfo progRes = new IqacBasicInfo();

		try {
			progRes = iqacBasicInfoRepo.findByDelStatusAndIsActiveAndIqacInfoId(1, 1, iqacInfoId);

		} catch (Exception e) {
			System.err.println("Exce in getAllCastCategory  " + e.getMessage());
			e.printStackTrace();
		}

		return progRes;

	}

	@RequestMapping(value = { "/deleteInstProf" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstProf(@RequestParam int iqacInfoId) {

		Info info = new Info();
		try {
			int res = iqacBasicInfoRepo.deleteSchemes(iqacInfoId);

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

	// ******************************mou*******************************//

	@RequestMapping(value = { "/saveInstituteMOU" }, method = RequestMethod.POST)
	public @ResponseBody InstituteFunctionalMOU saveInstituteMOU(@RequestBody InstituteFunctionalMOU instInfo) {

		InstituteFunctionalMOU instResp = null;

		try {

			instResp = instituteFunctionalMOURepo.saveAndFlush(instInfo);

		} catch (Exception e) {
			System.err.println("Exce in saving InstituteInfo " + e.getMessage());
			e.printStackTrace();
		}

		return instInfo;

	}

	@RequestMapping(value = { "/getAllMouByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<InstituteFunctionalMOU> getAllMouByInstituteId(@RequestParam int instId,
			@RequestParam int yearId) {

		List<InstituteFunctionalMOU> libResp = new ArrayList<>();

		try {
			libResp = instituteFunctionalMOURepo.getAllMOUList(instId, yearId);
			System.err.println("lib are" + libResp.toString());

		} catch (Exception e) {
			System.err.println("Exce in getAllLibrarian Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return libResp;

	}

	@RequestMapping(value = { "/getMOUByMouId" }, method = RequestMethod.POST)

	public @ResponseBody InstituteFunctionalMOU getMOUByMouId(@RequestParam int mouId) {

		InstituteFunctionalMOU progRes = new InstituteFunctionalMOU();

		try {
			progRes = instituteFunctionalMOURepo.findByDelStatusAndIsActiveAndMouId(1, 1, mouId);

		} catch (Exception e) {
			System.err.println("Exce in getAllCastCategory  " + e.getMessage());
			e.printStackTrace();
		}

		return progRes;

	}

	@RequestMapping(value = { "/deleteMous" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMous(@RequestParam List<String> mouIdList) {

		Info info = new Info();
		try {
			int res = instituteFunctionalMOURepo.deleteMous(mouIdList);

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

	// ******************************linkage*******************************//

	@RequestMapping(value = { "/saveInstituteColLinkage" }, method = RequestMethod.POST)
	public @ResponseBody InstituteLinkage saveInstituteColLinkage(@RequestBody InstituteLinkage instInfo) {

		InstituteLinkage instResp = null;

		try {

			instResp = instituteLinkageRepo.saveAndFlush(instInfo);

		} catch (Exception e) {
			System.err.println("Exce in saving InstituteInfo " + e.getMessage());
			e.printStackTrace();
		}

		return instInfo;

	}

	@RequestMapping(value = { "/getAllInstLinkageByInstituteId" }, method = RequestMethod.POST)
	public @ResponseBody List<InstituteLinkage> getAllInstLinkageByInstituteId(@RequestParam int instId,
			@RequestParam int yearId) {

		List<InstituteLinkage> libResp = new ArrayList<>();

		try {
			libResp = instituteLinkageRepo.getAllInstKinkagesList(instId, yearId);
			System.err.println("lib are" + libResp.toString());

		} catch (Exception e) {
			System.err.println("Exce in getAllLibrarian Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return libResp;

	}

	@RequestMapping(value = { "/getInstLinkageByLinkId" }, method = RequestMethod.POST)

	public @ResponseBody InstituteLinkage getInstLinkageByLinkId(@RequestParam int linkId) {

		InstituteLinkage progRes = new InstituteLinkage();

		try {
			progRes = instituteLinkageRepo.findByDelStatusAndIsActiveAndLinkId(1, 1, linkId);

		} catch (Exception e) {
			System.err.println("Exce in getAllCastCategory  " + e.getMessage());
			e.printStackTrace();
		}

		return progRes;

	}

	@RequestMapping(value = { "/deleteInstLinkages" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInstLinkages(@RequestParam List<String> linkIdList) {

		Info info = new Info();
		try {
			int res = instituteLinkageRepo.deleteLinkages(linkIdList);

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
