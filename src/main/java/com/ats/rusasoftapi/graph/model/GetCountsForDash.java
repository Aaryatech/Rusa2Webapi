package com.ats.rusasoftapi.graph.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetCountsForDash {
	
	@Id
	private String id;
	
	private int count;
	
	private int  count1;
	
	private String data1;
	
	private String data2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount1() {
		return count1;
	}

	public void setCount1(int count1) {
		this.count1 = count1;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "GetCountsForDash [id=" + id + ", count=" + count + ", count1=" + count1 + ", data1=" + data1
				+ ", data2=" + data2 + ", getId()=" + getId() + ", getCount()=" + getCount() + ", getCount1()="
				+ getCount1() + ", getData1()=" + getData1() + ", getData2()=" + getData2() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	 
	 
}
