package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SectionList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="yesno_id")
    private int yesnoId;
	
	@Column(name="yesno_pagecode")
	private String yesnoPagecode;
	
	@Column(name="yesno_seccode")
	private String yesnoSeccode;
	
	@Column(name="yesno_secname")
	private String yesnoSecname;

	public int getYesnoId() {
		return yesnoId;
	}

	public void setYesnoId(int yesnoId) {
		this.yesnoId = yesnoId;
	}

	public String getYesnoPagecode() {
		return yesnoPagecode;
	}

	public void setYesnoPagecode(String yesnoPagecode) {
		this.yesnoPagecode = yesnoPagecode;
	}

	public String getYesnoSeccode() {
		return yesnoSeccode;
	}

	public void setYesnoSeccode(String yesnoSeccode) {
		this.yesnoSeccode = yesnoSeccode;
	}

	public String getYesnoSecname() {
		return yesnoSecname;
	}

	public void setYesnoSecname(String yesnoSecname) {
		this.yesnoSecname = yesnoSecname;
	}

	@Override
	public String toString() {
		return "SectionList [yesnoId=" + yesnoId + ", yesnoPagecode=" + yesnoPagecode + ", yesnoSeccode=" + yesnoSeccode
				+ ", yesnoSecname=" + yesnoSecname + "]";
	}
	 
	

}
