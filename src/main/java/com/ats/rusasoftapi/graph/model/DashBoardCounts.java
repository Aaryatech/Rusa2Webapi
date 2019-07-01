package com.ats.rusasoftapi.graph.model;



public class DashBoardCounts {
	
	private int totalfaculties;                       //Principal,IQAC,HOD as Total Faculty Available
	
	
	private int  totalfacultieswithPHD;               //Principal,IQAC
	
	private float ratio ;                             //Principal,IQAC
	
	private int totalstudent;                          //Principal,IQAC,HOD as Total Students Admitted
	 
	private int malestudent;                           //Principal,IQAC
	
	private int femalestudent;                          //Principal,IQAC
	
	
	private int noofprogram;                           //Principal,IQAC,HOD as  Total Programs Added by Hod
	
	
	private int noOfreserchpub;                         //Principal,IQAC,Faculty as No of Research Publication
	
	
	private int noofbookpub;;                            //Principal,IQAC,Faculty as No of book Publication
	
	private int currfinyearbudget;                       //Principal,IQAC
	
	private String researchprojecttitle;                 //Faculty
	
	private int noofpatentsfilled;                        //Faculty
	
	private String  libraryusageperdayfaculty;            //Librarian
	
	private String  libraryusageperdaystudents;           //Librarian
	
	private int noofbooksinlibrary;                       //Librarian
	
	private String  LMSsoftwarename;                      //Librarian
	
	private String  noofLMSsoftwareusers;                  //Librarian
	
	private int totalresearchprojects;                     //Dean R&D
	
	private int totalnoofMOUs;                             //Dean R&D
	
	private int totallinkages;                             //Dean R&D
	
	private String  fundingfrom;                           //Dean R&D

	public int getTotalfaculties() {
		return totalfaculties;
	}

	public void setTotalfaculties(int totalfaculties) {
		this.totalfaculties = totalfaculties;
	}

	public int getTotalfacultieswithPHD() {
		return totalfacultieswithPHD;
	}

	public void setTotalfacultieswithPHD(int totalfacultieswithPHD) {
		this.totalfacultieswithPHD = totalfacultieswithPHD;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

	public int getTotalstudent() {
		return totalstudent;
	}

	public void setTotalstudent(int totalstudent) {
		this.totalstudent = totalstudent;
	}

	public int getNoofprogram() {
		return noofprogram;
	}

	public void setNoofprogram(int noofprogram) {
		this.noofprogram = noofprogram;
	}

	public int getNoOfreserchpub() {
		return noOfreserchpub;
	}

	public void setNoOfreserchpub(int noOfreserchpub) {
		this.noOfreserchpub = noOfreserchpub;
	}

	public int getNoofbookpub() {
		return noofbookpub;
	}

	public void setNoofbookpub(int noofbookpub) {
		this.noofbookpub = noofbookpub;
	}

	public int getCurrfinyearbudget() {
		return currfinyearbudget;
	}

	public void setCurrfinyearbudget(int currfinyearbudget) {
		this.currfinyearbudget = currfinyearbudget;
	}

	public String getResearchprojecttitle() {
		return researchprojecttitle;
	}

	public void setResearchprojecttitle(String researchprojecttitle) {
		this.researchprojecttitle = researchprojecttitle;
	}

	public int getNoofpatentsfilled() {
		return noofpatentsfilled;
	}

	public void setNoofpatentsfilled(int noofpatentsfilled) {
		this.noofpatentsfilled = noofpatentsfilled;
	}

	public String getLibraryusageperdayfaculty() {
		return libraryusageperdayfaculty;
	}

	public void setLibraryusageperdayfaculty(String libraryusageperdayfaculty) {
		this.libraryusageperdayfaculty = libraryusageperdayfaculty;
	}

	public String getLibraryusageperdaystudents() {
		return libraryusageperdaystudents;
	}

	public void setLibraryusageperdaystudents(String libraryusageperdaystudents) {
		this.libraryusageperdaystudents = libraryusageperdaystudents;
	}

	public int getNoofbooksinlibrary() {
		return noofbooksinlibrary;
	}

	public void setNoofbooksinlibrary(int noofbooksinlibrary) {
		this.noofbooksinlibrary = noofbooksinlibrary;
	}

	public String getLMSsoftwarename() {
		return LMSsoftwarename;
	}

	public void setLMSsoftwarename(String lMSsoftwarename) {
		LMSsoftwarename = lMSsoftwarename;
	}

	public String getNoofLMSsoftwareusers() {
		return noofLMSsoftwareusers;
	}

	public void setNoofLMSsoftwareusers(String noofLMSsoftwareusers) {
		this.noofLMSsoftwareusers = noofLMSsoftwareusers;
	}

	public int getTotalresearchprojects() {
		return totalresearchprojects;
	}

	public void setTotalresearchprojects(int totalresearchprojects) {
		this.totalresearchprojects = totalresearchprojects;
	}

	public int getTotalnoofMOUs() {
		return totalnoofMOUs;
	}

	public void setTotalnoofMOUs(int totalnoofMOUs) {
		this.totalnoofMOUs = totalnoofMOUs;
	}

	public int getTotallinkages() {
		return totallinkages;
	}

	public void setTotallinkages(int totallinkages) {
		this.totallinkages = totallinkages;
	}

	public String getFundingfrom() {
		return fundingfrom;
	}

	public void setFundingfrom(String fundingfrom) {
		this.fundingfrom = fundingfrom;
	}

	public int getMalestudent() {
		return malestudent;
	}

	public void setMalestudent(int malestudent) {
		this.malestudent = malestudent;
	}

	public int getFemalestudent() {
		return femalestudent;
	}

	public void setFemalestudent(int femalestudent) {
		this.femalestudent = femalestudent;
	}

	@Override
	public String toString() {
		return "DashBoardCounts [totalfaculties=" + totalfaculties + ", totalfacultieswithPHD=" + totalfacultieswithPHD
				+ ", ratio=" + ratio + ", totalstudent=" + totalstudent + ", malestudent=" + malestudent
				+ ", femalestudent=" + femalestudent + ", noofprogram=" + noofprogram + ", noOfreserchpub="
				+ noOfreserchpub + ", noofbookpub=" + noofbookpub + ", currfinyearbudget=" + currfinyearbudget
				+ ", researchprojecttitle=" + researchprojecttitle + ", noofpatentsfilled=" + noofpatentsfilled
				+ ", libraryusageperdayfaculty=" + libraryusageperdayfaculty + ", libraryusageperdaystudents="
				+ libraryusageperdaystudents + ", noofbooksinlibrary=" + noofbooksinlibrary + ", LMSsoftwarename="
				+ LMSsoftwarename + ", noofLMSsoftwareusers=" + noofLMSsoftwareusers + ", totalresearchprojects="
				+ totalresearchprojects + ", totalnoofMOUs=" + totalnoofMOUs + ", totallinkages=" + totallinkages
				+ ", fundingfrom=" + fundingfrom + ", getTotalfaculties()=" + getTotalfaculties()
				+ ", getTotalfacultieswithPHD()=" + getTotalfacultieswithPHD() + ", getRatio()=" + getRatio()
				+ ", getTotalstudent()=" + getTotalstudent() + ", getNoofprogram()=" + getNoofprogram()
				+ ", getNoOfreserchpub()=" + getNoOfreserchpub() + ", getNoofbookpub()=" + getNoofbookpub()
				+ ", getCurrfinyearbudget()=" + getCurrfinyearbudget() + ", getResearchprojecttitle()="
				+ getResearchprojecttitle() + ", getNoofpatentsfilled()=" + getNoofpatentsfilled()
				+ ", getLibraryusageperdayfaculty()=" + getLibraryusageperdayfaculty()
				+ ", getLibraryusageperdaystudents()=" + getLibraryusageperdaystudents() + ", getNoofbooksinlibrary()="
				+ getNoofbooksinlibrary() + ", getLMSsoftwarename()=" + getLMSsoftwarename()
				+ ", getNoofLMSsoftwareusers()=" + getNoofLMSsoftwareusers() + ", getTotalresearchprojects()="
				+ getTotalresearchprojects() + ", getTotalnoofMOUs()=" + getTotalnoofMOUs() + ", getTotallinkages()="
				+ getTotallinkages() + ", getFundingfrom()=" + getFundingfrom() + ", getMalestudent()="
				+ getMalestudent() + ", getFemalestudent()=" + getFemalestudent() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	 

}
