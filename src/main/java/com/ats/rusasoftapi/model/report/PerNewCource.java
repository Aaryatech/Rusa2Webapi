package com.ats.rusasoftapi.model.report;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PerNewCource {
@Id
	private String id1;
	private float noCoursesInLast5;
	private String instituteName;
	private String academic_year;
	public String getId1() {
		return id1;
	}
	public float getNoCoursesInLast5() {
		return noCoursesInLast5;
	}
	
	public String getInstituteName() {
		return instituteName;
	}
	public String getAcademic_year() {
		return academic_year;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public void setAcademic_year(String academic_year) {
		this.academic_year = academic_year;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public void setNoCoursesInLast5(float noCoursesInLast5) {
		this.noCoursesInLast5 = noCoursesInLast5;
	}
	@Override
	public String toString() {
		return "PerNewCource [id1=" + id1 + ", noCoursesInLast5=" + noCoursesInLast5 + ", instituteName="
				+ instituteName + ", academic_year=" + academic_year + "]";
	}
	
}
