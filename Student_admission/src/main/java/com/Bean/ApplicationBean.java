package com.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applications")
public class ApplicationBean {
	@Id
	private int applicant_no;
	private String name;
	private String password;
	private String board;
	private int percentage;
	private String gpa;
	private String school_name;
	private String dept_choice;
	private String college_ch1;
	private String college_ch2;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getDept_choice() {
		return dept_choice;
	}
	public void setDept_choice(String dept_choice) {
		this.dept_choice = dept_choice;
	}
	public String getCollege_ch1() {
		return college_ch1;
	}
	public void setCollege_ch1(String college_ch1) {
		this.college_ch1 = college_ch1;
	}
	public String getCollege_ch2() {
		return college_ch2;
	}
	public void setCollege_ch2(String college_ch2) {
		this.college_ch2 = college_ch2;
	}
	@Override
	public String toString() {
		return "ApplicationBean [applicant_no=" + applicant_no + ", name=" + name + ", password=" + password
				+ ", board=" + board + ", percentage=" + percentage + ", gpa=" + gpa + ", school_name=" + school_name
				+ ", dept_choice=" + dept_choice + ", college_ch1=" + college_ch1 + ", college_ch2=" + college_ch2
				+ ", status=" + status + "]";
	}
	
	
	

}
