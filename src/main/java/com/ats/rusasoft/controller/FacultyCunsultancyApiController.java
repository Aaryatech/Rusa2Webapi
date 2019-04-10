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

import com.ats.rusasoft.model.FacultyConsultancy;
import com.ats.rusasoft.model.GetFacultyConsultancy;
import com.ats.rusasoft.model.Info;
import com.ats.rusasoft.model.faculty.GetJournal;
import com.ats.rusasoft.repository.FacultyConsultancyRepo;
import com.ats.rusasoft.repository.GetFacultyConsultancyRepo;

@RestController
public class FacultyCunsultancyApiController {

	@Autowired
	FacultyConsultancyRepo facultyConsultancyRepo;

	@Autowired
	GetFacultyConsultancyRepo getFacultyConsultancyRepo;

	@RequestMapping(value = { "/getConListByFacultyIdAndtype" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFacultyConsultancy> getConListByFacultyIdAndtype(@RequestParam int facultyId,
			@RequestParam int isPrincipal, @RequestParam int isIQAC, @RequestParam int isHod, @RequestParam int yearId,
			@RequestParam List<Integer> deptIdList, @RequestParam int instituteId) {
		System.out.println("facultyId ==" + facultyId + "isPrincipal" + isPrincipal + "isIQAC" + isIQAC + "isHod"
				+ isHod + "yearId" + yearId + "deptIdList" + deptIdList);

		List<GetFacultyConsultancy> conList = new ArrayList<>();

		try {

			if (isPrincipal == 1 || isIQAC == 1) {
				conList = getFacultyConsultancyRepo.getConListYear(yearId, instituteId);
			} else if (isHod == 1) {
				conList = getFacultyConsultancyRepo.getConListByDept(deptIdList, yearId, instituteId);
			} else {
				conList = getFacultyConsultancyRepo.getConList(facultyId, yearId, instituteId);
			}

		} catch (Exception e) {
			System.err.println("Exce in getConListByFacultyIdAndtype  " + e.getMessage());
			e.printStackTrace();

		}
		return conList;
	}

	@RequestMapping(value = { "/saveFacultyConsultancy" }, method = RequestMethod.POST)
	public @ResponseBody FacultyConsultancy saveFacultyConsultancy(@RequestBody FacultyConsultancy facultyConsultancy) {

		FacultyConsultancy save = new FacultyConsultancy();

		try {

			save = facultyConsultancyRepo.saveAndFlush(facultyConsultancy);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return save;

	}

	@RequestMapping(value = { "/getFacultyConsultancyListByFacultyId" }, method = RequestMethod.POST)
	public @ResponseBody List<FacultyConsultancy> getFacultyConsultancyListByFacultyId(
			@RequestParam("facultyId") int facultyId, @RequestParam("yearId") int yearId) {

		List<FacultyConsultancy> list = new ArrayList<>();

		try {

			list = facultyConsultancyRepo.findByFacultyIdAndDelStatusAndIsActiveAndYearIdOrderByConsIdDesc(facultyId, 1,
					1, yearId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteConsultancy" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteConsultancy(@RequestParam("consId") int consId) {

		Info info = new Info();
		try {

			try {
				int res = facultyConsultancyRepo.deleteConsultancy(consId);
				if (res > 0) {
					info.setError(false);
					info.setMsg("success");

				} else {
					info.setError(true);
					info.setMsg("failed");

				}
			} catch (Exception e) {

				System.err.println("Exce in deleteHods  " + e.getMessage());
				e.printStackTrace();
				info.setError(true);
				info.setMsg("excep");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getConsultancyByConsId" }, method = RequestMethod.POST)
	public @ResponseBody FacultyConsultancy getConsultancyByConsId(@RequestParam("consId") int consId) {

		FacultyConsultancy facultyConsultancy = new FacultyConsultancy();

		try {

			facultyConsultancy = facultyConsultancyRepo.findByConsId(consId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return facultyConsultancy;

	}

}
