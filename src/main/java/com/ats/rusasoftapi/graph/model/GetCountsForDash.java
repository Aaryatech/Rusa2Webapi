package com.ats.rusasoftapi.graph.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetCountsForDash {
	
	@Id
	private String id;
	
	private int count;
	
	private String count1;

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

	public String getCount1() {
		return count1;
	}

	public void setCount1(String count1) {
		this.count1 = count1;
	}

	@Override
	public String toString() {
		return "GetCountsForDash [id=" + id + ", count=" + count + ", count1=" + count1 + ", getId()=" + getId()
				+ ", getCount()=" + getCount() + ", getCount1()=" + getCount1() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	 

}
