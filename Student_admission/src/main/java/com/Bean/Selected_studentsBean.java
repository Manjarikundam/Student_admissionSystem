package com.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Selected_studentsBean {

	@Id
	private int applicant_no;
	private String name;
	private int percentage;
	private String alloted_dept;
	private String alloted_college;
	public int getApplicant_no() {
		return applicant_no;
	}
	public void setApplicant_no(int applicant_no) {
		this.applicant_no = applicant_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getAlloted_dept() {
		return alloted_dept;
	}
	public void setAlloted_dept(String alloted_dept) {
		this.alloted_dept = alloted_dept;
	}
	public String getAlloted_college() {
		return alloted_college;
	}
	public void setAlloted_college(String alloted_college) {
		this.alloted_college = alloted_college;
	}
	@Override
	public String toString() {
		return "Selected_studentsBean [applicant_no=" + applicant_no + ", name=" + name + ", percentage=" + percentage
				+ ", alloted_dept=" + alloted_dept + ", alloted_college=" + alloted_college + "]";
	}
	
	
	
	
	
	
}
