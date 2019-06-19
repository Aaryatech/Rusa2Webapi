package com.ats.rusasoftapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusasoftapi.master.repo.PlagiarismCodeEthicsRepo;
import com.ats.rusasoftapi.model.AwrdRecgAgnstExtActivity;
import com.ats.rusasoftapi.model.Info;
import com.ats.rusasoftapi.model.InstResearchDevMous;
import com.ats.rusasoftapi.model.MExtActList;
import com.ats.rusasoftapi.model.MExtensionActivity;
import com.ats.rusasoftapi.model.ResearchDevMou;
import com.ats.rusasoftapi.model.TExtensionActivity;
import com.ats.rusasoftapi.model.TNeighbourhoodCommActivities;
import com.ats.rusasoftapi.model.infra.PlagiarismCodeEthics;
import com.ats.rusasoftapi.repositories.InstResearchDevMousRepo;
import com.ats.rusasoftapi.repositories.MExtActListRepo;
import com.ats.rusasoftapi.repositories.MExtensionActivityRepo;
import com.ats.rusasoftapi.repositories.ResearchDevMouRepo;
import com.ats.rusasoftapi.repositories.TExtensionActivityRepo;
import com.ats.rusasoftapi.repositories.TNeighbourhoodCommActivitiesRepo;
import com.ats.rusasoftapi.repository.AwrdRecgAgnstExtActRepo;

@RestController
public class ResearchAndInnovationApi {
	@Autowired MExtensionActivityRepo mExtRepo;
	
	@Autowired TExtensionActivityRepo extAcrRepo;
	
	@Autowired MExtActListRepo extReop;
	
	@Autowired ResearchDevMouRepo mouRepo;
	
	@Autowired InstResearchDevMousRepo rsrcMouRepo;
	
	@Autowired TNeighbourhoodCommActivitiesRepo neghComActRepo;
	
	@Autowired AwrdRecgAgnstExtActRepo awrdRecgExtActRepo;
	
/******************Extension Activity********************/
	
	
	@RequestMapping(value = { "/getAllExtensionActivities" }, method = RequestMethod.GET)
	public @ResponseBody List<MExtensionActivity> getAllExtensionActivities() {
		// System.out.println("List");
		List<MExtensionActivity> extList = null;
		
		extList = mExtRepo.findByDelStatusOrderBySequenceAsc(1);
		// System.out.println("List"+extList);
		return extList;
	
	}
	
	
	
	@RequestMapping(value = { "/saveExtActivity" }, method = RequestMethod.POST)
	public @ResponseBody TExtensionActivity saveExtActivity(@RequestBody TExtensionActivity tExtAct) {
		TExtensionActivity extAct = null;
			extAct = extAcrRepo.save(tExtAct);
		
		return extAct;
	
	}
	
	@RequestMapping(value = { "/getAllExtActivities"}, method = RequestMethod.POST)
	public @ResponseBody List<MExtActList> getAllExtActivities(@RequestParam("instituteId") int instituteId) {

		List<MExtActList> extActList = null;

		try {

			extActList = extReop.getAllExtActByInstId(instituteId);
			System.err.println("List="+extActList);

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return extActList;

	}
	
	@RequestMapping(value = { "/getExtActivityById"}, method = RequestMethod.POST)
	public @ResponseBody TExtensionActivity getExtActivityById(@RequestParam("extActId") int extActId) {

		TExtensionActivity extAct = null;

		try {

			extAct = extAcrRepo.findByinstExtensionActId(extActId);
			System.err.println("Ext="+extAct);

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return extAct;

	}
	
	@RequestMapping(value = { "/deleteTExtActById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMExtActById(@RequestParam int extActId) {
		
		Info info = new Info();
		try {
			int res = extAcrRepo.deleteExtActInfoById(extActId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteMExtActById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}
	
	@RequestMapping(value = { "/deleteSelExtAct" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelExtAct(@RequestParam List<String> exActIdsList) {

		Info info = new Info();
		try {
			int res = extAcrRepo.deletetExtAct(exActIdsList);

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
	
	@RequestMapping(value = { "/getAllRsrchDevMous" }, method = RequestMethod.GET)
	public @ResponseBody List<ResearchDevMou> getAllRsrchDevMous() {
		// System.out.println("List");
		List<ResearchDevMou> extList = null;
		
		extList = mouRepo.findBydelStatus(1);
		// System.out.println("List"+extList);
		return extList;
	
	}
	
	@RequestMapping(value = { "/savResrchDevMou" }, method = RequestMethod.POST)
	public @ResponseBody InstResearchDevMous saveExtActivity(@RequestBody InstResearchDevMous tExtAct) {
		InstResearchDevMous saveMous = null;
		saveMous = rsrcMouRepo.save(tExtAct);
		
		return saveMous;
	
	}
	
	@RequestMapping(value = { "/getAllRsrchDevMous"}, method = RequestMethod.POST)
	public @ResponseBody List<InstResearchDevMous> getAllRsrchDevMous(@RequestParam("instituteId") int instituteId) {

		List<InstResearchDevMous> extActList = null;

		try {// System.out.println("Inst="+instituteId);

			extActList = rsrcMouRepo.getAllRsrchDevMousByInstId(instituteId);
			System.err.println("List="+extActList);

		} catch (Exception e) {

			System.err.println("Exce in getAllRsrchDevMous" + e.getMessage());
			e.printStackTrace();

		}

		return extActList;

	}
	
	
	@RequestMapping(value = { "/getMouRsrchDevById"}, method = RequestMethod.POST)
	public @ResponseBody InstResearchDevMous getMouRsrchDevById(@RequestParam("mouRsrchDevId") int mouRsrchDevId) {

		InstResearchDevMous mouRsrch = null;

		try {

			mouRsrch = rsrcMouRepo.findByInstReasearchDevMouIdAndDelStatus(mouRsrchDevId,1);
			//System.err.println("Ext="+mouRsrch);

		} catch (Exception e) {

			System.err.println("Exce in getMouRsrchDevById" + e.getMessage());
			e.printStackTrace();

		}

		return mouRsrch;

	}
	
	@RequestMapping(value = { "/deleteRsrchMouById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRsrchMouById(@RequestParam int mouRsrchDevId) {
		
		Info info = new Info();
		try {
			int res = rsrcMouRepo.deleteMouRsrchDevById(mouRsrchDevId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteRsrchMouById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}
	
	@RequestMapping(value = { "/deleteSelResearchMous" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelResearchMous(@RequestParam List<String> mouRsrchDevIdList) {

		Info info = new Info();
		try {
			int res = rsrcMouRepo.deletetRsrchMous(mouRsrchDevIdList);

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
	
	
	@RequestMapping(value = { "/saveNeighbourhoodCommAct" }, method = RequestMethod.POST)
	public @ResponseBody TNeighbourhoodCommActivities saveEcontentDevFacilities(@RequestBody TNeighbourhoodCommActivities neighbourCommAct) {
		TNeighbourhoodCommActivities neighborhoodActivity = null;
		neighborhoodActivity = neghComActRepo.save(neighbourCommAct);
		
		return neighborhoodActivity;
	
	}
	
	@RequestMapping(value = { "/showNeighbourCommActivities" }, method = RequestMethod.POST)
	public @ResponseBody List<TNeighbourhoodCommActivities> showNeighbourCommActivities(@RequestParam("instituteId") int instituteId) {

		List<TNeighbourhoodCommActivities> neighbourActList = null;

		try {

			neighbourActList = neghComActRepo.findByInstIdAndDelStatusOrderByInstNeighbourhoodCommActIdDesc(instituteId, 1);
			System.err.println("linls="+neighbourActList);

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return neighbourActList;

	}

	@RequestMapping(value = { "/getneighbCommActivityById" }, method = RequestMethod.POST)
	public @ResponseBody TNeighbourhoodCommActivities getneighbCommActivityById(@RequestParam("neighbCommActId") int neighbCommActId) {

		TNeighbourhoodCommActivities neighbourCommAct = null;

		try {

			neighbourCommAct = neghComActRepo.findByInstNeighbourhoodCommActIdAndDelStatus(neighbCommActId, 1);
			System.err.println("act="+neighbourCommAct);

		} catch (Exception e) {

			System.err.println("Exce in getneighbCommActivityById" + e.getMessage());
			e.printStackTrace();

		}

		return neighbourCommAct;

	}
	
	
	@RequestMapping(value = { "/deleteneghCommActivityId" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteneghCommActivityId(@RequestParam("neighbCommActId") int neighbCommActId) {
		
		Info info = new Info();
		try {
			int res = neghComActRepo.deleteNeghbCommActivityById(neighbCommActId);

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
	
	@RequestMapping(value = { "/deleteSelAcitivities" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelAcitivities(@RequestParam List<String> actIdList) {

		Info info = new Info();
		try {
			int res = neghComActRepo.deleteActivities(actIdList);

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
	
/*********************************Award Recognition  against Extension Activity*******************************/
	@RequestMapping(value = { "/saveAwrdRecgAgnstExtAct" }, method = RequestMethod.POST)
	public @ResponseBody AwrdRecgAgnstExtActivity saveEcontentDevFacilities(@RequestBody AwrdRecgAgnstExtActivity araea) {
		AwrdRecgAgnstExtActivity awrdrecgagnstext = null;
		awrdrecgagnstext = awrdRecgExtActRepo.save(araea);
		return awrdrecgagnstext;
	
	}
	
	@RequestMapping(value = { "/showAwrdRecgExtAct" }, method = RequestMethod.POST)
	public @ResponseBody List<AwrdRecgAgnstExtActivity> showAwrdRecgExtAct(@RequestParam("instituteId") int instituteId) {

		List<AwrdRecgAgnstExtActivity> awrdRecgList = null;

		try {

			awrdRecgList = awrdRecgExtActRepo.findByInstIdAndDelStatusOrderByAwrdRecgAgnstExtActIdDesc(instituteId, 1);
			System.err.println("links="+awrdRecgList);

		} catch (Exception e) {

			System.err.println("Exce in showAwrdRecgExtAct Resrch&Inonv " + e.getMessage());
			e.printStackTrace();

		}

		return awrdRecgList;

	}
	
	@RequestMapping(value = { "/getAwrdRecgAgnstExtActById" }, method = RequestMethod.POST)
	public @ResponseBody AwrdRecgAgnstExtActivity getAwrdRecgAgnstExtActById(@RequestParam("awrdRecgid") int awrdRecgid) {

		AwrdRecgAgnstExtActivity awrdExt = null;

		try {

			awrdExt = awrdRecgExtActRepo.findByAwrdRecgAgnstExtActIdAndDelStatus(awrdRecgid, 1);
			System.err.println("act="+awrdExt);

		} catch (Exception e) {

			System.err.println("Exce in getneighbCommActivityById" + e.getMessage());
			e.printStackTrace();

		}

		return awrdExt;

	}
	
	@RequestMapping(value = { "/deleteAwrdRecgAgnstExtActById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAwrdRecgAgnstExtActById(@RequestParam("awrdRecgid") int awrdRecgid) {
		
		Info info = new Info();
		try {
			int res = awrdRecgExtActRepo.deleteAwrdRecgExtActById(awrdRecgid);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteAwrdRecgAgnstExtActById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}
	
	@RequestMapping(value = { "/deleteSelAwardRecgExtAct" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelAwardRecgExtAct(@RequestParam List<String> exActIdList) {

		Info info = new Info();
		try {
			int res = awrdRecgExtActRepo.delAwrdRecgAct(exActIdList);

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
	/*****************************Plagiarism & Code of Ethics******************************/
	@Autowired PlagiarismCodeEthicsRepo plagRepo;
	
	@RequestMapping(value = { "/savePlagCodeEthic" }, method = RequestMethod.POST)
	public @ResponseBody PlagiarismCodeEthics savePlagCodeEthic(@RequestBody PlagiarismCodeEthics soft) {
		PlagiarismCodeEthics plag = null;
		plag = plagRepo.save(soft);
		
		return plag;
	
	}
	
	@RequestMapping(value = { "/getAllPlagiarismEcthcCodList" }, method = RequestMethod.POST)
	public @ResponseBody List<PlagiarismCodeEthics> getAllPlagiarismEcthcCodList(@RequestParam("instituteId") int instituteId) {

		List<PlagiarismCodeEthics> plagEthcCodeList = null;

		try {

			plagEthcCodeList = plagRepo.findByInstIdAndDelStatusOrderByPlagCodeEthcIdDesc(instituteId, 1);
			System.err.println("links="+plagEthcCodeList);

		} catch (Exception e) {

			System.err.println("Exce in showAwrdRecgExtAct Resrch&Inonv " + e.getMessage());
			e.printStackTrace();

		}

		return plagEthcCodeList;

	}
	
	@RequestMapping(value = { "/getPlagrismEthicsCodeById" }, method = RequestMethod.POST)
	public @ResponseBody PlagiarismCodeEthics getPlagrismEthicsCodeById(@RequestParam("plagId") int plagId) {

		PlagiarismCodeEthics plg = null;

		try {

			plg = plagRepo.findByPlagCodeEthcId(plagId);
			System.err.println("act="+plg);

		} catch (Exception e) {

			System.err.println("Exce in getPlagrismEthicsCodeById" + e.getMessage());
			e.printStackTrace();

		}

		return plg;

	}
	
	@RequestMapping(value = { "/deletePlagiarismCodeEthicsById" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePlagiarismCodeEthicsById(@RequestParam("plagId") int plagId) {
		
		Info info = new Info();
		try {
			int res = plagRepo.deletePlagrismEthicSCodeById(plagId);

			if (res > 0) {
				info.setError(false);
				info.setMsg("success");

			} else {
				info.setError(true);
				info.setMsg("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteAwrdRecgAgnstExtActById  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMsg("excep");
		}

		return info;
	}
	
	@RequestMapping(value = { "/deleteSelPlagrismEithcsCode" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSelPlagrismEithcsCode(@RequestParam List<String> plagIdList) {

		Info info = new Info();
		try {
			int res = plagRepo.deletePlagEthcCodes(plagIdList);

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
