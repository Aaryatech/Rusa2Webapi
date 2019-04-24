package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lib_book_purchase")
public class LibBookPurchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_purchase_id")
	private int bookPurchaseId;
	
	@Column(name="institute_id")
	private int instituteId;
	
	@Column(name="academic_yrid")
	private int academicYrid;
	
	@Column(name="no_of_books")
	private int noOfBooks;
	
	@Column(name="cost_of_books")
	private int costOfBooks;
	
	@Column(name="no_of_journal")
	private int noOfJournal;
	
	@Column(name="cost_of_journal")
	private int costOfJournal;
	
	@Column(name="no_of_ejournal")
	private int noOfEjournal;
	
	@Column(name="cost_of_ejournal")
	private int costOfEjournal;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	public int getBookPurchaseId() {
		return bookPurchaseId;
	}
	public void setBookPurchaseId(int bookPurchaseId) {
		this.bookPurchaseId = bookPurchaseId;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	
	public int getAcademicYrid() {
		return academicYrid;
	}
	public void setAcademicYrid(int academicYrid) {
		this.academicYrid = academicYrid;
	}
	public int getNoOfBooks() {
		return noOfBooks;
	}
	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}
	public int getCostOfBooks() {
		return costOfBooks;
	}
	public void setCostOfBooks(int costOfBooks) {
		this.costOfBooks = costOfBooks;
	}
	public int getNoOfJournal() {
		return noOfJournal;
	}
	public void setNoOfJournal(int noOfJournal) {
		this.noOfJournal = noOfJournal;
	}
	public int getCostOfJournal() {
		return costOfJournal;
	}
	public void setCostOfJournal(int costOfJournal) {
		this.costOfJournal = costOfJournal;
	}
	public int getNoOfEjournal() {
		return noOfEjournal;
	}
	public void setNoOfEjournal(int noOfEjournal) {
		this.noOfEjournal = noOfEjournal;
	}
	public int getCostOfEjournal() {
		return costOfEjournal;
	}
	public void setCostOfEjournal(int costOfEjournal) {
		this.costOfEjournal = costOfEjournal;
	}
	
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	public int getExInt1() {
		return exInt1;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	@Override
	public String toString() {
		return "LibBookPurchase [bookPurchaseId=" + bookPurchaseId + ", instituteId=" + instituteId + ", academicYrid="
				+ academicYrid + ", noOfBooks=" + noOfBooks + ", costOfBooks=" + costOfBooks + ", noOfJournal="
				+ noOfJournal + ", costOfJournal=" + costOfJournal + ", noOfEjournal=" + noOfEjournal
				+ ", costOfEjournal=" + costOfEjournal + ", delStatus=" + delStatus + ", userId=" + userId + ", exVar1="
				+ exVar1 + ", exInt1=" + exInt1 + "]";
	}
	
	
}
