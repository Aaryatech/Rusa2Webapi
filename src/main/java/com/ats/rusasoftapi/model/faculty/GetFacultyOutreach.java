package com.ats.rusasoftapi.model.faculty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetFacultyOutreach {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int outreachId;

	private String typeName;

	private String outreachDate;

	private String outreachLevel;

	private String outreachName;

	public int getOutreachId() {
		return outreachId;
	}

	public void setOutreachId(int outreachId) {
		this.outreachId = outreachId;
	}

	public String getOutreachDate() {
		return outreachDate;
	}

	public void setOutreachDate(String outreachDate) {
		this.outreachDate = outreachDate;
	}

	public String getOutreachLevel() {
		return outreachLevel;
	}

	public void setOutreachLevel(String outreachLevel) {
		this.outreachLevel = outreachLevel;
	}

	public String getOutreachName() {
		return outreachName;
	}

	public void setOutreachName(String outreachName) {
		this.outreachName = outreachName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "GetFacultyOutreach [outreachId=" + outreachId + ", typeName=" + typeName + ", outreachDate="
				+ outreachDate + ", outreachLevel=" + outreachLevel + ", outreachName=" + outreachName + "]";
	}

}
